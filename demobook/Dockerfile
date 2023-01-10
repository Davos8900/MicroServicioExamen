FROM openjdk:8u151-jre-slim
ADD target/demobook-0.0.1-SNAPSHOT.jar /opt/demobook-0.0.1-SNAPSHOT.jar
MAINTAINER davos8900@gmail.com
EXPOSE 8084
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/demobook-0.0.1-SNAPSHOT.jar" ]
