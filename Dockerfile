FROM openjdk:8-jdk-alpine

WORKDIR /app
COPY target/ms-desafio-1.0.0-SNAPSHOT.jar app.jar
EXPOSE 8031
CMD ["java", "-jar", "app.jar"]
CMD ["java", "-jar", "app.jar"]