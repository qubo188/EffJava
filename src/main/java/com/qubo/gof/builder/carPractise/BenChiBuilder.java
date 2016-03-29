package com.qubo.gof.builder.carPractise;

import java.util.List;

public class BenChiBuilder extends CarBuilder{

	private BenChiCar bcc = new BenChiCar();
	
	@Override
	public void setSequence(List<String> sequence) {
		this.bcc.setSequence(sequence);
	}

	@Override
	public CarMode getCar() {
		return bcc;
	}

}
