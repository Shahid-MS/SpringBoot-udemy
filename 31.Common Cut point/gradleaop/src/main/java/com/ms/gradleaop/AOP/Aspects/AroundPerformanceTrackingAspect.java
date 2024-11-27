package com.ms.gradleaop.AOP.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class AroundPerformanceTrackingAspect {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Around(
    "com.ms.gradleaop.AOP.Aspects.CommonPointcutConfig.configUsingAnnotation()"
  )
  public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint)
    throws Throwable {
    // Start Time
    long startTimeMS = System.currentTimeMillis();

    // Execute Method
    Object returnValue = proceedingJoinPoint.proceed();

    // end time
    long stopTimeMS = System.currentTimeMillis();
    long executionTime = stopTimeMS - startTimeMS;
    logger.info(
      "Around Aspect method : " +
      proceedingJoinPoint +
      " Execution Time : " +
      executionTime +
      " miliseconds"
    );

    return returnValue;
  }
}
