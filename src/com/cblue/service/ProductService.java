package com.cblue.service;

import java.util.List;

import com.cblue.entity.Product;

public interface ProductService {

	public void saveProduct(Product product);
	
	public List<Product> showAllProduct();
	
	public Product getAProduct(int id);
	
	public void changeProductInfo(Product product);
	
	public void removeProduct(Product product);
	

}
