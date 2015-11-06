package com.qubo.Nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ChannelMain {

	public static void main(String[] args) {
		
			File f  = new File("F:\\WebWork\\EffJava\\src\\main\\java\\com\\qubo\\Nio\\ChannelMain.java");
			
			try {
					
				FileChannel fChannel_input = new FileInputStream(f).getChannel();
				
				FileChannel fChannel_out = new FileOutputStream("F:\\a.txt").getChannel();
				
				MappedByteBuffer mbb = fChannel_input.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
				
				Charset c = Charset.forName("GBK");
				
				fChannel_out.write(mbb);
				
				mbb.clear();
				
				CharsetDecoder cd = c.newDecoder();
				
				CharBuffer cb = cd.decode(mbb);
				
				System.out.println(cb);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	}
}
