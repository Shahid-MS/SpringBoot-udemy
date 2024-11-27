package com.ms.gradleaop.AOP.Aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {

  @Pointcut("execution(* com.ms.gradleaop..*.*(..))")
  public void businessAndDataPackage() {}

  @Pointcut("execution(* com.ms.gradleaop.Business..*.*(..))")
  public void businessPackage() {}

  @Pointcut("execution(* com.ms.gradleaop.Data..*.*(..))")
  public void dataPackage() {}

  @Pointcut("bean(*Service*)")
  public void configUsingBean() {}

  @Pointcut("@annotation(com.ms.gradleaop.AOP.Aspects.Annotations.TrackTime)")
  public void configUsingAnnotation() {}
}
