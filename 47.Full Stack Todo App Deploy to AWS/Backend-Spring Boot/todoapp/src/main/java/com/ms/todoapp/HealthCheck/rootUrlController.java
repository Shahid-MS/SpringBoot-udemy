package com.ms.todoapp.HealthCheck;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rootUrlController {
    @GetMapping(path = "/")
    public String rootUrlHealthCheck(){
        return "Everything fine";
    }
}
