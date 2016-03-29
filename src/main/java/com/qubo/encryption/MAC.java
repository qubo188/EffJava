package com.qubo.encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

/**
 *	Mac 分为2大类：
 *									1 MD 
 *												1.1 HmacMD2
 *												1.2 HmacMD4 
 *												1.3 HmacMD5
 *
 *									2 SHA
 *												2.1 HmacSHA1
 *												2.2 HmacSHA224
 *												2.3 HmacSHA256
 *												2.4 HmacSHA384
 *												2.5 HmacSHA512
 *
 *Mac摘要算法 又称之为 ： 含有密钥的 散列函数
 *
 */
public class MAC {
	
	public static String str = "qubo  test MD5 MessageDigest";

	public static void main(String[] args) {
		jdkHmacMD5();
		bcHmacMD5();
	}
	
	/**
	 * jdk  实现 MAC 算法中的  MD 系列  之   HmacMD5算法
	 */
	public static void jdkHmacMD5(){
		try {
			
			//初始化  KeyGenerator
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
			
			// 产生密钥
			SecretKey secretKey = keyGenerator.generateKey();
			//获得密钥
			//byte[] key = secretKey.getEncoded();
			
			byte[] key = Hex.decodeHex(new char[]{'a','a','a','a','a','a','a','a','a','a'});
			
			// 还原密钥
			SecretKey restoreSecretKey = new SecretKeySpec(key , "HmacMD5");
			
			// 实例化Mac
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
			
			// 初始化 Mac
			mac.init(restoreSecretKey);
			
			// 执行 摘要
			byte[] hmacMD5Bytes = mac.doFinal(str.getBytes());
			
			//打印结果
			System.out.println("jdk HmacMD5  Encode : " + Hex.encodeHexString(hmacMD5Bytes));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (DecoderException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	/**
	 * 使用Bouncy Castle  来实现 
	 */
	public static void bcHmacMD5(){
		
			HMac hmac = new HMac(new MD5Digest());
			
			hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
			
			hmac.update(str.getBytes() , 0 , str.getBytes().length);
			
			byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];
			
			hmac.doFinal(hmacMD5Bytes, 0);
			
			System.out.println("Bouncy Castle HmacMD5 Encode : " + org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
	}
	
	
}
