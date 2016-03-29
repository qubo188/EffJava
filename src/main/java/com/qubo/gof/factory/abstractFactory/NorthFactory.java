package com.qubo.gof.factory.abstractFactory;

public class NorthFactory implements FruitFactory{


	public Fruit createApple() {
		return new NorthApple();
	}

	public Fruit createBanana() {
		return new NorthBanana();
	}

}
