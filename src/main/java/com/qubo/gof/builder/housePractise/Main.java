package com.qubo.gof.builder.housePractise;

/**
 *	创建者 模式 ：
 *		指挥者 -- 真实创建者--具体产品
 */
public class Main {

	public static void main(String[] args) {
			
			// 一个房主。其实就是一个指挥者
		    // 这房子 现在想装修房子！
			PersonDirector pd  = new PersonDirector();
			
			// 选择 工程队
			HouseBuilder hb = new LouFangHouseBuilder();
			// 最终确定 选择 盖楼房的工程队
			pd.Building(hb);
			
			// 工程队完成 装修。交付房子
			House h = hb.getHouse();
			
			System.out.println("房子的地板是 ： " + h.getFloor().getFloorColor());
			System.out.println("房子的墙是:" + h.getWall().getWallColor());
			
			
			
	}
}
