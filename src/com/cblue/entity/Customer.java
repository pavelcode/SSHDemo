package com.cblue.entity;

import java.util.Date;

public class Customer {

	private int cid ;
	private String username;
	private String userpass;
	private Date createdate;
	
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", username=" + username
				+ ", userpass=" + userpass + ", createdate=" + createdate + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	
}
