package com.qubo.gof.factory.factoryMethod;

/**
 *	工厂方法模式 也叫 多态工厂----------->属于创建型模式里面的
 *	主要思路就是为每一个 产品创建一个专属的工厂。由这个专属的工厂创建这个对象。
 *	
 */
public class Main {

	public static void main(String[] args) {
		
		// 创建苹果 工厂
		FruitFactory appleFactory = new AppleFactory();
		// 得到 苹果对象
		Apple apple = (Apple)appleFactory.createFruit();
		// 打印 苹果
		apple.create();
		
		FruitFactory bananaFactory = new BananaFactory();
		Banana banana = (Banana)bananaFactory.createFruit();
		banana.create();
	}
}
