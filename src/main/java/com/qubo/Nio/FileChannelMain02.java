package com.qubo.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelMain02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File f  = new File("F:\\WebWork\\EffJava\\src\\main\\java\\com\\qubo\\Nio\\ChannelMain.java");
		
		try {
			
			//创建管道 与 数据连通
			FileChannel fc = new FileInputStream(f).getChannel();
			
			ByteBuffer bb = ByteBuffer.allocate(254);
			
			while(fc.read(bb)>0){
				
					Charset charset = Charset.forName("GBK");
					CharsetDecoder cd = charset.newDecoder();
					CharBuffer cb = cd.decode(bb);
					System.out.println(bb);
			}
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
