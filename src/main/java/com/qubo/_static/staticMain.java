package com.qubo._static;

/**
 * static 的作用与理解
 * 
 * static可以声明 属性， 可以声明方法。
 * 
 * 重点： static声明的 属性，无论这个对象创建多少个，那么在内存中 static 只创建了一个
 * 
 * test: Person里面有name age personSum name :每个人 肯定有自己的名字，所以是不一样的 age :
 * 每个人都有自己的年龄。所以肯定也是不一样的 personSum:而我要求的 personSum的总和，是无论你创建了多少个Person对象，
 * 取这个personSum的值，都必须是唯一的一个。
 * 
 * static的 属性 用法 ：
 * 举例：卖火车票。
 * 				如果我们的火车票 总数就只有 100张。
 * 				这个时候。无论有多少人。来买，都必须从 这100张 中 ，往下减。
 * 				所以这100张火车票 必须是静态的，无论谁来访问，都访问这唯一的一个。
 * 
 * static的 方法用法：
 * 	举例：假如说，我有10个糖果。
 * 				来一个孩子，我就分给一个。也就是说，我们这里面的操作是不变的，即使是国家领导人来，我也只是减去1个糖果
 * 				也就是说：static声明的方法内部做的事情，是谁来都必须用同一种方式做。
 * 
 * 总结： 被声明为 static 的对象。不属于一个类的本身。 而是 属于公共的。是全局的。
 * 
 * 	静态静态 代码块：
 * 									静态块 与对象无关。只与当前类有关系。
 * 									也就是说：无论你创建几百个对象。静态代码块只会创建 1 次。
 * 									只有在虚拟机加载当前类的时候，静态代码块 被执行 这 1次。以后再也不会执行
 * 	 static{
 * 			只有 虚拟机 加载当前类的时候。才会创建  有且只有一次。
 * 			与 多少个对象无关系
 * }
 */
public class staticMain {
	
	
	public void f1(){
		 g1();// 因为 f1 是当前对象的。所以 这个地方相当于 this.g1();
		 f2();// 因为f2是公共方法。属于全局的，所以我这肯定能访问
	}
	public static void f2(){
		// 因为f2 是属于全局的。不属于staticMain这个类的本身的。编译器实际上是这么理解的this.f1();但是 this是谁呢？它不知道
		// 因为f2 是谁都可以调用的。所以它根本没有办法确定 this.f1()中的this到底属于谁。
		//f1();//打开就报错
	}
	public void g1(){
		
	}
	public static void g2(){
		
	}

	public static void main(String[] args) {

		/*
		 * 测试1 
		 * // 1 先将 personSum的值 设置成不是 static 的。测试 Person p1 = new
		 * Person("张1",11); Person p2 = new Person("张2",12); Person p3 = new
		 * Person("张3",13);
		 * 
		 * System.out.println(p1.getPersionSum());// 1
		 * System.out.println(p2.getPersionSum());// 1
		 * System.out.println(p3.getPersionSum());// 1
		 */
		
		/*
		 * 测试 2
		 *  //2 将personSum属性 设置成 static的 。 测试 Person p1 = new
		 * Person("张1",11); Person p2 = new Person("张2",12); Person p3 = new
		 * Person("张3",13);
		 * 
		 * System.out.println(p1.getPersionSum());// 3
		 * System.out.println(p2.getPersionSum());// 3
		 * System.out.println(p3.getPersionSum());// 3 // 测试
		 * 结果发现，无论我创建了多少个Person对象。personSum的取值都是 一个
		 */
	}
}
