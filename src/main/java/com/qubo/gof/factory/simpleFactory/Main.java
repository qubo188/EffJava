package com.qubo.gof.factory.simpleFactory;

/**
 *	简单工厂 ：
 *	就是 一组 继承了统一接口的对象。由一个类生产创建 这些不同的对象。这个生产类 就叫工厂
 *	一组对象 ： 例如  苹果  香蕉 桃子    他们统一属于 水果类。
 *	而我们要使用一个类。来可以创建不同的水果
 *
 *	优点： 编写简单。我不用关注你到底是如何创建对象的。
 * 缺点： 如果在有兵器工厂  ， 汽车工厂 ，自行车工厂。那么 就会增加很多个工厂类。这样核心的工厂类就得不断增加或者修改
 */
public class Main {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
			
			Fruit apple = FruitFactory.createFruit("com.qubo.gof.factory.simpleFactory.Apple");
			apple.create();
			
	}
}
