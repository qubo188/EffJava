package com.qubo.gof.builder.housePractise;

/**
 *		一个真实的 建造 平房的 装修公司。
 */
public class PingFangHouseBuilder implements HouseBuilder {

	private House pingfang = new House();
	
	// 要将 平房的地板  设计成什么样子
	public void makeFloor() {
		Floor f = new Floor();
		f.setFloorColor("白色的地板");
		pingfang.setFloor(f);
	}

	// 要将 平房的 墙  设计成什么样子
	public void makeWall() {
		Wall w = new Wall();
		w.setWallColor("白色的墙");
		pingfang.setWall(w);
	}

	// 返回 装修好的 房子
	public House getHouse() {
		return pingfang;
	}

}
