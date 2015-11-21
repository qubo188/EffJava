package com.qubo.annotation.basic_RetentionAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.qubo.annotation.basic_EnumAnnotation.MyEnum;

/**
 *			重点： Retention 是代表这个 保留信息。 有三个种
 *						1  Source :代表 这个Annotation的信息  只会 保存在  《*.java》里
 *						2 class :代表 这个Annotation的信息 只会 保存在 《 *.java》  和 《 *.class》 里
 *					    3 runtime : 代表  这个 Annotation的信息 只会 保存在  《*.java》 和 《*.class》  和 《运行环境》 里 
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RetentionAnnotationInterface {
	
		public MyEnum name() default MyEnum.val2;
}
