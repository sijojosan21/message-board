FROM openjdk:8-jdk-alpine as builder
WORKDIR '/app'
EXPOSE 4000

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

CMD ["./mvnw", "spring-boot:run"]
