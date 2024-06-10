FROM khipu/openjdk17-alpine

# Establecer el directorio de trabajo en el contenedor
WORKDIR /microservices

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/eureka-service-0.0.1-SNAPSHOT.jar /microservices/eureka-service.jar

# Puerto en el que la aplicación expone sus servicios
EXPOSE 8761

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/microservices/eureka-service.jar"]