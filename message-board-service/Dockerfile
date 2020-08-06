FROM openjdk:8-jdk-alpine as builder
WORKDIR '/app'

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw clean install


FROM openjdk:8-jdk-alpine
EXPOSE 4000
WORKDIR '/app'
COPY --from=builder /app/target/*.jar ./message-board-service.jar
ENTRYPOINT ["java","-jar","/message-board-service.jar"]