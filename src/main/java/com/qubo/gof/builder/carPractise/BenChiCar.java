package com.qubo.gof.builder.carPractise;

public class BenChiCar extends CarMode{

	@Override
	protected void start() {
			System.out.println("奔驰启动");
	}

	@Override
	protected void stop() {
		System.out.println("奔驰停止");
	}

	@Override
	protected void alarm() {
		System.out.println("奔驰按了喇叭.......滴滴滴.....");
	}

	@Override
	protected void engineBoom() {
		System.out.println("奔驰发动机........嗡嗡嗡.....");
	}

}
