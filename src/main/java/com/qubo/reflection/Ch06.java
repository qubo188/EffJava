package com.qubo.reflection;

/**
 *	ClassLoad的使用
 */
public class Ch06 {

	public static void main(String[] args) {
			Person p = new Person();
			System.out.println("类加载器 : " + p.getClass().getClassLoader());
			System.out.println("类加载器 : " + p.getClass().getClassLoader().getClass().getName());
	}

}

class Person{}