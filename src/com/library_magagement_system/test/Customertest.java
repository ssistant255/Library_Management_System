package com.library_magagement_system.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library_Magament_system.dao.CustomerDaoImpl;
import com.library_management_system.pojo.Customer;

public class Customertest 
{
	public static void main(String args[])
	{
		 int id,choice;
		 String  name, emailId, password,address;
	     Long contanct;
	     Customer c=new Customer();
	     CustomerDaoImpl cd=new CustomerDaoImpl();
			do
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("1.Add Customer\n2.Update Customer\n3.Delete Customer\n4.DisplayCustomerById\n5.DisplayAllCustomer\n6.Exit");
				System.out.println("Enter your choice[1-6]");
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter the name");
					name=sc.next();
					System.out.println("Enter the emailId");
					emailId=sc.next();
					System.out.println("Enter the password");
					password=sc.next();
					System.out.println("Entre the address");
					address=sc.next();
					System.out.println("Enter the contanct");
					contanct=sc.nextLong();
					c.setName(name);
					c.setEmailId(emailId);
					c.setPassword(password);
					c.setAddress(address);
					c.setContanct(contanct);
					boolean flag1=cd.addCustomer(c);
					if(flag1==true)
					{
						System.out.println("Customer adding  successfully");
					}
					else
					{
						System.out.println("Customer not add successfully");
					}
					break;
				case 2:
					System.out.println("Enter the id");
					id=sc.nextInt();
					System.out.println("Enter the name");
					name=sc.next();
					System.out.println("Enter the emailId");
					emailId=sc.next();
					System.out.println("Enter the password");
					password=sc.next();
					System.out.println("Entre the address");
					address=sc.next();
					System.out.println("Enter the contanct");
					contanct=sc.nextLong();
					c.setName(name);
					c.setEmailId(emailId);
					c.setPassword(password);
					c.setAddress(address);
					c.setContanct(contanct);
					c.setId(id);
					boolean flag2=cd. updateCustomer(c);
					if(flag2==true)
					{
						System.out.println("Customer Update   successfully");
					}
					else
					{
						System.out.println("Customer not Update successfully");
					}
					break;
				case 3:
					System.out.println("Enter the  id");
					id=sc.nextInt();
					c.setId(id);
					boolean flag3=cd.deleteCustomer(id);
					if(flag3==true)
					{
						System.out.println("Customer Delete successfully");
					}
					else
					{
						System.out.println("Customer Not Delete successfully");
					}
					break;
				case 4:
					System.out.println("Enter the id");
					id=sc.nextInt();
					c.setId(id);
					c = cd. displayCustomerById(id);
					System.out.println(c.getId()+" "+c.getName()+" "+c.getEmailId()+" "+c.getPassword()+" "+c.getAddress()+" "+c.getContanct());
					break;
				case 5:
					List<Customer> c1 = new ArrayList<Customer>();
					c1 = cd.displayAllCustomer();
					for(Customer customer : c1)
					{
						System.out.println(customer.getId()+" "+customer.getName()+" "+customer.getEmailId()+" "+customer.getPassword()+" "+customer.getAddress()+" "+customer.getContanct());
					}
					break;
				case 6:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Enter the invalid choice[1-6]");
					break;
				}
			}while(choice<6);
	}
}