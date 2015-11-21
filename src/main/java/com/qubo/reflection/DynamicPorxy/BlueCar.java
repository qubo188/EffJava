package com.qubo.reflection.DynamicPorxy;

public class BlueCar implements Car {

	public String getCarColor() {
		return "Blue";
	}

	public void CarGoto() {
		System.out.println("我开着BlueCar 去往北京");
	}

}
