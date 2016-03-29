package com.qubo.gof.observer.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

public class UserAction extends Observable{

	/**
	 * @param updatePersonId  修改哪个人的编号
	 */
	public void updateUserLogo(int updatePersonId){
		
		//要具体修改 哪个人的
		User u = PersonDB.pdata.get(updatePersonId);
		
		u.setuLogo("/logo/updateLogo");
		Map<String , Object> m = new HashMap<String , Object>();
		m.put("updatePersonId", updatePersonId);
		m.put("logo", "/logo/updateLogo");
		//去通知评论表
		this.setChanged();
		this.notifyObservers(m);
	}
	
	
}
