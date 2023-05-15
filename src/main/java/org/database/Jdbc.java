package org.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc {
	
	public static Connection con=JdbcConnection.getJdbcConnection();
	
	public static boolean signup(String name,String pwd,String email,String mobileNo,Date dob )
	{
		PreparedStatement stmt=null;
		String query="insert into madan.users values(?,?,?,?,?)";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1,name);
			stmt.setString(2,email);
			stmt.setString(3,pwd);
			stmt.setString(4,mobileNo);
			stmt.setDate(5,dob);
			if(stmt.executeUpdate()>=1)
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static boolean validateuser(String userName, String pwd)
	{
		PreparedStatement stmt=null;
		boolean result=false;
		String query="select * from madan.users where email= ? and password= ?";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1, userName);
			stmt.setString(2, pwd);
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				result=true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<Users> getUserDetails(String email)
	{
		PreparedStatement stmt=null;
		ResultSet rs=null;
		List<Users> userData=new ArrayList<>();
		String query="select * from madan.users where email=?";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1, email);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				Users user=new Users();
				user.setName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setMobileNo(rs.getString(4));
				user.setDateOfBirth(rs.getDate(5));
				userData.add(user);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return userData;
	}
	
	public static boolean deleteUser(String email)
	{
		PreparedStatement stmt=null;
		boolean result=false;
		String query="delete from madan.users where email=?";
		try 
		{
			stmt=con.prepareStatement(query);
			stmt.setString(1, email);
			if(stmt.executeUpdate()>=1)
			{
				result=true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
