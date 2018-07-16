package servicePackage;

import java.sql.SQLException;


//import daoPackage.UserCrud;
import daoPackage.UserCrudImplementation;
import daoPackage.UserFactory;
import daoPackage.UserCrudImplementation;
import entityPackage.User;


public class UserService 
{
	UserFactory uf=new UserFactory();
	public boolean userServiceMethod(User u) 
	{System.out.println("User Service is working");
		UserCrudImplementation c=new UserCrudImplementation();
			boolean bool=c.select(u);
			
			return bool;
		
		
	}
}
