package com.qubo.gof.prototype;

import java.util.ArrayList;
import java.util.List;

import com.qubo.config.Config;

/**
 *	原型模式
 */
public class Main {

	public static void main(String[] args) {
		
		// 浅克隆 。这种 方式 。内部如果包含 list  Object 数组时候！是没克隆上的。
		Person p = new Person();
		p.setName("张三");
		p.setId("1");
		p.setAge(18);
		
		Person p2 = p.clone();
		
		p2.setId("2");
		p2.setName("李四");
		
		System.out.println("浅克隆-------");
		System.out.println("元数据 ： " + p);
		System.out.println("克隆之后的数据 ： " + p2);
		
		Config.printEnter();
		//-------------------------------------------------------------------------------------------------------------
		
		System.out.println("深度克隆-------");
		
		// 深度 克隆 
		// 元数据
		Classes cls = new Classes();
		cls.setId("1");
		cls.setClsName("班级1");
		List<Person> data = new ArrayList<Person>();
		for (int i = 0; i < 3; i++) {
			Person person = new Person();
			person.setName("小黄飞"+i);
			person.setId(""+i);
			person.setAge(18+i);
			data.add(person);
		}
		cls.setData(data);
		
		//克隆数据
		Classes cls2 = cls.clone();
		List<Person> ppp = cls2.getData();
		for (int i = 0; i < ppp.size(); i++) {
			ppp.get(i).setName("张三丰"+i);
		}
		
		System.out.println("元数据 : " + cls);
		System.out.println("深度克隆数据 : " + cls2);
		
		
	}
}
