# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21-jdk AS build
WORKDIR /app

# Copy pom.xml first (dependency caching)
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy source code
COPY src ./src

# Build JAR
RUN mvn -B clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar spring.jar

# Expose Spring Boot port
EXPOSE 8080

# Run application
ENTRYPOINT ["java","-jar","spring.jar"]
