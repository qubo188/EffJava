package com.qubo.gof.builder.carPractise;

import java.util.List;

public abstract class CarBuilder {

	// 指定要创建的顺序是什么
	public abstract void setSequence(List<String> sequence);
	// 返回具体的车型
	public abstract CarMode getCar();
	
}
