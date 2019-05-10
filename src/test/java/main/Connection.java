package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import net.sf.corn.converter.ParsingException;
import net.sf.corn.converter.json.JsTypeComplex;
import net.sf.corn.converter.json.JsTypeList;
import net.sf.corn.converter.json.JsonStringParser;


public class Connection {
	
	public HttpURLConnection openConnection(URL url) throws IOException {
	    HttpURLConnection conection = (HttpURLConnection) url.openConnection();
	    return conection;
	}
	
	public int sendGetRequest(HttpURLConnection conection) throws IOException {
		conection.setRequestMethod("GET");
	    int responseCode = conection.getResponseCode();	
	    
	    return responseCode;
	}
	
	public String getResponseData(HttpURLConnection conection) throws IOException {
	    String readLine = null;
		
	    BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
		 StringBuffer response = new StringBuffer();
		
		 while ((readLine = in .readLine()) != null) {
		     response.append(readLine);
		 }
		 in .close();
		 
		 return response.toString();
	}

}
