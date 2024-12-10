package com.ms.todoapp.Todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicSecurity {

  @GetMapping("/basicauth")
  public String basicAuth() {
    return "Security success";
  }
}
