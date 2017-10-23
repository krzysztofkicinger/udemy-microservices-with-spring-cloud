package com.kicinger.udemy.cloud.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(url = "localhost:8080/warehouse")
public interface CachedFeignClient {

    @Cacheable(value = "inventory", key = "#id")
    @RequestMapping("/inventory/{id}")
    public String getInventoryItemName(@PathVariable Long id);

}
