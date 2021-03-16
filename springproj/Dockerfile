FROM openjdk:8-jdk-alpine
WORKDIR /spring
COPY target/springproj-1.0.0.jar xyz.jar
ENTRYPOINT [ "sh" ,"-c","java -jar xyz.jar" ]
