package com.qubo.reflection;

import java.lang.reflect.Method;

import com.qubo.config.Config;

public class Ch05 {

	/**
	 * 本章 主要实现的内容:
	 * 												1 通过反射 调取 类的内部方法
	 */
	public static void main(String[] args) throws Exception {
		
		Class<?> cls = Class.forName("com.qubo.reflection.Child1");
		// 调取 类  的 内部 无参方法
		invokeNoParamsMethod(cls);
		Config.printEnter();
		// 调取 类 的 内容 有参方法
		invokeParamsMethod(cls);

	}

	/**
	 * 调取 Child1 中的 无参方法 sayChina();
	 */
	public static void invokeNoParamsMethod(Class<?> cls) throws Exception{
			
		/*Child1 c1 = (Child1)cls.newInstance();
			c1.sayChina();*/
		
		Method m = cls.getMethod("sayChina");
		
		m.invoke(cls.newInstance());
		
	}
	
	/**
	 *调取 Child1 中的 无参方法 sayHello(String,int);
	 */
	public static void invokeParamsMethod(Class<?> cls) throws Exception{
		
				Method m = cls.getMethod("sayHello", String.class , int.class);
				String returnStr = "";
				returnStr = (String)m.invoke(cls.newInstance(), "中国" , 70);
				System.out.println(returnStr);
	}
	
}

interface Father{
	public static final String patternName = "qubo"; // 常量
	public static final String patternDesc = "程序员";// 常量
	
	public void sayChina();//定义无参的 抽象方法
	public String sayHello(String name , int age);// 定义 有参的    抽象方法
	
}

class Child1 implements Pattern{

private String childName;
private int childAge;

// 无参 构造
public Child1(){
	
}

public Child1(String childName){
	this.childName = childName;
}

public Child1(String childName ,  int childAge){
	this.childName = childName;
	this.childAge = childAge;
}



public String getChildName() {
	return childName;
}

public void setChildName(String childName) {
	this.childName = childName;
}

public int getChildAge() {
	return childAge;
}

public void setChildAge(int childAge) {
	this.childAge = childAge;
}

public void sayChina() {
	System.out.println("patternName : " + patternName  + "  patternDesc :  " + patternDesc);
}

public String sayHello(String name, int age) {
	
	return name + "你好，我今年: " +  age + "岁了。";
}

}
