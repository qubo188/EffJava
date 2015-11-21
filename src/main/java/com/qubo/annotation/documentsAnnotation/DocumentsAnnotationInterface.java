package com.qubo.annotation.documentsAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 *		@Documents 的主要 作用在于，当你的源文件，生成javadoc文档的时候。写的那些提示信息
 *
 */
@Documented // 声明 可以使用 DocumentsAnnotationInterface这个注解的时候，定义一些信息。用于生成javadoc的时候看。
@Target({ElementType.TYPE , ElementType.FIELD,ElementType.METHOD})
public @interface DocumentsAnnotationInterface {
	
			public String key() default "qubo";
			public String value() default "学习 Annotation中的Documents的使用方式";
}
