# Prerequisite

## Create a Docker network:

```shell
docker network create mylocal
```


# Example app

## Build

```shell
gradle clean shadowJar
docker build -t testdw .
```

## Run

```shell
docker run --name testdw --network mylocal -d -p 8080:8080 -p 8081:8081 testdw
```

## Generate traffic

Run the `Main` class.


# Monitoring

## Run Prometheus and Grafana

```shell
docker run --name prometheus -d --network mylocal -v ~/sources/testdw/prometheus.yml:/etc/prometheus/prometheus.yml -p 127.0.0.1:9090:9090 quay.io/prometheus/prometheus
docker run -d --name=grafana --network mylocal -p 3000:3000 grafana/grafana
```
## Configure Grafana

User/pwd: admin/admin, add datasource to `http://prometheus:9090` (proxy).
