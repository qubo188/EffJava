package com.qubo.encryption;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *  Base64 一般用于 Email 证书  密钥的 加密 
 *  
 */
public class Base64 {

	private static String str = "qubo study security base64";
	
	public static void main(String[] args) {
		
		//默认使用jdk的实现方式
		jdkBase64();
		
		//使用扩展包 Commons Codec 里面的 Base64
		commonsCodesBase64();
		
		// 使用扩展包  Bouncy Castle 里面的 Base64
		BouncyCastle();
	}
	
	/**
	 * 默认使用JDK 的 jar实现 Base64的实现
	 */
	public static void jdkBase64(){
		try {
			//加密 
			BASE64Encoder base64 = new BASE64Encoder();
			String encoderStr = base64.encode(str.getBytes());
			System.out.println("jdk encoder :  " + encoderStr);
			
			//解密
			BASE64Decoder base64Decoder = new BASE64Decoder();
			
			byte[] decode = base64Decoder.decodeBuffer(encoderStr);
			
			System.out.println("jdk decoder : " + new String(decode));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 使用 CommonsCodesBase64来实现
	 */
	public static void commonsCodesBase64(){
		
		byte[] encode = org.apache.commons.codec.binary.Base64.encodeBase64(str.getBytes());
		System.out.println("Commons Codec encode : " + new String(encode));
		
		byte[] decode = org.apache.commons.codec.binary.Base64.decodeBase64(encode);
		System.out.println("Commons Codec decode : " + new String(decode));
	}
	
	/**
	 * 使用 BouncyCastle 来实现 Base64
	 */
	public static void BouncyCastle(){
			byte[] encode = org.bouncycastle.util.encoders.Base64.encode(str.getBytes());
			System.out.println("Bouncy Castle encode: " + new String(encode));
			
			byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
			System.out.println("Bouncy Castle decode : " + new String(decode));
	}
	
	public static void test(){
	}
}

