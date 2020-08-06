FROM openjdk:8-jdk-alpine as builder
WORKDIR '/app'
COPY . .
RUN ./mvnw clean install


FROM openjdk:8-jdk-alpine
EXPOSE 4000
WORKDIR '/app'
COPY --from=builder /app/target/*.jar ./message-board-service.jar
RUN ls
ENTRYPOINT ["java","-jar","/message-board-service.jar"]