FROM openjdk:8u121-jre-alpine

COPY ./build/libs/testdw-all.jar /testdw-all.jar

COPY config.yml /config.yml

WORKDIR /

CMD ["java", "-jar", "testdw-all.jar", "server", "config.yml"]
