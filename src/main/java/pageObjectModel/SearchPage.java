package pageObjectModel;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage{
	WebDriver driver;
	ItemDetailsPage itemDetailsPage;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		itemDetailsPage = new ItemDetailsPage(driver);
	}
	
    ArrayList<String> tabs2;
	private By searchBox = By.id("search_value");
	private By itemBox = By.xpath("//div[@class='column column-block block-list-large single-item']");
	private By itemTitle = By.xpath("//h1[@class='itemTitle']");
	private By itemPrice = By.xpath("//h3[@class='itemPrice']");
	private By itemDetailsLink = By.xpath("//a[@class='view-product-details sPrimaryLink secondary button expand white tiny']");
	private By cartCount = By.xpath("//span[@class='cart-item-count-aj show-mini-cart-aj cart-icon-item-count']");
	
	public String getSearchText() {
		return driver.findElement(searchBox).getText();
	}
	
	public String getItemPrice(WebElement item) {
		String priceS = item.findElement(itemPrice).getText();
		String[] price = priceS.split(" ");
		return price[0];
	}
	
	public String getItemTitle(WebElement item) {
		return item.findElement(itemTitle).getText();
	}
	
	public List<WebElement> getSearchResult(){
		return driver.findElements(itemBox);
	}
	
	public WebElement findCertainElement(String title) {
		List<WebElement> allElements = this.getSearchResult();
		for(int i=0; i < allElements.size();i++) {
			String searchedTitle = allElements.get(i).findElement(itemTitle).getText();
			if(title.equals(searchedTitle)) {
				return allElements.get(i);
			}
		}
		return null;
	}
	
	public void getItemDetailsPage(WebElement item) {
		item.findElement(itemDetailsLink).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
	}
	
	public String getCartCount() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartCount));
		return driver.findElement(cartCount).getText();
	}
	
	public void addItemToCart() {
		tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		itemDetailsPage = new ItemDetailsPage(driver);
		itemDetailsPage.addToCart();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
}
