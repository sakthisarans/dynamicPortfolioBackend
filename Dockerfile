FROM --platform=arm64 maven:3.9.5 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM --platform=arm64 openjdk:17-oracle
EXPOSE 8080
COPY --from=build /home/app/target/auth-0.1.jar  app.jar
ENTRYPOINT exec java $JAVA_OPTS  -jar /app.jar
