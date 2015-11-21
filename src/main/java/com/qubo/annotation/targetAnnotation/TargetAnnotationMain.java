package com.qubo.annotation.targetAnnotation;

/**
 *		@target的使用 ：  指定  annotation的使用 方式  ： 一共有  8   种,重点 这8种都是定义在枚举ElementType中
 *					
 *										1 public static final ElementType  ANNOTATION_TYPE : 只能声明在《注释》上
 *										2 public static final ElementType CONSTRUCTOR     :只能声明在 《构造方法》上
 *										3 public static final ElementType FIELD        : 只能声明在 《字段》上
 *										4 public static final ElementType  LOCAL_VARIABLE  : 只能声明在 《局部变量》上 
 *										5 public static final ElementType METHOD  : 只能声明在  《方法》上面
 *										6 public static final ElementType PACKAGE  : 只能声明 在《包》上
 *									    7 public static final ElementType PARAMETER : 只能声明在   《参数》上
 *										8 public static final ElementType TYPE  : 只能声明在   《类》   《接口》   《枚举》上 
 */

@OneTargetAnnotationInteface()
@TwoTargetAnnotation()
public class TargetAnnotationMain {

		//@OneTargetAnnotationInterface() 把这个打开就会报错！！因为 这个Annotation中我定义的类型为ElementType.TYPE。只能声明在类上
		@TwoTargetAnnotation// 这个就可以！因为我设置了两个属性，1 ElementType.TYPE 和  2 ElementType.METHOD
		public String aa(){
			return "";
		}
}
