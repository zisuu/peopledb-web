FROM openjdk:17-slim
COPY . /tmp
EXPOSE 8080
ENTRYPOINT ["java", "-DSTORAGE_FOLDER=/tmp/", "-jar", "/tmp/build/libs/peopledb-web-0.0.1-SNAPSHOT.jar"]