FROM openjdk:17-slim
#WORKDIR /app
COPY build/libs/peopledb-web-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-DSTORAGE_FOLDER=/tmp/", "-jar", "app.jar"]
