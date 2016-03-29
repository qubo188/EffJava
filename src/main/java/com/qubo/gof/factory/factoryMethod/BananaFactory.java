package com.qubo.gof.factory.factoryMethod;

public class BananaFactory implements FruitFactory {

	public Fruit createFruit() {
		return new Banana();
	}

}
