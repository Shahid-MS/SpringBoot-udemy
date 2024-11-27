package com.ms.hello_world_docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/hello-world")
  public String helloWorld() {
    return "{\"message\":\"Hello World Spring Boot\"}";
  }
}
