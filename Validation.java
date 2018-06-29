package dao;

import java.io.File;

public class Validation
{
	public boolean fileFormat(String fileName)
	{
		   return fileName.endsWith(".txt");
	}
	
	public boolean checkName(String s)
	{		
		if(s==null)
			return false;
		else if(s.matches("[A-Za-z 0-9]+"))
			return true;
		else 
			return false;
		
	}
	public boolean checkPinCode(int i){
		if(i==0)
		return false;
		int j = String.valueOf(i).length();
		if(j==6)
		return true;
		else
		return false;
	}
	boolean	checkEmailFormat(String email)
	{
	    if(email == null)
	    {
	        return false;
	    }    

	    else if(email.endsWith(".com")&&email.contains("@"))
	    {
	    	 return true;
	    }
	return false;		
	}
	
}
