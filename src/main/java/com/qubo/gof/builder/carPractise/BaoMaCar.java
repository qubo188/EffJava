package com.qubo.gof.builder.carPractise;

public class BaoMaCar extends CarMode{

	@Override
	protected void start() {
			System.out.println("宝马启动");
	}

	@Override
	protected void stop() {
		System.out.println("宝马停止");
	}

	@Override
	protected void alarm() {
		System.out.println("宝马按了喇叭.......滴滴滴.....");
	}

	@Override
	protected void engineBoom() {
		System.out.println("宝马发动机........嗡嗡嗡.....");
	}

}
