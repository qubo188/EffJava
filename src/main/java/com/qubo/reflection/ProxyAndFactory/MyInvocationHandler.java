package com.qubo.reflection.ProxyAndFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

	private Object obj;
	public Object bind(Object obj){ //是哪个具体的实现类
			this.obj = obj;
			// 参数1 ： classLoad
			// 参数2 ： 到底这个《具体的实现类》 到底实现了哪些接口
			// 参数3 ： InvocationHandler ：真正的 《具体实现类》 调用 《具体方法》的操作
			return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		// 可以 在 调取 具体操作之前 增加额外操作
		// before();
		Object obj1 =  method.invoke(obj, args);
		// 也可以 在 调取 具体 操作 之后  增加一些额外操作
		//after();
		
		return obj1;
	}
	
	

}
