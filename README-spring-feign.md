# Spring Cloud Feign - Declarative REST Client

## What is Feign?

* Declarative REST client
* Allows to write calls to REST services with no implementation code
* Alternative to RestTemplate (even easier)
* Spring Cloud provides easy wrapper for using Feign

## Spring Rest Template

Template takes control of all HTTP and type conversion. But the code still must be written and unit-tested with mocks and stubs.

```
private RestTemplate restTemplate = new RestTemplate();

private String getName() {
    String url = "http://localhost:8080/{0}";
    return restTemplate.getForObject(url, String.class, 123);
}
```


## Feign - Declarative Web Service Clients

1. How does it work?
    * Define **interfaces** for REST clients
    * Annotate interface with **@Feign** annotation
    * Annotate methods with Spring MVC annotations - other implementation like JAX/RS pluggable
2. Spring Cloud will implement it at run-time:
    * Scans for interfaces
    * Automatically implements code to call REST service and process response

## How to create a Feign interface?

1. Mark the interface to be implemented by Feign - **@Feign** annotation
2. Set the url or the Eureka client ID
3. Annotate methods with Spring MVC mapping metadata

```
@FeignClient(url = "http://localhost:8080/warehouse")
public interface InventoryClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/inventory"
    )
    List<Item> getItems();

    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/inventory/{sku}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    void update(@PathVariable Long sku, @RequestBody Item item);

}
```

4. Implementation to the interface is provided by Spring/Feign - Spring scans for **@FeignClients** and provides implementation at runtime. The only thing that needs to be done is to annotate application with **@EnableFeignClients**

```
@SpringBootApplication
@EnableFeignClients
public class FeignApplication {
}
```

## What does @EnableFeignClients do?

1. Before startup there is only normal Java interface with **@FeignClient** annotation
2. Spring looks up during startup for **@FeignClient** interfaces
3. Spring creates an implementation - Spring-Implemented Proxy
4. It is just a bean that can be @Autowire'd anywhere in the application

## How to use Eureka, Ribbon and Feign cooperate?

Replace the url with the Eureka's Client ID:

```
@FeignClient("warehouse")
public interface InventoryClient {
}
```

* Ribbon is automatically enabled and applies load balancing
* Eureka gives application all "Clients" that match the given ID
* Feign handles the code