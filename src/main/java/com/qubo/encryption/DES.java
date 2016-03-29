package com.qubo.encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *		对称加密 之 DES加密
 *     此对称加密 已经过时！现在已经完全被破解
 */
public class DES {

	public static void main(String[] args) {
			String test = "asdaasda123";
			jdkDES(test);
	}
	
	/**
	 * 这种方式  是 使用jdk的实现方式  实现 
	 */
	public static void jdkDES(String str){
		try {
			
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			//声明 默认长度 是 56
			keyGenerator.init(56);
			
			SecretKey secretKey = keyGenerator.generateKey();
			
			byte[] bytesKey = secretKey.getEncoded();
			
			// KEY转换
			DESKeySpec deskeySpac = new DESKeySpec(bytesKey);
			
			SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			
			SecretKey convertSecretKey = factory.generateSecret(deskeySpac);
			
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE , convertSecretKey);
			
			byte[] result = cipher.doFinal(str.getBytes());
			
			System.out.println("jdk des encryption  : " + new String(result));
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			cipher.doFinal(result);
			System.out.println("jdk des decrypt : " + new String(result));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
