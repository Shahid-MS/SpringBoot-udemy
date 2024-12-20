package com.ms.google_authentication;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/")
  public String getHelloWorld(Authentication authentication) {
    System.out.println(authentication);
    System.out.println(authentication.getPrincipal());
    return "Hello World";
  }
}
