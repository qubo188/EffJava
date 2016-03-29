package com.qubo.gof.templateMethod;

import com.qubo.config.Config;

/**
 * 模板方法 模式
 * 	使用条件：
 * 1 一组具有 相同 操作的 类
 * 2 调用 的顺序 必须是固定的
 */
public class Main {

	public static void main(String[] args) {
		MakeCar bus = new MakeBus();
		bus.make();
		
		Config.printEnter();
		
		MakeCar jeep = new MakeJeep();
		jeep.make();
	}
}
