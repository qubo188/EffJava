package com.qubo.gof.builder.carPractise;

import java.util.ArrayList;
import java.util.List;

/**
 *	抽象类的好处是。可以定义一些抽象的方法。因为每个具体的实现是不同的！
 *                                   
 */
public abstract class CarMode {

	// 汽车的启动顺序
	private List<String> sequence = new ArrayList<String>();
	
	// 汽车可以跑
	protected abstract void start();
	// 汽车可以停止
	protected abstract void stop();
	//汽车肯定是有喇叭的
	protected abstract void alarm();
	//汽车肯定有引型
	protected abstract void engineBoom();
	
	//	因为每台汽车的执行顺序可以定制！所以顺序是可变的
	final public void setSequence(List<String> sequence){
		this.sequence = sequence;
	}
	
	// 每辆汽车都可以跑，都可以启动起来
	public void run(){
		for(String what : sequence){
			 if(what.equalsIgnoreCase("start")){
				  this.start();
			 }
			 else if(what.equalsIgnoreCase("stop")){
				 this.stop();
			 }
			 else if(what.equalsIgnoreCase("alarm")){
				 this.alarm();
			 }
			 else if(what.equals("engineBoom")){
				 this.engineBoom();
			 }
		}
	}
	
}
