package com.qubo.reflection.ProxyAndFactory;

public class ProxyFactory {

		public static Object instance(String what)throws Exception{
				return Class.forName(what).newInstance();
		}
}
