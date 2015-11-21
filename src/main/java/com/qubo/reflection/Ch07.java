package com.qubo.reflection;



/**
 *	本章 主要目的 就是单一 接口类的代理。统称为：《静态代理》
 *	staticProxy concept  ：也就是说一个代理，只能为一个接口服务。
 *	DynamicProxy concept : 但是 我们在开发中，接口有很多个。所以这个时候我们需要《一个代理》可以《服务多个接口》。我们就得使用动态代理看 Ch08.java
 */

//接口类 Subject
interface Subject{
	public String say(String name , int age);
}

//具体的实现类
class RealizeSubject implements Subject{
	public String say(String name , int age){
		return name + " 你好 ,  你今年" + age + "岁了";
	}
}

//单一接口的  代理类

class ProxySubject implements Subject{
	
	private Subject obj;
	public ProxySubject(Subject obj){
		this.obj = obj;
	}
		
	public String say(String name , int age){
		return obj.say(name, age);
	}
}

public class Ch07 {

	public static void main(String[] args) {
		Subject s = new ProxySubject(new RealizeSubject());
		System.out.println(s.say("王五",30));
	}

}


