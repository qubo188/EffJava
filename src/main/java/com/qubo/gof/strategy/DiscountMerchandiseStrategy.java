package com.qubo.gof.strategy;

/**
 *  抽象 策略类
 *  DiscountMerchandise ：打折商品
 */
public interface DiscountMerchandiseStrategy {

		public double discount(double money);
}
