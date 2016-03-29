package com.qubo.gof.builder;

/**
 * Description : 这是 抽象Builder的具体实现类
 *
 */
public class ConcreteBuilderA extends Builder{

	// 声明 创建 一个 产品
	Product p = new Product();
	
	// 实现 这个产品 的 具体操作步骤1 
	@Override
	public void builderPartA() {
		p.add(this.getClass().getName() + " invoke-->builderPartA()");
	}

	// 实现这个 产品的 具体 步骤2
	@Override
	public void builderPartB() {
		p.add(this.getClass().getName() + " invoke---> builderPartB()");
	}

	// 返回这个 产品的实例
	@Override
	public Product getResult() {
		return p;
	}

	
}
