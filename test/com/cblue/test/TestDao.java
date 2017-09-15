package com.cblue.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cblue.dao.CustomerDao;
import com.cblue.dao.ProductDao;
import com.cblue.entity.Customer;
import com.cblue.entity.Product;

public class TestDao {

	@Test
	public void testSave(){
		ApplicationContext  context =  
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao)context.getBean("customerDao");
		for(int i=0;i<10;i++){
			Customer customer = new Customer();
			customer.setUsername("zhangsan"+i);
			customer.setUserpass("123");
			customer.setCreatedate(new Date());
			customerDao.save(customer);	
		}
		
	}
	
	@Test
	public void testIsExist(){
		ApplicationContext  context =  
				new ClassPathXmlApplicationContext("applicationContext.xml");
		CustomerDao customerDao = (CustomerDao)context.getBean("customerDao");
		Customer customer = new Customer();
		customer.setUsername("zhangsan");
		customer.setUserpass("123");
		System.out.println(customerDao.isExist(customer));
		
	}
	@Test
	public void saveProduct(){
		ApplicationContext  context =  
				new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao productDao = (ProductDao)context.getBean("productDao");
		for(int i=0;i<10;i++){
		    Product product = new Product();
			product.setPname("new"+i);
			product.setPrice(99);
			productDao.save(product);
		}
	}
	
	@Test
	public void updateProduct(){
		ApplicationContext  context =  
				new ClassPathXmlApplicationContext("applicationContext.xml");
		ProductDao productDao = (ProductDao)context.getBean("productDao");
		Product product = new Product();
		product.setPid(1);
		product.setPname("new");
		product.setPrice(99);
		productDao.update(product);
		
	}
}
