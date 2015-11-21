package com.qubo.reflection.DynamicPorxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvoktionHandler implements InvocationHandler{
	
	public Object obj;
	
	public Object bind(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(obj, args);
	}

}
