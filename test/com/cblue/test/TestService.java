package com.cblue.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.entity.Customer;
import com.cblue.service.CustomerService;

public class TestService {
	
	@Test
	public void testRegister(){
		
		ApplicationContext  context =  
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerService customerService = (CustomerService)context.getBean("customerService");
		Customer customer = new Customer();
		customer.setUsername("lisi");
		customer.setUserpass("123");
		customerService.register(customer);	
	}

}
