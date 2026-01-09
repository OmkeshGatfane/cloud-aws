FROM amazoncorretto:17
WORKDIR /app
COPY target/*.jar /app/spring.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring.jar"]