package com.ms.restful_services.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping(path = "/hello-world")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/hello-world-bean")
  public HelloWorldBean helloWorldBean() {
    return new HelloWorldBean("Hello-World-Bean");
  }

  @GetMapping("/hello-world-bean/path-variable/{name}")
  public HelloWorldBean helloWorldBean(@PathVariable String name) {
    return new HelloWorldBean("Hello " + name);
  }
}
