package com.softtek.testing;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

public class AzureUpload {

	private CloudStorageAccount storageAccount;
	private CloudBlobClient blobClient = null;
	private CloudBlobContainer container = null;
	private Map<String, String> otherMimeTypes = new HashMap<String, String>();

	private static Logger log = LogManager.getLogger(AzureUpload.class);

	public AzureUpload(String accountName, String accountKey, String endpointSuffix, String containerName)
			throws InvalidKeyException, URISyntaxException, StorageException {

		String storageConnectionString = this.getStorageConnectionString(accountName, accountKey, endpointSuffix);
		storageAccount = CloudStorageAccount.parse(storageConnectionString);
		log.info("CloudStorageAccount creada");

		blobClient = storageAccount.createCloudBlobClient();
		log.debug("CloudBlobClient creado");

		container = blobClient.getContainerReference(containerName);
		log.info("CloudBlobContainer creada");
		this.initMimeTypes();
	}

	private void initMimeTypes() {
		otherMimeTypes.put("css", "text/css");
		otherMimeTypes.put("js", "application/javascript");
		otherMimeTypes.put("eot", "application/vnd.ms-fontobject");
		otherMimeTypes.put("svg", "image/svg+xml");
		otherMimeTypes.put("ttf", "application/font-ttf");
	}

	public void uploadBlob(String name, InputStream sourceStream, long length)
			throws URISyntaxException, StorageException, IOException {

		log.info("Iniciando uploadBlob...");

		CloudBlockBlob blob = container.getBlockBlobReference(name);

		log.debug("CloudBlockBlob creado");

		String mimeType = this.getWellKnownMimes(name);

		blob.getProperties().setContentType(mimeType);
		blob.upload(sourceStream, length);

		log.info("Blob " + name + " subido OK del tipo " + mimeType);
	}

	private String getWellKnownMimes(String fileName) {
		String mimeType = URLConnection.guessContentTypeFromName(fileName);
		if (mimeType == null) {
			mimeType = otherMimeTypes.get(getFileExtension(fileName));
		}
		return mimeType;
	}

	private String getFileExtension(String fileName) {

		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			return "";

		}
	}

	private String getStorageConnectionString(String accountName, String accountKey, String endpointSuffix) {
		String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=" + accountName + ";AccountKey="
				+ accountKey + ";EndpointSuffix=" + endpointSuffix;
		return storageConnectionString;
	}
}
