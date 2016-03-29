package com.qubo.gof.factory.abstractFactory;

public class SouthFactory implements FruitFactory {

	public Fruit createApple() {
		return new SouthApple();
	}

	public Fruit createBanana() {
		return new SouthBanana();
	}

}
