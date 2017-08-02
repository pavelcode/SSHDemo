package com.cblue.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cblue.entity.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	public boolean isExist(final Customer customer) {
		// TODO Auto-generated method stub
		List<Customer> customers = this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<Customer>>() {

			public List<Customer> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from Customer where username=? and userpass=?");
				query.setString(0, customer.getUsername());
				query.setString(1, customer.getUserpass());
				return query.list();
			}
		});
		return customers.size()>0 ;

	}

	public void save(Customer customer) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(customer);	
	}

}
