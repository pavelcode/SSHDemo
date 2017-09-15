package com.cblue.service;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.cblue.dao.PageDao;
import com.cblue.dao.ProductDao;
import com.cblue.entity.Product;
import com.cblue.vo.PageBean;

public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;
	private PageDao pageDao;
	

	public void setPageDao(PageDao pageDao) {
		this.pageDao = pageDao;
	}


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


	public PageBean getPageBean(int currentPage) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
		int allRecountCount = pageDao.getRecodeCount("select count(*) from Product");
		pageBean.setAllRecordCount(allRecountCount);
		pageBean.setCurrentPage(currentPage);
		System.out.println("pageBean.getCurrentPageStartPosition()="+pageBean.getCurrentPageStartPosition());
		List products = pageDao.queryByPage("from Product", pageBean.getCurrentPageStartPosition(), PageBean.pageSize);
		pageBean.setList(products);
		
		return pageBean;
	}


}
