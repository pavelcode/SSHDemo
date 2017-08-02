package com.cblue.dao;

import com.cblue.entity.Customer;

public interface CustomerDao {
	
	public boolean isExist(Customer customer);
	
	public void save(Customer customer);

}
