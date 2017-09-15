package com.cblue.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.entity.Customer;
import com.cblue.entity.Product;
import com.cblue.service.CustomerService;
import com.cblue.service.ProductService;

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
	
	@Test
	public void testPage(){
		ApplicationContext  context =  
				new ClassPathXmlApplicationContext("applicationContext.xml");
		 ProductService productService = (ProductService)context.getBean("productService");
		 List<Product> list =productService.getPageBean(1).getList();
		 for(Product product:list){
			 System.out.println(product);
		 }
	}

}
