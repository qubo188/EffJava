package com.qubo.gof.strategy;

/**
 *	具体的 策略类的 实现类
 *	打 八折
 */
public class EightDiscount implements DiscountMerchandiseStrategy {

	public double discount(double money) {
		return money * 0.8;
	}

}
