package com.annotation.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LogInfo {
	public String value() default "";
}
