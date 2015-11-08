package com.qubo.Nio.charset02;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class EncoderAndDecoder {

	/**
	 * 
	 * 主要 演示 编码 和 解码
	 * @throws CharacterCodingException 
	 */
	public static void main(String[] args) throws CharacterCodingException {

		// 指定  编码和解码  使用哪种字符集
		Charset charset = Charset.forName("UTF-8");
		
		// 创建 编码器
		CharsetEncoder encoder = charset.newEncoder();
		
		// 创建解码器
		CharsetDecoder decoder = charset.newDecoder();
		
		
		// 使用CharBuffer装载数据
		CharBuffer cb = CharBuffer.wrap("新IO的使用。还不是很熟练。");
		
		// 加编码 
		ByteBuffer bb = encoder.encode(cb);
		
		// 解码
		System.out.println(decoder.decode(bb));
	
		
		
		/*CharBuffer c = CharBuffer.allocate(100);
		c.put("121");
		c.put("zh");
		c.put("重化工");
		c.put("啊是大师的");
		
		c.flip();
		
		System.out.println(c);
		
		c.put("asdasd");
		System.out.println(c);*/
		
	}

}
