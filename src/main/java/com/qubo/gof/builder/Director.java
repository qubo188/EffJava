package com.qubo.gof.builder;

/**
 * 指挥者 只有一个 作用。就是指挥创建出 具体的产品
 *
 */
public class Director {

	// 创建 具体的产品
	public void build(Builder b){
			b.builderPartA();
			b.builderPartB();
	}
	
	
}
