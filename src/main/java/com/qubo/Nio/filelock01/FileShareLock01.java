package com.qubo.Nio.filelock01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

import com.qubo.config.Config;

public class FileShareLock01 {

	/**
	 * 一 ： 文件所 分为两种 1 共享锁 2 独占锁
	 * 
	 * 1 共享锁 ： 即所有人只有 可 “读的” 操作。 
	 * 2 独占锁 ：即只有 一人 可以对文件 行 “读写” 操作
	 * 
	 *  主要  演示 ： 共享锁(lock方式) 在 同一个线程内  是否 可以读 可以写
	 *   
	 */
	
	public static void main(String[] args) throws Exception {
		// demo1();
		demo2();
	}

	public static void demo2() throws Exception{
		
		
		// 读取的 地址
		File fInput = new File(Config.inputAdd);
		
		// 读
		FileInputStream fis = new FileInputStream(fInput);
		
		// 写  true-->以追加的方式
		FileOutputStream fos =  new FileOutputStream(fInput , true);
		
		// 读 管道
		FileChannel inputChannel = fis.getChannel();
		
		// 写管道
		FileChannel outputChannel = fos.getChannel();
		
		
		// 对文件fInput  加  《阻塞》 ->  “共享锁”
		
		FileLock lock = inputChannel.lock(0 , fInput.length() , true);
		
		// 重点 提示。如果 有其它线程 在对 fInput文件 上锁。那么这个地方是阻塞的。不会往下执行代码
		
		if(null!=lock){
			// 说明 当前 fInput文件 没有被 上锁。或者说 已经被释放
			System.out.println("文件 没有被上锁 或者 已经被释放锁");
			
			MappedByteBuffer mbb = inputChannel.map(FileChannel.MapMode.READ_ONLY, 0, fInput.length());
			System.out.println("数据 已经  被 读取 完毕 ");
			
			outputChannel.write(mbb);
			System.out.println("数据 已经  被 写入 完毕 ");
			
		}else{
			System.out.println("按道理说 这句话 永远 不应该被打印 的.....");
		}
		
		//释放锁
		lock.release();
		
		
		fis.close();
		fos.close();
		inputChannel.close();
		outputChannel.close();
		
		
		
	}
	/**
	 *  演示 用 Channel锁 主文件。
	 *     但是 用传统的 io 写入文件 时。是可以写入的。
	 */
	public static void demo1() throws Exception {

		// 读取的 地址
		File fInput = new File(Config.inputAdd);

		// 创建 一个 读写 操作
		RandomAccessFile raf = new RandomAccessFile(fInput, "rw");
		// 跳至 文件默认 准备 追加
		raf.seek(fInput.length());

		FileChannel channel = raf.getChannel();

		// true 创建 一个 共享锁
		// 如果说 当前 没有其它线程占用。那么这个地方就会返回一个新的 FileLock对象。代表我将文件Config.inputAdd锁定。
		// 如果 被其它人 占用 那么就会成 阻塞 模式。不往下继续执行
		FileLock fileLock = channel.lock(0, fInput.length(), true);
		// 重点------>不要忘记lock 是阻塞方式。也就是说。假如现在有另一个线程在使用着这个文件的资源。
		// 那么执行到这里。就不会 往下 执行的。
		// 直到 另一个线程 释放了 资源。我这个地方 才能返回一个新的 FileLock对象

		if (null != fileLock) {
			System.out.println("已经 获取 到 文件锁");
			// 没有 被其他人 占用。或者说已经释放了。
			// 目前已经被我自己占用

			// 那么第一步 我先读取
			// 已经 数据 一次性 的 读取到 内存映射 mbb当中
			MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE,
					0, fInput.length());

			byte[] temp = new byte[(int) fInput.length()];
			int foot = 0;

			while (mbb.hasRemaining()) {
				temp[foot++] = mbb.get();
			}
			System.out.println(new String(temp));
			System.out.println("数据  读取 完毕");
			// 在上面 锁没有 释放的情况下，我又往这个文件 写入数据了。
			raf.write(temp);
			System.out.println("数据  写入 完毕");

		} else {
			System.out.println("当前 文件 已经 被其它线程锁定 ---这句话 应该是永远也不会被执行的。 ");
		}

		// 释放锁
		fileLock.release();
		System.out.println("文件锁 已经  释放");

		raf.close();
		channel.close();

	}

}
