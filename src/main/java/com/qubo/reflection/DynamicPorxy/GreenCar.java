package com.qubo.reflection.DynamicPorxy;

public class GreenCar implements Car {

	public String getCarColor() {
		return "Green";
	}

	public void CarGoto() {
		System.out.println("我开着 GreenCar去往 上海");
	}

}
