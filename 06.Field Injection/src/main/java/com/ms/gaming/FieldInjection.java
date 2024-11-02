package com.ms.gaming;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {

  @Autowired
  Depedency1 d1;

  @Autowired
  Depedency2 d2;

  public String toString() {
    System.out.println("To String Method Called");
    return "Dependency 1: " + d1 + " Dependency 2: " + d2;
  }
}

@Component
class Depedency1 {}

@Component
class Depedency2 {}

@Configuration
@ComponentScan
public class FieldInjection {

  public static void main(String[] args) {
    try (
      var context = new AnnotationConfigApplicationContext(FieldInjection.class)
    ) {
      Arrays
        .stream(context.getBeanDefinitionNames())
        .forEach(System.out::println);

      System.out.println(context.getBean(YourBusinessClass.class).toString());
    }
  }
}
