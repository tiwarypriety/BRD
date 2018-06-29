package connection;

import java.sql.Connection;

import connection.ConnectionI;

public class MysqlConnection implements ConnectionI{

	
	public Connection getConnection() {
		System.out.println("Mysql Connection");
		return null;
	}

}
