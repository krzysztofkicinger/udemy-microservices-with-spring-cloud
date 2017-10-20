package com.kicinger.udemy.cloud.hystrix;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Future;

@Component
public class StoreIntegration {

    @HystrixCommand(
            fallbackMethod = "defaultStores",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "20"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000")
            }
    )
    public Object getStores(Map<String, Object> parameters) {
        // do stuff that might fail
        return null;
    }


    @HystrixCommand(fallbackMethod = "defaultStores")
    public Future<Object> getStoresAsynchronously(Map<String, Object> parameters) {
        return new AsyncResult<Object>() {
            @Override
            public Object invoke() {
                //do stuff that might fail
                return null;
            }
        };
    }

//    @HystrixCommand(fallbackMethod = "defaultStores")
//    public Observable<Object> getStoresObservable(Map<String, Object> parameters) {
//        return new Observable<Object>() {
//            @Override
//            public Object invoke() {
//                //do stuff that might fail
//                return null;
//            }
//        };
//    }

    public Object defaultStores(Map<String, Object> parameters) {
        // do useful stuff
        return "Some Storage";
    }

}
