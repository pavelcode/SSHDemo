package com.cblue.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	
	@Test
	public void testSpring(){
		ApplicationContext  context =  
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	

}
