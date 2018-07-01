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
public class CustomerDAO implements CustomerDAOI
{
	Connection con;
	ConnectionI ci ;
	ResultSet rs ;
	PreparedStatement pst ;
	
	public int insertRecord(Customer c)
	{
		int g = 0;
		try
		{
			ci = new OracleConnection();
			con = ci.getConnection();
			con.setAutoCommit(false);
		String str = "insert into customer_master1909 values(cus_id.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		pst = con.prepareStatement(str);	
	
        pst.setString(1,c.getCode());
        pst.setString(2,c.getName());
        pst.setString(3,c.getAddress1());
        pst.setString(4,c.getAddress2());
        pst.setInt(5,c.getPin_code());
        pst.setString(6,c.getEmail());
        pst.setLong(7,c.getContact_number());
        pst.setString(8,c.getPrimary_contact_person());
        pst.setString(9,c.getRecordStatus());
        pst.setString(10,c.getFlag());
        pst.setString(11,c.getCreateDate());
        pst.setString(12,c.getCreatedBy());
        pst.setString(13,c.getModifiedDate());
        pst.setString(14,c.getModifiedBy());
        pst.setString(15,c.getAuthorizedDate());
        pst.setString(16,c.getAuthorizedBy());               
        g = pst.executeUpdate();		
		}
		catch(SQLException ex)
		{

			System.out.println(ex);
	
		}
		
		return g;		
	}
	
	public void roll() throws SQLException
	{
		System.out.println("rr");
		con.rollback();
		System.out.println("rollbacked");
		
	}
}

