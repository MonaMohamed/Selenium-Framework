package pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By signUp = By.xpath("//a[@class='login_to_register']");
	private By loginButton = By.id("userNameField_topbar");
	private By dailyDealsLink = By.xpath("//a[contains(text(),'Daily Deals')]");
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public void getDailyDeals(){
		driver.findElement(dailyDealsLink).click();
	}
	
}
