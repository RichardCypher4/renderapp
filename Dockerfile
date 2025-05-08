# ---- Build Stage ----
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app
COPY . .

# Ensure Maven wrapper is executable
RUN chmod +x mvnw

# Build the application (skipping tests)
RUN ./mvnw clean package -DskipTests

# ---- Run Stage ----
FROM eclipse-temurin:21-jre

WORKDIR /app
EXPOSE 8080

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
