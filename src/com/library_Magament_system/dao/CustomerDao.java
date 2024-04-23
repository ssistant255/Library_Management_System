package com.library_Magament_system.dao;

import java.util.List;

import com.library_management_system.pojo.Customer;

public interface CustomerDao 
{
		boolean addCustomer(Customer c);
		boolean updateCustomer(Customer c);
		boolean deleteCustomer(int id);
		Customer  displayCustomerById(int id);
		List<Customer>displayAllCustomer();
}
