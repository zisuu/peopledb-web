FROM gradle:6.9.3-jdk17 as builder
COPY . /usr/src/java-code/
WORKDIR /usr/src/java-code
RUN gradle bootJar -i --stacktrace

FROM openjdk:17-slim
EXPOSE 8080
USER root
WORKDIR /usr/src/java-app
COPY --from=builder /usr/src/java-code/build/libs/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
