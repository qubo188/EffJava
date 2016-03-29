package com.qubo.gof.observer.practise;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class CommentAction implements Observer{

	public void update(Observable o , Object arg){
		
		Map<String , Object> m = (Map<String , Object>)arg;
		Integer updatePersonId = (Integer)m.get("updatePersonId");
		String logo = (String)m.get("logo");
		
		Comment c = CommentDB.cdata.get(updatePersonId);
		c.setcLogo(logo);
		
	}
}
