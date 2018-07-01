package dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Customer;

public class FileLevel {
	Validation v = new Validation();
	Customer cus = new Customer();
	CustomerDAO dao = new CustomerDAO();
	String c;
	
FileLevel(BufferedReader br) throws NumberFormatException, IOException, SQLException
{
	FileWriter out = new FileWriter("d:/newErrorLog2.txt");
	while((c = br.readLine())!=null)					
	{
		
String s[] = c.split("~",-1);
		cus.setCode(s[0]);
		cus.setName(s[1]);
		cus.setAddress1(s[2]);
		cus.setAddress2(s[3]);
		cus.setPin_code(Integer.parseInt(s[4]));
		cus.setEmail(s[5]);
		cus.setContact_number(Long.parseLong(s[6]));
		cus.setPrimary_contact_person(s[7]);
		cus.setRecordStatus(s[8]);
		cus.setFlag(s[9]);
		cus.setCreateDate(s[10]);
		cus.setCreatedBy(s[11]);
		cus.setModifiedDate(s[12]);
		cus.setModifiedBy(s[13]);
		cus.setAuthorizedDate(s[14]);
		cus.setAuthorizedBy(s[15]);		
		
try{
	int number;
	

	}					

		catch(Exception e)
			{
				System.out.println(e);
			}	
}	
	dao.roll();
	}
}
