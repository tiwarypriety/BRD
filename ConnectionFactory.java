
package factory;

import connection.ConnectionI;
import connection.MysqlConnection;
import connection.OracleConnection;

public class ConnectionFactory 
{
static ConnectionI getConnectionMethod(String str)
{
	if(str.equalsIgnoreCase("mysql"))
	{
		return new MysqlConnection();
	}
	else
	{
		return new OracleConnection();
	}
}


}
