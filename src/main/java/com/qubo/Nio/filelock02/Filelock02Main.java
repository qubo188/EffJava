package com.qubo.Nio.filelock02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import com.qubo.config.Config;

public class Filelock02Main {

	/**
	 *  主要 模拟  共享锁(lock方式) ： 1 主线程 对 文件 A 加锁之后。
	 *                		         子线程 是否 是阻塞 住。
	 */
	public static void main(String[] args) throws Exception{
		
		
		// 读取的 地址
		File fInput = new File(Config.inputAdd);
		
		// 读取流
		FileInputStream fis = new FileInputStream(fInput);
		
		// 写入 流
		FileOutputStream fos = new FileOutputStream(fInput , true);
		
		// 读取 管道 
		FileChannel inputChannel = fis.getChannel();
		
		// 写入管道
		FileChannel outputChannel = fos.getChannel();
		
		// lock方式 加  共享锁
		
		FileLock lock = inputChannel.lock(0, fInput.length(), true);
		
		if(null!=lock){
			System.out.println("主线程 锁住了 文件");
			// 主线程 占用文件 30秒
			Thread.sleep(5000);
			
			//MappedByteBuffer mbb = inputChannel.map(FileChannel.MapMode.READ_WRITE, 0, fInput.length());
			
			ByteBuffer bb = ByteBuffer.allocate((int)fInput.length());
			
			int temp = 0;
			
			while((temp = inputChannel.read(bb))!=-1){
				bb.flip();
				System.out.println(bb);
				bb.clear();
			}
			
			System.out.println("主线程 写入 数据--->完毕 ");
			
		}else{
			
		}
		
		lock.release();
		System.out.println("主线程 释放了 文件");
		
		// 释放资源
		fis.close();
		fos.close();
		inputChannel.close();
		outputChannel.close();
				
	}
}
