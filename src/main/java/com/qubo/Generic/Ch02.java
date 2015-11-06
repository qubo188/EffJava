package com.qubo.Generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ch02 {

	public void getList(List<Object> l, String str){
		
		HashMap<String , Integer> m = new HashMap<String , Integer>();
		m.put("name" , 1);
		m.put("age" , 12);
		
		Set<Map.Entry<String , Integer>> s = m.entrySet();
		
		for(Map.Entry<String, Integer> e : s){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
	
	
	public <S>S add(S x , S y){
		return y;
	}
	
	public int add(int x , int y){
		return x+y;
	}
	public float add(float x , float y){
		return x+y;
	}
}
