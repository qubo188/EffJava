package com.qubo.annotation.targetAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *		我声明的 这个注解 ，我只希望 使用者。 使用在 类上
 */
@Target(value = ElementType.TYPE)// ElementTyoe.TYPE 代表 OneTargetAnnotationInteface这个注解只能使用在类上
public @interface OneTargetAnnotationInteface {

		public String key() default "qubo";
		public String value() default "学习 Annotation中的 Target";
}
