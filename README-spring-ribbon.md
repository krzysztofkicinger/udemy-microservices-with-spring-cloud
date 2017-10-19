# Spring Ribbon - Load Balancing

## What is Load Balancing?

**Traditional load balancers** are server-side components:
* Distribute incoming traffic among several servers
* Software (Apache, Nginx, HA Proxy) or Hardware (F5, NSX, BigIP)

![Image of Layers](./docs/images/load_balancing_1.png)

**Client-Side load balancers** selects which server to call:
* Based on some criteria
* Part of client software
* Server can still employ its own load balancer

![Image of Layers](./docs/images/load_balancing_2.png)

Why do we need load balancers?
* Not all servers are the same
* **Faults** - some servers may be unavailable
* **Performance** - some servers may be slower than others
* **Regions** - some servers may be further away than others

## Spring Cloud Netflix Ribbon

### Ribbon (alone) Introduction

1. Client side load balancer
2. Automatically integrates with service discovery (Eureka)
3. Built in failure resiliency (Hystrix)
4. Caching/Batching
5. Multiple protocols (HTTP, TCP, UDP)

Spring Cloud provides an easy API Wrapper for using Ribbon.

### List/Poll of possible servers

1. Determines what the list of possible servers are (for a given service (client))
    * **Static** - populated via configuration
    * **Dynamic** - populated via Service Discovery (Eureka)
2. Spring Cloud default - use Eureka when present on the classpath

```

```