package com.qubo.encryption;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 *	特点  ： 是将 DES AES的加密方式 的优点 集于一身的 
 *					盐 ：其实就是 随机的字符串 或者是  随机的 数字
 *
 *			http://www.imooc.com/video/5842    看到10：34
			http://www.imooc.com/learn/286  还没看
			http://www.imooc.com/learn/288 还没看
			http://www.imooc.com/learn/285 还没看
 */
public class PBE {
	
	public static String str = "as中国sd213123123asdauuuuyyyyszsdasdas" +
			 "中国sd213123123asdauuuuyyyyszsdasdas中国" +
			 "sd213123123asdauuuuyyyyszsdasdas中国sd21312" +
			 "3123asdauuuuyyyyszsdasdas中国sd213123123as" +
			 "dauuuuyyyyszsdasdas中国sd213123123asdauuuuy" +
			 "yyyszsdasdas中国sd213123123asdauuuuyyyyszsda" +
			 "sdas中国sd213123123asdauuuuyyyyszsdasdas中国sd" +
			 "213123123asdauuuuyyyyszsdasdas中国sd213123123asd" +
			 "auuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsd" +
			 "asdas中国sd213123123asdauuuuyyyyszsdasdas中国sd2131" +
			 "23123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyy" +
			 "szsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd2131" +
			 "23123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsd" +
			 "asdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123a" +
			 "sdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasda" +
			 "s中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asda" +
			 "uuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas" +
			 "中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asd" +
			 "auuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasd" +
			 "as中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123as" +
			 "dauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasd" +
			 "as中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123as" +
			 "dauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasd" +
			 "as中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123as" +
			 "dauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasd" +
			 "as中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123a" +
			 "sdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdas" +
			 "das中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123a" +
			 "sdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasd" +
			 "as中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asd" +
			 "auuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中" +
			 "国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauu" +
			 "uuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd21" +
			 "3123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasda" +
			 "s中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdas" +
			 "das中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszs" +
			 "dasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyys" +
			 "zsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszs" +
			 "dasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsda" +
			 "sdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasda" +
			 "中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中" +
			 "国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国s" +
			 "d213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasdas中国sd213123123asdauuuuyyyyszsdasd";

	
	
	public static void main(String[] args) {
		jdkPBE(str);
	}
	
	public static void jdkPBE(String str){
		try {
			
		// 初始化盐
		SecureRandom secureRandom = new SecureRandom();
		byte[] salt = secureRandom.generateSeed(8);
		
		//加密
		String password = "qubo";
		PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
		
	
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5ANDDES");
		Key key = factory.generateSecret(pbeKeySpec);
		
		//加密
		PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt , 100);
		Cipher cipher = Cipher.getInstance("PBEWITHMD5ANDDES");
		cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
		byte[] result = cipher.doFinal(str.getBytes());
		System.out.println("PBE JDK Encrypt : " + parseByte2HexStr(result));
		
		// 解密
		cipher.init(Cipher.DECRYPT_MODE , key , pbeParameterSpec);
		result = cipher.doFinal(result);
		System.out.println("PBE JDK Decrupt : " + new String(parseHexStr2Byte(parseByte2HexStr(result))));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
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
	
	/**将二进制转换成16进制 
	 * @param buf 
	 * @return 
	 */  
	public static String parseByte2HexStr(byte buf[]) {  
	        StringBuffer sb = new StringBuffer();  
	        for (int i = 0; i < buf.length; i++) {  
	                String hex = Integer.toHexString(buf[i] & 0xFF);  
	                if (hex.length() == 1) {  
	                        hex = '0' + hex;  
	                }  
	                sb.append(hex.toUpperCase());  
	        }  
	        return sb.toString();  
	}  
	
	/**将16进制转换为二进制 
	 * @param hexStr 
	 * @return 
	 */  
	public static byte[] parseHexStr2Byte(String hexStr) {  
	        if (hexStr.length() < 1)  
	                return null;  
	        byte[] result = new byte[hexStr.length()/2];  
	        for (int i = 0;i< hexStr.length()/2; i++) {  
	                int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);  
	                int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);  
	                result[i] = (byte) (high * 16 + low);  
	        }  
	        return result;  
	}  
	
}
