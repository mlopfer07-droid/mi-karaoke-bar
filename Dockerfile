# Usamos Maven con Java 17 directamente
FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app
# Copiamos todo el proyecto
COPY . .
# Compilamos sin usar el archivo mvnw
RUN mvn clean package -DskipTests
EXPOSE 8080
# Arrancamos el archivo que se genera
CMD ["java", "-jar", "target/karaoke-0.0.1-SNAPSHOT.jar"]