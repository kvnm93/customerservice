FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/customer-service-1.0-SNAPSHOT-exec.jar .
ENTRYPOINT ["java","-jar","/customer-service-1.0-SNAPSHOT-exec.jar"]