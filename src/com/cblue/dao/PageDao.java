package com.cblue.dao;

import java.util.List;

public interface PageDao {
	
	public int getRecodeCount(String hql);
	
	public List queryByPage(String hql,int start,int max);

}
