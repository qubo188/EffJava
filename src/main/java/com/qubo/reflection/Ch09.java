package com.qubo.reflection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import com.qubo.config.Config;

public class Ch09 {

	/**
	 * 实现 工厂模式 
	 */
	public static void main(String[] args) throws Exception {
			
		Properties p = getPro();
		
		String what = p.getProperty("apple");
		
		Factory f = new Factory();
		Fruit fruit = f.getFruitInstance(what);
		
		if(fruit!=null){
			fruit.eat();
		}
		
	}
	
	public static Properties getPro() throws Exception{
		
		Properties p = null;
		
		File f = new File(Config.FruitpropertiesAddress);
		
		p = new Properties();
		
		if(f.exists()){
			
			p.load(new FileInputStream(f));
			
		}else{
			
			p.setProperty("apple", "com.qubo.reflection.Apple");
			p.setProperty("orange", "com.qubo.reflection.Orange");
			p.store(new FileOutputStream(f), "Fruit class");
			
		}
			return p;
	}

}
