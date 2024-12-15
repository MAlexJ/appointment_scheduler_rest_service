### Gradle

Gradle is a build automation tool for multi-language software development.
It controls the development process in the tasks of compilation and packaging to testing, deployment, and publishing

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