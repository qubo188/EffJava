package com.qubo.gof.observer.shouYinJiPractise;

/**
 *	模拟环境-----> 广播
 *  角色---------> 1 被观察者---->收音机电视台
 *                            2 观察者------>接收者
 */
public class Main {

	public static void main(String[] args) {
			
		 // 定义 被观察者-----收音机 广播电视台
		AbsDianShiTai idst = new NewsDianShiTai("雾霾蓝色警告");
			
		 // 模拟真实用户手中的收音机
		 AbsJieShouZhe ijsz_A = new A_ShouYinJi();
		 AbsJieShouZhe ijsz_B = new B_ShouYinJi();
		 
		 idst.addObserver(ijsz_A);
		 idst.addObserver(ijsz_B);
		 
		 idst.publishGuangBo();
	}
}
