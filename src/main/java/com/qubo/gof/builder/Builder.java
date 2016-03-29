package com.qubo.gof.builder;

/**
 *	Description : 创建 产品的 抽象类
 *		创建 产品 分为3个部分
 *		步骤1 ----> builderPartA()
 *		步骤2 ----> builderPartB();
 *		取回创建的产品
 */
public  abstract class Builder {

		// 创建一个产品 所需要的 步骤1 ---由子类具体实现
		public abstract void  builderPartA();
		
		// 创建一个产品 所需要的 步骤2 --- 由 子类具体实现
		public abstract void builderPartB();
		
		// 取回创建的 产品 实力
		public abstract Product getResult();
}
