FROM openjdk:8u151-jre-slim
ADD target/api-posts-0.0.1-SNAPSHOT.jar /opt/api-posts-0.0.1-SNAPSHOT.jar
MAINTAINER davos8900@gmail.com
EXPOSE 8086
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/api-posts-0.0.1-SNAPSHOT.jar" ]
