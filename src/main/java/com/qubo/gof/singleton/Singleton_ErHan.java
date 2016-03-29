package com.qubo.gof.singleton;

public class Singleton_ErHan {

	private static Singleton_ErHan instance = new Singleton_ErHan();
	// 必须 定义 默认构造方法，并且指定权限为 private.这样外部不可以访问
	private Singleton_ErHan(){
		
	}
	
	public static Singleton_ErHan getInstance(){
		return instance;
	}
}
