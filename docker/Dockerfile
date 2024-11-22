# Spring project is prepared to run on https://render.com/ webservice
#
# Build stage
FROM gradle:8.11.1-jdk23-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test

LABEL org.name="malex"
# Package stage
FROM eclipse-temurin:23-jdk-alpine
EXPOSE 8080 5005
COPY --from=build /home/gradle/src/build/libs/appointment_scheduler_rest_service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Xdebug", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005","-jar","/app.jar"]