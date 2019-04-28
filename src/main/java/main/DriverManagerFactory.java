package main;

import main.DriverManager.*;

public class DriverManagerFactory {
	
	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driverManager;
		
		switch(type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
		case SAFARI:
			driverManager = new SafariDriverManger();
			break;
		default:
			driverManager = new IEDriverManager();
			break;
		}
		return driverManager;
	}

}
