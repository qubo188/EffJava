package com.qubo.concurrent.ch02;

import java.util.Timer;
import java.util.TimerTask;


/**
 *		Timer定时器
 */
public class TimerMain {

		public static void main(String[] args) {
				// 第一种 基本使用------------1000秒钟的定时器 之后执行
				// 相当于 安装了一个 1000之后爆炸的 炸弹
			/*
			 new Timer().schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println("第一种");
				}
			}, 1000);
			*/
			
			// 第二种 相当于 安装了 一个连贯的炸弹
			// 第一个1000: 启动之后 1000之后爆炸
			// 第二个1000：相当于连环炸弹。每过1秒钟 爆炸一回
			/**
			new Timer().schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("爆炸");
				}
			}, 1000 , 1000);
			*/
			
			
			new Timer().schedule(
					new MyTimeTask()
					,1000);
			new Thread(){
				public void run(){
					int count = 0;
					while(true){
						try {
							count++;
							Thread.sleep(1000);
							System.out.println(count + "秒");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
			
		}
		
		
		
}

class MyTimeTask extends TimerTask{
	static int count = 0;
	public void run(){
		count++;
		count = count % 2;
		System.out.println("爆炸");
		new Timer().schedule(new MyTimeTask() , 1000 + 1000*count);
	}
}
