package com.ms.gradleaop.AOP.Aspects.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Methods
@Target(ElementType.METHOD)
// Runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackTime {
}
