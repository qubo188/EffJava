package com.qubo.gof.observer.practise;

import java.util.ArrayList;
import java.util.List;

public class PersonDB {

	public static List<User> pdata = new ArrayList<User>(); 

	/**
	 * 模拟数据库 创建 100个人
	 */
	public void initPerson(){
		for (int i = 0; i < 100; i++) {
				User u = new User();
				u.setuId("编号"+i);
				u.setuName("zhangsan-"+i);
				u.setuLogo("/logo/"+i);
				pdata.add(u);
		}
	}
}
