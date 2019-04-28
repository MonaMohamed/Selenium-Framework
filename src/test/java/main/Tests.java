package main;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.DriverManager.DriverType;
import pageObjectModel.LoginPage;

public class Tests {
	DriverManager driverManager;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeClass
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.get("https://app.vapulus.com/business/login");
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.login("admin", "invalid");
		//assertEquals(loginPage.getLoginErrorMessage(),"user name or password isnot valid");
	}
	
	@DataProvider
	public void getData() {
		
	}
}
