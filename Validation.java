package dao;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import pojo.Customer;

public class Validation
{
	public boolean checkNull(String s[])
	{
		if(s[0].isEmpty()&&s[1].isEmpty()&&s[2].isEmpty()&&s[4].isEmpty()&&s[5].isEmpty()&&s[7].isEmpty()&&s[8].isEmpty()&&s[8].isEmpty()&&s[9].isEmpty()&&s[10].isEmpty()&&s[11].isEmpty())
		return false;

		return true;
	}

	public boolean checkName(String s)
	{		
		if(s.length()<=30)
		{
		 if(s.matches("[A-Za-z 0-9]+"))
			return true;
		}		
		return false;
	}
	public boolean checkPinCode(int i){
		int j = String.valueOf(i).length();
		if(j==6)
		return true;
		else
		return false;
	}
	public boolean checkContact(Long i)
	{
		int j = String.valueOf(i).length();
		if(j==10)
		return true;
		else
		return false;
	}	
	boolean	checkEmailFormat(String email)
	{
	   
	    if(email.contains("@"))
	    {
	    	 return true;
	    }
	return false;		
	}	
	boolean checkRecordStatus(String s)
	{
		if(s.charAt(0)=='N'||s.charAt(0)=='M'||s.charAt(0)=='D'||s.charAt(0)=='A'||s.charAt(0)=='R')
		return true;
		return false;
	}
	boolean checkFlag(String s)
	{
		if(s.charAt(0)=='A'||s.charAt(0)=='I')
		return true;
		return false;
	}
	public boolean fileFormat(String fileName)
	{
		   return fileName.endsWith(".txt");
	}
	public boolean code(String code){		
		if(code.length()<=10)	
		return true;
		return false;
	}
}

