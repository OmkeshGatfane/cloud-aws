FROM openjdk:21-oracle
WORKDIR /app
COPY target/*.jar /app/spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring.jar"]