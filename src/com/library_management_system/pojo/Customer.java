package com.library_management_system.pojo;

public class Customer
{
	private int id;
	private String  name, emailId, password,address;
	private Long contanct;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getContanct() {
		return contanct;
	}
	public void setContanct(Long contanct) {
		this.contanct = contanct;
	}
}
