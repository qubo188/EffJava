package com.qubo.gof.templateMethod;

/**
 *	具体 实现 一个 创建 公交车
 */
public class MakeBus extends MakeCar{

	@Override
	public void makeHead() {
		System.out.println("公交车 ： 创建 车头");
	}

	@Override
	public void makeBody() {
		System.out.println("公交车 ： 创建 车身");
	}

	@Override
	public void makeTail() {
		System.out.println("公交车 ： 创建 车尾");
	}

}
