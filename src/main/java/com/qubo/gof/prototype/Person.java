package com.qubo.gof.prototype;

public class Person implements Cloneable{

	private String id;
	private String name;
	private int age;

	/**
	 * 一个类的内部 包含了 一个 克隆自身的 方法
	 */
	public Person clone(){
		try {
			
			return (Person)super.clone();
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
