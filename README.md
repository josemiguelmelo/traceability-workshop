# Run the workshop

**After starting the workshop, open its documentation [here](http://docs.traceability.localhost)**

## Intel

Run the following commands:

```bash
sudo ./add_hosts.sh
./start.sh
```

## M1

1. Remove `workshop/services/fluentd/Dockerfile`
2. Rename `workshop/services/fluentd/Dockerfile.mac` to `workshop/services/fluentd/Dockerfile`
3. Run the commands:

```bash
sudo ./add_hosts.sh
./start.sh
```

## Windows

1. Add the following hosts to your unknown hosts (`C:\Windows\System32\drivers\etc\hosts`) - should be edited with Admin privileges

```
127.0.0.1  api.traceability.localhost
127.0.0.1  kafka.traceability.localhost
127.0.0.1  logs.traceability.localhost
127.0.0.1  jaeger.traceability.localhost
127.0.0.1  docs.traceability.localhost
```

2. Run the commands:

```bash
cd workshop
cd services
docker-compose up -d
```

# Stop the workshop

> The remove_hosts.sh command used to fully stop the workshop services will use the backup hosts file created locally to replace you current hosts file. If you prefer, you can open /etc/hosts and remove the added hosts manually.


Run the following commands:


```bash
sudo ./remove_hosts.sh
./stop.sh
```
