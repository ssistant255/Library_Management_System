package com.library_management_system.pojo;

public class Libraries 
{
	private int id;
	private String name, address, city,state;
	private Long  contanct;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getContanct() {
		return contanct;
	}
	public void setContanct(Long contanct) {
		this.contanct = contanct;
	}
}