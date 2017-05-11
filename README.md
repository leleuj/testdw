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

## Run with Gelf driver

```shell
docker run --name testdw --log-driver=gelf --log-opt gelf-address=udp://localhost:12201 --network mylocal -d -p 8080:8080 -p 8081:8081 testdw
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


# Logs

## Run Graylog (and MongoDB and Elasticsearch)

```shell
docker run --network mylocal --name mongo -d mongo:3
docker run --network mylocal --name elasticsearch -d elasticsearch:2 elasticsearch -Des.cluster.name="graylog"
docker run --network mylocal --name graylog -p 9000:9000 -p 12201:12201 -e GRAYLOG_WEB_ENDPOINT_URI="http://localhost:9000/api" -d graylog2/server
```

## Configure Graylog

User/pwd: admin/admin