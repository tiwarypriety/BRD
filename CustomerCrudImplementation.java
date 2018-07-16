package daoPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import connectionPackage.ConnectionI;
import connectionPackage.Factory;
import constantFilePackage.MakerConstant;
import entityPackage.Customer;

public class CustomerCrudImplementation 
{
	ArrayList<String> arr=new ArrayList<String>();
	Factory f = new Factory();
	public boolean insert(Customer c)
	{
		
		ConnectionI con = f.factoryConnection("ORACLE");
		Connection conn = con.getConnection();
		
		String sql=MakerConstant.customerInsertQuery;
		PreparedStatement ps=null;
		try 
		{
			ps=conn.prepareStatement(sql);
			ps.setString(1,c.getCode());
			ps.setString(2,c.getName());
			ps.setString(3,c.getAddress1());
			ps.setString(4,c.getAddress2());
			ps.setString(5,c.getPin());
			ps.setString(6,c.getEmail());
			ps.setString(7,c.getNumber());
			ps.setString(8,c.getContactPerson());
			//ps.setString(9,c.getCreatedDate());
			Date date=new Date();
			ps.setDate(9, new java.sql.Date(date.getTime()));
			ps.setString(10,c.getCreatedBy());
			//date=new Date();
			ps.setDate(11, new java.sql.Date(date.getTime()));
			ps.setString(12, c.getModifiedBy());
			ps.setDate(13, new java.sql.Date(date.getTime()));
			ps.setString(14, c.getAuthorizedBy());
			ps.executeUpdate();
		
		} catch (SQLException e) 
		{
			System.out.println(e);
		}
		finally
		{
			try 
			{
				ps.close();
				conn.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return false;
		
		
	}
	public ArrayList<String> unique() 
	{
		ConnectionI con = f.factoryConnection("ORACLE");
		Connection conn = con.getConnection();
		ResultSet rs=null;
		Statement st=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery(MakerConstant.queryForUnique);
			
			while(rs.next())
			{
				//System.out.println(rs.getString(1));
				arr.add(rs.getString(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		finally{
		try {
			rs.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
		return arr;	
	
		
	}
	public ResultSet forSearch(Customer c,String code)
	{
		ConnectionI con = f.factoryConnection("ORACLE");
		Connection conn = con.getConnection();
		ResultSet rs=null;
		PreparedStatement st=null;
		try
		{
			st=conn.prepareStatement(MakerConstant.queryForPreviousDataInUpdate);
			st.setString(1, code);
			rs=st.executeQuery();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		//problem because in case of search data can't be fetched
		/*finally
		{
			try 
			{
				conn.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		*/
		
		return rs;
	}
	public boolean update(Customer c)
	{
		ConnectionI con = f.factoryConnection("ORACLE");
		Connection conn = con.getConnection();
		PreparedStatement ps=null;
		
		String sql=MakerConstant.queryForUpdate;
		
		try 
		{
			ps=conn.prepareStatement(sql);
			
		ps.setString(1,c.getName());
		ps.setString(2,c.getAddress1());
		ps.setString(3,c.getAddress2());
		ps.setString(4,c.getPin());
		ps.setString(5,c.getEmail());
		ps.setString(6,c.getNumber());
		ps.setString(7,c.getContactPerson());
		//ps.setString(8,c.getCreatedDate());
		Date date=new Date();
		ps.setDate(8, new java.sql.Date(date.getTime()));
		ps.setString(9,c.getCreatedBy());
		ps.setString(10,c.getCode());
		ps.executeUpdate();
		return true;
		} catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try 
			{
				conn.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Customer> forView()
	{
		ConnectionI con = f.factoryConnection("ORACLE");
		Connection conn = con.getConnection();
		Statement st=null;
		ResultSet rs=null;
		String sql=MakerConstant.queryForView;
		
		ArrayList<Customer> arr=new ArrayList<Customer>();
		try 
		{
			st=conn.createStatement();
			rs=st.executeQuery(sql);
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
		try 
		{
		while(rs.next())
		{
			Customer c=new Customer();
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
			
			arr.add(c);
			
		}	
		} catch (SQLException e)
		{
				
				e.printStackTrace();
		}
		finally
		{
			try 
			{
				conn.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return arr;
	}
}
