package com.qubo.annotation.targetAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//@Target(value = {ElementType.TYPE , ElementType.METHOD})
@Target({ElementType.TYPE , ElementType.METHOD})
public @interface TwoTargetAnnotation {

	public String key() default "qubo";
	public String value() default "学习 使用 Annotation 中的 Target ，并同时声明两个ElementType";
}
