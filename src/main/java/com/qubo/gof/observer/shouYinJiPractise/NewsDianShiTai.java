package com.qubo.gof.observer.shouYinJiPractise;

import java.util.Observable;
/**
 *   extends Observable 由jdk自己提供   主要目的就是：标准此类是 "被观察的对象"
 *   此类 是一个具体的实现 ----广播电视台-----可以发布新闻
 */
public class NewsDianShiTai extends  AbsDianShiTai{

	//收音机 电视台发布的 官方信息
	private String message;
	public NewsDianShiTai(String message){
		this.message = message;
	}
	// 实现业务逻辑
	public void publishGuangBo() {
		System.out.println("收音机电视台--发送了一条广播----->"+message);
		// 通知 Observable里面的状态发生改变
		this.setChanged();
		// 执行发送通知
		this.notifyObservers(message);
	}

}
