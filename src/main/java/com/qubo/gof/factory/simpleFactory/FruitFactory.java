package com.qubo.gof.factory.simpleFactory;

/**
 *	具体 生成 水果的 工厂类
 *	工厂就 负责一件事情。就是生产 对象
 */
public class FruitFactory {

	public static Fruit createFruit(String who) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return (Fruit)Class.forName(who).newInstance();
	}
	
}
