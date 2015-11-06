package com.qubo.EnumAndAnimation;

public enum Season_Enum implements SeasonInfo{

	// 1 枚举类的 第一步  必须 声明 其 所有具有的对象 , 并以第一个分号作为结尾。
	spring("春天","万物苏醒的季节"){//这种定义 就相当于  public static final Season_Enum spring = new Season_Enum("春天","万物苏醒的季节");
		public String getSeasonInfo(){
			return "春天";
		}
	},
	summer("夏天" , "万物长的最好的季节"){
		public String getSeasonInfo(){
			return "春天";
		}
	},// 相当于 调用的是 15行的 构造方法
	fall("秋天","万物凋零的季节"){
		public String getSeasonInfo(){
			return "春天";
		}	
	},
	winter("冬天","万物沉睡的季节"){
		public String getSeasonInfo(){
			return "春天";
		}
	};
	
	// 2 枚举类型 的 属性值 必须是 固定的 。不可变的。 所以声明为 final
	private final String name;
	private final String desc;
	
	// 3 因为枚举类型 。是有限的对象。所以只能自己构造自己。不能被外部类构造。所以构造函数定义为private
	private Season_Enum(String name , String desc){
		this.name = name;
		this.desc = desc;
	}


	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

/*	public String getSeasonInfo() {
		// TODO Auto-generated method stub
		return null;
	}
*/	
	
	
}
