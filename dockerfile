FROM openjdk:26-ea-jdk
WORKDIR /app
COPY target/*.jar /app/spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring.jar"]