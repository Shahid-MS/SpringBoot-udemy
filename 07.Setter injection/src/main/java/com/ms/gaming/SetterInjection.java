package com.ms.gaming;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {

  Depedency1 d1;

  Depedency2 d2;

  @Autowired
  public void setD1(Depedency1 d1) {
    System.out.println("Setter D1 Called");
    this.d1 = d1;
  }

  @Autowired
  public void setD2(Depedency2 d2) {
    System.out.println("Setter D2 Called");
    this.d2 = d2;
  }

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
public class SetterInjection {

  public static void main(String[] args) {
    try (
      var context = new AnnotationConfigApplicationContext(
        SetterInjection.class
      )
    ) {
      // Arrays
      //   .stream(context.getBeanDefinitionNames())
      //   .forEach(System.out::println);

      System.out.println(context.getBean(YourBusinessClass.class).toString());
    }
  }
}
