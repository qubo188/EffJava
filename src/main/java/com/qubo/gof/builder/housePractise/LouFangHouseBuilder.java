package com.qubo.gof.builder.housePractise;

public class LouFangHouseBuilder implements HouseBuilder {

	private House loufang = new House();
	
	// 要将 楼房的地板  设计成什么样子
	public void makeFloor() {
		Floor f = new Floor();
		f.setFloorColor("金色的地板");
		loufang.setFloor(f);
	}
	// 要将 楼房的 墙  设计成什么样子
	public void makeWall() {
		Wall w = new Wall();
		w.setWallColor("金色的墙");
		loufang.setWall(w);
	}
	// 返回 装修好的 楼房
	public House getHouse() {
		return loufang;
	}

}
