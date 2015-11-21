package com.qubo.annotation.basic_one_params;

/**
 * 声明 一个 Annotation : @interface 我声明了一个 AnnotationInterface的Annotation
 * 
 * 11:18
 */
public @interface AnnotationInterface {

	// 格式 是 ： 类型 + 变量名 + () 这种方式是固定写法，它其实相当于 public String value;
	// 这个的意思是：我可以接受一个 String类型的参数
	public String value();

}
