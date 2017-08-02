package com.cblue.service;

import com.cblue.entity.Customer;

public interface CustomerService {

	public void register(Customer customer);
	
	public boolean login(Customer customer);
}
