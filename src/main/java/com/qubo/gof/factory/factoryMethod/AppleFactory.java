package com.qubo.gof.factory.factoryMethod;

public class AppleFactory implements FruitFactory {

	public Fruit createFruit() {
		return new Apple();
	}

}
