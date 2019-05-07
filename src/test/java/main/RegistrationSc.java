package main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.DriverManager.DriverType;
import pageObjectModel.*;
import utility.ExcelUtils;

public class RegistrationSc {
	DriverManager driverManager;
	WebDriver driver;
	RegistrationPage registrationPage;
	HomePage homePage;
	LoginPage loginPage;
	private String sTestCaseName;
	private int iTestCaseRow;

	
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
	}
	
	@Test
	public void registerNewUser(){
		homePage.clickLogin();
		loginPage.clickRegister();
		registrationPage.register("mona", "123456", "test@test.com");
	}
	
//	 @DataProvider
//	  public Object[][] Authentication() throws Exception{
//		    // Setting up the Test Data Excel file
//		 	ExcelUtils.setExcelFile("/automationFrame/src/test/java/testData/RegistrationData.xlsx","Sheet1");
//		 	
//		 	sTestCaseName = this.toString();
//		  	// From above method we get long test case name including package and class name etc.
//		  	// The below method will refine your test case name, exactly the name use have used
//		  	sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
//		   
//		  	// Fetching the Test Case row number from the Test Data Sheet
//		    // Getting the Test Case name to get the TestCase row from the Test Data Excel sheet
//		 	iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,0);
//
//		    Object[][] testObjArray = ExcelUtils.getTableArray("/automationFrame/src/test/java/testData/TestData.xlsx","Sheet1",iTestCaseRow);
//		    return (testObjArray);
//	 }
	
	@AfterMethod
	public void exit() {
		//driver.quit();
	}
}
