package com.qubo.reflection.ProxyAndFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.qubo.config.Config;

public class Main {

	/**
	 * 用 动态 代理 的 方式  实现 Factory
	 */
	public static void main(String[] args) throws Exception{
			
			Properties p = getPro12();
			
			System.out.println((String)p.get("basketball"));
			Object o =ProxyFactory.instance((String)p.get("basketball"));	
			
			MyInvocationHandler invocationHandler = new MyInvocationHandler();
			ProxyAndFactory_Ball f = (ProxyAndFactory_Ball)invocationHandler.bind(o);
			f.play();
			
	}
	
	public static Properties getPro12() throws Exception{
		
			File f = new File(Config.ConfigpropertiesAddress);
			
			Properties p = new Properties();
			
			if(f.exists()){
					p.load(new FileInputStream(f));
			}else{
				p.setProperty("apple", "com.qubo.reflection.ProxyAndFactory.ProxyAndFactory_Apple");
				p.setProperty("orange", "com.qubo.reflection.ProxyAndFactory.ProxyAndFactory_Orange");
				p.setProperty("basketball",
						"com.qubo.reflection.ProxyAndFactory.ProxyAndFactory_BasketBall");
				p.setProperty("football",
						"com.qubo.reflection.ProxyAndFactory.ProxyAndFactory_FootBall");
				p.store(new FileOutputStream(f), "Config.properties");
			}
			return p;
	}
}
