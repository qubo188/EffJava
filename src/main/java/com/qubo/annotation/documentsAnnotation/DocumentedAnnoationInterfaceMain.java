package com.qubo.annotation.documentsAnnotation;

/**
 *		主要 使用 @Documented 可以在生成 javadoc文档的时候。声明这个方法 或者 类 或者 其它 的时候 一些注释信息
 */
@DocumentsAnnotationInterface
public class DocumentedAnnoationInterfaceMain {

	/**
	 *  这是我随意 定义的  方法，我这部分信息，将会在生成javadoc的时候。打印在 这个文档上
	 */
	@DocumentsAnnotationInterface
	public String  bb(){
		return "";
	}
	
}
