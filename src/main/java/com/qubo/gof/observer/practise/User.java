package com.qubo.gof.observer.practise;

public class User {

	private String uId;
	private String uName;
	private String uLogo;
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuLogo() {
		return uLogo;
	}
	public void setuLogo(String uLogo) {
		this.uLogo = uLogo;
	}
	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uLogo=" + uLogo
				+ "]";
	}
	
	
	
}
