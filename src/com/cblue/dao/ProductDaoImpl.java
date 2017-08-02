package com.cblue.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cblue.entity.Product;

public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	public void save(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdate(product);
	}

	public List<Product> getAll() {
		// TODO Auto-generated method stub
		List<Product> products = this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<Product>>() {
			public List<Product> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from Product");
				return query.list();
			}
		});
		return products;
	}
	
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Product.class,id);
	}

	public void update(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(product);
		
	}
	
	public void delete(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(product);
	}
	
}
