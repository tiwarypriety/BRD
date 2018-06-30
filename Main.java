package dao;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
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
						
						System.out.println("Enter your Choice(Rejection level)");
						System.out.println(" R  :  for Record level Rejection ");
						System.out.println(" F  :  for File level Rejection ");
					char d = sc.next().charAt(0);
					switch(d)
					{
					case 'R' :
					        Record r = new Record(br);
					case 'F' :	
							FileLevel l = new FileLevel(br);
		}	
			}
			catch(Exception e){
				
				System.out.println(e);
				
				}			
				
			
		}
		catch(Exception e){
			System.out.println("File name is invalid....!!");
		}
			
		}
		else
				{
					System.out.println("File Extension Should be   :   .txt");
				}
			
		
}
}
