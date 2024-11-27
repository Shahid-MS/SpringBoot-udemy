package com.ms.gradleaop;

import com.ms.gradleaop.Business.BusinessService;
import com.ms.gradleaop.Business.BusinessService2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradleaopApplication implements CommandLineRunner {

  @Autowired
  private BusinessService businessService;

  @Autowired
  private BusinessService2 businessService2;

  private Logger logger = LoggerFactory.getLogger(getClass());

  public static void main(String[] args) {
    SpringApplication.run(GradleaopApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("value return is : " + businessService.claculateMax());
    logger.info("value return is : " + businessService2.claculateMin());
  }
}
