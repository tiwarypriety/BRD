package controllerPackage;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import constantFilePackage.MakerConstant;
//import daoPackage.UserCrud;
import daoPackage.UserCrudImplementation;
import entityPackage.Customer;
import entityPackage.User;
import servicePackage.UserService;


public class UserController extends HttpServlet 
{ 
	private static final long serialVersionUID = 1L;
	Properties pr = new Properties();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		pr.load(new FileReader(MakerConstant.propertiesPath));
		PrintWriter p=response.getWriter();
		
		String name=request.getParameter("uname");
		String password=request.getParameter("paswd");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("name", name); 
		
//		String name1=(String) session.getAttribute("name");
//		System.out.println(name1);
		
		User u=new User();
		u.setName(name);
		u.setPassword(password);
		
		UserService s=new UserService();
		System.out.println("inside UserController");
		boolean bool=s.userServiceMethod(u);
		System.out.println("you have got "+bool);
		if(bool==true)
		{
			if(u.getRole().equalsIgnoreCase("Maker"))
			{
				System.out.println("you are Maker");
				
				
				RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("menu"));
				p.write("Welcome "+u.getName());
				rd.include(request, response);
				
				
			}
			else
			{
				System.out.println("you are Checker");
				p.println("your are checker..");
				RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("login"));
				rd.include(request, response);
			}
		}
		else
		{
			p.println("Please enter valid credentials...");
			System.out.println("Unauthorized user");
			RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("login"));
			rd.include(request, response);	
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		pr.load(new FileReader(MakerConstant.propertiesPath));
		String action=request.getParameter("operation");
		System.out.println(action);
		if(action.equalsIgnoreCase("Logout"))
		{
			System.out.println("lllllllllllllllllllll");
			HttpSession session = request.getSession(false);
			 
	            session.invalidate(); 
	            if(session!=null)
	            	System.out.println("session invalidate");
	          
	            RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("login"));
				rd.forward(request, response);
		}
		
		
	}
	

}
