package com.qubo.config;

import java.io.File;

public class Config {

	/*
	input Address:G:\WebWork\EffJava\src\main\java\com\qubo\Nio\input.txt
	output Address:G:\WebWork\EffJava\src\main\java\com\qubo\Nio\output.txt
	*/
	public static final String inputAdd = "g:" + File.separator + "WebWork"
			+ File.separator + "EffJava" + File.separator + "src"
			+ File.separator + "main" + File.separator + "java"
			+ File.separator + "com" + File.separator + "qubo" + File.separator
			+ "Nio"+ File.separator + "input.txt";

	public static final String outputAdd = "g:" + File.separator + "WebWork"
			+ File.separator + "EffJava" + File.separator + "src"
			+ File.separator + "main" + File.separator + "java"
			+ File.separator + "com" + File.separator + "qubo" + File.separator
			+ "Nio"+ File.separator + "output.txt";
	
	/*
	 * F:\WebWork\EffJava\src\main\java\com\qubo\reflection
	 */
	public static final String FruitpropertiesAddress = "F:" + File.separator + "WebWork" + File.separator +"EffJava" +
			File.separator +"src"+File.separator +"main"+File.separator +"java"+
			File.separator +"com"+File.separator +"qubo"+File.separator +"reflection"+
			File.separator +"Fruit.properties";
	/*
	 * F:\WebWork\EffJava\src\main\java\com\qubo\reflection
	 */
	public static final String BallpropertiesAddress = "F:" + File.separator + "WebWork" + File.separator +"EffJava" +
			File.separator +"src"+File.separator +"main"+File.separator +"java"+
			File.separator +"com"+File.separator +"qubo"+File.separator +"reflection"+
			File.separator +"Ball.properties";
	/*
	 *F:\WebWork\EffJava\src\main\java\com\qubo\reflection\ProxyAndFactory
	 */
	public static final String ConfigpropertiesAddress = "F:" + File.separator + "WebWork" + File.separator +"EffJava" +
																						File.separator +"src"+File.separator +"main"+File.separator +"java"+
																						File.separator +"com"+File.separator +"qubo"+File.separator +"reflection"+
																						File.separator + "ProxyAndFactory"+ File.separator +"Config.properties";
	
	/**
	 * 打印 回车
	 */
	public static void printEnter(){
			System.out.println();
	}
}
