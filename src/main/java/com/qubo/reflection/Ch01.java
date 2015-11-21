package com.qubo.reflection;

/**
 * 根据 反射  得到  类本身的  “包名 + 类名”
 *
 */
public class Ch01 {

	public static void main(String[] args) {
		
		X x = new X();
		System.out.println(x.getClass().getName());

	}

}

class X {
	
}
