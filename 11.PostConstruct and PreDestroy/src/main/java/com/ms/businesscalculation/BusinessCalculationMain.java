package com.ms.businesscalculation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class MyClass {

  private DependencyClass dependencyClass;

  MyClass(DependencyClass dependencyClass) {
    System.out.println("Constructor is called");
    this.dependencyClass = dependencyClass;
    System.out.println("All dependencies are ready");
  }

  @PostConstruct
  public void postContructMethod() {
    dependencyClass.initialize();
  }

  @PreDestroy
  public void cleanUp() {
    System.out.println("CleanUp pre Destroy");
  }
}

@Component
class DependencyClass {

  public void initialize() {
    System.out.println("Initialize Method Called");
  }
}

@Configuration
@ComponentScan
public class BusinessCalculationMain {

  public static void main(String[] args) {
    try (
      var context = new AnnotationConfigApplicationContext(
        BusinessCalculationMain.class
      )
    ) {}
  }
}
