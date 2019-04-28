package main;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	public enum DriverType{
		CHROME, FIREFOX, IE ,SAFARI;
	}
	protected WebDriver driver;
	protected abstract void createWebDriver();
	
	public void quitWebDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}
	
	
	public WebDriver getWebDriver() {
		if(null == driver) {
			createWebDriver();
		}
		return driver;
	}
}
