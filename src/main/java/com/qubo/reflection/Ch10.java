package com.qubo.reflection;

public class Ch10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Object o  = new Apple();
			
			Class c = o.getClass();
			System.out.println(c);
	}

}
