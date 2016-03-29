package com.qubo.gof.observer;

import com.qubo.config.Config;

/**
 *	观察者模式：
 *		1 主题 必须 extends Observable
 *		2 观察者 必须 implements Observer
 *
 *	一旦主题更改 ，必须 调用 观察 去做相应的更改
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// 创建 博主
		BlogMain bm = new BlogMain();
		// 创建粉丝对象
		ObserverA a = new ObserverA();
		ObserverB b = new ObserverB();
		
		// 给 这个博主注册添加粉丝---也就是添加观察者
			//添加粉丝 A
			bm.addObserver(a);
			//添加粉丝 B
			bm.addObserver(b);
				
		// 调用发布文章
		bm.publishArticle("观察者模式的使用", "应该据有一个主题。当主题发生改变，观察者也应该发生改变");
		
		//打印换行
		Config.printEnter();
		
		//---------------------------------------------------------------------------------------------------------------------
		
		//我将粉丝A 删除掉
		bm.deleteObserver(a);
		
		// 博主再次发布文章
		bm.publishArticle("观察者模式的使用", "应该据有一个主题。当主题发生改变，观察者也应该发生改变");
		
	}
	
}
