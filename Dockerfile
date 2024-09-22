# Spring project is prepared to run on https://render.com/ webservice
#
# Build stage
FROM gradle:8.10.0-jdk21-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
COPY ../.git .
WORKDIR /home/gradle/src

USER root
RUN chown -R gradle /home/gradle
RUN chmod 777 /home
USER gradle

RUN gradle build -x test

LABEL org.name="malex"
# Package stage
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /home/gradle/src/build/libs/appointment_scheduler_rest_service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]