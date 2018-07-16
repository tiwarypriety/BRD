package validationPackage;

import entityPackage.Customer;

public class CustomerValidation 
{
	public static String str="";
	
	public boolean customerCode(String code)
	{
		if(code.equals(""))
		{
			this.str="Customer Code Mandatory ";
			return false;
		}
		else	if(code.length()>10)	
		{
			
			this.str="Customer Code Length not valid";
			return false;
		}
		else return true;
	}
	public boolean customerName(String name)
	{
		String str1="[a-zA-Z0-9 ]+";
		if(name.equals(""))
		{
			this.str="Customer Name Mandatory ";
			return false;
		}
		else 	if(name.length()>30)
		{
			
			this.str="Customer Length not valid ";
			return false;
		}
		else	if(name.matches(str1))
					return true;
		else
		{
			this.str="Invalid Name";
			return false;
		}
	}
	
	public boolean address1(String address)
	{
		if(address.equals(""))
		{
			this.str="Address1 Mandatory ";
			return false;
		}
		else	if(address.length()>100)
		{
			
			this.str="Address1 Length not valid ";
			return false;
		}
		else	
			return true;
	}
	
	public boolean address2(String address)
	{
		if(address.length()>100)
		{
			//this.count1=1;
			this.str="Address1 Length not valid ";
			return false;
		}
		else	
			return true;
	}
	
	public boolean PinCode(String pin)
	{
		String str1="[0-9]+";
		if(pin.equals(""))
		{
			this.str="Pin Code Mandatory ";
			return false;
		}
		else	if(pin.length()!=6)
				{
					this.str="Invalid Pin Code Length ";
					return false;
				}
		else	if(pin.matches(str1))
				return true;
		else
		{
			this.str="Pin should contain numbers only ";
			return false;
		}
		
	}
	
	public boolean email(String email)
	{
		String str1="[a-zA-Z0-9._]+[@]{1}[a-zA-Z]+[.]{1}[a-zA-Z]+[.]?[a-zA-Z]+";
		if(email.equals(""))
		{
			this.str="Email Mandatory ";
			return false;
		}
		else	if(email.length()>100)
		{
			//this.count1=1;
			this.str="email Length not valid ";
			return false;
		}
		else	if(email.matches(str1))
					return true;
		else
		{
			this.str="Invalid email ";
			return false;
		}
	}
	
	public boolean contactNumber(String str1)
	{
		if(str1.length()>20)
		{
			str="Invalid length of Number";
			return false;
		}
		else
			return true;
	}
	
	public boolean primaryContactPerson(String str1)
	{
		
		if(str1.equals(""))
		{
			this.str="Primary Contact Person Mandatory ";
			return false;
		}
		else	if(str1.length()>100)
		{
			//this.count1=1;
			this.str="Primary contact name Length not valid ";
			return false;
		}
		else	
			return true;
	}
	
	
	public boolean createdDate(String date)
	{
		String str1="[0-3]{1}[0-9]{1}[/]{1}[a-zA-Z]{3}[/]{1}[0-9]{4}";
		if(date.equals(""))
		{
			this.str="Created Date Mandatory ";
			return false;
		}
		else	if(date.matches(str1))
			return true;
		else
		{
			str="Invalid created Date";
			return false;
		}
		
	}
	
	public boolean createdBy(String name)
	{
		if(name.equals(""))
		{
			this.str="Created By Mandatory ";
			return false;
		}
		else	if(name.length()>30)
		{
			//this.count1=1;
			this.str="CreatedBy Length not valid ";
			return false;
		}
		else	
			return true;
	}
	
	
}
