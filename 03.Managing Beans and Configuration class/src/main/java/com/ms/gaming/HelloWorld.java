package com.ms.gaming;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorld {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(MyConfig.class)) {
      //Get bean by name
      System.out.println(context.getBean("name"));

      //Get bean by type
      System.out.println(context.getBean(int.class));

      System.out.println(context.getBean("person"));

      //error as there is custom name
      // System.out.println(context.getBean("address"));
      System.out.println(context.getBean("customNameAddress"));

      //Using existing beans
      System.out.println(context.getBean("person2MethodCall"));
      System.out.println(context.getBean("person3Parameter"));

      // Print all beans
      System.out.println("All benas");
      Arrays
        .stream(context.getBeanDefinitionNames())
        .forEach(System.out::println);

      //Multiple matching beans
      System.out.println(context.getBean(Address.class));

      //Specific Bean
      System.out.println(context.getBean("personSpecificAddress"));
    }
  }
}
