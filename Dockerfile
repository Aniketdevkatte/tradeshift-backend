# Use official OpenJDK image (Java 22)
FROM openjdk:22-jdk

# Set working directory inside container
WORKDIR /app

# Copy everything from your project folder into container
COPY . .

# Build your Spring Boot project using Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Render sets PORT dynamically, use it
ENV PORT=8080
EXPOSE 8080

# Run the Spring Boot JAR (automatically detect jar file)
CMD ["sh", "-c", "java -jar target/*.jar --server.port=$PORT"]
