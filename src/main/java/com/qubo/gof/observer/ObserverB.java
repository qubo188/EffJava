package com.qubo.gof.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverB implements Observer{

	public void update(Observable o , Object arg){
		Article a = (Article)arg;
		System.out.println("粉丝B---->接到了博主发布博客的通知");	
		System.out.println("粉丝B---->博主发了一个新帖子 标题为：" + a.getTitle());
		System.out.println("粉丝B---->博主发了一个新帖子 内容为：" + a.getContent());
	}
}
