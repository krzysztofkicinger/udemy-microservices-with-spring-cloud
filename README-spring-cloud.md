# Spring Cloud

## Goal of Spring Cloud

Provide libraries to apply common patterns needed in distributed applications:
- Distributed/Versioned/Centralized Configuration Management
- Service Registration and Discovery
- Load Balancing
- Service-To-Service Calls
- Circuit Breakers
- Routing
- ...

## Common Concepts

1. Spring Cloud projects are all based on Spring Boot
- Difficult to employ using only core Spring Framework
- Dependency management based on Boot
- ApplicationContext startup process modified

2. **Server** vs **Client**
- Both are relative terms - based on the role in a relationship
- Microservice is often a client and a server

## How to initialize Spring Cloud project?

1. Replace Spring Boot parent with Spring Cloud

```xml
<parent>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-parent</artifactId>
    <version>Dalston.SR4</version>
</parent>
```

or start with the **dependencyManagement** system:
- this allows to reference the parent POM without being a parent
- parent can be any POM we want
- sth like multi-inheritance

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.0.M3</version>
</parent>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Dalston.SR4</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

2. Add any dependency that is required

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-*</artifactId>
</dependency>
```

# Spring Cloud Config - Distributed/Versioned/Centralized Configuration Management

## Application Configuration

- Application are more than just code (connections to resources, other applications)
- Usually external configuration adjusts software behavior:
    - Where resources are located
    - How to connect to the DB, etc.

## Configuration Options

- Package configuration files with application - requires rebuild, restart
- Configuration files in common file system - unavailable in cloud
- Use environment variables:
    - Done differently on different platforms
    - Large # of individual variables to manage/duplicate
- Use a cloud-vendor specific solution - coupling application to specific environment

## Other configuration challenges

- **Microservices** - large number of dependent services (manual work, brittle)
- **Dynamic updates** - changes to services or environment variables require restage or restart (deployment activities)
- **Version control** - traceability

## Desired solution for Configuration

- **Language/Platform/Cloud-Independent**
- **Centralized** - one or a few discreet sources of our choosing
- **Dynamic** - ability to update settings while an application is running
- **Controllable** - same SCM choices we use with software
- **Passive** - services (applications) should do most of the work themselves by self-registering