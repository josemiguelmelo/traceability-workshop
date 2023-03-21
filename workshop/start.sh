#!/bin/bash
(
    cd services
    docker-compose up -d
    sleep 30
    docker-compose up -d
)