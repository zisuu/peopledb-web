FROM openjdk:17-slim
RUN mkdir /app
COPY . /app
WORKDIR /app
#RUN gradle build
#CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
CMD ["java", "-DSTORAGE_FOLDER=/tmp/", "-jar", "build/libs/peopledb-web-0.0.1-SNAPSHOT.jar"]