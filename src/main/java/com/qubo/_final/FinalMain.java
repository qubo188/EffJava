package com.qubo._final;

/**
 *			Final :
 *							Final 是不能被 修改的。任何时候。
 *
 *			Final的声明：
 *										1 private final int num = 0; 创建属性的时候 赋值。
 *										2 在构造方法里面赋值
 *											private final int num;
 *											public 构造方法(){	
 *													num = 0;//如果这里面不声明 ，上面就会报错
 *											}
 *	
 *			Final 可以做为 局部参数传递
 *										 public void aaa(final int b){
 *														在这个 方法体内。
 *														b 只可以被使用。 不能被修改
 *										}
 */
public class FinalMain {

		// 第一种声明方式 
			private final int num = 0;
			
		// 第二种声明方式 
			private final int type;
			public FinalMain(){
					type = 1;
			}
			
			public void aa(final int bb){
					System.out.println(bb);
			}
}
