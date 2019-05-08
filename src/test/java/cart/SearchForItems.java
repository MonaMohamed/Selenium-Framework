package cart;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import main.DriverManager;
import main.DriverManagerFactory;
import main.DriverManager.DriverType;
import pageObjectModel.*;
import utility.*;

public class SearchForItems {
	
	DriverManager driverManager;
	WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	ExcelUtils excelUtils;
	
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
		searchPage = new SearchPage(driver);
	}
	
	@Test(dataProvider="getSearchData")
	public void searchForItems(String itemTitle , String itemPrice) {
		homePage.searchWithKeyword(itemTitle);
	}
	
	 @DataProvider
	 public Object[][] getSearchData() throws Exception{
		 excelUtils = new ExcelUtils();
	     Object[][] testObjArray = excelUtils.getTableArray("/automationFrame/src/test/java/testData/ItemsData.xlsx","Sheet1");
	     return (testObjArray);
	 }
}
