package com.qubo.Nio.selector;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServerSocketChannelMain {

	public static Selector selector;
	
	/**
	 * Nio 的 Socket操作 举例： 
	 * 			学校 ： ServerSocketChannel 
	 * 			老师 ： ServerSocket
	 * 		         教导处：Selector 
	 *  老师编号/学生编号：SelectionKey
	 *  
	 *  老师是：服务器端。用于解答并反馈
	 *  学生是：客户端。用于提出问题。回答问题
	 */
	public static void main(String[] args) throws Exception {

		initSer();
		
		listen();

	}

	/**
	 * 初始化 操作：  1  学校
	 * 			2  老师与班级
	 * 			3  教导处
	 */
	public static void initSer() throws Exception {
		// 1 必须 先有学校。如果没有学校。就其它什么也没有。
		ServerSocketChannel ssc = ServerSocketChannel.open();

		// 2 创建一个老师 并 指定它管理哪个班级
		ServerSocket ss = ssc.socket();// 老师创建完毕
		ss.bind(new InetSocketAddress(8888));// 管理 班级 8888

		// 3 创建 一个教导处 管理 老师 和 学生
		selector = Selector.open();

		// 4 第一 将 教导处 绑定到 学校里面
		// 第二 由学校 给老师 分配一个唯一编号。 SlectionKey 代表 编号。
		// 第三 OP_ACCEPT 代表 这个老师只可以有 领 新生入学。因为他只有Accept属性
		SelectionKey teacherKey = ssc
				.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	public static void listen() throws Exception{
		
		// 轮询。
		// 这代表 如果你学校没有放假，那么你就必须随时 并且 一直  准备 解答 学生的问题
		while(true){
			
			// 查看教导处中是否 有要 操作的事情。
			int num = selector.select();
			// 小于1 代表，教导处没有 事情要处理
			if(num < 1)continue;
			// 大于1 代表 ， 有老师 或者是 学生 找到教导处 要处理问题
			// 注意 ：来解决问题的 有些时候，并不是一个人。而是多个人！
			// 所以这个地方 是一个 集合。代表我可能要处理多个人的 事情
			Set<SelectionKey> keys = selector.selectedKeys();
			// 循环处理 每个 人要做的事情
			Iterator<SelectionKey> ite = keys.iterator();
			while(ite.hasNext()){
				SelectionKey key = ite.next();
				// 已经处理过的请求。就应该从教导处 移除。要不就会反复 处理同一个问题
				ite.remove();
				
				if((key.readyOps()&SelectionKey.OP_ACCEPT)==SelectionKey.OP_ACCEPT){
					// 这个 时候 说明 当前 是 老师   领 新生 入学
					
					// 先通过 新生 找到  对应的 老师 和 学校
					ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
					
					//accept代表 ：接受的意思。
					// 说明我这个老师 接受了这个学生
					SocketChannel sc = ssc.accept();
					
					
				}
				else if((key.readyOps()&SelectionKey.OP_READ)==SelectionKey.OP_READ){
					// 说明 此时 是  老 学生 提问了。
				}
					
				
			}
			
			
			
		}
	}
}
