package com.softtek.testing;

import java.io.IOException;
import java.util.Hashtable;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.core.Base64;

@RestController
@RequestMapping(value = "/api/uploadFile")
public class UploadFileServlet {

	private UnZip unZip = null;
	private AzureUpload azureUpload = null;
	private boolean configProxy = false;
	private final Hashtable<String, String> users = new Hashtable<String, String>();

	@Value("${upload.app.user}")
	private String appUser;

	@Value("${upload.app.pwd}")
	private String pwdUser;

	@Value("${upload.app.endpointSuffix}")
	private String endpointSuffix;

	@Value("${upload.app.containerName}")
	private String containerName;

	@Value("${upload.app.accountName}")
	private String accountName;

	@Value("${upload.app.accountKey}")
	private String accountKey;

	private static Logger log = LogManager.getLogger(UploadFileServlet.class);

	@PostConstruct
	public void init() {

		log.info("Inicializando UploadFileServlet...");

		this.unZip = new UnZip();

		String key = appUser + ":" + pwdUser;

		this.users.put(key, "allowed");

		log.info("UploadFileServlet inicializado OK...");

	}

	private void inicializaProxy(String hostname) {
		if ("localhost".equals(hostname)) {
			ProxyUtils.initializeProxyAuthenticator();
		}
		configProxy = true;
		log.info("Proxy inicializado!");
	}

	protected boolean allowUser(String auth) throws IOException {
		if (auth == null) {
			return false;
		}
		if (!auth.toUpperCase().startsWith("BASIC ")) {
			return false;
		}

		String userpassEncoded = auth.substring(6);

		String userpassDecoded = new String(Base64.decode(userpassEncoded), "UTF-8");

		if ("allowed".equals(this.users.get(userpassDecoded))) {
			return true;
		}
		log.warn("No permitido acceso a usuario  " + auth);
		return false;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResultDto uploadFile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("fileName") MultipartFile file) throws IOException {
		ResultDto resultDto = new ResultDto();

		String auth = request.getHeader("Authorization");

		if (!allowUser(auth)) {
			response.setContentType("text/plain");
			response.setHeader("WWW-Authenticate", "BASIC realm=\"users\"");
			response.sendError(401);

			return resultDto;
		} else {

			if (!configProxy) {
				inicializaProxy(request.getServerName());
			}

			try {
				log.info("Se va a parser request...");

				log.info("Fichero obtenido...");
				log.info("Nombre de container: " + containerName);
				log.info("Nombre de accountName: " + accountName);

				azureUpload = new AzureUpload(accountName, accountKey, endpointSuffix, containerName);

				log.info("AzureUpload inicializado...");

				if (file == null) {
					resultDto.setCode(ResultDto.RESULT_CODE_KO);
					resultDto.setMessage("No hay ficheros para subir");
					return resultDto;
				}

				String fileName = file.getOriginalFilename();

				log.info("Fichero a subir: " + fileName);

				if (fileName.toUpperCase().endsWith("ZIP")) {
					unZip.unZipIt(file.getInputStream(), azureUpload);

				} else {
					azureUpload.uploadBlob(fileName, file.getInputStream(), file.getSize());
				}

				resultDto.setCode(ResultDto.RESULT_CODE_OK);
				resultDto.setMessage("File " + fileName + " uploaded successfully.");

			} catch (Exception e) {
				resultDto.setCode(ResultDto.RESULT_CODE_KO);
				resultDto.setMessage("Exception in uploading file");
				log.error("Error general subiendo fichero", e);
			}
			return resultDto;
		}
	}
}
