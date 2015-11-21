package com.qubo.annotation.basic_two_params;

/**
 *	因为 我在使用的 注解中声明了两个字段
 *		public String key();
 *		public String value();
 *		
 *		所以我在使用的时候，就必须 进行给两个字段分别赋值
 */
@AnnotationInterface(key="name",value="zhangsan")
public class AnnotationInterfaceMain {

}
