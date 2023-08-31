FROM maven:3.8.6-eclipse-temurin-17-alpine AS package
WORKDIR /app
COPY pom.xml ./
RUN mvn -B dependency:resolve
COPY src ./src
RUN mvn -B package -Dspring.config.location=./src/main/resources/application.yml,./src/main/resources/test.yml

FROM eclipse-temurin:17-jdk-focal
WORKDIR /app
COPY --from=package /app/target/backend.jar /app/src/main/resources/application.yml ./
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app/backend.jar", "--spring.config.location=/app/application.yml"]
