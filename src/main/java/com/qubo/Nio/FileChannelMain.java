package com.qubo.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileChannelMain {

	public static void main(String[] args) {
		File f  = new File("F:\\WebWork\\EffJava\\src\\main\\java\\com\\qubo\\Nio\\ChannelMain.java");
		
		try {
			
			
			FileChannel fc = new FileInputStream(f).getChannel();
			
			//将 ChannelMain.java的全部数据 装载 到  MappedByteBuffer
			MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			
			Charset c = Charset.forName("GBK");
			
			CharBuffer bb = c.decode(mbb);
			
			System.out.println(bb);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
