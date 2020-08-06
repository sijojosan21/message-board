FROM openjdk:8 as builder
WORKDIR '/app'
COPY . .
RUN ./mvnw clean install


FROM openjdk:8
EXPOSE 4000
WORKDIR '/app'
COPY --from=builder /app/target/*.jar ./