package com.qubo.concurrent.ch05;

/**
 * 切记。java是面向对象的编程。所以一定要划分好对象之后。在做其它业务逻辑
 * Piao这个类。描述了一张票的 基本信息 1 车次  2  发车日期  3 座位号
 *
 */
public class Piao {

	private String checi;//车次
	private String date;//发车日期
	private String zuowei;//座位号
	
	
	public Piao(String checi, String date, String zuowei) {
		super();
		this.checi = checi;
		this.date = date;
		this.zuowei = zuowei;
	}
	public String getCheci() {
		return checi;
	}
	public void setCheci(String checi) {
		this.checi = checi;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getZuowei() {
		return zuowei;
	}
	public void setZuowei(String zuowei) {
		this.zuowei = zuowei;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checi == null) ? 0 : checi.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((zuowei == null) ? 0 : zuowei.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piao other = (Piao) obj;
		if (checi == null) {
			if (other.checi != null)
				return false;
		} else if (!checi.equals(other.checi))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (zuowei == null) {
			if (other.zuowei != null)
				return false;
		} else if (!zuowei.equals(other.zuowei))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Piao [checi=" + checi + ", date=" + date + ", zuowei=" + zuowei
				+ "]";
	}
	
	
}
