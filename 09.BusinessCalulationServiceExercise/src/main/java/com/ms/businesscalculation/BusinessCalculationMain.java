package com.ms.businesscalculation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BusinessCalculationMain {

  public static void main(String[] args) {
    try (
      var context = new AnnotationConfigApplicationContext(
        BusinessCalculationMain.class
      )
    ) {
      System.out.println(
        context.getBean(BusinessCalculationService.class).findMax()
      );
    }
  }
}
