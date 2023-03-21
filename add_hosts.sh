#!/bin/bash

cat /etc/hosts > hosts_bkp
echo  -e "\n127.0.0.1  api.traceability.localhost" >> /etc/hosts
echo  -e "127.0.0.1  kafka.traceability.localhost" >> /etc/hosts
echo  -e "127.0.0.1  logs.traceability.localhost" >> /etc/hosts
echo  -e "127.0.0.1  jaeger.traceability.localhost" >> /etc/hosts
echo  -e "127.0.0.1  docs.traceability.localhost" >> /etc/hosts