package com.qubo.EnumAndAnimation;

import java.util.Iterator;

public  class Main {

	public static void main(String[] args) {
		
		// 测试 Season_NoEnum
		// 因为枚举类 是私有的。是不能再类外部调用的。所以这个地方 报错
		//Season_NoEnum s = new Season_NoEnum("",""); 
		
		//System.out.println(Season_NoEnum.spring);
		
		//System.out.println(Season_Enum.spring.getName());
		
		/*for(Season_Enum se : Season_Enum.values()){
				System.out.println(se);
		}*/
		
		//System.out.println(Season_Enum.spring.getSeasonInfo());
		
		// 根据枚举对象的 获得 值。
		//Season_Enum se = Season_Enum.valueOf(Season_Enum.class, "fall");
		//System.out.println(se.getName());
	}
}
