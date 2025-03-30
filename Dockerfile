# Sử dụng JDK base image
FROM openjdk:17-jdk-slim

# Thông tin về maintainer
LABEL maintainer="your-email@example.com"

# Tạo thư mục để chứa ứng dụng
WORKDIR /app

# Copy file JAR từ target vào container
COPY target/*.jar app.jar

# Port mà ứng dụng Spring Boot sẽ chạy
EXPOSE 8080

# Command để chạy ứng dụng
ENTRYPOINT ["java","-jar","/app/app.jar"]