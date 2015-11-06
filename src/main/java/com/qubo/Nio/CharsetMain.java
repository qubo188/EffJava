package com.qubo.Nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class CharsetMain {

	public static void main(String[] args) {
			SortedMap<String,Charset> m = Charset.availableCharsets();
			
			for(String alias : m.keySet()){
				System.out.println(alias);
			}
	}
}
