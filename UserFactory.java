package daoPackage;

import connectionPackage.ConnectionImp;
import entityPackage.User;

public class UserFactory 
{
	public UserCrudInterface userFactory(String database)
	{
		System.out.println("inside UserFactory");
		if (database.equalsIgnoreCase("oracle"))
			return new UserCrudImplementation();
		else if (database.equalsIgnoreCase("sql"))
			return null;
		else
		return null;
		
	}
}
