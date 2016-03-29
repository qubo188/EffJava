package com.qubo.concurrent.ch03;

public class NoSynchronouizedMain {

	/**
	 *  这种打印 结果 你会发现，是打着打着就错乱了。
	 *  这是因为当一个线程运行运行。JVM 会将其暂停一会。让其它线程进入。所以会执行不错乱
	 */
	public static void main(String[] args) {
		new Thread(){
			public void run(){
				while(true){
					print("zhangsanfeng");
				}
			}
		}.start();
			new Thread(){
				public void run(){
					while(true){
						print("zhouxingchi");
					}
				}
			}.start();
	}
	
	public static void print(String name){
			for(int i = 0; i<name.length() ; i++){
					System.out.print(name.charAt(i));
			}
			System.out.println();
	}
}
