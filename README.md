# Run the workshop

**After starting the workshop, open its documentation [here](http://docs.traceability.localhost)**

## Intel

Run the following commands:

```bash
./add_hosts.sh
./start.sh
```

## M1

1. Remove `workshop/services/fluentd/Dockerfile`
2. Rename `workshop/services/fluentd/Dockerfile.mac` to `workshop/services/fluentd/Dockerfile`
3. Run the commands:

```bash
./add_hosts.sh
./start.sh
```

# Stop the workshop

> The remove_hosts.sh command used to fully stop the workshop services will use the backup hosts file created locally to replace you current hosts file. If you prefer, you can open /etc/hosts and remove the added hosts manually.


Run the following commands:


```bash
./remove_hosts.sh
./stop.sh
```
