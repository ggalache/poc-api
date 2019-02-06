# Ejecución
   
   ```
   mvn spring-boot:run
   ```
# Swagger:
Se puede acceder a la documentación de las apis mediante 2 urls:

* json: http://localhost:8080/api-poc/v2/api-docs
* html: http://localhost:8080/api-poc/swagger-ui.html, en este caso también es posible ejecutarlas.

# Spring-boot actuator
## Endpoints
1. health: 
   * detalle completo: http://localhost:8080/api-poc/actuator/health
   * por componente:
      * base de datos: http://localhost:8080/api-poc/actuator/health/db

2. Todos los endpoints habilitados: http://localhost:8080/api-poc/actuator/

## Configuración
Se puede configurar que endpints habilitar, cuales exponer, temas de seguridd, etc. 
Se realiza através del archivo application.properties.

Por ejemplo:
 ```
#Actuator
#seguridad:
management.security.enabled=false 
#incluir los endpoints que se quiera, con * se incluyen todos.
management.endpoints.web.exposure.include=*

# HEALTH ENDPOINT
management.endpoint.health.show-details=always
 ```
### Links útiles:
* https://www.callicoder.com/spring-boot-actuator-metrics-monitoring-dashboard-prometheus-grafana/
* https://aboullaite.me/spring-boot-elastic-kibana/
* https://www.vojtechruzicka.com/spring-boot-actuator/
* web oficial: https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html
