package com.qubo.gof.builder.carPractise;

import java.util.ArrayList;
import java.util.List;

public class Director {

	private List<String> sequence = new ArrayList<String>();
	
	private BenChiBuilder bcb = new BenChiBuilder();
	
	private BaoMaBuilder bmb = new BaoMaBuilder();
	
	/**
	 * 指挥者 打算 创建 A种类型的 奔驰  启动顺序是 ----->按喇叭 ------>启动---->引型---->停止
	 */
	public CarMode get_A_BenChiCar(){
		// 必须 先 清除掉 之前的 数据
		this.sequence.clear();
		// 设置启动顺序
		this.sequence.add("alarm");
		this.sequence.add("start");
		this.sequence.add("engineBoom");
		this.sequence.add("stop");
		bcb.setSequence(this.sequence);
		// 返回 A种执行方式的 car
		return (BenChiCar)bcb.getCar();
	}
	
	/**
	 * 指挥者 打算 创建 B种类型的 奔驰 启动顺序是 ---->启动----->按喇叭------>引型---->停止
	 */
	public CarMode get_B_BenChiCar(){
		// 清除以前的数据
		this.sequence.clear();
		//添加 启动顺序
		this.sequence.add("start");
		this.sequence.add("alarm");
		this.sequence.add("engineBoom");
		this.sequence.add("stop");
		bcb.setSequence(sequence);
		return (BenChiCar)bcb.getCar();
	}
	
	/**
	 * 指挥者 打算 创建 A种类型的 宝马 启动顺序是 ---->启动----->按喇叭
	 */
	public CarMode get_A_BaoMaCar(){
		
		//清除掉之前的记录
		this.sequence.clear();
		
		//添加启动顺序
		this.sequence.add("start");
		this.sequence.add("alarm");
		
		bmb.setSequence(sequence);
		return (BaoMaCar)bmb.getCar();
	}
}
