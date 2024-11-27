package com.ms.gradleaop.AOP.Aspects;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

// Configuration
// AOP

@Configuration
@Aspect
public class LoggingAspect {

  private Logger logger = LoggerFactory.getLogger(getClass());

  // Pointcut when ?
  //   execution(* PACKAGE.*.*(..))

  // Business package
  //   @Before("execution(* com.ms.gradleaop.Business.*.*(..))")
  //  Data package
  //   @Before("execution(* com.ms.gradleaop.Data.*.*(..))")

  //  All Intercept
  @Before("execution(* com.ms.gradleaop.*.*.*(..))")
  public void logMethodCallBefore(JoinPoint joinPoint) {
    // what
    logger.info(
      " Before Aspect Method is called : " +
      joinPoint +
      " Arguments: " +
      joinPoint.getArgs()
    );
  }

  //   @After("execution(* com.ms.gradleaop.*.*.*(..))")
  //   public void logMethodCallAfter(JoinPoint joinPoint) {
  //     // what
  //     logger.info(
  //       " After Aspect Method is executed : " +
  //       joinPoint +
  //       " Arguments: " +
  //       joinPoint.getArgs()
  //     );
  //   }

  //   @AfterThrowing(
  //     pointcut = "execution(* com.ms.gradleaop.*.*.*(..))",
  //     throwing = "exception"
  //   )
  //   public void logMethodCallAfterThrowing(
  //     JoinPoint joinPoint,
  //     Exception exception
  //   ) {
  //     logger.info("Exception Type: " + exception.getClass().getName());
  //     // what
  //     logger.info(
  //       " After Throwing error Aspect Method is executed : " +
  //       joinPoint.getSignature() +
  //       " | Arguments: " +
  //       Arrays.toString(joinPoint.getArgs()) +
  //       " | Exception: " +
  //       exception.getMessage()
  //     );
  //   }

  // @AfterReturning(
  //   pointcut = "execution(* com.ms.gradleaop.*.*.*(..))",
  //   returning = "resultValue"
  // )
  // public void logMethodCallAfterThrowing(
  //   JoinPoint joinPoint,
  //   Object resultValue
  // ) {
  //   // what
  //   logger.info(
  //     " After Return Aspect Method is executed : " +
  //     joinPoint.getSignature() +
  //     " | Result value : " +
  //     resultValue
  //   );
  // }
}
