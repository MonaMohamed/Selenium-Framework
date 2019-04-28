package main;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class IOSDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("PlatformName", "IOS");
		this.driver = new IOSDriver(getRemoteUrl(),capabilities);
	}

	private URL getRemoteUrl() {
		// TODO Auto-generated method stub
		return null;
	}

}
