package com.cblue.dao;

import java.util.List;

import com.cblue.entity.Product;

public interface ProductDao {

	public void save(Product product);
	
	public List<Product> getAll();
	
	public Product getProduct(int id);
	
	public void update(Product product);
	
	public void delete(Product product);

	
	
}
