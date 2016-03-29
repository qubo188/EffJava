package com.qubo.concurrent.ch05;

public class GouPiaoRunnable implements Runnable{

	public Piao p ;
	public PiaoPoolAdmin ppa = new PiaoPoolAdmin();
	public void GouPiaoRunnable(Piao p){
		this.p = p;
	}
	public void run(){
		Piao piao = ppa.maipiao(p);
		while(piao==null){
			
		}
	}
}
