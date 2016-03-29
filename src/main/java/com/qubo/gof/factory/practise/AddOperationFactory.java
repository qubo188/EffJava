package com.qubo.gof.factory.practise;

public class AddOperationFactory extends OperationFactory {

	@Override
	public Double getResult() {
		double result = Integer.parseInt(this.getNum1()) + Integer.parseInt(this.getNum2());
		return result;
	}

}
