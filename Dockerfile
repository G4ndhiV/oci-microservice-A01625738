# Usar OpenJDK 17 con una imagen ligera
FROM openjdk:17-jdk-slim

# Definir el directorio de trabajo dentro del contenedor
WORKDIR /oci-microservice-A01625738

# Copiar el archivo JAR generado en target/
COPY target/*.jar oci-microservice-A01625738.jar

# Copiar la carpeta Wallet_javadev101 al contenedor
COPY src/main/resources/Wallet_javadev101 Wallet_javadev101

# Definir la variable de entorno TNS_ADMIN para Oracle Wallet
ENV TNS_ADMIN=/oci-microservice-A01625738/Wallet_javadev101

# Exponer el puerto 8080 para que el servicio sea accesible
EXPOSE 8080

# Comando de inicio del contenedor
ENTRYPOINT [ "java", "-jar", "oci-microservice-A01625738.jar" ]
