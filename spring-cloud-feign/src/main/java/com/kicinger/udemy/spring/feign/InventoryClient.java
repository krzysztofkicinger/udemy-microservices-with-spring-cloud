package com.kicinger.udemy.spring.feign;

import com.kicinger.udemy.spring.feign.model.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "http://localhost:8080/warehouse")
//@FeignClient("warehouse")
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
