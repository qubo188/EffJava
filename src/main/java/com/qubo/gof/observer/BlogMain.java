package com.qubo.gof.observer;

import java.util.Observable;

/**
 *	这相当于 一个博主  他可以被其它粉丝 所关注。
 */
public class BlogMain extends Observable{

	/**
	 * @param title  发布文章的标题
	 * @param content 发布文章的内容
	 */
	public void publishArticle(String title , String content ){
		
		// 这个时候 说明 博主 发布了一个新的博客。
		Article a = new Article();
		a.setTitle(title);
		a.setContent(content);
		
		// 要去通知他所有的粉丝。
		this.setChanged();
		// 这个地方 有两种。1 不带参数。只是通知 粉丝
		// 带参数。可以传递。我更改的内容
		this.notifyObservers(a);
		
	}
}
