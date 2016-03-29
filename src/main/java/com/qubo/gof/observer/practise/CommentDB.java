package com.qubo.gof.observer.practise;

import java.util.ArrayList;
import java.util.List;

public class CommentDB {

	public static List<Comment> cdata = new ArrayList<Comment>(); 

	/**
	 * 模拟数据库 创建 100个人
	 */
	public void initPerson(){
		for (int i = 0; i < 100; i++) {
			Comment c = new Comment();
				c.setcId("编号"+i);
				c.setcName("zhangsan-"+i);
				c.setcLogo("/logo/"+i);
				cdata.add(c);
		}
	}
}
