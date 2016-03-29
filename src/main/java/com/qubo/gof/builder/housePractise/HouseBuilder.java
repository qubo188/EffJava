package com.qubo.gof.builder.housePractise;

public interface HouseBuilder {

	//装修地板
	public void makeFloor();
	// 装修 墙
	public void makeWall();
	
	//返回装修好的房子
	public House getHouse();
}
