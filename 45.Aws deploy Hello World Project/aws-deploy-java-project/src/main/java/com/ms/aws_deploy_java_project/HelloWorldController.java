package com.ms.aws_deploy_java_project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/")
  public String getHelloWorld() {
    return "{\"message\":\"Hello World\"}";
  }
}
