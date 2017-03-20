package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Queries {
	
	public PreparedStatement pst;
	public ResultSet rs;
	public Statement st;
	
	public Queries()
	{
		Connector.getConnection();
	}
	
	public void insert(int id, String nm, float sal)
	{
		String query = "insert into emp values(?,?,?)";
		try {
			pst = Connector.con.prepareStatement(query);
			pst.setInt(1, id);
			pst.setString(2, nm);
			pst.setFloat(3, sal);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(int id,String nm,float sal)
	{
		
		try {
			String query = "update emp set name = ?,salary = ? where id = ?";
			pst = Connector.con.prepareStatement(query);
			pst.setString(1, nm);
			pst.setFloat(2, sal);
			pst.setInt(3, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Integer> getId()
	{
		ArrayList<Integer> list = new ArrayList<>();
		try
		{
			st = Connector.con.createStatement();
			String q = "select id from emp";
			rs = st.executeQuery(q);
			
			while(rs.next())
			{
				list.add(rs.getInt(1));
			}
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}
	
	public void delete(int emp_id)
	{
		try
		{
			String q = "delete from emp where id = ?";
			pst = Connector.con.prepareStatement(q);
			pst.setInt(1, emp_id);
			pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String[] getData(int id)
	{
		String[] data = new String[2];
		try
		{
			String q = "select name,salary from emp where id = ?";
			pst = Connector.con.prepareStatement(q);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next())
			{
				data[0] = rs.getString(1);
				data[1] = rs.getString(2);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
		
	}
	
	public void select()
	{
		try
		{
			st = Connector.con.createStatement();
			String sql = "select * from emp ";
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				rs.getInt(1);
				rs.getString(2);
				rs.getFloat(3);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String[][] selectasArray()
	{
		String[][] data = null;
		try
		{
			st = Connector.con.createStatement();
			String q = "select * from emp";
			rs = st.executeQuery(q);
			int i = 0,j=1;
			while(rs.next())
			
				i++;
			data = new String[i][3];
			rs.beforeFirst();
			i = 0;
			
			while(rs.next())
			{
				data[i][0] = rs.getString(1);
				data[i][1] = rs.getString(2);
				data[i][2] = rs.getString(3);
				i++;
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}

}
