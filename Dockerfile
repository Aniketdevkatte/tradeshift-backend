# Use OpenJDK 22 image
FROM openjdk:22-jdk

# Install Maven (since mvnw isn’t in repo)
RUN apt-get update && apt-get install -y maven

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build Spring Boot JAR
RUN mvn clean package -DskipTests

# Expose port 8080
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "target/tradeshift-backend-0.0.1-SNAPSHOT.jar"]
