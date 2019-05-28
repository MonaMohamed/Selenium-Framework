package e2e;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.DriverManager;
import main.DriverManagerFactory;
import main.DriverManager.DriverType;
import pageObjectModel.*;
import utility.*;


public class Login {
	DriverManager driverManager;
	WebDriver driver;
	RegistrationPage registrationPage;
	HomePage homePage;
	LoginPage loginPage;
	MailPage mailPage;
	Random random;
	
	@BeforeClass
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		driver.get("https://egypt.souq.com/eg-en/");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void initializeObjects() {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		mailPage = new MailPage(driver);
	}
	
	@Test(dataProvider="getData",enabled = true)
	public void loginUser(String email,String pass){
		homePage.clickLogin();
		loginPage.login(email, pass);
		String currentUrl = driver.getCurrentUrl().toString();
		String userName   = homePage.getUserName();
		assertEquals(currentUrl,"https://egypt.souq.com/eg-en/");
		assertEquals(userName , "test souq");
	}
	
	
	@Test(dataProvider="getData",enabled=false)
	public void forgetPassword(String email,String pass) {
		homePage.clickLogin();
		loginPage.forgetPassword(email);
		//mailPage.getEmailOpened(email, pass);
	}
	
	@DataProvider
	public Object[][] getData(){
		Object[][] userData = new Object[1][2];
		
		userData[0][0] =  "souqtest2019@gmail.com";
		userData[0][1] = "test@1234";
		
		return userData;
	}
	
	@AfterMethod
	public void exit() {
		//driver.quit();
	}
}
