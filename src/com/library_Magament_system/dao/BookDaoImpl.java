package com.library_Magament_system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library_management_system.pojo.Book;
import com.library_management_system.utility.DBUtility;
public class BookDaoImpl implements BookDao  
{
     String query;
     Book b=new Book();
	@Override
	public boolean addBook(Book b) 
	{
		query="insert into  book(name,author,year) values(?,?,?)";
		 try
		    {
		    	Connection conn=DBUtility. establishConnection();
		    	PreparedStatement ps=conn.prepareStatement(query);
		    	ps.setString(1, b.getName());
		    	ps.setString(2, b.getAuthor());
		    	ps.setInt(3,b.getYear());
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
	public boolean updateBook(Book b) 
	{

		query="update book set name=?, author=?, year=? where id=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setString(1, b.getName());
	    	ps.setString(2, b.getAuthor());
	    	ps.setInt(3,b.getYear());
	    	ps.setInt(4, b.getId());
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
	public boolean deleteBook(int id) 
	{
		query="delete from book where id=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, b.getId());
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
	public Book displayBookById(int id)
	{
		query="select * from book where id=?";
		try
	    {
	    	Connection conn=DBUtility. establishConnection();
	    	PreparedStatement ps=conn.prepareStatement(query);
	    	ps.setInt(1, id);
	    	ResultSet  rs = ps.executeQuery();
	    	while(rs.next())
			{
	    		b.setId(rs.getInt(1));
	    		b.setName(rs.getString(2));
	    		b.setAuthor(rs.getString(3));
	    		b.setYear(rs.getInt(4));
			}
	    }
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public List<Book> displayAllBook() 
	{
		query="select * from book";
		 Connection conn;
			List<Book> BookList = new ArrayList<Book>();
			try 
			{
				conn = DBUtility. establishConnection();
				Statement st =  conn.createStatement();
				ResultSet  rs = st.executeQuery(query);
				while(rs.next())
				{
					Book b=new Book();
					b.setId(rs.getInt(1));
		    		b.setName(rs.getString(2));
		    		b.setAuthor(rs.getString(3));
		    		b.setYear(rs.getInt(4));
		    		BookList.add(b);
				}
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}		
		return BookList;
	}
}