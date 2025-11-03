# Use Maven image that already includes Java 22
FROM maven:3.9.6-eclipse-temurin-22

# Set working directory inside the container
WORKDIR /app

# Copy the entire project
COPY . .

# Build the project (skip tests for speed)
RUN mvn clean package -DskipTests

# Expose port 8080 for the Spring Boot app
EXPOSE 8080

# Run the jar
CMD ["java", "-jar", "target/tradeshift-backend-0.0.1-SNAPSHOT.jar"]
