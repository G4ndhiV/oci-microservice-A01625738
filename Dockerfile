# Usar OpenJDK 17 con una imagen ligera
FROM openjdk:17-jdk-slim

# Definir el directorio de trabajo dentro del contenedor
WORKDIR /oci-microservice-A01625738

# Copiar el archivo JAR desde target/
# Se usa `*.jar` para copiar cualquier versión generada
COPY target/*.jar oci-microservice.jar

# Copiar la carpeta Wallet_javadev101 si existe
COPY src/main/resources/Wallet_javadev101 /oci-microservice-A01625738/Wallet_javadev101

# Definir la variable de entorno TNS_ADMIN para Oracle Wallet
ENV TNS_ADMIN=/oci-microservice-A01625738/Wallet_javadev101

# Exponer el puerto 8080 para que el servicio sea accesible
EXPOSE 8081

# Comando de inicio del contenedor
ENTRYPOINT ["java", "-jar", "oci-microservice.jar"]
