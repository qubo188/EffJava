package com.qubo.gof.builder.housePractise;

/**
 *	指挥者。其实我们可以理解为：购买房子的房主，他现在要装修了！他会选择哪家具体的 装修公司。来装自己的房子
 *	重点：我们永远不可能用PersonDirector来返回 具体装修好的房子！！因为我们也不知道。装修公司具体什么时间能装修好！
 *				 所以返回真正的房子！应该由装修公司来返回。
 */
public class PersonDirector {

	/**
	 * @param hb  真实的装修公司
	 */
	public void Building(HouseBuilder hb){
		// 选择好的 真实的装修公司 去 装修地板
		hb.makeFloor();
		// 选择好的 真是装修公司 去 装修 墙
		hb.makeWall();
	}
}
