package pageObjectModel;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemsOfCategoryPage{
	WebDriver driver;
	
	public ItemsOfCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By addToCartBtn = By.xpath(".//ul[@class='body no-bullet']/li[6]");
	private By itemCol = By.xpath("//div[@class='column column-block block-grid-large     ']");
	private By singleItem = By.xpath("//div[@class='column column-block block-grid-large single-item']");
	private By singleItemTitle = By.xpath(".//h6[@class='title itemTitle']");
	private By itemPrice = By.xpath(".//h5[@class='price']/span[1]");
	private By itemTitel = By.xpath(".//h6[@class='title']");
	private By cartIcon = By.id("mini-cart_topbar");
	private By notifiy = By.xpath("//span[@class='notificationItemTitle item-title']");
	private By cartItems = By.xpath("//div[@id='cartDrop_topbar']/ul");
	private By cartElement = By.tagName("li");
	private By itemQty = By.xpath(".//span[@class='small-cart-qty']");
	private By grandTotal = By.xpath("//div[@id='cartDrop_topbar']/div/h4");
	private By quntity = By.xpath(".//input[@id='quantity']");
			
	public double getitemPrice(WebElement item){
		try{
			String priceS = item.findElement(itemPrice).getText();
	        String[] arrOfStr = priceS.split(" ", 2); 

	        return Double.parseDouble(arrOfStr[0]);
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	public WebElement findSingleItem() {
		return driver.findElement(singleItem);
	}
	
	public String getSindleItemTitle(WebElement item) {
		return item.findElement(singleItemTitle).getText();
	}
	
	public String getItemTitle(WebElement item) {
		return item.findElement(itemTitel).getText();
	}
	
	public void openItemDetailsPage() {
		driver.findElement(singleItemTitle).click();
	}
	
	public List<WebElement> getItemsList(){
		List<WebElement> itemsList= driver.findElements(itemCol);
		return itemsList;
	}
	
	public WebElement getItemCol(int itemIndex){
		return this.getItemsList().get(itemIndex); 
	}
	
	public void clickAddToCartBtn(WebElement item) {
		Actions actions = new Actions(driver);
		actions.moveToElement(item).build().perform();
		item.findElement(addToCartBtn).click();
	}
	
	public void addItemsToCart(int itemsCount) {		
			List<WebElement> items = this.getItemsList();
			for(int i=0 ; i < itemsCount ; i++) {
				WebElement item = items.get(i);
				
				this.clickAddToCartBtn(item);
				
				WebDriverWait wait = new WebDriverWait(driver, 100);
				wait.until(ExpectedConditions.visibilityOfElementLocated(quntity));
			}
	}

	public void openCart() {
		WebDriverWait wait = new WebDriverWait(driver, 60); 
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(notifiy));
		driver.findElement(cartIcon).click();
	}
	
	public List<WebElement> getCartItems() {
		WebDriverWait wait = new WebDriverWait(driver, 60); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
		WebElement cart = driver.findElement(cartItems);
		List<WebElement> items = cart.findElements(cartElement);
		
		return items;
	}
	
	public String getItemQtyElement(WebElement item) {
		return item.findElement(itemQty).getText();
	}
	
	public String sumPrice(int itemsCount) {
		double sumPrices =0 ;
		
		List<WebElement> items = this.getItemsList();
		for(int i=0 ; i < itemsCount ; i++) {
			WebElement item = items.get(i);
			double price = this.getitemPrice(item);
			sumPrices += price;
		}
		return Double.toString(sumPrices);
	}
	
	public String getGrandTotal() {
		String[] total = driver.findElement(grandTotal).getText().split(" ");
		return total[2]; 
	}
	
	public int getCartSize() {
		return this.getCartItems().size();
		
	}
	
}
