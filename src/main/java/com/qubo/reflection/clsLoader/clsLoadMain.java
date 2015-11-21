package com.qubo.reflection.clsLoader;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 *		类的 加载器 有三层 结构： 
 *														系统类加载器<System ClassLoader>      ： 第一级：appClassLoader
 *														扩展类加载器<Extension ClassLoader> ： 第二级：ExtClassLoader
 *														引导类加载器<Bootstap ClasssLoader> :     第三级：这个是 C语言默认的。我们是看不到的
 *
 *		2疑问？类加载器有什么用？
 *		  答：它可以知道 当前的这个类 是由哪个类 加载的
 *
 *		3类加载器 到底是加载哪个地方 的 类呢？？
 *			3.1 首先我们这个工程是用 maven功能构建的，我们都知道，maven默认把编译好的文件是放在target文件夹下面。
 *			3.2 所有classLoader实际上 是 获取 编译好的.class的存放路径里面的所有文件，也就是target里面的文件
 */
public class clsLoadMain {

	public static void main(String[] args) throws ClassNotFoundException {
		
		ClassLoader classLoader;
		
		// 1 打印 系统 类加载器
		classLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统的类加载器 是  : " + classLoader);
		
		// 2 那么 系统类 加载器的 父级加载器是谁呢？是扩展类加载器  ExtClassLoader
		classLoader = classLoader.getParent();
		System.out.println("系统的累加器的 父级 是  : " + classLoader);
		
		// 3 那么 扩展类的加载器  的 父级  是谁呢？？ 是 引导类加载器。这个是我们获取不到的，null。因为是用c语言写的
		classLoader = classLoader.getParent();
		System.out.println("扩展类的 加载器的 父级是 ：" + classLoader);
		
		// 测试 ，你说 当前 这个 clsLoadMain.java是由哪个类加载器 加载的呢？？？
		// 答是由系统加载器  加载的 也就是：AppClassLoader;
		classLoader  = clsLoadMain.class.getClassLoader();
		System.out.println("clsLoadMain.java这个类 是由哪个加载器 加载的呢？？  是 ： " + classLoader);
				
		// 测试 ，那么 java.lang.Object是由谁呢？
		// 是由 引导类 加载器 加载的，所以我们得不到。
		classLoader = Class.forName("java.lang.Object").getClassLoader();
		System.out.println("java.lang.Object是由谁加载的？？ 是 ： " + classLoader);
		
		// 测试 classLoader到底是加载 哪个地方的 类，提示：这个工程是由maven构建的。
		///F:/WebWork/EffJava/target/classes/com/qubo/reflection/Ball.properties
		URL url = clsLoadMain.class.getClassLoader().getResource("com/qubo/reflection/Ball.properties");
		System.out.println(url.getPath());
		
		// 之前我们要获取一个文件地址的时候，
		File file = new File("pom.xml");
		System.out.println(file.getName());
		File file2 = new File("Ball.properties");
		System.out.println(file2.getName());
		
		// 而我们现在 获取是：
		InputStream in = clsLoadMain.class.getClassLoader().getResourceAsStream("com/qubo/reflection/Ball.properties");
		System.out.println(in);
		
	}

}
