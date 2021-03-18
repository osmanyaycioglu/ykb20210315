FROM openjdk:8-jdk-alpine
WORKDIR /spring
COPY target/ms-accounting-1.0.0.jar xyz.jar
EXPOSE 9090
ENTRYPOINT [ "sh" ,"-c","java -jar xyz.jar" ]
