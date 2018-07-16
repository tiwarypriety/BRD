package controllerPackage;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

import constantFilePackage.MakerConstant;
import entityPackage.Customer;
import servicePackage.CustomerService;
import validationPackage.CustomerValidation;


public class CustomerController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Properties pr = new Properties();
	CustomerService cs=new CustomerService();
	Customer c=new Customer();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		pr.load(new FileReader(MakerConstant.propertiesPath));
		HttpSession session = request.getSession(false);
		String name1=(String)session.getAttribute("name"); 
				PrintWriter p=response.getWriter();
		
	
		
		String action=request.getParameter("operation");
		if(session!=null)
		{
		if(action.equalsIgnoreCase("newcustomer"))
		{
			String code=request.getParameter("code");
			String name=request.getParameter("name");
			String address1=request.getParameter("address1");
			String address2=request.getParameter("address2");
			String pin=request.getParameter("pin");
			String email=request.getParameter("email");
			String number=request.getParameter("number");
			String contactPerson=request.getParameter("contactPerson");
			
			
			
			
			
			c.setCode(code);
			c.setName(name);
			c.setAddress1(address1);
			c.setAddress2(address2);
			c.setPin(pin);
			c.setEmail(email);
			c.setNumber(number);
			c.setContactPerson(contactPerson);
			c.setCreatedDate();
			c.setCreatedBy(name1);
			
			if(!cs.searchService().contains(c.getCode()))
				{
					cs.customerServiceMethod(c);
					RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("new"));
					p.println("Enter New Details");
					rd.include(request, response);
					
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("new"));
					p.println("Customer already exist");
					rd.include(request, response);
				}
		}
		else	 if(action.equalsIgnoreCase("search"))
		{
					String code=request.getParameter("code");
				//	cs.searchService();
					if(cs.searchService().contains(code))
					{
						System.out.println("yes it contains code");
						ResultSet rs=cs.forSearchService(c,code);
						try 
						{
						while(rs.next())
						{
						
							c.setCode(rs.getString(1));
							c.setName(rs.getString(2));
							c.setAddress1(rs.getString(3));
							c.setAddress2(rs.getString(4));
							c.setPin(rs.getString(5));
							c.setEmail(rs.getString(6));
							c.setNumber(rs.getString(7));
							c.setContactPerson(rs.getString(8));
							c.setCreatedDate();
							c.setCreatedBy(rs.getString(10));
							
							request.setAttribute("code", c.getCode());
							request.setAttribute("name", c.getName());
							request.setAttribute("address1", c.getAddress1());
							request.setAttribute("address2", c.getAddress2());
							request.setAttribute("pin", c.getPin());
							request.setAttribute("email", c.getEmail());
							request.setAttribute("number", c.getNumber());
							request.setAttribute("contactPerson", c.getContactPerson());
							request.setAttribute("createdDate", c.getCreatedDate());
							request.setAttribute("createdBy", c.getCreatedBy());
							
							
							RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("update"));
							p.println("please upate values");
							rd.include(request, response);
						}
						}catch (SQLException e) 
						{
							
							e.printStackTrace();
						}
						
						
					}
					else
					{
					RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("search"));
					p.println("Customer Code doesn't exist");
					rd.include(request, response);
					}
		}
		else	if(action.equalsIgnoreCase("update"))
		{
			
			String code=request.getParameter("code");
			String name=request.getParameter("name");
			String address1=request.getParameter("address1");
			String address2=request.getParameter("address2");
			String pin=request.getParameter("pin");
			String email=request.getParameter("email");
			String number=request.getParameter("number");
			String contactPerson=request.getParameter("contactPerson");
			String createdDate=request.getParameter("createdDate");
			String createdBy=request.getParameter("createdBy");
			
			
			
			c.setCode(code);
			c.setName(name);
			c.setAddress1(address1);
			c.setAddress2(address2);
			c.setPin(pin);
			c.setEmail(email);
			c.setNumber(number);
			c.setContactPerson(contactPerson);
			c.setCreatedDate();
			
			
			
			
			
				boolean bool1=cs.updateService(c);
				if(bool1==true)
				{
					System.out.println("data updated");
					RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("new"));
					p.println("data updated");
					rd.include(request, response);
				}
				else
					System.out.println("data not updated");
			
			System.out.println("still printing");
			
		}
		/*else
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}*/
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		pr.load(new FileReader(MakerConstant.propertiesPath));
		HttpSession session = request.getSession(false);
		//String str=(String)session.getAttribute("name");
		
		PrintWriter p=response.getWriter();
		String action=request.getParameter("operation");
		if(session!=null)
		{
		if(action.equalsIgnoreCase("viewdetails"))
		{
			ArrayList<Customer> r=cs.forViewService();
			request.setAttribute("customer", r);
			RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("view"));
			p.println("all details");
			rd.include(request, response);
			
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("login"));
			rd.forward(request, response);
		}
		}
	}
}
