package e2e;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class SearchForItems {
	
	DriverManager driverManager;
	WebDriver driver;
	HomePage homePage;
	SearchPage searchPage;
	ItemDetailsPage itemDetailsPage;
	ShoppingCartPage shoppingCartPage;
	ExcelUtils excelUtils;
	private int cartCount=0;
	private String price , title;
	
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
		shoppingCartPage = new ShoppingCartPage(driver);
	}
	
	@Test(dataProvider="getSearchData")
	public void searchForItems(String itemTitle , String itemPrice) {
		try {
			homePage.searchWithKeyword(itemTitle);
			WebElement item = searchPage.findCertainElement(itemTitle);
			title = searchPage.getItemTitle(item);
			price = searchPage.getItemPrice(item);
			assertEquals(title,itemTitle);
			assertEquals(price,itemPrice);
			searchPage.getItemDetailsPage(item);
			searchPage.addItemToCart();
			String cartCountS = shoppingCartPage.getCartCount();
			String totalPriceS = shoppingCartPage.getCartTotal();
			cartCount= cartCount + 1;
			assertEquals(cartCountS," ("+Integer.toString(cartCount)+")");
			searchPage.clearSearchBox();
		}catch(NumberFormatException ex) {
			System.out.print(ex.getMessage());
		}
	}
	
	 @DataProvider
	 public Object[][] getSearchData() throws Exception{
		 excelUtils = new ExcelUtils();
	     Object[][] testObjArray = excelUtils.getExcelData("/"+System.getProperty("user.dir")+"/src/test/java/testData/ItemsData.xlsx","Sheet1");
	    
	     return testObjArray;
	 }
	 
	 @AfterClass
	 public void exit() {
		driver.quit();
	}
}
