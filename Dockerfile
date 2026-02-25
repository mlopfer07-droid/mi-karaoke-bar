# Usamos Java 17 con Maven ya instalado
FROM maven:3.8.4-openjdk-17-slim

# Creamos la carpeta de la app
WORKDIR /app

# Copiamos solo el archivo de configuración primero
COPY pom.xml .

# Copiamos la carpeta del código
COPY src ./src

# Construimos el proyecto directamente con maven
RUN mvn clean package -DskipTests

# Exponemos el puerto
EXPOSE 8080

# Arrancamos el karaoke
CMD ["java", "-jar", "target/karaoke-0.0.1-SNAPSHOT.jar"]
