package pageObjectModel;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemDetailsPage{
	WebDriver driver;
	ShoppingCartPage shoppingCartPage;
	
	public ItemDetailsPage(WebDriver driver) {
		this.driver = driver;
		shoppingCartPage = new ShoppingCartPage(driver);
	}
	
	private By searchBox = By.id("search_value");
	private By itemTitle = By.xpath("//div[@class='small-12 columns product-title']/h1");
	private By itemPrice = By.xpath("//h3[@class='price is sk-clr1']");	
	
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
		shoppingCartPage.addToCart();
	}
	
}
