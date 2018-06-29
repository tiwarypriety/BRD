package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.ConnectionI;
import pojo.Customer;
import connection.OracleConnection;
public class CustomerDAO implements CustomerDAOI{
	Connection con;
	ConnectionI ci ;
	ResultSet rs ;
	PreparedStatement pst ;
	
	public int insertRecord(Customer c) {
		int g = 0;
		ArrayList<Customer> customer = new ArrayList<Customer>();
		try
		{
			ci = new OracleConnection();
			con = ci.getConnection();
			con.setAutoCommit(false);
		String str = "insert into customer_master19(id,code,name,address1,address2,pin_code,email,contact_number,primary_contact_person,record_status,flag,create_date,created_by,modified_date,modified_by,authorized_date,authorized_by) values(,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		pst = con.prepareStatement(str);	
		
        pst.setString(2,c.getCode());
        pst.setString(3,c.getName());
        pst.setString(4,c.getAddress1());
        pst.setString(5,c.getAddress2());
        pst.setInt(6,c.getPin_code());
        pst.setString(7,c.getEmail());
        pst.setLong(8,c.getContact_number());
        pst.setString(9,c.getPrimary_contact_person());
        pst.setString(10,c.getRecordStatus());
        pst.setString(11,c.getFlag());
        pst.setString(12,c.getCreateDate());
        pst.setString(13,c.getCreatedBy());
        pst.setString(14,c.getModifiedDate());
        pst.setString(15,c.getModifiedBy());
        pst.setString(10,c.getAuthorizedDate());
        pst.setString(10,c.getAuthorizedBy());
                
        g = pst.executeUpdate();
		}
		catch(SQLException ex)
		{
			System.out.println(ex);
		}
		finally
		{
			
			try 
			{
				con.commit();
				con.close();
				
			} catch (SQLException ex) 
			{
				ex.printStackTrace();
			}
		}
		return g;		
	}
}
