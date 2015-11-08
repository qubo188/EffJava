package com.qubo.Nio.mappedByteBuffer01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import com.qubo.config.Config;

public class MappedByteBuffer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		// 读取的 地址
		File fInput = new File(Config.inputAdd);
		
		FileInputStream fis = new FileInputStream(fInput);
		
		FileChannel fileChannel = fis.getChannel();
		
		// 映射到 内存
		java.nio.MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fInput.length());
		
		byte[] buf = new byte[(int)fInput.length()]; 
		
		int foot = 0;
		
		while(mappedByteBuffer.hasRemaining()){
			buf[foot++] = mappedByteBuffer.get();
		}
		
		System.out.println(new String(buf));
		
		fileChannel.close();
		fis.close();
		
		
	}

}
