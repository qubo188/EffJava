package com.qubo.gof.templateMethod;

/**
 *	抽象 创建 汽车
 */
public abstract class MakeCar {

	// 实现具体操作 步骤1
	public abstract void makeHead();
	
	// 实现具体操作 步骤2
	public abstract void makeBody();
	
	//实现具体操作 步骤3
	public abstract void makeTail();
	
	// 提供外部的 调取方法
	// 内部具体操作 是 按 固定 顺序 调取 每一个步骤
	public void make(){
		// 具体实现步骤1
		this.makeHead();
		// 具体实现步骤2 
		this.makeBody();
		// 具体实现步骤3
		this.makeTail();
	}
}
