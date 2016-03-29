package com.qubo.gof.builder;

import com.qubo.config.Config;

/**
 * Main相当于 一个客户端 
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// 客户端 首先 创建 一个 指挥者
		Director d = new Director();
		
		// 客户端 其次 创建 一个 构造者
		ConcreteBuilderA cba = new ConcreteBuilderA();
		ConcreteBuilderB cbb = new ConcreteBuilderB();
		
		// 指挥者 设定 构造者  。里面做了两个事情
		// 1 设定产品 步骤1 
		// 2 设定产品 步骤2 
		d.build(cba);
		// 创建完 产品 得到 返回的 产品 
		Product p1 = cba.getResult();
		// 打印 创建的 产品
		p1.show();
		
		Config.printEnter();
		//-----------------------------------------------------------------------------------------
		
		d.build(cbb);
		
		Product p2 = cbb.getResult();
		
		p2.show();
		
		
		
		
		
	}
}
