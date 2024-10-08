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

#### Replace token and git-version plugin

add import to build.gradle

```
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    .....
    id "com.palantir.git-version" version "3.1.0"
}

processResources {
    filter(ReplaceTokens, tokens:[appVersion: gitVersion()])
}

tasks.register('showVersion') {
    doLast {
        println "\nCurrent version: ${gitVersion()}\n"

        def details = versionDetails()
        println "last tag          : ${details.lastTag}"
        println "commit distance   : ${details.commitDistance}"
        println "hash              : ${details.gitHash}"
        println "branch name       : ${details.branchName}"
        println "is clean tag      : ${details.isCleanTag}"
    }
}
```

add placeholder to application.yaml file

```
application:
  version: @appVersion@

spring:
  data:
    jpa:
      repositories:
        enabled: true
```

create rest controller with property:

```
@RequestMapping("/api/v1")
public class AppInfoRestController {

    @Value("${application.version}")
    private String gitVersion;
```

##### Gradle: build version task

Allow BuildProperties bean to be used to get project info: version, name, time and group

```
springBoot {
    buildInfo()
}
```

create new rest controller:

```
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AppInfoRestController {

    /**
     * Provide build-related information such as group and artifact:
     * "name" -  name of the project
     * "time" -  timestamp of the build
     * "version" - version of the project
     * "group" - groupId
     * "artifact" - artifactId of the project
     */
    private final BuildProperties buildProperties;

    @GetMapping("/info")
    public ResponseEntity<BuildProperties> appInfo() {
        return ResponseEntity.ok(buildProperties);
    }
}
```