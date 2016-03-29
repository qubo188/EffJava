package com.qubo.gof.singleton;

public class Singleton_LanHan {

	private Singleton_LanHan instance;
	
	private Singleton_LanHan(){
		
	}
	
	public Singleton_LanHan getInstance(){
		if(instance==null){
			instance = new Singleton_LanHan();
		}
		return instance;
	}
	
	
	
}
