package gui;

import javax.swing.JOptionPane;

public class Validate {
	
	public boolean validateId(String id)
	{
		char[] c =  id.toCharArray();
		
		
		for(int i = 0;i<c.length;i++)
		{
			if(Character.isDigit(c[i])==false)
			{
				return false;
			}
		}
		
		if(id.equals(""))
		{
			return false;
		}
		return true;
		
	}

	public boolean validateSalary(String sal)
	{
		char[] c =  sal.toCharArray();
		
		
		for(int i = 0;i<c.length;i++)
		{
			if(Character.isDigit(c[i])==false)
			{
				return false;
			}
		}
		
		if(sal.equals(""))
		{
			return false;
		}
		return true;
		
	}
	
	public boolean validateName(String nm)
	{
		char[] c =  nm.toCharArray();
		
		
		for(int i = 0;i<c.length;i++)
		{
			if(Character.isDigit(c[i])==true)
			{
				return false;
			}
		}
		
		if(nm.equals(""))
		{
			return false;
		}
		return true;
		
	}

}
