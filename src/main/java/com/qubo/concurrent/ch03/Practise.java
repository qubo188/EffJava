package com.qubo.concurrent.ch03;

/**
 *	实现目标：
 *		 子线程 运行10次之后，主线程运行20次。
 *		  反复执行20次。
 *
 *
 *	重点 ： wait() 是让当前线程等待。并且 它的最外层一般会与"while"配合 和 "synchronized"一起使用
 *					重点：为什么要和while一起使用呢？
 *					因为 ：有的时候wait是被伪唤醒。while里面的变量有可能还是false.所以。这个时候wait会先去执行while里面的变量看看是否为true.
 *								如果为true的话，就继续等待。如果为false 那么就执行其它代码
 *					public synchronized void xxx(){
 *						while(xx){
 *								this.wait();// notify()执行这之后。会去看一下xx到底为什么。如果为true就继续等待
 *						}
 *				}
 *
 *				notify()：重点：它是通知 所有的wait都会唤醒。这个时候就会出现伪唤醒。
 *				
 *
 */
public class Practise {
	
	
	public static void main(String[] args) {
		final Print p = new Print();
		new Thread(new Runnable(){
			public void run(){
				for (int i = 1; i <= 20; i++) {
					p.print_sub("子线程" , 10);
				}
			}
		}).start();
				
		
		for (int i = 1; i <= 20; i++) {
			p.print_main("主线程" , 20);	
		}
				
	}
	
	

}

class Print{
	
	public  boolean exeSub = true;
	/**
	 * @param name  打印的名称
	 * @param len 打印的长度
	 * Description : 打印 子线程信息
	 */
	public synchronized  void print_sub(String name , int len){
		while(!exeSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		 for (int j = 1; j <= len; j++) {
				System.out.println("name : " + name + " , 打印次数 : " + j);
			}
			 exeSub = false;
			 this.notify();
	} 
	/**
	 * @param name  打印的名称
	 * @param len 打印的长度
	 * Description : 打印 主线程信息
	 */
	public synchronized  void print_main(String name , int len){
		while(exeSub){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= len; j++) {
			System.out.println("name : " + name + " , 打印次数 : " + j);
		}
	 exeSub = true;
	 this.notify();
	}
}


