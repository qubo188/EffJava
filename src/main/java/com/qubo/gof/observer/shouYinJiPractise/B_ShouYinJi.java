package com.qubo.gof.observer.shouYinJiPractise;

import java.util.Observable;
import java.util.Observer;

public class B_ShouYinJi  extends AbsJieShouZhe{

	/* (non-Javadoc)
	 * @see com.qubo.gof.observer.shouYinJiPractise.IJieShouZhe#update()
	 * 模拟用户 手中的 收音机-----接收 广播电视台 发出新闻
	 */
	public void update(Observable o, Object arg) {
		System.out.println("B收音机接收到广播 ： " + arg );
	}

	public void update() {
		System.out.println("B收音机接收到广播");
	}

}
