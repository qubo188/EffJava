package com.qubo.EnumAndAnimation;

public class Enum01 {

	//java1.5之前定义 常量
	public static final int red = 0;
	public static final int green = 1;
	public static final int blue = 2;
	
	//java 1.5之后 定义常量
	public enum Color{black , white , orange , yellow };
	
	public static void main(String[] args) {
				Color color = Color.white;
				switch(color){
				case black:
					System.out.println("red");
					break;
				case white:
					System.out.println("white");
					break;
				case orange:	
					System.out.println("orange");
					break;
				case yellow:
					System.out.println("yellow");
					break;
				}
	}
}
