# Udemy - Microservices with Spring Cloud (Boot, Data, Data REST)

## Spring Boot

### What happens when Spring Boot runs the application?

* **SpringApplication.run(...)** - creates new Spring application context
* **@SpringBootApplication**:
    - Combination of **@Configuration**:
        - Marks a configuration file
        - Java equivalent of <beans> file
    - ... and **@ComponentScan**:
        - Looks for @Components
    - ... and **@EnableAutoConfiguration**
        - Master runtime switch for Spring Boot
        - Examines ApplicationContext & classpath
        - Creates missing beans based on intelligent defaults

### What happens when Spring Boot runs the web application?

**spring-boot-starter-web**

- adds spring-web, spring-mvc jars
- adds embedded Tomcat jars

**When application starts:**

- **@EnableAutoConfiguration** looks for 'missing' beans
    - Based on specified beans + classpath
    - Notices @Controller / Spring MVC jars
- Automatically creates **MVC beans**:
    - DispatcherServlet
    - HandlerMappings
    - Adapters
    - ViewResolvers
- Launches **embedded Tomcat** instance

### How to convert JAR to WAR?

1. Change POM packaging to
2. Extend SpringBootServletInitializer

```java
@SpringBootApplication
public class SpringBootWarApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootApplication.class);
    }

}
```

3. Deploy to app server (url becomes: http://localhost:8080/<app>)

### What about Web Pages?

- Spring MVC supports a wide range of view options
- Easy to use: JSP, Freemaker, Thymeleaf
- Boot automatically establishes defaults:
    - **InternalResourceViewResolver** for JSPs
    - **ThymeleafViewResolver** if Thymeleaf is on the classpath
- Thymeleaf: **spring-boot-starter-thymeleaf**

### How to use thymeleef web pages?

1. Add **spring-boot-starter-thymeleaf** to the POM
    - Automatically configures ThymeleafViewResolver
2. Create **/templates** folder in the /resources
    - By default thymeleaf looks here
3. Create endpoint that returns the name of the page: **name**.html

### How to use JSP Web Pages?

1. Place JSP in desired folder - /src/main/webapp/WEB-INF/views
2. Set **spring.mvc.view.prefix**
3. Set **spring.mvc.view.suffix**
4. Exclude **spring-boot-starter-tomcat**

### Rest Controllers in Spring MVC

Creating simple Rest Controller:
- @Controller + @ResponseBody
- (or) @RestController

Request Mappings:
- @GetMapping
- @PostMapping
- ..

Parameters:
- "/{name}" + @PathVariable
- @RequestBody
- @QueryParam

### How to return XML from Rest endpoint?

// TODO

## Spring Data JPA

Introduction:
- Typical web application
- REST Controllers provide CRUD interface to clients
- DAO provide CRUD interface to DB

Spring Data Repositories = **Instant Repositories**:
- Spring Data provides **dynamic repositories**
- We provide interface - Spring Data dynamically implements it
    - JPA
    - MongoDB
    - GemFire, etc.
- Service Layer/Controllers have almost no logic

### How to introduce Spring Data to the project?

1. Add dependency for **spring-boot-starter-data-jpa**
2. Add dependency for database (e.g. hsqldb)
3. Annotate Domain objects with plain JPA annotations
4. Add an interface for Spring Data JPA
5. Inject repository to controllers

When application starts:
- SpringData dynamically implements repositories
- DataSource, Transaction Management are handled

### How to create repository?

1. Create **interface**
2. Extend:
    - CrudRepository<entity, id>
    - JpaRepository<entity, id>

```java
public interface TeamRepository extends CrudRepository<Team, Long> {
}
```

3. Create additional methods signature - fulfil the convention:
- findAll
- findBy<field><operation>

## Spring Data Rest

- Application simply exposes DAO methods as REST resources
- Generates RESTful interface: GET, PUT, POST, DELETE

### How to introduce Spring Data Rest?

1. Add **spring-boot-starter-data-rest**
2. Add **@RestResource** to the data interface

### HATEOS

- Replaces all entities related to object with URI
- This URI points to particular resource

**How to add id?**

- Create a repository for connected entities
- All children should be represented by links

```json
{
    "name": "Peanuts",
    ...
    "_links": {
        "players": {
            "href": "http://localhost:8080/teams/1/players"
        }
    }
}
```