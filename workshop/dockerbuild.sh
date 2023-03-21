#!/bin/bash
(
    cd microservices/spring-jaeger-demo-userdiscounts
    docker build -t demo-userdiscounts .
)

(
    cd microservices/spring-jaeger-demo-usermanagement
    docker build -t demo-usermanagement .
)

(
    cd microservices/spring-jaeger-demo-userroles
    docker build -t demo-userroles .
)

(
    cd microservices/spring-jaeger-demo-gateway-swagger
    docker build -t demo-apidocs .
)