package com.qubo.reflection.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodReflectionMain {

	/**
	 * 反射 ： 方法
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

		/*
		 测试1 ： 打印 一个类中的 所有的方法 
		 ------------------------------------------------------------------------------------------------
		// 打印  自身类的 所有方法，重点：这个只能是打印，并不能调用
		Method[] methods = Person.class.getDeclaredMethods();
		// Method[] methods = Person.class.getMethods(); // 得到自身 + 父类 + 实现类 里面的所有方法
		for(Method method : methods){
			System.out.println(Modifier.toString(method.getModifiers()) + " " + method.getReturnType().getName() + " " + method.getName());
		}
		
		*/
		
		/*
		
		测试2 ：调用一个类中的 private 的方法
		------------------------------------------------------------------------------------------------
		 // 调用方法 
		// 参数1 ： 调用的 方法 是哪个
		// 参数2 ： 可变参数
		System.out.println(invokePrivateMethod(Person.class , "getPersonInfo" ,"张三" , 50));
		
		// 真正的调用
		m.invoke(Person.class.newInstance(), "张三" , 20);
		
		*/
		
		/*
		 
		 测试3 ： 调用 public的方法
		 ------------------------------------------------------------------------------------------------
		 // 可以调用，但是这个是 public 的工程
		Method m = Person.class.getDeclaredMethod("PersonJob");
		System.out.println(m.invoke(Person.class.newInstance()));
		
		*/
		
		//测试4 ： 调取 父类  及 子类里面的方法
		
		// 先打印一下 看看 Child里面都有什么方法
		// 重点：使用 getMethods()是可以得到 子类 和 父类里面所有的方法
		/*	
		    Method[] methods = Child.class.getMethods();
			for (int i = 0; i < methods.length; i++) {
				System.out.println(methods[i].getName());
			}
		*/
		
		// 首先我调用了 自己内部的方法------>成功
		/*Method m = Child.class.getMethod("childMethod1");
		m.invoke(Child.class.newInstance());*/
		
		Method m = Child.class.getMethod("PersonMethod2");
		m.invoke(Child.class.newInstance());
		
		
	}
	
	/**
	 * @param o  : 具体你要调取的是哪个对象
	 * @param invokeMethod 你要调取的是哪个对象里面的哪个方法
	 * @param parameters 你传递的参数
	 * @return 调取完这个方法的返回值
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static Object invoke(String clsName , String invokeMethod , Object... parameters) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
					try {
						
						Object o = Class.forName(clsName).newInstance();
						Class[] clazz = new  Class[parameters.length]; 
						
						for(int i = 0; i<parameters.length ; i++){
							clazz[i] = parameters[i].getClass();
						}
						// 声明调取的方法是什么
						Method m = o.getClass().getDeclaredMethod(invokeMethod, clazz);
						
						return m.invoke(o, parameters);
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					return null;
					
	}
	
	public static Object invoke(Class c , String invokeMethod , Object...objects ) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException{
			
			Class[] cs = new Class[objects.length];
			for (int i = 0; i < objects.length; i++) {
				cs[i] = objects[i].getClass();
			}
			Method method = c.getDeclaredMethod(invokeMethod, cs);
			
			return method.invoke(c.newInstance(), objects);
			
	}
	
	/**
	 * @param clsName  具体要调用的哪个类对象
	 * @param invokeMethod 具体指明 调取哪个类里面的 哪个方法
	 * @param parameters 这个方法 所需要的参数
	 * @return
	 * @throws Exception
	 * 
	 * 重点：这个专门是调取 私有方法的。使用的 setAccessible(true);这个属性
	 */
	public static Object invokePrivateMethod(Class clsName , String invokeMethod , Object... parameters) throws Exception{
		
			Class[] parameterTypes = new Class[parameters.length];
			for (int i = 0; i < parameters.length; i++) {
				parameterTypes[i] = parameters[i].getClass();
			}
			Method method = clsName.getDeclaredMethod(invokeMethod , parameterTypes);
			
			// 必须 加上这句话  。 这句话的意思就是：允许你调用private 方法
			method.setAccessible(true);
			return method.invoke(clsName.newInstance(), parameters);
	}

	
}
