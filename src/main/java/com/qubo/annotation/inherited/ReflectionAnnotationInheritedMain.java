package com.qubo.annotation.inherited;

import java.lang.annotation.Annotation;

public class ReflectionAnnotationInheritedMain {

	public static void main(String[] args) throws Exception {
		
		// 第一步 得到 Student 的class类
		Class c  = Class.forName("com.qubo.annotation.inherited.Student");
		
		// 获得 Student中的 所有 Anntation 。重点提示：我在Student中。根本没有定义Annotation。
		// 但是 我在 Student extends Person中的Person中 可是使用了 Annotation
		Annotation[] anns = c.getAnnotations();
		
		for(Annotation ann : anns){
				System.out.println(ann);
				
				if(c.isAnnotationPresent(InheritedAnnotationInterface.class)){
					InheritedAnnotationInterface iai =(InheritedAnnotationInterface) c.getAnnotation(InheritedAnnotationInterface.class);
					System.out.println("key = " + iai.key());
				}
		}
		
		
	}
}
