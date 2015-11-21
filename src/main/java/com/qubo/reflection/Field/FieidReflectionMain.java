package com.qubo.reflection.Field;

import java.lang.reflect.Field;

public class FieidReflectionMain {

	/**
	 * 主要 获取 ：1 类本身的 属性
	 * 						   2 类的 父类 属性
	 * 						   3 私有属性的访问
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws SecurityException, NoSuchFieldException, InstantiationException, IllegalAccessException {
				Field[] fields = Person.class.getDeclaredFields();
				
				for(Field field : fields){
						System.out.println(field.getName());
				}
				
				Field field = Person.class.getDeclaredField("age");
				
				field.setAccessible(true);
				
				System.out.println(field.getName());
				
				Person p = new Person("asda",12);
				// 取得值
				System.out.println(field.get(p).toString());
				
				//设置值 之后 取值
				
				field.set(p,99);
				System.out.println(field.get(p).toString());
				
				
	}

}
