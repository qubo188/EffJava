package com.qubo.gof.templateMethod;

public class MakeJeep extends MakeCar{

	@Override
	public void makeHead() {
		System.out.println("吉普车 ： 创建 车头");
	}

	@Override
	public void makeBody() {
		System.out.println("吉普车 ： 创建 车身");
	}

	@Override
	public void makeTail() {
		System.out.println("吉普车 ： 创建 车尾");
	}

}
