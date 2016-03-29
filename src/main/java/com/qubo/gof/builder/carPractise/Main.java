package com.qubo.gof.builder.carPractise;

import com.qubo.config.Config;

/**
 *  建造者模式 与 工厂最大的区别 就在于 它关注的是执行的顺序。或者说是组装的顺序。
 *  通过不同的组装 得到不同的结果
 *   角色划分： 1 指挥者   2 创建者  3 产品
 */
public class Main {

	public static void main(String[] args) {
		
		Director d = new Director();
		
		// 获得 A中宝马类型的车子
		CarMode bmc_a = d.get_A_BaoMaCar();
		// 执行
		bmc_a.run();
		
		Config.printEnter();
		
		// 获得 A种类型奔驰的车子
		CarMode bcc_a = d.get_A_BenChiCar();
		//执行
		bcc_a.run();
		
		Config.printEnter();

		// 获得 B种类型奔驰的车子
		CarMode bcc_b = d.get_B_BenChiCar();
		//执行
		bcc_b.run();
		
		
	}
}
