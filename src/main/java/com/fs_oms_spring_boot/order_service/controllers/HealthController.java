package com.fs_oms_spring_boot.order_service.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//annotation to tell springboot that this is a rest based controller
public class HealthController {
    // access dataTypeToReturn functionName
    @GetMapping("/health") // tells that this is a get api along with route
    public String health(){
        return "order service is running successfully";
    }
}
