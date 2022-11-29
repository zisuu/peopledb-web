FROM openjdk:17-slim
COPY . /app
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-DSTORAGE_FOLDER=/tmp/", "-jar", "/app/build/libs/peopledb-web-0.0.1-SNAPSHOT.jar"]