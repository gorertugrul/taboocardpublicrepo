FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/taboopublicservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} taboopublicservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/taboopublicservice-0.0.1-SNAPSHOT.jar"]


