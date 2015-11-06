package com.qubo.Nio;

import java.nio.CharBuffer;

public class BufferMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
			CharBuffer cb = CharBuffer.allocate(8);
			
			System.out.println("capacity : " + cb.capacity());
			System.out.println("limit : " + cb.limit());
			System.out.println("Position : " + cb.position());
			System.out.println("Mark : " + cb.mark());
			
			cb.put("a");
			cb.put("b");
			cb.put("c");
			cb.put("d");
			
			System.out.println("----------------------装入数据--------------");
			
			System.out.println("Position : " + cb.position());
			System.out.println("Limit : " + cb.limit());
			System.out.println("mark : " + cb.mark());
			
			cb.flip();
			
			System.out.println("----------------------装入数据执行 flip()--------------");
			System.out.println("Position  : " + cb.position());
			System.out.println("Limit : " + cb.limit());
			
			System.out.println("----------------------装入数据执行 flip() -》取出一个数据--------------");
			System.out.println("取出一个元素[position=0] : " + cb.get());
			System.out.println("Position : " + cb.position());
			System.out.println("Limit : " + cb.limit());
			
			cb.flip();
			
			System.out.println("----------------------装入数据执行 flip() -》取出一个数据-->flip--------------");
			System.out.println("Position : " + cb.position());
			System.out.println("Limit : " + cb.limit());
			
			cb.clear();
			
			System.out.println("----------------------装入数据执行 flip() -》取出一个数据-->flip--->clear--------------");
			System.out.println("Position : " + cb.position());
			System.out.println("Limit : " + cb.limit());
			
			System.out.println("----------------------取得下标为2的数据--------------");
			System.out.println("取 [position=2]的数据 ： " + cb.get(2));
			System.out.println("position : " + cb.position());
			
			
	}

}
