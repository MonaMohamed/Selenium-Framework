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

public class GetItemDetails {
	DriverManager driverManager;
	WebDriver driver;
	HomePage homePage;
	AllCategoriesPage allCategoriesPage;
	ItemDetailsPage itemDetailsPage;
	ItemsOfCategoryPage itemsOfCategoryPage;
	
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
		allCategoriesPage = new AllCategoriesPage(driver);
		itemsOfCategoryPage = new ItemsOfCategoryPage(driver);
		itemDetailsPage = new ItemDetailsPage(driver);
	}
	
	@Test
	public void getItemsDetails(){
		homePage.getAllCategories();
		allCategoriesPage.getCategory();
		WebElement item = itemsOfCategoryPage.findSingleItem();
	    String itemTitle = itemsOfCategoryPage.getSindleItemTitle(item);
	    double itemPrice = itemsOfCategoryPage.getitemPrice(item);
	    itemsOfCategoryPage.openItemDetailsPage();
	    String itemTitle2 = itemDetailsPage.getSingleItemTitle();
	    double itemPrice2 = itemDetailsPage.getSingleItemPrice();

	    assertEquals(itemTitle,itemTitle2);
	    assertEquals(itemPrice,itemPrice2);
	}
	
	@AfterMethod
	public void exit() {
		driver.quit();
	}
}
