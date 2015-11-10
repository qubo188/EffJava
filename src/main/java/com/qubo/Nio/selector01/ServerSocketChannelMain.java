package com.qubo.Nio.selector01;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 *		重要概念 理解 ： 1  ServerSocketChannel  :  学校一切的根源。相当于 服务器端
 *										 2 ServerSocket : 老师。只有 有老师 才能 带新生入校，和 回答 学生问题
 *										 3 Selector : 教导处。 用于管理 老师  和 学生。主要两个功能：1 为 老师和学生分配编号
 *																																							2 为老师  和 学生分配权限
 *										 4 SelectionKey :  老师  或者 学生的 编号
 */
public class ServerSocketChannelMain {
	
	// 所有的 一切 事情 ，交由 教导处 代理 分配 执行
	public static Selector selector;

	public static void main(String[] args)  throws Exception{

		// 初始化 学校 信息
		initSer();
		// 让 教导处 监督 有 谁来问什么样的问题。应该如何解答。
		// 重点：在学校没有放假的情况下，要一直可以监听 老师的 事情 及 学生的提出的问题。要给予做出应答
		listen();
		
	}
	
	/**
	 *  初始化  学校的 基本信息
	 */
	public static void initSer() throws Exception{
			
				// 1 创建 学校 
				ServerSocketChannel ssc = ServerSocketChannel.open();
				ssc.configureBlocking(false);
				
				// 2 创建 老师   并 分配 班级号为 ：8888
				ssc.socket().bind(new InetSocketAddress(8888));
				
				// 3 创建教导处 
				selector = Selector.open();
				
				// 4 将 学校 与 教导处 绑定 。 
				//     并 分配 教导处 一个  接受 新生 或者 接受 老生提问题的窗口。也就是说教导处上班了，可以接受问题了
				// 重点：OP_ACCEPT不会出现在 .select()里面
				// OP_READ  OP_WRITE OP_CONNECT 是可以 触发 .select()；也就是说，只有这三种才能把事件添加到.select()里面
				ssc.register(selector, SelectionKey.OP_ACCEPT);
				
				System.out.println("服务器 端口 为 ： 8888-------->已经开启");
	}
	
	/**
	 * 监听 --->谁去了 教导处---->要做什么事情。
	 * 一般事情 分为： 1 老师(ServerSocketChannel)领 新生入校。 由 教导处(Selecotr)给新生分配编号(SelectionKey)，
	 * 										并为这个学生分配他能做的权限是什么(OP_READ | OP_WRITE .....)
	 */
	public static void listen() throws Exception{
		
		// 轮询 
		 while(true){
			 	System.out.println("教导处 开始 上班 ");
			 	// 看看 教导处 里面 是否 有什么 事情 要处理
			   // 在没有事情 处理的时候。这个地方 就阻塞住了。
			 	int num = selector.select();
			 	// 如果有事情。才会 往下执行
			 	
			 	System.out.println("当前 教导处 有 "+num+"件事情 要处理。");
			 	if(num<1)continue;// 说明 教导处 里面 没有 事情 要 处理
			 	// 否则 ，  说明 有人 来 教导处 要 办理事件
			 	
			 	// 办理的事情 种类 有很多。这个时候。教导处 就得判断，到底 来的这个人 要做 什么事情
			 	// 先看看到底 要有多少事情要处理
			 	Set<SelectionKey> keys = selector.selectedKeys();
			 	
			 	Iterator<SelectionKey> ite = keys.iterator();
			 	
			 	while(ite.hasNext()){
			 		
			 				SelectionKey sk = ite.next();
			 				// 去处理 当前这个 编号的 要 做 什么样的 操作
			 				
			 				handler(sk);
			 				
			 				// 已经 处理过的，就把他清除掉。要不就会反复执行。
			 				ite.remove();
			 				
			 	}
			 	
		 }
	}
	
	public static void handler(SelectionKey key){
		
		if(key.isAcceptable()){
				// Accept是接受的 意思。这种情况，说明 是 老师 带领 新生 入学。
				System.out.println("新生 加入");
				newClientAdd(key);
		}
		else if(key.isReadable()){
				// 说明 学生 像老师 提出 问题了。
			System.out.println("新生 提出问题");
		}
		else if(key.isWritable()){
			   //  老师 解答 问题
			System.out.println("老师 解答问题 ");
		}
			
	}
	
	public static void newClientAdd(SelectionKey key) throws Exception{
		
			// 先找到  学校 和老师 
			ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
			
			ssc.socket();
	}
	
}
