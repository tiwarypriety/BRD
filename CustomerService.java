package servicePackage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import daoPackage.CustomerCrud;
import entityPackage.Customer;
import validationPackage.CustomerValidation;

public class CustomerService 
{
	CustomerCrud cCrud=new CustomerCrud();
	public boolean customerServiceMethod(Customer c)
	{
			cCrud.insert(c);
			return true;
	
	}
	public ArrayList<String> searchService()
	{
		
			return (cCrud.unique());
		
		
	}
	public ResultSet forSearchService(Customer c,String code)
	{
		ResultSet rs=cCrud.forSearch(c,code);
		return rs;
	}
	
	public boolean updateService(Customer c)
	{
		return cCrud.update(c);
	}
		
	public ArrayList<Customer> forViewService()
	{
		return cCrud.forView();
	}
	
	public boolean fileValidation(Customer c)
	{
		CustomerValidation cv=new CustomerValidation();
		if(cv.customerCode(c.getCode()) && cv.customerName(c.getName()) &&cv.address1(c.getAddress1())&&cv.address2(c.getAddress2())&&cv.PinCode(c.getPin())&& cv.email(c.getEmail())&&cv.contactNumber(c.getNumber())&& cv.primaryContactPerson(c.getContactPerson())&&cv.createdBy(c.getCreatedBy()))
			return true;
		return false;
		
	}
	
}
