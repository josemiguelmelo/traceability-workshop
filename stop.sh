#!/bin/bash
(
    cd workshop/services
    docker-compose stop
    docker-compose rm
)