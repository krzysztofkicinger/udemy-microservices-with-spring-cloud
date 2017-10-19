# Spring Eureka - Service Discovery

## Chat analogy

1. Client **registers** itself with the **server** - server knows you are online
2. The **server** provides you with a list of all the other known clients
3. In essence, you client has **discovered** the other clients and **has itself been discovered** by others

## Service Discovery

1. Microservice architectures result in large numbers of inter-service calls - very challenging to configure
2. How can one application easily find all of the other runtime dependencies? - manual configuration, impractical, brittle
3. Service Discovery provides a **single 'lookup' service**:
    * Clients register themselves, discover other registrants
    * Solutions: Eureka, Consul, Zookeeper, SmartStack, etc.

## Eureka - Service Discovery Client and Server

1. Eureka provides a **'lookup' server**:
    * Generally made highly available by running multiple copies
    * Copies replicate state of registered services
2. **"Client'** services register with Eureka:
    * Address: Host + port
    * Health indicator URL (endpoint)
3. Client services send heatbeats to Eureka - Eureka removes services without heartbeats

## Eureka Server

### How to create a Eureka server?

Eureka server is just a regular Spring Boot web application with dependencies and **@EnableEurekaServer**

1. Add dependencies to the POM:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```

2. Add **@EnableEurekaServer**:

```java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}
```

### How to run multiple Eureka Servers?

Typically, multiple Eureka servers should be run simultaneously:
* Otherwise there will be many warnings in the log
* Eureka servers communicate with each other to share state
* Provides HA (High Availability)

Each server should know URL to the others:
* Can be provided by the Config Server
* One server (JAR), multiple profiles

## How to configure Eureka server?

Remember that Eureka server in multiple servers environment is also a client because it communicates with other Eureka Servers.

* **server.port** - control HTTP port Eureka runs on (for any boot application)
* **eureka.instance.statusPageUrlPath** -
* **eureka.instance.healthCheckUrlPath** -
* **eureka.instance.hostname** -
* **eureka.client.registerWithEureka** - use it when single copy of Eureka server runs (does not register Eureka to the zone, not for production)
* **eureka.client.fetchRegistry** - use it when single copy of Eureka server runs (does not fetch eny registry, not for production)
* **eureka.client.serviceUrl.defaultZone** - servers that Eureka (as a client) should connect to

```yml
server:
  port: 11002
eureka:
  instance:
    status-page-url-path: ${management.contextPath}/info
    health-check-url-path: ${management.contextPath}/health
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      default-zone: http://server:port/eureka, http://server:port/eureka
```

## Eureka Client

### How to register client with Eureka?

1. Add the dependency to the POM:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
```

2. Add the **@EnableEurekaClient** or **@EnableDiscoveryClient** to the Boot application

```java
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
```

3. Configure the url Eureka is listening on - application.yml (default fallback, any Eureka instance will do but we want several comma-separated URLs):

```yml
eureka:
  client:
    service-url:
      default-zone: http://localhost:11002/eureka
```