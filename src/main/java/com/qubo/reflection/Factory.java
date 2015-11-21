package com.qubo.reflection;

public class Factory {

	public static Fruit getFruitInstance(String clsName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
				Fruit f = (Fruit)Class.forName(clsName).newInstance();
				return f;
	}
		
}
