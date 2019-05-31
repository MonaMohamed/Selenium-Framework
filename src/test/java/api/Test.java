package api;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import main.Connection;
import net.sf.corn.converter.ParsingException;


public class Test {
	Connection connectionClass;
	
	@org.testng.annotations.BeforeMethod
	public void init() {
		connectionClass = new Connection();
	}
	
	@org.testng.annotations.Test
	public void getCountriesList() throws IOException, ParsingException {
	    
		URL url = new URL("http://services.groupkt.com/country/get/all");
	    
	    //open connection
	    HttpURLConnection conection = connectionClass.openConnection(url);
	    
	    //Set Get Request
	    int responseCode = connectionClass.sendGetRequest(conection);
	    assertEquals(responseCode, HttpURLConnection.HTTP_OK);
	    //Get response Data
	    String response = connectionClass.getResponseData(conection);
	    boolean res = response.contains("Total [249] records found.")? true:false;
	    // print result
	    assertTrue(res);
	}
	
	@org.testng.annotations.Test(dataProvider = "getRegions")
	public void getCountriesCode(String code) throws IOException {
		URL url = new URL("http://services.groupkt.com/country/get/iso2code/"+code);
		//open connection
	    HttpURLConnection conection = connectionClass.openConnection(url);
	    
	    //Set Get Request
	    int responseCode = connectionClass.sendGetRequest(conection);
	    assertEquals(responseCode, HttpURLConnection.HTTP_OK);
	    //Get response Data
	    String response = connectionClass.getResponseData(conection);
	    boolean res = response.contains("Country found matching code " + "[" + code + "].")? true:false;
	    // print result
	    assertTrue(res);
	}
	
	@org.testng.annotations.DataProvider
	public Object[] getRegions() {
		Object[] regions = {"US","DE","GB"};
		
		return regions;
	}
	
}
