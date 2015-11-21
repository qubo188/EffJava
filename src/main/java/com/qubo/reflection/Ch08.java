package com.qubo.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *	 *	本章 主要目的 就是动态 代理
 *		类加载器 有三种 ：  1 Bootstrap  Classload: 此类加载器使用C++编写，一般开发中是看不到的
 *											  2 Extension Classload:用于扩展类的加载 ， 一般对应的是jre/lib/ext目录中的类
 *											  3 AppClassload :加载 classpath指定的类 ， 是 最常用的一种 
 *
 *		Proxy ：可以 《创建动态代理类》 和 《实力的静态方法》
 *		Invokecation ： 主要里面 有一个 invoke的 具体调用的方法
 *
 *		所谓 代理 就是  ： 一个《接口》   Subject
 *										   一个 《具体的实现接口的类》  realSubject
 *											一个 一个用于 《调取》  《具体实现接口的类》 Proxy
 *
 *			before()
 *			具体业务调用()
 *			after();
 *		
 *			代理的优点：在不改变业务代码的逻辑。之外 可以在 《调用之前》 加入《额外的操作》。和在 《调用之后》 加入《额外操作》
 */

//接口1 
interface Subject01{
		public void say01(String  name);
}
//接口2
interface Subject02{
		public void say02(String name , int age);
}
// 接口3
interface Subject03{
	public void say03(String name , int age  , String address);
}

// 实现 接口 Subject01
class realizeSubject01 implements Subject01{
	public void say01(String name){
		System.out.println("姓名 : " + name + "----Subject01");
	}
}
// 实现 接口 Subject02
class realizeSubject02 implements Subject02{
	public void say02(String name , int age){
		System.out.println("姓名 : " + name + "  , 年龄 ： " + age +"----Subject01");
	}
}
// 实现 接口 Subject03
class realizeSubject03 implements Subject03{
		public void say03(String name , int age , String address){
				System.out.println("姓名 : " + "  , 年龄 ： " + age + " , 住址 : "+ address +"----Subject01");
		}
}

// MyInvokeHandler就相当于 《动态 代理类》
class MyInvokeHandler implements InvocationHandler {

	private Object obj;

	public Object bind(Object obj) { // 具体的 真是的 《实现类》
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj
				.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		// 之前 额外操作
		// xxx(); 例如 调取 一些 日志
		
		Object obj = method.invoke(this.obj, args);
		
		// 之后 额外操作
		//xxx();
		
		
		return obj;
	}
}

public class Ch08 {

	public static void main(String[] args) {
		Subject02 s2 = (Subject02) new MyInvokeHandler().bind(new realizeSubject02());
		s2.say02("张三" , 21);
	}

}
