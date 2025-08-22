# Stage 1: Build app với Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy toàn bộ source code vào container
COPY . .

# Build project (tạo file JAR)
RUN mvn clean install -DskipTests

# Stage 2: Chạy app với JDK base image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy file JAR từ stage build sang
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]


