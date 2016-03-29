package com.qubo.gof.observer.practise;

public class Comment {

	//评论人ID
	private String cId;
	//评论人名称
	private String cName;
	//评论人 头像
	private String cLogo;
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcLogo() {
		return cLogo;
	}
	public void setcLogo(String cLogo) {
		this.cLogo = cLogo;
	}
	@Override
	public String toString() {
		return "Comment [cId=" + cId + ", cName=" + cName + ", cLogo=" + cLogo
				+ "]";
	}
	
	
	
}
