package com.qubo.annotation.reflectionSystemAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ReflectionAnnotationMain {

	public static void main(String[] args) throws Exception{
		
				Class c = Class.forName("com.qubo.annotation.reflectionAnnotation.SimpleBean");
				
				Method m = c.getMethod("toString");
				
				Annotation[] anns = m.getAnnotations();
				for(Annotation a : anns){
					System.out.println(a);
				}
				
				// 打印 ：@java.lang.Deprecated()
				// 因为 Deprecated 默认是运行在 runtime中。所以我们能得到
	}
}
