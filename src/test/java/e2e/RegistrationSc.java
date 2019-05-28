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

public class RegistrationSc {
	DriverManager driverManager;
	WebDriver driver;
	RegistrationPage registrationPage;
	HomePage homePage;
	LoginPage loginPage;
	VerifyEmailPage verifyEmailPage;
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
		registrationPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		verifyEmailPage = new VerifyEmailPage(driver);
	}
	
	@Test(dataProvider="getRandomData")
	public void registerNewUser(String userName, String email,String pass,String code){
		homePage.clickLogin();
		loginPage.clickRegister();
		registrationPage.register(userName, email, pass);
		if(!registrationPage.getAlertNotExist()) {
			String alert = registrationPage.getAlert();
			assertEquals(alert,"There was a problem\n" + "Enter the characters as they are given in the challenge.");
		}else {
			verifyEmailPage.verifyEmail(code);
			assertEquals(verifyEmailPage.getVerifyErrorMessage(),"Invalid code. Please check your code and try again.");
		}
	}
	
	
	@DataProvider
	public Object[][] getRandomData(){
		random = new Random();
		Object[][] userData = new Object[1][4];
		
		userData[0][0] =  random.randomAlphaNumeric();
		userData[0][1] =  random.randomAlphaNumeric()+"@test.com";
		userData[0][2] = "123456";
		userData[0][3] = "123456";
		
		return userData;
	}
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
}
