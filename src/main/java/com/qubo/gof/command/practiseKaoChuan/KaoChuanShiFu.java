package com.qubo.gof.command.practiseKaoChuan;

import java.util.List;

public class KaoChuanShiFu {

	protected void exec(List<Command> commands){
		for(Command command : commands){
			command.exec();
		}
	}
}
