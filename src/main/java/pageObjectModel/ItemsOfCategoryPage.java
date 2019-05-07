package pageObjectModel;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ItemsOfCategoryPage{
	WebDriver driver;
	
	public ItemsOfCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By addToCartBtn = By.xpath("//button[@data-track-name='ajaxAddToCart']");
	private By itemCol = By.xpath("//div[@class='column column-block block-grid-large     ']");
	private By itemPrice = By.xpath("//h5[@class='price']/span[1]");
	
	
	public double getitemPrice(WebElement item){
		try{
			String priceS = item.findElement(itemPrice).getText();
	        String[] arrOfStr = priceS.split(" ", 2); 

	        return Double.parseDouble(arrOfStr[0]);
		}catch(NumberFormatException e) {
			System.out.println(e);
		}
		return 0;
	}
		
	
	public List<WebElement> getItemsList(){
		return driver.findElements(itemCol);
	}
	
	public WebElement getItemCol(int itemIndex){
		return this.getItemsList().get(itemIndex); 
	}
	
	public void clickAddToCartBtn(WebElement item) {
		Actions actions = new Actions(driver);
		actions.moveToElement(item).click().perform();
		
		item.findElement(addToCartBtn).click();
	}
	
	public void addItemsToCart(int itemsCount) {
		double sumPrices = 0;
		int index=0;
		
		List<WebElement> items = this.getItemsList();
		for(WebElement item : items) {
			if(itemsCount == index) break;
			sumPrices = sumPrices + this.getitemPrice(item);
			this.clickAddToCartBtn(item);
			index++;
		}
		
	}
}
