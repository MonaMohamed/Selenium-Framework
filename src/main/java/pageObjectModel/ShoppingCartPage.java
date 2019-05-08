package pageObjectModel;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage{
	WebDriver driver;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchBox = By.id("search_value");
	private By itemTitle = By.xpath("//div[@class='small-12 columns product-title']/h1");
	private By itemPrice = By.xpath("//h3[@class='price is sk-clr1']");	
	private By addToCartBtn = By.xpath("//form[@id='addItemToCart']");
	
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
	
	public void addToCart(){
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
		 driver.findElement(addToCartBtn).click();
		 driver.close();
		 driver.switchTo().window(tabs2.get(0));
	}
	
	
	public void getCartCount() {
		
	}
}
