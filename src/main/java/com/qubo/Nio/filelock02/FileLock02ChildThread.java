package com.qubo.Nio.filelock02;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

import com.qubo.config.Config;

public class FileLock02ChildThread {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception{

		// 读取的 地址
		File fInput = new File(Config.inputAdd);

		// 读取流
		FileInputStream fis = new FileInputStream(fInput);
		
		// 读取 管道
		FileChannel inputChannel = fis.getChannel();
		// lock方式 加 共享锁
		
		
		System.out.println("主线程 在 控制文件fInput - 30秒 ， 当前时间子线程 - >" + new Date());
		FileLock lock = inputChannel.lock(0, fInput.length(), true);
		System.out.println("子线程 对 fInput 加上锁了。加上的时间为： " + new Date());
		
		if (null != lock) {
			System.out.println("子线程开始执行 锁里面的操作了");
		} else {
			System.out.println("按道理说 这句话 永远 不应该被打印 的.....");
		}

		lock.release();

		// 释放资源
		fis.close();
		inputChannel.close();
	}

}
