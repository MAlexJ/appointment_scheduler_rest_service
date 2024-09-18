### Appointment scheduler app

### Project setup

* Java 21
* Springboot 3.3.3
* Gradle 8.10
* render.com webservice
* UptimeRobot webservice monitoring

### Project configuration

###### Add properties to `.env` file:

```
PORT=8080
APP_SERVICE_NAME=appointment_scheduler_rest_service

APP_SERVICE_ROOT_LOG_LEVEL=TRACE
APP_SERVICE_SPRING_LOG_LEVEL=TRACE

APP_SERVICE_MYSQL_URL=....mysql....
APP_SERVICE_MYSQL_PORT=.....
APP_SERVICE_MYSQL_DATABASE=client_events_db
APP_SERVICE_MYSQL_USERNAME=......
APP_SERVICE_MYSQL_PASSWORD=..........
```

### API documentation

Project uses OpenAPI (link: https://springdoc.org/)

Configuration api documentation endpoint in *.yaml file

```
springdoc:
  swagger-ui:
    path: /api/documentation
```

API documentation endpoint:  <br>

* http://{URL}:{port}/api/documentation

### Java code style

Java code style refers to the conventions and guidelines that developers follow when writing Java code to ensure
consistency and readability.

project: google-java-format,
link: https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config

### Github

#### Git

configuration

```
git config --global core.autocrlf true
```

#### Github action

issue:  ./gradlew: Permission denied
link: https://stackoverflow.com/questions/17668265/gradlew-permission-denied

You need to update the execution permission for gradlew

1. add action workflow

2. locally pull changes

3. run Git command:

```
git update-index --chmod=+x gradlew
git add .
git commit -m "Changing permission of gradlew"
git push
```

### Spring boot

#### Hikari pool

Configuring a Hikari Connection Pool with Spring Boot

link: https://www.baeldung.com/spring-boot-hikari

link: https://medium.com/@mukitulislamratul/maximizing-hikaricp-performance-in-spring-boot-applications-f7ee8474410a

#### Spring Data JPA

Spring Boot JPA (Java Persistence API) is a powerful framework that simplifies the development of Java applications 
that interact with relational databases.

link: https://springjava.com/spring-data-jpa/


### MySQL

#### SQL statements

Table of Contents

* Data Definition Statements
* Data Manipulation Statements
* Transactional and Locking Statements
* Replication Statements
* Prepared Statements
* Compound Statement Syntax
* Database Administration Statements
* Utility Statements

link: https://dev.mysql.com/doc/refman/8.4/en/sql-statements.html

### Render

#### configuration: server port

The default value of PORT is 10000 for all Render web services.
You can override this value by setting the environment variable for your service in the Render Dashboard.

```
issue: 
New primary port detected: 10000. 
Restarting deploy to update network configuration...
==> Docs on specifying a port: https://render.com/docs/web-services#port-binding

process.env.PORT

const port = process.env.PORT || 4000;
```

### Gradle

#### Gradle Versions Plugin

Displays a report of the project dependencies that are up-to-date, exceed the latest version found, have upgrades, or
failed to be resolved, info: https://github.com/ben-manes/gradle-versions-plugin

command:

```
gradle dependencyUpdates
```

#### Gradle wrapper

Gradle Wrapper Reference:
https://docs.gradle.org/current/userguide/gradle_wrapper.html

How to Upgrade Gradle Wrapper:
https://dev.to/pfilaretov42/tiny-how-to-upgrade-gradle-wrapper-3obl

```
./gradlew wrapper --gradle-version latest
```
