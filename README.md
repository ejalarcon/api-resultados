# api-resultados

Proyectos con el api de resultados de pruebas automáticas.

También contiene el api necesaria para subir reports generados como zip al Storage de Azure.

Para ejecutarlo es necesario:

- Configurar fichero src/main/resources/application.properties 
- Añadir al crontab el script start-app-resultados.sh para que arranque al iniciar sistema operativo

Ajustar script de arranque de la aplicación Spring boot:

java -Dserver.port=XXXX -jar /path/api-resultados.jar


