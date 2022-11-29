#FROM gradle:7.5-jdk17 as builder
#COPY . /usr/src/java-code/
#WORKDIR /usr/src/java-code
#RUN gradle build --no-daemon
FROM openjdk:17-slim
WORKDIR /app
COPY ./build/libs/peopledb-web-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java", "-DSTORAGE_FOLDER=/tmp/", "-jar", "peopledb-web-0.0.1-SNAPSHOT.jar"]