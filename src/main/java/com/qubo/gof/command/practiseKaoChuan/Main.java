package com.qubo.gof.command.practiseKaoChuan;

/**
 *		角色：
 *    				1 顾客----------负责创建服务员。下达点餐的内容
 *    				2 服务员-------记录顾客点了哪些餐，通知烤肉师傅烤肉
 *    				3 命令----------顾客创建的烤串命令
 *     				4 烤串师傅----开始烤串
 */
public class Main {

	public static void main(String[] args) {
		//顾客 点了 烤肉
		KaoRouCommand krc = new KaoRouCommand();
		//顾客 点了 烤鱼
		KaoYuCommand kyc = new KaoYuCommand();
		
		//找到服务员
		FuWuYuan fwy = new FuWuYuan();
		
		//服务员下单
		fwy.addCommand(kyc);
		fwy.addCommand(krc);
		
		//服务员 通知烤肉师傅 开始烤肉
		fwy.notifyKaoChuangShiFuExec();
		
	}
}
