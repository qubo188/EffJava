package com.qubo._static;

public class Person {

	private String name;
	private int age;
	
	private static int persionSum;

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

	public int getPersionSum() {
		return persionSum;
	}

	public void setPersionSum(int persionSum) {
		this.persionSum = persionSum;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		persionSum++;
	}
	
	
}
