package controllerPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import constantFilePackage.MakerConstant;
import entityPackage.Customer;
import servicePackage.CustomerService;

/**
 * Servlet implementation class FileUploadController
 */
@WebServlet("/FileUploadController")
public class FileUploadController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	CustomerService cs=new CustomerService();
	Customer c=new Customer();
	Properties pr = new Properties();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		pr.load(new FileReader(MakerConstant.propertiesPath));
		//HttpSession session = request.getSession(false);
		//String name1=(String)session.getAttribute("name"); 
				PrintWriter p=response.getWriter();
				
			//String action=request.getParameter("operation");
				
				//	System.out.println("inside if loop");
		
					response.setContentType("text/html");
		
					/*MultipartRequest m = new MultipartRequest(request, "c:/Khushboo_JFiles/MakerBRD/WebContent"); 
					System.out.println("file uploaded");
					String str=request.getParameter("fname");
					System.out.println(str);*/
					//BufferedReader br=new BufferedReader(new FileReader("c:/Khushboo_JFiles/MakerBRD/WebContent/testCase1"));
					//BufferedWriter bw=new BufferedWriter(new FileWriter("D:/logError2.txt"));
					ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
					try {
						List<FileItem> multifiles=sf.parseRequest(request);
						for (FileItem item : multifiles ) 
						{
							try 
							{
								item.write(new File(MakerConstant.filePathToUploadInsertFile));
							} catch (Exception e) 
							{
								e.printStackTrace();
							}
						}
					}
					catch (FileUploadException e) 
					{
						e.printStackTrace();
					}
					BufferedReader br=new BufferedReader(new FileReader(MakerConstant.filePathToUploadInsertFile));
					//BufferedWriter bw=new BufferedWriter(new FileWriter("c:/Khushboo_JFiles/MakerBRD/WebContent/errorLog.jsp"));
					BufferedWriter bw1=new BufferedWriter(new FileWriter(MakerConstant.filePathforError));
					//BufferedWriter bw1=new BufferedWriter(new FileWriter("D:/logError2.txt"));
					String line= br.readLine();
					//List errorList=new ArrayList();
					
					while(line!=null)
					{
						if(line.charAt(line.length()-1)=='~')
							line=line+"NA";
						String[] s=line.split("~");
						c.setCode(s[0]);
						c.setName(s[1]);
						c.setAddress1(s[2]);
						c.setAddress2(s[3]);
						c.setPin(s[4]);
						c.setEmail(s[5]);
						c.setNumber(s[6]);
						c.setContactPerson(s[7]);
						c.setRecordStatus(s[8]);
						c.setFlag(s[9]);
					//	c.setCreatedDate();10
						c.setCreatedBy(s[11]);
					//	c.setModifiedDate();12
						c.setModifiedBy(s[13]);
					//	c.setAuthorizedDate();14
						c.setAuthorizedBy(s[15]);
						
						if(cs.fileValidation(c))
						{
							if(!cs.searchService().contains(c.getCode()))
								cs.customerServiceMethod(c);
						}
						else
						{
							//errorList.add(c);
						//	System.out.println(c.getName());
							//bw.write(c.getCode()+" "+c.getName()+" "+c.getAddress1()+" "+c.getAddress2()+" "+c.getPin()+" "+c.getEmail()+" "+c.getNumber()+" "+c.getContactPerson()+" "+c.getRecordStatus()+" "+c.getFlag()+" "+c.getCreatedDate()+" "+c.getCreatedBy()+" "+c.getModifiedDate()+c.getModifiedBy()+" "+c.getAuthorizedDate()+" "+c.getAuthorizedBy());
							bw1.write(line);
							bw1.newLine();
							//bw1.newLine();
							bw1.flush();
							System.out.println("data in errorlog...");
						}
						line= br.readLine();
					}
					br.close();
					bw1.close();
					
					ArrayList<String> arr1=new ArrayList<String>();
					BufferedReader br1=new BufferedReader(new FileReader(MakerConstant.filePathforError));
					String line1=br1.readLine();
					while(line1!=null)
					{
					arr1.add(line1);
					line1=br1.readLine();
					
					}
					for(String s:arr1)
						{System.out.println(s);
						}
					request.setAttribute("err", arr1);
					br1.close();
					RequestDispatcher rd=request.getRequestDispatcher(pr.getProperty("errorPage"));
					p.println("all errrors");
					rd.forward(request, response);
					
					
					
					
					/*RequestDispatcher rd=request.getRequestDispatcher("errorLog.jsp");
					//p.println("errors.....");
					rd.include(request, response);*/
	}

}
