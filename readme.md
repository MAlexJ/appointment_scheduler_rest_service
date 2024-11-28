### Appointment scheduler app

#### Project setup

* Java 23
* Springboot 3.4.0
* Gradle 8.11.+
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

APP_SERVICE_TEST_ENDPOINT=...
```

### Java code style

Java code style refers to the conventions and guidelines that developers follow when writing Java code to ensure
consistency and readability.

project: google-java-format,
link: https://github.com/google/google-java-format/blob/master/README.md#intellij-jre-config

### Spring boot

#### Hikari pool

Configuring a Hikari Connection Pool with Spring Boot

link: https://www.baeldung.com/spring-boot-hikari

link: https://medium.com/@mukitulislamratul/maximizing-hikaricp-performance-in-spring-boot-applications-f7ee8474410a

#### Spring Data JPA

Spring Boot JPA (Java Persistence API) is a powerful framework that simplifies the development of Java applications
that interact with relational databases.

link: https://springjava.com/spring-data-jpa/

#### JPA

Issue JPA in PetClinic (Amplicode): https://youtu.be/efhh31qKTCk?t=1747

```
spring.jpa.properties.hibernate.default_batch_fetch_size=50
```

default_batch_fetch_size recommended values

link: https://stackoverflow.com/questions/21162172/default-batch-fetch-size-recommended-values

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