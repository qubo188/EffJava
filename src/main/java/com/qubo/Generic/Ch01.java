package com.qubo.Generic;

import java.util.List;
import java.util.Vector;

/**
 * @author Administrator
 * 	
 * 		1  请不要再 新代码中使用原生态 类型
 * 
 * 		2  泛型 分为 以下几种：
 * 												1 原生态的类型------>List ---->这种是不安全的。-->因为里面可以存入一个list。这样就破坏了规则
 * 											    2 通配符的类型----->List<?>-->是安全的--->它代表是某种未知类型的一个集合
 * 											    3 参数化类型------>List<Object>-->是安全的。--->代表是一组任何对象类型的一个集合
 * 
 * 		3 重点：原生态类型 是为了 兼容java1.5以前的老程序。但是从java1.5之后。就强力不建议这么写了。
 * 
 * 
 * 		4 当警告 出现时：我们一定不能使用。@Supperss Warnings。它代表的是。（忽略/禁止）当前所有的警告。
 * 								     即使我们的程序发现大错误的时候。那么它也不会警告了。因为你给（忽略/禁止）掉了这个警告。
 * 									 我们应该排除掉这个警告。
 * 									----------------------------------------警告就意味着一个程序有可能存在错误的风险--------------------
 * 
 * 
 * 
 *
 */
public class Ch01 {

	public  void unsafeadd(List l ,Object o){
		l.add(o);
		
		Vector<Integer> vectorList = (Vector<Integer>) new Vector<Integer>();
	}
}
