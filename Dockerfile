# Base image được sử dụng để build image
FROM openjdk:22

# Set working directory trong container
WORKDIR /app

# Copy file JAR được build từ ứng dụng Spring Boot vào working directory trong container
COPY target/blog-app-0.0.1-SNAPSHOT.jar blog-app-0.0.1-SNAPSHOT.jar
# Expose port của ứng dụng

# Chỉ định command để chạy ứng dụng khi container khởi chạy
CMD ["java", "-jar", "blog-app-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080