package com.qubo.encryption;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	public static void main(String[] args) {
			String str = "as中国sd213123123asdauuuuyyyyszsdasdas" +
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
			jdkAES(str);
	}
	
	public static void jdkAES(String str){
		
		try {

			// 生成key
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			// 生成密钥的长度
			keyGenerator.init(128);
			
			keyGenerator.generateKey();
			
			SecretKey secretKey = keyGenerator.generateKey();
			
			byte[] keyBytes = secretKey.getEncoded();
			
			//key的转换
			Key key = new SecretKeySpec(keyBytes , "AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			
			cipher.init(Cipher.ENCRYPT_MODE, key);
			
			byte[] result = cipher.doFinal(str.getBytes());
			
			System.out.println("jdk AES Encrypt : " + parseByte2HexStr(result));
			
			// 解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("jdk AES Decrypt : " + new String(parseHexStr2Byte(parseByte2HexStr(result))));
			
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
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
