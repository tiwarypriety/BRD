package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.Scanner;

import pojo.Customer;

import java.text.SimpleDateFormat;

public class Main
{

	public static void main(String[] args) throws Exception 
	{
		Validation v = new Validation();
		Customer cus = new Customer();
		CustomerDAO dao = new CustomerDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of File");
		String a = sc.next();	
				
		if(v.fileFormat(a))
		{
		try{
				BufferedReader br = new BufferedReader(new FileReader("d:/"+a));
			try{							
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
					}							
					System.out.println("Enter your Choice(Rejection level)");
					System.out.println(" R  :  for Record level Rejection ");
					System.out.println(" F  :  for Record level Rejection ");
					char d = sc.next().charAt(0);
					switch(d)
					{
					case 'R' :
						 if(v.checkName(cus.getName()))
						 {
							 if(v.checkPinCode(cus.getPin_code()))
							 {
								if(v.checkEmailFormat(cus.getEmail()))
								{
									
								int s= 	dao.insertRecord(cus);
									System.out.println("REcored inserted "+s);
									
								}
								else
								{
									System.out.println("wrong email format");
								}
								 
							 }
							 else
							 {
							System.out.println("invalid pin");
							 }
						 }
						 else
						 {
							 System.out.println("Name contains special character");
						 }
					          
						       
					case 'F' :	
						
						
						
					}
			}
			catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
		}
		catch(Exception e){
			System.out.println("File name is invalid....!!");
		}
			
		}else
				{
					System.out.println("File Extension Should be   :   .txt");
				}
			
			
			
		
		
		
		
	
		
		
		
	}
}
