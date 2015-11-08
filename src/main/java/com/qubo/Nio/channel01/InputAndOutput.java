package com.qubo.Nio.channel01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.qubo.config.Config;

public class InputAndOutput {

	/**
	 * @param args
	 * @throws IOException 
	 *            
	 * 
	 */
	public static void main(String[] args) throws IOException {
		
		
		
		// 读取的 地址 
		File fInput = new File(Config.inputAdd);
		// 写入的 地址
		File fOutput = new File(Config.outputAdd);
		
		FileInputStream fis = new FileInputStream(fInput);
		FileOutputStream fos = new FileOutputStream(fOutput);
		
		// 1 Channel 无论是 读 或者 写  都必须 使用 Buffer。所以第一步创建Buffer
		ByteBuffer bb = ByteBuffer.allocate(1024);
		
		// 2 得到 Channel的 读 操作
		FileChannel cInput = fis.getChannel();
		
		// 3 得到 Channel 的 写操作
		FileChannel cOutput = fos.getChannel();
		
		int temp = 0;
		
		while((temp=cInput.read(bb))!=-1){
			
			// 1 当你执行完  cInput.read(bb);之后。bb将会被写满数据 
			//	 此时 position在数据的最后一个位置
			//  此时 limit为整个长度  
			//  所以你必须将 指针position从新 执行 数据的起始端。我们才能将bb内的缓冲数据全部写入到对应得地方
			bb.flip();
			cOutput.write(bb);
			bb.clear();
		}
		
		System.out.println("数据 写入完毕");
		fis.close();
		fos.close();
		cInput.close();
		cOutput.close();
		
		
		
			
	}
}
