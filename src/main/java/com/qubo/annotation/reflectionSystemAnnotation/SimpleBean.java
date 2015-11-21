package com.qubo.annotation.reflectionSystemAnnotation;

/**
 *		系统内建的 三种 Annotation:
 *																	1 Override
 *																    2 Deprecated  我们 使用 反射只能取到这一块 。因为这个的信息是保存在runtime当中的
 *																	3 SuppressWranings("uncheck")
 */
public class SimpleBean {

	@SuppressWarnings("uncheck")
	@Deprecated 
	@Override
	public String toString(){
		return "SimpleBean";
	}
}
