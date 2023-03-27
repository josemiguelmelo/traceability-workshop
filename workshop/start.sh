#!/bin/bash
(
    cd services
    docker-compose up -d
    sleep 120
    docker-compose up -d
)