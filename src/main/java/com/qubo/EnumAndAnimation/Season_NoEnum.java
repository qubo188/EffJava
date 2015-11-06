package com.qubo.EnumAndAnimation;
/**
 * 枚举类的 特点 ： 对象是有限制的。并且值是固定的
 * 									1 对象有限制的就代表：只有自己能声明自己。也就是在自己内部类声明
 * 									2 值是固定的就代表：里面的属性值是固定不变的
 * @author Administrator
 *
 */
public class Season_NoEnum{

	// 1 枚举类的 属性值必须是 固定的 
	private final String name;
	private final String desc;
	
	// 2 对象是有限制的。所以必须只能在自己内部调用。所以定义为 private
	private Season_NoEnum(String name , String desc){
			this.name = name ;
			this.desc = desc;
	}
	
	//3 只能内部声明枚举类。并且可以提供外部访问。但是不能修改其属性值
	public  static final Season_NoEnum spring = new Season_NoEnum("春天","万物苏醒的季节");
	public  static final Season_NoEnum summer = new Season_NoEnum("夏天" , "万物长的最好的季节");
	public  static final Season_NoEnum fall = new Season_NoEnum("秋天","万物凋零的季节");
	public  static final Season_NoEnum winter = new Season_NoEnum("冬天","万物沉睡的季节");

	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	
	@Override
	public String toString() {
		return "Season_NoEnum [name=" + name + ", desc=" + desc + "]";
	}
	
	
}
