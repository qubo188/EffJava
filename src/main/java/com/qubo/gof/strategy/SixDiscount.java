package com.qubo.gof.strategy;

/**
 *	具体的 策略 实现类
 * 	打6折
 */
public class SixDiscount implements DiscountMerchandiseStrategy {

	public double discount(double money) {
		
		return money * 0.6;
	}

}
