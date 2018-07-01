package dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Customer;

public class Rejection {
	
	Rejection(BufferedReader br,char ch) throws NumberFormatException, IOException, SQLException{
		FileWriter out = new FileWriter("d:/newErrorLog.txt");
		Validation v = new Validation();
		Customer cus = new Customer();
		CustomerDAO dao = new CustomerDAO();
		String c;
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
if(ch=='R')
{
if(v.checkNull(s)&&v.checkName(cus.getName())&&v.checkPinCode(cus.getPin_code())&&v.checkEmailFormat(cus.getEmail())&&v.checkRecordStatus(cus.getRecordStatus())&&v.checkFlag(cus.getFlag())&&v.checkContact(cus.getContact_number())&&v.code(cus.getCode()))	
	{
		int number= dao.insertRecord(cus);
		System.out.println("record inserted "+number);
			number++;
		}
	else
		{		
		 for(int i = 0;i<s.length;i++)
		 {						 
			 out.write(s[i]);
			 out.write(" ");
			 
			 
		 }
		 out.append(System.lineSeparator()); 
	
		out.flush();
		}	
}
if(ch=='F'){
	int number;
	if(v.checkNull(s)&&v.checkName(cus.getName())&&v.checkPinCode(cus.getPin_code())&&v.checkEmailFormat(cus.getEmail())&&v.checkRecordStatus(cus.getRecordStatus())&&v.checkFlag(cus.getFlag())&&v.checkContact(cus.getContact_number())&&v.code(cus.getCode()))	
	{
	
	 number= dao.insertRecord(cus);
	 System.out.println("record inserted "+number);
	 for(int i = 0;i<s.length;i++)
	 {						 
		 out.write(s[i]);
		 out.write(" ");
		 
		 
	 }
	 out.append(System.lineSeparator()); 
		out.flush();

		}
		
	else
	{
		break;
	}	
}
}		
catch(Exception e)
{
System.out.println(e);
}

	}	
		if(ch=='F'){
			dao.roll();
		}
	
	}
}
