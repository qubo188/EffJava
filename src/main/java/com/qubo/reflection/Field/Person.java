package com.qubo.reflection.Field;

public class Person {

	String name;
	private int age;
	
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
	
	/**
	 *  获取用户信息
	 */
	private void getPersonInfo(String name , Integer age){
			System.out.println("用户名  ： " + name + "  age : " + age);
	}
	
	public String PersonJob(){
		return "他是 一名 工作者";
	}
	
	public Person(){
		
	}
	public Person(String name , int age){
		this.name = name;
		this.age = age;
	}
	
	public void PersonMethod2(){
		System.out.println("Person-----> childMethod2()");
	}
	
	
}
