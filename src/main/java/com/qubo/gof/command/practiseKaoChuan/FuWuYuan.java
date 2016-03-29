package com.qubo.gof.command.practiseKaoChuan;

import java.util.ArrayList;
import java.util.List;

public class FuWuYuan {

	// 1 记录 顾客下达烤串的命令
	private List<Command> commands = new ArrayList<Command>();
	// 2 烤串师傅
	private KaoChuanShiFu kcsf = new KaoChuanShiFu();
	
	// 服务员 添加 记录顾客点餐记录 
	protected void addCommand(Command command){
		commands.add(command);
	}
	
	// 服务员 删除 顾客点击多余的东西
	protected void deleteCommand(Command command){
		commands.remove(command);
	}
	
	protected void notifyKaoChuangShiFuExec(){
		kcsf.exec(commands);
	}
	
}
