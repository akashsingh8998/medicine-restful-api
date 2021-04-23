# Restful Api Service
## Services that can be used to connect to database

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
*   [Spring Cloud](https://spring.io/projects/spring-cloud) - Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, etc)
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.


## Running the application locally

here are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.saveo.medicinerestfulapi.App` class from your IDE.

- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- make sure to update the resources/application.properties file to connect to your local database
- Open Command Prompt and Change directory (cd) to folder containing pom.xml and run the command to install all the dependencies
```
mvn clean install
```
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (App.java file in  package `com.saveo.medicinerestfulapi` )
- Right Click on the file and Run as Java Application


Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

After this you can access the application from following url:
http://localhost:6769/swagger-ui.html

- Open Command Prompt and Change directory (cd) to folder containing pom.xml and run the command to run all the tests
```
mvn test
```

## packages

- `entity` — to hold our entities;
- `service` — to hold our business logic;
- `controller` — to listen to the client;
- `utils` — to hold the helper functions;

- `resources/` - Contains all the static resources, templates and property files.
- `resources/application.properties` - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. You can define server’s default port, server’s context path, database URLs etc, in this file.

- `test/` - contains unit tests

- `pom.xml` - contains all the project dependencies

 

