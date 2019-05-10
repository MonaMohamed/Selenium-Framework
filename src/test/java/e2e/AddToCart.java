package e2e;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	private int rowIndex = 1;
	private int blockIndex = 1;
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
	    itemsOfCategoryPage.openCart();
	    int cartSize = itemsOfCategoryPage.getCartSize();
	    String total = itemsOfCategoryPage.sumPrice(numOfItems);
	    String grandTotal = itemsOfCategoryPage.getGrandTotal();
	    
	    assertEquals(cartSize,numOfItems);
	    assertEquals(total+'0',grandTotal);
	}
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
}
