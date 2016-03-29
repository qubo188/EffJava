package com.qubo.gof.strategy;

public class DiscountMerchandiseContext {

	private DiscountMerchandiseStrategy strategy;
	
	public void setStrategy(DiscountMerchandiseStrategy strategy){
		this.strategy = strategy;
	}
	
	public double discount(double money){
		double d = strategy.discount(money);
		return d;
	}
	
	
	
}
