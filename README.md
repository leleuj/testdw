Test Dropwizard
---------------

# Run docker images:

Run prometheus and Grafana:

```shell
docker run --name prometheus -d -p 127.0.0.1:9090:9090 quay.io/prometheus/prometheus
docker run -d --name=grafana -p 3000:3000 grafana/grafana
```

# Graphana configuration

User/pwd: admin/admin, add datasource to Prometheus


# Generate traffic:

To start HTTP calls on Dropwizard:

```shell
curl -X POST http://localhost:8081/tasks/call
```
