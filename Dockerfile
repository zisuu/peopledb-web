#FROM gradle:7.5-jdk17 as builder
#COPY . /usr/src/java-code/
#WORKDIR /usr/src/java-code
#RUN gradle build --no-daemon
FROM openjdk:17-slim
EXPOSE 8080
USER root
WORKDIR /usr/src/java-app
COPY . /usr/src/java-code/
ENTRYPOINT ["java", "-jar", "build/libs/peopledb-web-0.0.1-SNAPSHOT.jar"]
