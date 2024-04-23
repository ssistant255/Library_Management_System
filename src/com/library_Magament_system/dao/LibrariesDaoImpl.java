package com.library_Magament_system.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.library_management_system.pojo.Libraries;
import com.library_management_system.utility.DBUtility;
public class LibrariesDaoImpl implements  LibrariesDao
{
    String query;
	@Override
	public boolean addLibraries(Libraries l) 
	{
		query="insert into Libraries1(name,address, city,state,contanct) values(?,?,?,?,?)";
		 try
		    {
		    	Connection conn=DBUtility. establishConnection();
		    	PreparedStatement ps=conn.prepareStatement(query);
		    	ps.setString(1, l.getName());
		    	ps.setString(2, l.getAddress());
		    	ps.setString(3, l.getCity());
		    	ps.setString(4, l.getState());
		    	ps.setLong(5, l.getContanct());
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
	public List<Libraries> showLibraries() 
	{
		query="select * from Libraries1";
		 Connection conn;
			List<Libraries> LibrariesList = new ArrayList<Libraries>();
			try 
			{
				conn = DBUtility. establishConnection();
				Statement st =  conn.createStatement();
				ResultSet  rs = st.executeQuery(query);

				while(rs.next())
				{
					Libraries l=new Libraries();
					l.setId(rs.getInt(1));
					l.setName(rs.getString(2));
					l.setAddress(rs.getString(3));
					l.setCity(rs.getString(4));
					l.setState(rs.getString(5));
					l.setContanct(rs.getLong(6));
					LibrariesList.add(l);
				}
			}
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace();
			}		
		return LibrariesList;
	}
}