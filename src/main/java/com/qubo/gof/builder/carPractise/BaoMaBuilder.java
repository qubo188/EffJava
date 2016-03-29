package com.qubo.gof.builder.carPractise;

import java.util.List;

public class BaoMaBuilder extends CarBuilder{

	private BaoMaCar bmc = new BaoMaCar();
	
	@Override
	public void setSequence(List<String> sequence) {
		this.bmc.setSequence(sequence);
	}

	@Override
	public CarMode getCar() {
		return bmc;
	}

}
