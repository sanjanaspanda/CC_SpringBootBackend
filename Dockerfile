FROM amazoncorretto:17-alpine-jdk
LABEL maintainer="Sanjana Panda sanjanapanda1610@gmail.com"
COPY target/CareConnect-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]