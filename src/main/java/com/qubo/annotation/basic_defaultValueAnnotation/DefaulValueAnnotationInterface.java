package com.qubo.annotation.basic_defaultValueAnnotation;

public @interface DefaulValueAnnotationInterface {

	public String key() default "name";
	public String value() default "zhangsan";
}
