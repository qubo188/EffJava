package com.qubo.reflection.GenericAndFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import com.qubo.config.Config;

/**
 *	用 泛型 实现 工厂模式！
 * 缺点：工厂只能实现 单一 接口。如果接口多！那么工厂类也必须增加！
 * 				所以 使用 动态代理 实现 工程
 * 				@see com.qubo.reflection.ProxyAndFactory.Main
 */
public class Main {

	public static void main(String[] args) throws Exception {
					Factory f = new Factory();
					
					Properties p = getPro();
					Ball b = (Ball)f.instance((String)p.get("basketball"));
					b.play();
		}

	public static Properties getPro() throws Exception {

		File f = new File(Config.BallpropertiesAddress);

		Properties p = new Properties();

		if (f.exists()) {
			p.load(new FileInputStream(f));
		} else {
			p.setProperty("basketball",
					"com.qubo.reflection.GenericAndReflect.BasketBall");
			p.setProperty("football",
					"com.qubo.reflection.GenericAndReflect.FootBall");
			p.store(new FileOutputStream(f), "BallProperties");
		}

		return p;

	}
}
