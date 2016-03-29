package com.qubo.concurrent.ch03;

public class SynchronizedMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				while(true){
					print("zhangsan");
				}
			}
		}.start();
			new Thread(){
				public void run(){
					while(true){
						print("wangxiaoer");
					}
				}
			}.start();
	}
	
	public synchronized static void print(String name){
		for(int i = 0; i<name.length() ; i++){
			System.out.print(name.charAt(i));
		}
		System.out.println();
	}
}
