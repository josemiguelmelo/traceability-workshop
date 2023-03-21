FROM maven:3.8.5-openjdk-17 as builder

WORKDIR /build/src
COPY ./ /build/src
RUN mvn clean install -DskipTests

FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/gateway-0.0.1-SNAPSHOT.jar
COPY --from=builder /build/src/${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]