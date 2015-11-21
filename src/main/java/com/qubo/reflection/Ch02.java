package com.qubo.reflection;

/**
 * 1  实例化Class的三种方式 : 1 forName() 
 * 													  2 new Object().getClass();
 * 													 3 Object.class
 * 	Class是反射的根源 的理由：
 * 														1 因为所有 .java文件最终都是编译成 .class文件
 * 														2 因为 找到 class就意味着你找到了 这个类里面的所有 方法 与变量
 */
public class Ch02 {

			public static void main(String[] args) throws ClassNotFoundException {
					Class<?> c1 = null;
					Class<?> c2 = null;
					Class<?> c3 = null;
				
					// 第一种 ：  通过 类的 完整包名 找到
					c1 = Class.forName("com.qubo.reflection.A");
					
					// 第二种 ： 通过 .class找到
					c2 = A.class;
					
					// 第三种：通过 对象.getClass()找到
					c3 = new A().getClass();
					
					/*----------------------------打印类-------------------------------------*/
					
					System.out.println(c1.getName());
					System.out.println(c2.getName());
					System.out.println(c3.getName());
			}
}

class A {

}