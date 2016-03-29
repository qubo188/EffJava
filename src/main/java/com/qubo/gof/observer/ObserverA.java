package com.qubo.gof.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * 粉丝 A 用户  。它关注了 BlogMain的博客
 * 粉丝 必须 implements Observer 接口
 */
public class ObserverA implements Observer{

	public void update(Observable o , Object arg){
		
		Article a = (Article)arg;
		System.out.println("粉丝A---->接到了博主发布博客的通知");	
		System.out.println("粉丝A---->博主发了一个新帖子 标题为：" + a.getTitle());
		System.out.println("粉丝A---->博主发了一个新帖子 内容为：" + a.getContent());
		
		
	}



	
}
