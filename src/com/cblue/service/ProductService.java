package com.cblue.service;

import java.util.List;

import com.cblue.entity.Product;
import com.cblue.vo.PageBean;

public interface ProductService {

	public void saveProduct(Product product);
	
	public List<Product> showAllProduct();
	
	public Product getAProduct(int id);
	
	public void changeProductInfo(Product product);
	
	public void removeProduct(Product product);
	
	public PageBean getPageBean(int currentPage); //分页
	

}
