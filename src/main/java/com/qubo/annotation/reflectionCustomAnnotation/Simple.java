package com.qubo.annotation.reflectionCustomAnnotation;

import com.qubo.annotation.reflectionCustomAnnotation.ReflectionAnnotationInterface;

public class Simple {

	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	@ReflectionAnnotationInterface(key="瞿博",value="跟着 李兴华 学习 Annotation")
	public String toString(){
			return "ReflectionAnnotation---simple";
	}
}
