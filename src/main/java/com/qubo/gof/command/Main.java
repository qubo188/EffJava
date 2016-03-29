package com.qubo.gof.command;

/**
 *	命令模式----生活中的例子
 *	情景1 ： 路边摊烧烤 , 人物 (1 吃烧烤的人 。 2 烧烤师傅)
 *				    吃烧烤的人 来  路边吃烤串。
 *					A 像烤串师傅 点了10个羊肉串   5个 牛肉串  2瓶瓶酒    ---没给钱
 *					B 像烤串师傅 点了3个羊肉串   2个 牛肉串  0瓶瓶酒    ---给钱了
 *					C 像烤串师傅 点了20个羊肉串   10个 牛肉串  10瓶瓶酒    ---没给钱
 *					.....随着 顾客的不断增加,烤串师傅已经忘记 哪些顾客是给钱了。哪些是没给钱的。那些人烤了什么。谁先点的
 *					谁后点的.....
 *					如果此时顾客点的东西 点多了。不想要了。或者 点了哪些东西没有！那么烤串师傅就会忙蒙
 *
 * 情景2 : 烤肉店  人物( 1 吃烧烤的顾客     2 服务员   3 烧烤师傅)
 * 				 顾客 ：吃烧烤的人 进入店内开始 点 烧烤
 * 				 服务员 ：这时服务员来进行接待，它会做以下几件事情
 * 									1 记录 哪些顾客点了哪些东西。
 * 									2 查看 顾客点的东西是否存在，如果不存在，就告诉顾客此种产品没有
 * 									3 如果顾客点多了，可以减少多点的烤串，如果点少了就增加顾客的烤串
 * 									4 通知 厨房烤串师傅开始做
 * 				烤串师傅： 就1件事情，根据服务员下的订单，来烤不同种类的串
 */
public class Main {

}
