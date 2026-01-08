FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/*.jar /app/spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring.jar"]