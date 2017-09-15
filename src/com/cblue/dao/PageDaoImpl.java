package com.cblue.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PageDaoImpl extends HibernateDaoSupport implements PageDao {

	//hql = select count(*) from Page
	public int getRecodeCount(final String hql) {
		// TODO Auto-generated method stub
		int count = this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Integer>() {

			public Integer doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				return Integer.parseInt(query.list().get(0).toString());
			}
		});
		return count;
	}

	public List queryByPage(final String hql,final int start,final int max) {
		// TODO Auto-generated method stub
		List list = this.getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				query.setFirstResult(start);
				query.setMaxResults(max);
				return query.list();
			}
		});
		return list;
	}

}
