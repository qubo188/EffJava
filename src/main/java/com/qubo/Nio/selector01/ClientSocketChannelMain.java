package com.qubo.Nio.selector01;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

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

	// 管理 客户端 收发 消息
	public static Selector selector;
	// 这个客户端 不能创建 其它客户端。它永远是他自己！
	public static SocketChannel client;

	public static void main(String[] args) throws Exception {

		initClient();

		listen();

	}

	public static void initClient() throws Exception {
		// 创建 一个学生
		SocketChannel sc = SocketChannel.open();
		sc.configureBlocking(false);

		selector = Selector.open();

		sc.register(selector, SelectionKey.OP_CONNECT);

		// 去 找学校
		sc.connect(isa);
	}

	public static void listen() throws Exception {

		// 开始 轮询
		System.out.println("客户端1 -- 开始接收/发送 消息");
		while (true) {

			System.out.println("准备完毕");
			int num = selector.select();
			System.out.println("客户端1 --->有 " + num + "要处理");

			Set<SelectionKey> keys = selector.selectedKeys();

			Iterator<SelectionKey> ite = keys.iterator();

			while (ite.hasNext()) {

				SelectionKey key = ite.next();

				handler(key);

				// 移除 已经 操作过的动作
				ite.remove();
			}
		}
		
		
	}

	public static void handler(SelectionKey key) throws Exception {

		// sc.connect(isa);通过这句 连接服务器。
		// key.isConnectable()判断 与 服务器 是否连接成功
		if (key.isConnectable()) {
			System.out.println("-----------与 服务器 连接 完毕 ----------------");
			System.out.println("client: 向老师 提出问题");
			
			writeServerMsg(key);
		}
		else if(key.isReadable()){
			readServerMsg(key);
		}
		else if(key.isWritable()){
			writeServerMsg(key);
		}
	}
	
	/**
	 *向 服务器 写入 回复 数据
	 */
	public static void writeServerMsg(SelectionKey key) throws Exception{
		// 得到 与 服务器 连接的 通信管道
					client = (SocketChannel) key.channel();

					// 判断 客户端 与 服务器端 是否 使用 此管道 在通信
					if (client.isConnectionPending()) {
						client.finishConnect();
						send.clear();
						send.put(new String("老师，我有问题要提问").getBytes());
						send.flip();
						client.write(send);
					}
					// 告诉 服务器。我写完数据了。你去读吧。服务器端Selector就会获取isRead()状态
					client.register(selector, SelectionKey.OP_READ);
	}
	
	/**
	 * 读取 服务器 回复 数据
	 */
	public static void readServerMsg(SelectionKey key) throws Exception {
		
			SocketChannel server = (SocketChannel)key.channel();
			
			receiver.clear();

			int temp = 0;
			while((temp = server.read(receiver))!=-1){
					receiver.flip();
					System.out.println("server :" + new String(receiver.array()));
					receiver.clear();
			}
			server.register(selector, SelectionKey.OP_WRITE);
			
			
	}
}
