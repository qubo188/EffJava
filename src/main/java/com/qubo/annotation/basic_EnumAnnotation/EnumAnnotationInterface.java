package com.qubo.annotation.basic_EnumAnnotation;

/**
 *		使用 枚举 定义 Annotation
 */
public @interface EnumAnnotationInterface {

		public MyEnum obj() default MyEnum.val1;
}
