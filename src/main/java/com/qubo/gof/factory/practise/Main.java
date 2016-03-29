package com.qubo.gof.factory.practise;

import java.util.Scanner;

/**
 *	实现目的 ： 使用 抽象 工厂 完成 计算器
 *	分析： 应该将 运算符 封装成为核心工厂。由具体的 运算符工厂来完成具体的计算
 */
public class Main {

	public static void main(String[] args) {
		
			// 获得 输入
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("请输入第一个数:");
			
			String strNum1 = scanner.nextLine();
			
			System.out.println("请输入 运算符 : ");
			
			String oper = scanner.nextLine();
			
			System.out.println("请输入第二个数:");
			
			String strNum2 = scanner.nextLine();
			
			// 开始 使用工厂
			
			if("+".equals(oper)){
				OperationFactory of = new AddOperationFactory();
				of.setNum1(strNum1);
				of.setNum2(strNum2);
				System.out.println(strNum1 + oper + strNum2 + "=" + of.getResult());
			}else{
				OperationFactory of2 = new SubtractionOperationFactory();
				of2.setNum1(strNum1);
				of2.setNum2(strNum2);
				System.out.println(strNum1 + oper + strNum2 + "=" + of2.getResult());
			}
			
			
			
	}
	
}
