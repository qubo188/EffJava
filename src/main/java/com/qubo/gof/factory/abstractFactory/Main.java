package com.qubo.gof.factory.abstractFactory;

import com.qubo.config.Config;

/**
 *	抽象 工厂：
 *						抽象工厂中 方法 对应的 是 产品的结构
 *						具体工厂 对应 具体产品
 *
 *	抽象工厂的父类。只关注 一组产品工厂的 结构
 *	而具体的工厂真正关注的是 生产哪种具体的产品
 * 
 */
public class Main {

	public static void main(String[] args) {

		// 创建 一个 北方的工厂
		FruitFactory ff1 = new NorthFactory();
		// 用北方的工厂  创建 一个 北方的苹果
		Fruit apple1 = ff1.createApple();
		// 用北方的工厂  创建  一个 北方的香蕉
		Fruit banana1 = ff1.createBanana();
		
		//打印
		apple1.create();
		banana1.create();
		
		Config.printEnter();
		//--------------------------------------------------------------------------------------------------------
		
		// 创建 一个南方的 工厂
		FruitFactory ff2 = new SouthFactory();
		// 用南方的 工厂创建一个苹果
		Fruit apple2 = ff2.createApple();
		// 用南方的 工厂创建一个香蕉
		Fruit banana2 = ff2.createBanana();
		
		// 打印
		apple2.create();
		banana2.create();
		
		
		
		
	}
}
