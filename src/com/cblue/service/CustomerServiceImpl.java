package com.cblue.service;

import com.cblue.dao.CustomerDao;
import com.cblue.entity.Customer;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao customerDao;
	

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void register(Customer customer) {
		// TODO Auto-generated method stub
		customerDao.save(customer);

	}

	public boolean login(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.isExist(customer);
	}

}
