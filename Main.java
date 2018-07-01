package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) throws Exception 
	{
		
		Validation v = new Validation();
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
					        Rejection r1 = new Rejection(br,d);
					case 'F' :	
							Rejection r2 = new Rejection(br,d);
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
