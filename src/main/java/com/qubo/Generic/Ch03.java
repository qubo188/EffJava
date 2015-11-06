package com.qubo.Generic;

public class Ch03 {

	
	public static <T> T autoConvert(Object obj){
		return (T)obj;
	}
	
	public static <T> T[] auto(T[] objs){
		return (T[])objs;
	}
	public static void main(String[] args) {
		Integer[] a = new Integer[4];
		a[0] = 1;
		a[1] = 2;
		a[2] = 3;
		Integer[] b  = auto(a);
	}
	
	
}
