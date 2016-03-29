package com.qubo.concurrent.ch01;

/**
 *	实现 线程的两种方式 ：
 *			1 extends Thread
 *			2 implements Runnable
 *
 *	区别：  
 *				1 使用Thread的话，你就不能再extends 其它类。 而实现Runnable你可以继承其它类。扩展性更高。
 *				2 Thread没有办法做到数据共享。而 Runnable可以做到。
 */
public class Basic_Thread_Runnable {

	
	public static void main(String[] args) {
		
				// 第一种
				new Thread(){
						public void run(){
							System.out.println("Thread--->" + Thread.currentThread().getName());
						}
				}.start();
				
				// 第二种
				new Thread(new MyRunnable()).start();
				
	}
	
}

class MyRunnable implements Runnable{
	public void run(){
		System.out.println("Runnable--->"+Thread.currentThread().getName());
	}
}

