# Use a base image with Java support
FROM openjdk:17.0.1-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged JAR file into the container
COPY build/libs/mefit-backend-0.0.1-SNAPSHOT.jar app.jar

# Expose the port on which your Spring Boot application listens
EXPOSE 8080

# Set the entry point command to run your application
CMD ["java", "-jar", "app.jar"]
