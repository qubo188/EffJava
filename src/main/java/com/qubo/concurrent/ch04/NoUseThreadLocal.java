package com.qubo.concurrent.ch04;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *	 实现功能： 线程 之间 共享数据
 *
 *	
 */
public class NoUseThreadLocal {

	public static Map<String , Integer> map  = new HashMap<String,Integer>();
	
	public static void main(String[] args) {
			
		
		for (int i = 0; i < 3; i++) {
			new Thread(
					new Runnable(){
						public void run(){
								int count = new Random().nextInt();
								map.put(Thread.currentThread().getName(), count);
								A a = new A();
								a.print();
								B b = new B();
								b.print();
						}
					}
					){}.start();
					
		}
			
	}
	
	static class A{
		public void print(){
			System.out.println("A--Thread-"+Thread.currentThread().getName() + map.get(Thread.currentThread().getName()));
		}
	}
	static class B{
			public void print(){
				System.out.println("B--Thread-"+Thread.currentThread().getName() + map.get(Thread.currentThread().getName()));
			}
	}
	
}
