package com.cblue.action;

import java.util.Date;

import com.cblue.entity.Customer;
import com.cblue.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	
	private CustomerService customerService;
	private Customer customer = new Customer();
	
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String register(){
		System.out.println("CustomerAction--register");
	//	customer.setCid(0);
		customer.setCreatedate(new Date());
		customerService.register(customer);
		return SUCCESS;
	}
	
	public String login(){
		System.out.println("CustomerAction--login");
		boolean isLogin = customerService.login(customer);
		System.out.println("isLogin="+isLogin);
		if(isLogin){
			return "shopcar";
		}
		return INPUT;
	}

	

}
