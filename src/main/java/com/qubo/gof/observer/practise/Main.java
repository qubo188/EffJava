package com.qubo.gof.observer.practise;

import com.qubo.config.Config;

/**
 * 场景：
 * 1 用户表 2 评论表
 * 具体场景 ： 用户表里面存有 用户头像地址 。 评论表里面也存有用户地址。
 * 	1 当我用户 更改用户头像之后。我 应该将 评论表里面的头像也更改掉 
 */
public class Main {

	public static void main(String[] args) {
			
			//初始化 阶段
			PersonDB p = new PersonDB();
			CommentDB c = new CommentDB();
			p.initPerson();
			c.initPerson();
					
			//更改数据
			int update = 10;//更改 第10条数据
			
			//创建 被 观察者
			UserAction u = new UserAction();
			// 创建 观察者
			CommentAction comm = new CommentAction();
			
			//添加 观察者
			u.addObserver(comm);
			
			System.out.println("原始user数据 ： " + PersonDB.pdata.get(update));
			System.out.println("原始comment数据 ： " + CommentDB.cdata.get(update));
			//更改数据
			u.updateUserLogo(10);
			Config.printEnter();
			
			System.out.println("更改user数据 ： " + PersonDB.pdata.get(update));
			System.out.println("更改comment数据 ： " + CommentDB.cdata.get(update));
			
			
	}
}
