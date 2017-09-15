package com.cblue.vo;

import java.util.List;

public class PageBean {

	
	public List list;  //分页的集合
	public int allRecordCount;//总记录数
	public int totalPages;//总页数
	public int currentPage;//当前页
	public static int pageSize = 3;//每页面显示的记录数
	
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRecordCount() {
		return allRecordCount;
	}
	public void setAllRecordCount(int allRecordCount) {
		this.allRecordCount = allRecordCount;
	}
	
	public int getTotalPages() {
		return (allRecordCount%pageSize)==0?(allRecordCount/pageSize):(allRecordCount/pageSize)+1;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
//		if(currentPage==0){
//			currentPage=1;
//		}
		return currentPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	//当前页开始的记录数
	public int getCurrentPageStartPosition(){
		return pageSize*getCurrentPage();
	}
	
	
}
