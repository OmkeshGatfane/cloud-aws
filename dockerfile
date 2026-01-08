# Dockerfile
FROM maven:3.9.9 AS build
WORKDIR /workspace

# copy pom first to cache dependencies
COPY `pom.xml` .
RUN mvn -B dependency:go-offline

# copy sources and build
COPY `src` ./src
RUN mvn -B -DskipTests clean package

FROM eclipse-temurin:21-jdk AS runtime
WORKDIR /app

# optional: create non-root user (may fail on some images, harmless)
RUN groupadd -r app && useradd -r -g app app || true

# copy the built jar
COPY --from=build /workspace/target/*.jar app.jar
RUN chown app:app app.jar || true
USER app

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
