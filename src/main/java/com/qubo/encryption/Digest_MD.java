package com.qubo.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *	MD 家族：1 MD2 -------默认长度 128 -------JDK实现
 *						2 MD4--------默认长度128--------Bouncy Castle 实现
 *						3 MD5--------默认长度128--------JDK实现
 *
 *		jdk实现MD的操作都是一些基本的操作。而且效率不高
 *		CommonsCodec :其实内部是使用jdk一样的操作。只不过是对 jdk进行了封装。让用户用起来更顺手而已
 *		BouncyCodec ：是用自己的方式 实现的 MD
 */
public class Digest_MD {
	
	public static String str = "qubo  test MD5 MessageDigest";
	
	public static void main(String[] args) {
			// md2
			jdkMD2();
			// md5
			jdkMD5();
			// Bouncy Castle 实现  MD4
			BCMD4();
			// jdk 实现MD4 .但是 jdk根本没有提供	MD4所以会报错。但是如果将jdk 的 Security  addProvider(new BouncyCastle())就可以。将本地jdk添加第三方依赖库
			// Security.addProvider(new BouncyCastleProvider());
			// jdk 添加第三方 BouncyCastle来做MD4的操作
			jdkUseProviderBouncyCastle_MD4();
			// CommonsCodec 实现MD5
			CC_MD5();
	}
	
	/**
	 * md2 使用 jdk实现
	 */
	public static void jdkMD2(){
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD2");
			byte[] md2Byte = md.digest(str.getBytes());
			//重点：如果将 数组 md2Byte显示 必须做一个16进制的转换。而默认的 jdk 是没有对MD的转换。
			//所以此时 我们需要借助第三方包 Commons Codec中的Hex
			System.out.println("jdk md2 : " + Hex.encodeHexString(md2Byte));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  jdk 实现 MD5
	 */
	public static void jdkMD5(){
		try {
			
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] md5Byte = md5.digest(str.getBytes());
			System.out.println("jdk MD5 : " + Hex.encodeHexString(md5Byte));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 *  用第三方库 Bouncy Castle 实现MD4
	 */
	public static void BCMD4(){
			Digest digest = new MD4Digest();
			byte[] md4Byte = new byte[digest.getDigestSize()];
			digest.update(str.getBytes(), 0, str.getBytes().length);
			digest.doFinal(md4Byte, 0);
			System.out.println("Bouncy Castle md4 : " + org.bouncycastle.util.encoders.Hex.toHexString(md4Byte));
	}
	/**
	 *  此方法 应该是报错的 。因为 jdk压根就没有 实现 MD4。
	 *  如果想使用md4必须使用第三方 Bouncy Castle  或者 Commons Codec
	 */
	public static void jdkUseProviderBouncyCastle_MD4(){
		try {
			
		/*	
		 * 这种 是错误的！因为 默认的 jdk 是没有实现 MD4的！
		    MessageDigest md4 = MessageDigest.getInstance("MD4");
			byte[] md4Byte = md4.digest(str.getBytes());
			System.out.println("jdk md4 : " + Hex.encodeHexString(md4Byte));
			*/
			
			Security.addProvider(new BouncyCastleProvider());
			
			MessageDigest md4 = MessageDigest.getInstance("MD4");
			byte[] jdk_provider_bc = md4.digest(str.getBytes());
			System.out.println("jdk usr provider Bouncy Castle MD4 : " + Hex.encodeHexString(jdk_provider_bc));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Commons Codec 实现MD5
	 */
	public static void CC_MD5(){
		System.out.println("Commons Codec MD5 :" + DigestUtils.md5Hex(str.getBytes()));
	}
	

	
}
