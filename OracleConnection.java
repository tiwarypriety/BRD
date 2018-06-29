package connection;

import java.sql.Connection;
import java.sql.DriverManager;

import connection.ConnectionI;

public class OracleConnection implements ConnectionI {

	Connection con = null;
	@Override
	public Connection getConnection() {
		try
		{		
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl","sh","sh");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}
