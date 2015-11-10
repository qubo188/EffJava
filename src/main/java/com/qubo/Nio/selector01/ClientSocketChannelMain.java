package com.qubo.Nio.selector01;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class ClientSocketChannelMain {

	// 要访问的端口
	public static final int port = 8888;

	// 缓冲区的大小
	public static final int BLOCK = 4096;

	// 接受 数据 的 缓冲区
	public static ByteBuffer receiver = ByteBuffer.allocate(BLOCK);

	// 发送数据的 缓冲区
	public static ByteBuffer send = ByteBuffer.allocate(BLOCK);

	// 请求 学校的地址
	public static InetSocketAddress isa = new InetSocketAddress("localhost",
			port);

	public static void main(String[] args) throws Exception {

		initClient();
		
		listen();

	}

	public static void initClient() throws Exception {
		// 创建 一个学生
		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);

		Selector selector = Selector.open();

		sc.register(selector, SelectionKey.OP_CONNECT);

		// 去 找学校
		sc.connect(isa);
	}

	public static void listen() throws Exception{
			
		while(true){
				
		}
	}
}
