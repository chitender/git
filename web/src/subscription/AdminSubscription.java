package subscription;
import web.Form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class AdminSubscription{
	Form form = new Form();
	private final String USER_AGENT = "Mozilla/5.0";
private final String PAID_URL = ("http://127.0.0.1:11088/testpfsapi/test?cmd=registrationRequest&1=91" + form.tf1 + "&2=true&3=" + form.tf6);
private final String DEMO_URL = ("http://127.0.0.1:11088/testpfsapi/test?cmd=registrationCommit&1=91" + form.tf1 + "&2=true&3=" + form.tf6);



public void activation() throws IOException {
	PaidActivation();
	System.out.println("Activation DONE");
	DemoActivation();
	System.out.println("Demo Registration DONE");
}

private void PaidActivation() throws IOException {
	URL obj = new URL(PAID_URL);
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
		System.out.println(response.toString());
	} else {
		System.out.println("GET request not worked");
	}

}

private void DemoActivation() throws IOException {
	URL obj = new URL(DEMO_URL);
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
		System.out.println(response.toString());
	} else {
		System.out.println("GET request not worked");

}
}
}

