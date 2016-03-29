package com.qubo.gof.strategy;

/**
 *	策略模式 
 *缺点：1  用户 必须 知道 全部的策略类
 *			   2  策略类 会不断的增加 
 *
 *使用规则 ：
 *						1 必须 有一个 抽象的 策略类
 *						2 有多个 具体实现的  抽象的 策略类
 *						3 使用环境  持有 一个 具体 的 实现的策略类
 *
 *	实现 商品 打折：
 *根据 不同的 商品。对 不同的 商品 使用 不同的 打折策略
 */
public class Main {

	public static void main(String[] args) {
		
		// 设置 使用环境
		DiscountMerchandiseContext  dms = new DiscountMerchandiseContext();
		// 创建 具体的策略
		SixDiscount sd = new SixDiscount();
		// 将具体的策略 设置到 使用环境当中
		dms.setStrategy(sd);
		// 根据 设置的策略 返回不同的价格
		double endMoney = dms.discount(100.0);
		// 打印 输出
		System.out.println("打折后的价格是: " + endMoney);
		
	}
}
