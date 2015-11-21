package com.qubo.reflection;

import java.lang.reflect.Constructor;

/**
 *		知识点1： 所有 的.java文件最终都会编译 成 .classs文件。
 *						   所以 如果你找到了 .class文件。就意味着你找到这个类的所有 “方法” 与 “变量”
 *						
 *		知识点2：三种方式 方式，其实默认的调取的是“无参的构造方法”进行“实例化”的
 *							但是 有些时候，我们的类内部包含 有参的构造方法。
 *
 *		推荐 ： 一个类里面 必须 有一个无参的构造函数
 */
public class Ch03 {

	public static void main(String[] args)  throws Exception{
			
			Class<?> c1 = Class.forName("com.qubo.reflection.Persion03");
			
			//推荐 ---每个类中都带一个无参的构造方式。
			Persion03 p = (Persion03)c1.newInstance();//这一步默认其实调取的就是 Persion03类中的《无参构造方法》
			p.setName("张三");
			
			
			
			Class<?> c2 = Class.forName("com.qubo.reflection.Student03");
			//c2.newInstance();//这样是报错的。因为Student03里面没有加《无参的构造方法》
			Constructor<?>[] constructors = c2.getConstructors();
			// 调取 一个构造函数construetor[0]
			Student03 s1 = (Student03)constructors[0].newInstance("王五");
			
			
			Class<?> c3 = Class.forName("com.qubo.reflection.Student03");
			Constructor<?>[] constructor2 = c3.getConstructors();
			
			Student03 s2 = (Student03)constructor2[1].newInstance("李六",30);
			
			System.out.println("p : " + p.getName());
			System.out.println("s1 : " + s1.getName()  + "  " +s1.getAge());
			System.out.println("s2 : " + s2.getName() + "     " +s2.getAge()  );
			
	}

}

class Persion03{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Student03{
	private String name;
	private int age;
	
	// 第一个构造方法
	public Student03(String name){
		this.name = name;
	}
	// 第二个构造方法
	public Student03(String name , int age){
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
