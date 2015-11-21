package com.qubo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import com.qubo.config.Config;

/**
 *		反射 能做到的事情：
 *												1 得到一个类 里面的 所有  《构造方法》
 *												2 得到一个类 里面的 所有  《变量》
 *												3 得到一个类 里面的 所有  《方法》
 *													3.1 得到 方法的 《修饰符》
 *													3.2 得到 方法的 《返回类型》
 *													3.3 得到  方法的 《方法名》
 *													3.4 得到  方法的 《参数类型》
 *												4 得到一个类 里面的 所有 《父类》
 *												5 得到一个类 里面的 所有 《实现类》
 *
 */
public class Ch04 {

	public static void main(String[] args) throws Exception{
		
			Class<?> c = Class.forName("com.qubo.reflection.Child");
			System.out.println("当前类是 : " + c.getName());
			Config.printEnter();
			
			// 得到 一个类 所有的 实现的 方法
			getImplements(c);
			Config.printEnter();
			
			// 得到 一个类 所有的 继承方法。重点：java是单一继承。所以返回的只是一个单一的Class而不是集合
			getSuperClass(c);
			Config.printEnter();
			
			// 取得  一个类的 所有 构造方法
			getConstructors(c);
			Config.printEnter();
			
			// 取得一个类中的所有 方法
			// getDeclaredMethd(); 只取本类的所有方法
			// getMethod();取得 父类  实现类  及 本类的 所有方法
			getMethods(c);
			Config.printEnter();
			
			// 取得 一个类 中的 所有 变量  
			// getDeclaredFileds();只取 本类 的 变量
			// getFileds(); 取得   父类 + 实现类 的 所有 变量
			getFileds(c);
	}

	/**
	 * 得到 一个类的 所有   《实现类》
	 */
	public static void getImplements(Class<?> c){
		
			// 因为一个类 可能实现 多个 接口，所有返回的是一个数组
			Class<?>[] cls = c.getInterfaces();
			
			for (int i = 0; i < cls.length; i++) {
				System.out.println(c.getName() +" 'implements' " + cls[i].getName() + "接口");
			}
			
	}
	
	/**
	 * 得到 一个类  所有的 《继承类》
	 * 重点：一个类只能单一继承  所以 返回的 只是一个 Class的
	 */
	public static void getSuperClass(Class<?> c){
			Class<?> cls = c.getSuperclass();
			System.out.println(c.getName() + " 'extends' " + cls.getName());
	}
	
	/**
	 * 取得 一个类中的 所有《构造方法》
	 */
	public static void getConstructors(Class<?> c){
		
			// 得到 全部的构造方法
			Constructor<?>[] constructor = c.getConstructors();
			
			for (int i = 0; i < constructor.length; i++) {
				//System.out.println(constructor[i]);// 这样是可以得。但是实际调取的是toString();
				
				// 1 得到 构造方法中的《全部参数》 
				Class<?> p[] = constructor[i].getParameterTypes();
				// 2 得到构造方法的 《修饰符》 public properted private default
				String XiuShiFu = Modifier.toString(constructor[i].getModifiers());
				// 3 取得构造方法的《名称》
				String methodName = constructor[i].getName();
				
				String str = "";
				
				str += "构造方法 "+i+"：" + XiuShiFu + " " + methodName + " (";
				
				for (int j = 0; j < p.length; j++) {
					str += p[i].getName() + " param"+j+"";
					if(j+1<p.length)str += ",";
				}
				
				str += ") {}";
				System.out.println(str);
			}
	}
	
	/**
	 * 取得 一个内部类 中的 所有 《方法》
	 *  getDeclaredMethods(); // 取出 一个类内部的 自己的方法
	 *  getMethods(); 可以取出   类内部的全部方法 + 父类 + 实现类  中的 所有方法
	 */
	public static void getMethods(Class<?> c){
		
		// 取出  本类 + 父类  + 实现类  的 所有方法
		Method[] cls = c.getMethods();
		
		for (int i = 0; i < cls.length; i++) {
				
				// 1 取出 所有方法的  修饰符 public  properted default private 
				String XiuShiFu = Modifier.toString(cls[i].getModifiers());
				
				// 2 取出 返回类型
				Class<?> returnCls = cls[i].getReturnType();
				
				// 3 方法名
				String methodName = cls[i].getName();
				
				// 4 参数 
				Class<?>[] params = cls[i].getParameterTypes();
				
				String str = "内部方法 ：";
				
				str  += XiuShiFu + " " + returnCls.getName() + " " + methodName + "(";
				
				for (int j = 0; j < params.length; j++) {
					str  += params[j].getName() + " param"+j+"";
					if(j+1<params.length)str += " , ";
				}
				
				
				
				// 5 得到异常
				Class<?>[] exceptions = cls[i].getExceptionTypes();
				
				if(exceptions.length>0){
					str += ") throws ";
				}else{
					str += ")";
				}
				
				for (int e = 0; e < exceptions.length; e++) {
					str += exceptions[e].getName();
					if(e+1<exceptions.length) str+=" , ";
				}
				
				str += "{}";
				
				System.out.println(str);
		}
			
	}
	
	/**
	 * 得到 方法中的 全部变量
	 * getDeclaredFields()---->取得 类自身 内部 所有的变量
	 * getFields()-------------->取得  父类 + 实现类 中的 全部 变量
	 */
	public static void getFileds(Class<?> cls){
				
		//{ 这种 写法 叫做 ：局部 代码块}
		
		{
			Field[] fields = cls.getFields();
			for (int f = 0; f < fields.length; f++) {
				
				// 1 取得 修饰符
				String XiuShiFu = Modifier.toString(fields[f].getModifiers());
				
				// 2 取得 声明的类型
				Class<?> typeCls = fields[f].getType();
				
				String fieldName = fields[f].getName();
				
				String str = "";
				
				str += "变量"+f+" : " + XiuShiFu + " " + typeCls + " " + fieldName;
				System.out.println(str);
			}
		}
		
		{
			Field[] fields = cls.getDeclaredFields();
			for (int f = 0; f < fields.length; f++) {
					
					// 1 取得 修饰符
					String XiuShiFu = Modifier.toString(fields[f].getModifiers());
					
					// 2 取得 声明的类型
					Class<?> typeCls = fields[f].getType();
					
					String fieldName = fields[f].getName();
					
					String str = "";
					
					str += "变量"+f+" : " + XiuShiFu + " " + typeCls + " " + fieldName;
					System.out.println(str);
			}
		}
				
				
	}
	
}





interface Pattern{
		public static final String patternName = "qubo"; // 常量
		public static final String patternDesc = "程序员";// 常量
		
		public void sayChina();//定义无参的 抽象方法
		public String sayHello(String name , int age);// 定义 有参的    抽象方法
		
}

class Child implements Pattern{
	
	private String childName;
	private int childAge;
	
	// 无参 构造
	public Child(){
		
	}
	
	public Child(String childName){
		this.childName = childName;
	}
	
	public Child(String childName ,  int childAge){
		this.childName = childName;
		this.childAge = childAge;
	}
	
	

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public int getChildAge() {
		return childAge;
	}

	public void setChildAge(int childAge) {
		this.childAge = childAge;
	}

	public void sayChina() {
		System.out.println("patternName : " + patternName  + "  patternDesc :  " + patternDesc);
	}

	public String sayHello(String name, int age) {
		
		return name + "你好，我今年: " +  age + "岁了。";
	}
	
}