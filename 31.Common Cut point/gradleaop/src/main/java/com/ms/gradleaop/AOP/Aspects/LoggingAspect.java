// package com.ms.gradleaop.AOP.Aspects;

// import org.aspectj.lang.JoinPoint;
// import org.aspectj.lang.annotation.After;
// import org.aspectj.lang.annotation.AfterReturning;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.annotation.Configuration;

// // Configuration
// // AOP

// @Configuration
// @Aspect
// public class LoggingAspect {

//   private Logger logger = LoggerFactory.getLogger(getClass());

//   @Before(
//     "com.ms.gradleaop.AOP.Aspects.CommonPointcutConfig.businessAndDataPackage()"
//   )
//   public void logMethodCallBefore(JoinPoint joinPoint) {
//     // what
//     logger.info(
//       " Before Aspect Method is called : " +
//       joinPoint +
//       " Arguments: " +
//       joinPoint.getArgs()
//     );
//   }

//   @After("com.ms.gradleaop.AOP.Aspects.CommonPointcutConfig.businessPackage()")
//   public void logMethodCallAfter(JoinPoint joinPoint) {
//     // what
//     logger.info(
//       " After Aspect Method is executed : " +
//       joinPoint +
//       " Arguments: " +
//       joinPoint.getArgs()
//     );
//   }

//   @AfterReturning(
//     pointcut = "com.ms.gradleaop.AOP.Aspects.CommonPointcutConfig.dataPackage()",
//     returning = "resultValue"
//   )
//   public void logMethodCallAfterThrowing(
//     JoinPoint joinPoint,
//     Object resultValue
//   ) {
//     // what
//     logger.info(
//       " After Return Aspect Method is executed : " +
//       joinPoint.getSignature() +
//       " | Result value : " +
//       resultValue
//     );
//   }
// }
