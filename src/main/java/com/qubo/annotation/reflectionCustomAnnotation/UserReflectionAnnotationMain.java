package com.qubo.annotation.reflectionCustomAnnotation;

import java.lang.reflect.Method;

public class UserReflectionAnnotationMain {

	public static void main(String[] args) throws Exception{
		
				// 反射 Class
				Class c = Class.forName("com.qubo.annotation.reflectionCustomAnnotation.Simple");
				
				// 找到 反射Class 对应的 toString 方法
				Method m = c.getMethod("toString");
				
				// 判断 在 toString这个方法上面 是否 存在 ReflectionAnnotationInterface这个反射
				if(m.isAnnotationPresent(ReflectionAnnotationInterface.class)){
					// 如果存在  
					//就得到 这个 Annotation的类。
					ReflectionAnnotationInterface rai = m.getAnnotation(ReflectionAnnotationInterface.class);
					
					// 得到 ReflectionAnnotationInterface 这个类的主要目的 就是 获取 它定义的值
					
					String key = rai.key();// @see com.qubo.annotation.reflectionCustomAnnotation.ReflectionAnnotationInterface 中，定义了key()
					String value = rai.value();// @see com.qubo.annotation.reflectionCustomAnnotation.ReflectionAnnotationInterface 中， 定义了 value()
					
					System.out.println("key = " + key);
					System.out.println("value = " + value);
				}
	}
}
