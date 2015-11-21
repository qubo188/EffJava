package com.qubo.annotation.inherited;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

@Documented
@Inherited //主要 用于 得到 继承类
@Target(value = {ElementType.TYPE , ElementType.METHOD , ElementType.FIELD})
public @interface InheritedAnnotationInterface {

		public String key() default "qubo";
		public String value() default "qubo 学习 Annotation中的 Inherited";
}
