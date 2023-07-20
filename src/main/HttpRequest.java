package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HttpRequest
{
    String username = "";
    String password = "";
    String ipAddress = "";
	
    
    
	public HttpRequest(String ipAddress, String username, String password)
	{
		this.username = username;
		this.password = password;
		this.ipAddress = ipAddress;
	}
	
	public String fire() throws Exception
	{
		// Encode the username and password in Base64
	    String credentials = username + ":" + password;
	    String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
	
	    // Create the URL object with the IP address
	    URL url = new URL("http://" + ipAddress);
	
	    // Open a connection to the URL
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	
	    // Set the request method to GET
	    connection.setRequestMethod("GET");
	
	    // Set the Authorization header with the encoded credentials
	    connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
	
	    // Get the response code
	    int responseCode = connection.getResponseCode();
	
	    // Read the response from the server
	    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    String line;
	    StringBuilder response = new StringBuilder();
	    while ((line = reader.readLine()) != null) {
	        response.append(line);
	    }
	    reader.close();
	
	    // Print the response
	    System.out.println("Response Code: " + responseCode);
	
	    // Close the connection
	    connection.disconnect();
	    
	    return response.toString();
	}
}
