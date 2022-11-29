#FROM gradle:7.5-jdk17 as builder
#COPY . /usr/src/java-code/
#WORKDIR /usr/src/java-code
#RUN gradle build --no-daemon
FROM openjdk:17-slim
EXPOSE 8080
USER root
COPY build/libs/peopledb-web-0.0.1-SNAPSHOT.jar peopledb-web-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "peopledb-web-0.0.1-SNAPSHOT.jar"]
