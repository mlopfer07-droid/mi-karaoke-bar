# Usamos una imagen de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Creamos una carpeta para nuestra app
WORKDIR /app

# Copiamos todo lo que tienes en GitHub a esa carpeta
COPY . .

# Le damos permiso al archivo que ayuda a compilar
RUN chmod +x mvnw

# Construimos el proyecto (esto crea el archivo .jar)
RUN ./mvnw clean package -DskipTests

# Exponemos el puerto que usa Render
EXPOSE 8080

# Comando para arrancar el karaoke
CMD ["java", "-jar", "target/karaoke-0.0.1-SNAPSHOT.jar"]