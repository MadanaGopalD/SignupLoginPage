package org.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	private static Connection con=null;
	
	private JdbcConnection()
	{
		
	}
	
	public static Connection getJdbcConnection() 
	{
		if(con==null)
		{
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		}
		else
		{
			return con;
		}
		
	}
	
}
