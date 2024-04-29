FROM eclipse-temurin:21-alpine as build

COPY . .

RUN apk add maven
RUN mvn clean install

FROM eclipse-temurin:21-alpine

EXPOSE 8080

COPY --from=build /target/desafioRpe-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]