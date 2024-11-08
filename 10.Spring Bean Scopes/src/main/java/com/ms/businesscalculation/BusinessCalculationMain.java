package com.ms.businesscalculation;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class singletonClass{
  
}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class prototypeClass{

}



@Configuration
@ComponentScan
public class BusinessCalculationMain {

  public static void main(String[] args) {
    try (
      var context = new AnnotationConfigApplicationContext(
        BusinessCalculationMain.class
      )
    ) {

      System.out.println(context.getBean(singletonClass.class));
      System.out.println(context.getBean(singletonClass.class));

      System.out.println(context.getBean(prototypeClass.class));
      System.out.println(context.getBean(prototypeClass.class));
      System.out.println(context.getBean(prototypeClass.class));
     
    }
  }
}
