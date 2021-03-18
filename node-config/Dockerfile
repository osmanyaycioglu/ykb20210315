FROM openjdk:8-jdk-alpine
WORKDIR /spring
COPY target/node-config-1.0.0.jar xyz.jar
EXPOSE 9090
ENTRYPOINT [ "sh" ,"-c","java -jar xyz.jar" ]
