FROM eclipse-temurin:21-alpine
WORKDIR /api
COPY . .
RUN apk add maven
CMD ["mvn", "spring-boot:run"]