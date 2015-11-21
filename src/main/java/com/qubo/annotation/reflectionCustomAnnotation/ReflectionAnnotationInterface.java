package com.qubo.annotation.reflectionCustomAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)// 设置 信息 保存的 有效 范围 为 runtime
public @interface ReflectionAnnotationInterface {

		public String key() default "name";
		public String value() default "学习Annotation";	
}
