package com.cblue.service;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.cblue.dao.ProductDao;
import com.cblue.entity.Product;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}


	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);

	}


	public List<Product> showAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}
	
	public Product getAProduct(int id){
		return productDao.getProduct(id);
	}


	public void changeProductInfo(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
		
	}


	public void removeProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}


}
