package subscription;
import web.Form;
import web.Form.thehandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class AdminSubscription{
	private String response1 = null;
	
	private final String USER_AGENT = "Mozilla/5.0";
		
	thehandler form = new Form.thehandler();
	
			




public void PaidActivation(String s) throws IOException {
	URL obj = new URL(s);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	int responseCode = con.getResponseCode();
	System.out.println("GET Response Code :: " + responseCode);
	if (responseCode == HttpURLConnection.HTTP_OK) { // success
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		
		response1 = response.toString();
		System.out.println(response1);
		
		if (response.equals("Success")){
			//update FF_USER_PROFILE
		}
	} 

}

}

