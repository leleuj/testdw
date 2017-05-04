Test Dropwizard
---------------

# Run docker images:

Create a network, run the web service, prometheus and Grafana:

```shell
# create local network
docker network create mylocal

# build web service
gradle clean shadowJar
# and package it as a docker image
docker build -t testdw .

# run all docker images
docker run --name testdw --network mylocal -d -p 8080:8080 -p 8081:8081 testdw
docker run --name prometheus -d --network mylocal -v ~/sources/testdw/prometheus.yml:/etc/prometheus/prometheus.yml -p 127.0.0.1:9090:9090 quay.io/prometheus/prometheus
docker run -d --name=grafana --network mylocal -p 3000:3000 grafana/grafana
```

# Graphana configuration

User/pwd: admin/admin, add datasource to `http://localhost:9090` (direct).


# Generate traffic:

Run the `Main` class.
