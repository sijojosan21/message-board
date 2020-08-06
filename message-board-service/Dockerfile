FROM openjdk:8 as builder
WORKDIR '/app'
COPY . .
CMD ["./mvn", "clean", "install"]



FROM openjdk:8
WORKDIR '/app'
EXPOSE 4000
COPY --from=builder /app/target/*.jar ./