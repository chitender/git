package subscription;
import web.Form;

import java.io.IOException;
import java.sql.*;  

public class UserProfileUpdation{
	
public void Mysql(String admin, String campaign) throws IOException, SQLException, ClassNotFoundException{
	final int rowcount;
	final int selection1;
	
	
		
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3327/IDEA_BFS","root","tneu34");
	
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select state from FF_REGISTERED_USERS where MSISDN='" +admin);
	selection1 = rs.getInt(1);
	rowcount = rs.getRow();
	if (rowcount == 0){
		System.out.println("Msisdn New To System, rquesting PFS to subscribe");
	}
	
	else{
		switch (selection1){
		case 1:
			System.out.println("MSISDN already Activated");
			break;
		case 2:
			System.out.println("Msisd in de-activated State, requesting to subscrption");
			String url = ("http://127.0.0.1:11088/testpfsapi/test?cmd=registrationRequest&1=91" +admin + "&2=true&3=" +campaign);
			AdminSubscription paidactivation = new AdminSubscription();
			paidactivation.PaidActivation(url);
			break;
		case 3:
			System.out.println("State description is not available");
			break;
		case 4:
			System.out.println("State description is not available");
			break;
		case 5:
		System.out.println("State description is not available");
		break;
		
		case 6:
			System.out.println("MSISDN is in Grace period");
			break;
		case 7:
			System.out.println("Msisdn is in suspended state");
			break;
		}
		
	
	}
	
	
	}
	
}




	

