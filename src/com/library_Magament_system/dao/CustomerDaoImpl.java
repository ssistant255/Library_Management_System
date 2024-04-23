package com.library_Magament_system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library_management_system.pojo.Customer;
import com.library_management_system.utility.DBUtility;
public class CustomerDaoImpl implements CustomerDao
{
     String query;
     Customer c=new Customer();
	@Override
	public boolean addCustomer(Customer c) 
	{
		query="insert into  customer(name, emailId,password,address ,contanct) values(?,?,?,?,?)";
		 try
		    {
		    	Connection conn=DBUtility. establishConnection();
		    	PreparedStatement ps=conn.prepareStatement(query);
		    	ps.setString(1, c.getName());
		    	ps.setString(2, c.getEmailId());
		    	ps.setString(3, c.getPassword());
		    	ps.setString(4, c.getAddress());
		    	ps.setLong(5, c.getContanct());
		    	int row =ps.executeUpdate();
		    	if(row>0)
		    	{
		    	     return true;
		    	}
		    	else
		    	{
		    		return false;
		    	}
		    }
		    catch(ClassNotFoundException e)
		    {
		    	e.printStackTrace(); 
		    }
		    catch(SQLException e)
		    {
		    	e.printStackTrace();
		    }
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) 
	{

		query="update customer set name=?, emailId=?, password=?, address=?, contanct=? where id=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setString(1, c.getName());
	    	ps.setString(2, c.getEmailId());
	    	ps.setString(3, c.getPassword());
	    	ps.setString(4, c.getAddress());
	    	ps.setLong(5, c.getContanct());
	    	ps.setInt(6, c.getId());
	    	int row =ps.executeUpdate();
	    	if(row>0)
	    	{
	    	     return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
	    catch(ClassNotFoundException e)
	    {
	    	e.printStackTrace(); 
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }
		return false;
	}

	@Override
	public boolean deleteCustomer(int id)
	{
		query="delete from customer where id=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1,c.getId() );
	    	int row =ps.executeUpdate();
	    	if(row>0)
	    	{
	    	     return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
	    catch(ClassNotFoundException e)
	    {
	    	e.printStackTrace(); 
	    }
	    catch(SQLException e)
	    {
	    	e.printStackTrace();
	    }

		return false;
	}

	@Override
	public Customer displayCustomerById(int id) 
	{
		query="select * from customer where id=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, id);
	    	ResultSet  rs = ps.executeQuery();
			while(rs.next())
			{
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmailId(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setAddress(rs.getString(5));
				c.setContanct(rs.getLong(6));
			}
	    }
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
			return c;
	}
	@Override
	public List<Customer> displayAllCustomer() 
	{
		query="select * from customer";
		 Connection conn;
			List<Customer> CustomerList = new ArrayList<Customer>();
			try 
			{
				conn = DBUtility. establishConnection();
				Statement st =  conn.createStatement();
				ResultSet  rs = st.executeQuery(query);

				while(rs.next())
				{
					Customer c = new Customer();
					c.setId(rs.getInt(1));
					c.setName(rs.getString(2));
					c.setEmailId(rs.getString(3));
					c.setPassword(rs.getString(4));
					c.setAddress(rs.getString(5));
					c.setContanct(rs.getLong(6));
					CustomerList.add(c);
				}
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}
					
		return CustomerList;
	}
}