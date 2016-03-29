package com.qubo.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;


public class Digest_SHA {

	public static String str = "qubo  test MD5 MessageDigest";
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		jdk_sha1(); 
		jdk_sha1_02();
		
		bc_sha1();
		bc_sha224();
		
	}
	
	/**
	 * JDK 实现 sha1
	 */
	public static void jdk_sha1(){
			try {
				
				MessageDigest sha1 = MessageDigest.getInstance("SHA1");
				byte[] sha1Byte = sha1.digest(str.getBytes());
				System.out.println("JDK  SHA1 : " + Hex.encodeHexString(sha1Byte));
				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * JDK  另一种实现 sha1 的方法
	 */
	public static void jdk_sha1_02(){
		try {
			
			MessageDigest sha1 = MessageDigest.getInstance("SHA1");
			sha1.update(str.getBytes());
			System.out.println("JDK SHA1 02 : " + Hex.encodeHexString(sha1.digest()));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用 Bouncy Castle
	 */
	public static void bc_sha1(){
		Digest digest = new SHA1Digest();
		digest.update(str.getBytes() , 0 , str.getBytes().length);
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		
		digest.doFinal(sha1Bytes,0);
		
		System.out.println("Bouncy Castle SHA1 : " + Hex.encodeHexString(sha1Bytes));
		System.out.println("Bouncy Castle SHA1 : " +org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
	}
	
	/**
	 * 使用 Bouncy Castle 做 sha224
	 */
	public static void bc_sha224(){
		Digest digest = new SHA224Digest();
		digest.update(str.getBytes(), 0, str.getBytes().length);
		byte[] sha224 = new byte[digest.getDigestSize()];
		digest.doFinal(sha224, 0);
		System.out.println("BC SHA224 : " + org.bouncycastle.util.encoders.Hex.toHexString(sha224));
	}

	
}
