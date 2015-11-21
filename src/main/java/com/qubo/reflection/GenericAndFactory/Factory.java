package com.qubo.reflection.GenericAndFactory;

public class Factory {
		
		public Object instance(String what) throws Exception{
						//T t = (T)Class.forName(what).newInstance();
						return Class.forName(what).newInstance();
		}
}
