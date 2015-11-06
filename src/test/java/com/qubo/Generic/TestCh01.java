package com.qubo.Generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCh01 {

	@Test
	public void testunsafeadd(){
			Ch01 c1 = new Ch01();
			List<String> strings = new ArrayList<String>();
			c1.unsafeadd(strings, new Integer(10));
			//It is dangerous to use raw type list.
			// because this can  save List. this will damage structrue of the container 
			// you saving cannot error
			// When you use will be  an error
			
			//System.out.println(strings.get(0));
	}
}
