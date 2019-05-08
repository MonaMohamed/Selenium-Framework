package pageObjectModel;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage{
	WebDriver driver;
	ItemDetailsPage itemDetailsPage;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		itemDetailsPage = new ItemDetailsPage(driver);
	}
	
	private By searchBox = By.id("search_value");
	private By itemBox = By.xpath("//div[@class='column column-block block-list-large single-item']");
	private By itemTitle = By.xpath("//h1[@class='itemTitle']");
	private By itemPrice = By.xpath("//h3[@class='itemPrice']");
	private By itemDetailsLink = By.xpath("//a[@class='view-product-details sPrimaryLink secondary button expand white tiny']");
	private By cartCount = By.xpath("//span[@class='cart-item-count-aj show-mini-cart-aj cart-icon-item-count']");
	
	public WebElement getSearchElement() {
		return driver.findElement(searchBox);
	}
	
	public double getItemPrice(WebElement item) {
		String priceS = item.findElement(itemPrice).getText();
		String[] price = priceS.split(" ");
		return Double.parseDouble(price[0]);
	}
	
	public String getItemTitle(WebElement item) {
		return item.findElement(itemTitle).getText();
	}
	
	public List<WebElement> getSearchResult(){
		return driver.findElements(itemBox);
	}
	
	public void getItemDetailsPage(WebElement item) {
		item.findElement(itemDetailsLink).sendKeys(Keys.chord(Keys.CONTROL,Keys.RETURN));
	}
	
	public String getCartCount() {
		return driver.findElement(cartCount).getText();
	}
	
	public void getItemDetailsWindow() {
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	}
	
	public void addItemToCart() {
		
	}
}
