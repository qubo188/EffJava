package com.qubo.concurrent;

/**
 * 实现 线程 有两种方式 ：
 * 												1 extends  Thread
 * 												2 implements Runnable
 * 
 * 	执行原理：
 * 						new Thread().start()--->执行执行的是Thread内部的 public void run()方法
 * 	
 * 	run()源码：
 * 						public void run(){
 * 							if(target!=null){
 * 										target.run();
 * 								}
 * 						}
 * 理解 ： 1  target ---其实指向的是 runnable 的对象。如果你使用的是 new Thread(new Runnable())其实就是这个Runnable.
 * 					  实际上也就是调用了 runnable的run方法
 * 				   2 如果你没有使用Runnable() 也就是 new Thread()的话。那么它上面也不执行。你必须自己重写run方法。你具体
 * 					  的执行代码 就放在run方法里面就行了
 */
public class ConcurrentMain {
	
	public static void main(String[] args) {
		new Thread();
	}

}
