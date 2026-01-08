FROM openjdk:26-ea-29-jdk-slim
WORKDIR /app
COPY target/*.jar /app/spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring.jar"]