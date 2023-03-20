#!/bin/bash
(
    cd services/spring-jaeger-demo-userdiscounts
    mvn clean install -DskipTests
    docker build -t demo-userdiscounts .
)

(
    cd services/spring-jaeger-demo-usermanagement
    mvn clean install -DskipTests
    docker build -t demo-usermanagement .
)

(
    cd services/spring-jaeger-demo-userroles
    mvn clean install -DskipTests
    docker build -t demo-userroles .
)

(
    cd services/spring-jaeger-demo-gateway-swagger
    mvn clean package -DskipTests
    docker build -t demo-apidocs .
)