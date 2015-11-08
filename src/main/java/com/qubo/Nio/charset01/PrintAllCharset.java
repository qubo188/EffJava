package com.qubo.Nio.charset01;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;

public class PrintAllCharset {

	/**
	 * 此类 主要功能  打印 所有的 字符集
	 */
	public static void main(String[] args) {

		SortedMap<String , Charset> all = Charset.availableCharsets();
		
		Set<Entry<String , Charset>> s = all.entrySet();
		
		Iterator<Entry<String, Charset>> ite = s.iterator();
		
		while(ite.hasNext()){
			Entry<String, Charset> entry = ite.next();
			
			// 打印所有字符集
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}
		
		
	}

}
