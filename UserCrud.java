package daoPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectionPackage.ConnectionI;
import connectionPackage.Factory;
import constantFilePackage.MakerConstant;
import entityPackage.User;


public class UserCrud {
	Factory f = new Factory();

	public boolean select(User u) throws SQLException
	{
		ConnectionI con = f.factoryConnection(MakerConstant.database);
		Connection conn = con.getConnection();
		
		PreparedStatement ps = null;
		
		String sql = MakerConstant.userLoginQuery;
		
		ResultSet rs = null;
		int n=0;
		
		try 
		{
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getName());
			
			ps.setString(2, u.getPassword());
			n=ps.executeUpdate();System.out.println(n);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(rs!=null && n!=0)
		{
			while(rs.next())
			{
				u.setRole(rs.getString(4));	
			}
			return true;
		}
		else
			return false;
		
		
		
	}
}
