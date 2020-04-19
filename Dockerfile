FROM ubuntu:18.04 as build
RUN mkdir -p ~/.m2 && rm -rf ~/.m2/settings.xml
RUN apt update && apt install -y openjdk-8-jdk-headless maven git --no-install-recommends && rm -rf /var/lib/apt/lists/* \
             && update-alternatives --set java /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java
COPY . /
RUN cp /ForDocker/settings.xml ~/.m2/
RUN mvn dependency:go-offline
RUN  mvn clean package -DskipTests

FROM alpine:latest
RUN apk update && apk fetch openjdk8  && apk add openjdk8
RUN apk --no-cache add curl
RUN mkdir -p /opt/unacademy
COPY --from=build /target/*.jar /opt/unacademy
EXPOSE 8080
CMD java -Xms200m -Xmx800m -jar /opt/unacademy/redis-usage-0.0.1-SNAPSHOT.jar --server.port=8080
