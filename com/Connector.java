package com;
import java.sql.*;
public class Connector {
	
	public static Connection con;
	
	public static void getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/employee","root","");
		}
		catch(ClassNotFoundException c)
		{
			c.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
