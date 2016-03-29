package com.qubo.concurrent.ch05;

import java.util.ArrayList;
import java.util.List;

public class PiaoPoolAdmin {

	private static List<Piao> piaos = new ArrayList<Piao>();
	
	// 初始化 票的池子
	static{
		piaos.add(new Piao("T18","2015-11-12","02A"));
		piaos.add(new Piao("J35","2015-10-10","04B"));
		piaos.add(new Piao("G36","2015-6-10","11F"));
		piaos.add(new Piao("F57","2015-3-8","9K"));
		piaos.add(new Piao("K12","2015-9-9","3J"));
		piaos.add(new Piao("L89","2015-7-03","Y7"));
	}
	
	/**
	 * @param p 要购买的票的对象
	 * @return 返回成功购买到的票
	 */
	public  Piao maipiao(Piao p ){
		Piao successPiao = null;
		for (int i = 0; i < piaos.size(); i++) {
				if(p.equals(piaos.get(i))){
					successPiao = p;
					piaos.remove(i);
					break;
				}else{
					System.out.println(p + "--已经售卖,等待退票");
				}
		}
		return successPiao;
	}
	
	/**
	 * @param p 要退哪张票
	 */
	public void tuipiao(Piao p ){
			// 将腿的票 重新加入池子里面
			piaos.add(p);
			// 通知 想要 购买 p这个等待的线程 去 执行购买。这个是通知全部等待购买p这张票的人
			p.notifyAll();
	}
}
