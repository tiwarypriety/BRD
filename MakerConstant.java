package constantFilePackage;

public class MakerConstant 
{
	// for Oracle Connection...............
			public static final String  connectionStatement="jdbc:oracle:thin:@10.1.50.198:1521:orcl";
			public static final String connectionUserName="sh";
			public static final String connectionPassword="sh";
			public static final String database="Oracle";
	// for User Query......
			public static final String userLoginQuery="select uname, paswd, user3.roleid, user3roles.urole from user3 inner join user3roles on user3.roleid=user3roles.roleid and user3.uname=? and user3.paswd=?";
			
	// for Customer Query...
			public static final String customerInsertQuery="insert into customer876 values(sequence76.nextval,?,?,?,?,?,?,?,?,'A','A',?,?,?,?,?,?)";
			public static final String queryForUnique="select customer_code from customer876";
			public static final String queryForPreviousDataInUpdate="select customer_code, customer_name, customer_address1, customer_address2, customer_pin, email, contact_number, primary_contact_person, created_date, created_by from customer876 where customer_code=?";
			public static final String queryForUpdate="update customer876 set customer_name=?, customer_address1=?, customer_address2=?, customer_pin=?, email=?, contact_number=?, primary_contact_person=?, created_date=?, created_by=? where customer_code=?";
			public static final String queryForView="select customer_code, customer_name, customer_address1, customer_address2, customer_pin, email, contact_number, primary_contact_person, created_date, created_by from customer876";
			
	// for properties
			public static final String propertiesPath="C:/Khushboo_JFiles/MakerBRD/WebContent/prop.properties";
			
	//
			public static final String filePathToUploadInsertFile="c:/Khushboo_JFiles/MakerBRD/WebContent/NewFile.txt";
			public static final String filePathforError="c:/Khushboo_JFiles/MakerBRD/WebContent/logError2.jsp"			;
}
