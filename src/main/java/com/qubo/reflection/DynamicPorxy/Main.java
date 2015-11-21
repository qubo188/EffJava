package com.qubo.reflection.DynamicPorxy;

public class Main {

	/**
	 * 我们来分析一下这个程序。
	 * 		have Two Interface ： 1 Car   2 Shcool
	 * 
	 * 		Car have Two Method : 1  getCarColor(); 获取 汽车的颜色
	 * 												 2 CarGoto(); 汽车要开去哪里
	 * 	
	 * 		Shcool have Two Method :	 1 getStudent(); 获得 是哪位学生
	 * 														 2 StudentCourse(); 学生 学习的哪门课程
	 * 		
	 * 		Car Realize : 1 GreenCar   2 BlueCar
	 * 		ShcoolRealize : 1 StudentOne     2 StudentTwo
	 * 
	 * 		现在我们要做的是：1 传递不同的对象，就可以调取里面的方法
	 * 
	 * 			
	 */
	public static void main(String[] args) throws Exception{

			//传统做法
		   // 每次我们获取哪个对象的时候，都必须 创建一次这个对象
			StudentOne so = new StudentOne();
			System.out.println(so.getStudent());
			GreenCar gCar = new GreenCar();
			gCar.CarGoto();
			
			//------------------------------------Over------------------------------------------------
		
			// 现在我希望有一个方法，我传递哪个对象，就可以调取这个对象里面的方法
			// 其实跟上面 差不多！只不过用了泛型而已
			Shcool s = getObj(new StudengTwo());
			System.out.println(s.getStudent());
			
			MyInvoktionHandler mih = new MyInvoktionHandler();
			mih.bind(new StudengTwo());
			
	}
	
	public static <T> T getObj(T t ) throws InstantiationException, IllegalAccessException{
			Class c = t.getClass();
			return (T)c.newInstance();
	}

}
