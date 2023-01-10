FROM openjdk:8u151-slim
MAINTAINER david hurtado "davos8900@gmail.com"
COPY arquitectura-discovery-server.jar /opt/arquitectura-discovery-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-jar", "/opt/arquitectura-discovery-server.jar"]
