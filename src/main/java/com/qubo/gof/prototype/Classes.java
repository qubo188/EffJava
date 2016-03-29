package com.qubo.gof.prototype;

import java.util.ArrayList;
import java.util.List;

public class Classes implements Cloneable{

	//班级编号 
	private String id;
	private String clsName;
	private List<Person> data = new ArrayList<Person>();
	
	public Classes clone(){
		try {
			
			Classes cls = (Classes)super.clone();
			// 深度克隆 部分 开始
			List<Person> data2 = new ArrayList<Person>();
			for(Person p : data){
				//这个地方 必须在克隆一次！
				Person ppppp = p.clone();
				data2.add(ppppp);
			}
			cls.setData(data2);
			// 深度 克隆 部分 结束
			return cls;
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		
		
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	public List<Person> getData() {
		return data;
	}
	public void setData(List<Person> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", clsName=" + clsName + ", data=" + data
				+ "]";
	}
	
}
