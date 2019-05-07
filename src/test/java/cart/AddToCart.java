package cart;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.DriverManager;
import main.DriverManager.DriverType;
import main.DriverManagerFactory;
import pageObjectModel.*;

public class AddToCart {
	DriverManager driverManager;
	WebDriver driver;
	HomePage homePage;
	DailyDealsPage dailyDealsPage;
	CategoriesOfCategoryPage itemsPage;
	ItemsOfCategoryPage itemsOfCategoryPage;
	private int rowIndex = 2;
	private int blockIndex = 2;
	private int numOfItems = 4;

	
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
		dailyDealsPage = new DailyDealsPage(driver);
		itemsPage = new CategoriesOfCategoryPage(driver);
		itemsOfCategoryPage = new ItemsOfCategoryPage(driver);
	}
	
	@Test
	public void addToCart(){
		homePage.getDailyDeals();
	    dailyDealsPage.getCategory();
	    itemsPage.getblock(blockIndex, rowIndex);
	    itemsOfCategoryPage.addItemsToCart(numOfItems);
	}
	
	@AfterMethod
	public void exit() {
		//driver.quit();
	}
}
