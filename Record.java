package dao;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pojo.Customer;

public class Record {
	
	Record(BufferedReader br) throws NumberFormatException, IOException{
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


if(v.checkNull(s)&&v.checkName(cus.getName())&&v.checkPinCode(cus.getPin_code())&&v.checkEmailFormat(cus.getEmail())&&v.checkRecordStatus(cus.getRecordStatus())&&v.checkFlag(cus.getFlag())&&v.checkContact(cus.getContact_number())&&v.code(cus.getCode()))	
	{


		int number= dao.insertRecord(cus);
		System.out.println("record inserted "+number);
			number++;
		}
	else
		{
		FileWriter out = new FileWriter("d:/newErrorLog.txt",true);
		
		 for(int i = 0;i<s.length;i++)
		 {						 
			 out.write(s[i]);
			 out.write(" ");
			 
			 
		 }
		 out.append(System.lineSeparator()); 
	out.write("\n");
		out.flush();
		}					
	
}		
catch(Exception e)
{

FileWriter out = new FileWriter("d:/newtestCase.txt",true);

for(int i = 0;i<s.length;i++)
{						 
out.write(s[i]);
out.write(" ");						
}

out.flush();
}
}

	}	
	
}
