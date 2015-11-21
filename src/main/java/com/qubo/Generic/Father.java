package com.qubo.Generic;

public abstract class Father<T> {
		T name;
		abstract void method(T name);
}

// 第一种 
// 子类声明时 指定父类 具体类型
class Child01 extends Father<String>{
	@Override
	void method(String name) {
		
	}
}

// 第二种
// 子类 同时也是 泛型类，并且，泛型 必须 与 父类一样

class Child02<T , T2> extends Father<T>{

	@Override
	void method(T name) {
		
	}
}

// 第三者 擦除  父类 泛型
// 父类 被擦除的泛型情况下 ： 默认指定的类型为 ：Object
class Child03 extends Father{

	@Override
	void method(Object name) {
		
	}
	
	
}

