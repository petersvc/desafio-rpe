FROM eclipse-temurin:21-alpine as build

COPY . .

RUN apk add maven
RUN mvn clean install

FROM eclipse-temurin:21-alpine

EXPOSE 8080

COPY --from=build /target/desafio-rpe-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]