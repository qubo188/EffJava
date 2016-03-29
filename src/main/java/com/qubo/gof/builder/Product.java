package com.qubo.gof.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Description : 真正的 产品
 *
 */
public class Product {

	List<String> list = new ArrayList<String>();

	/**
	 * @param content 添加 产品的内容
	 * 
	 * Description : 添加 产品
	 */
	public void add(String content) {
		list.add(content);
	}

	/** 
	 *  打印产品
	 */
	public void show() {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
