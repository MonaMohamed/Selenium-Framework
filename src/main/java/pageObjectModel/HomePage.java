package pageObjectModel;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By loginButton = By.id("userNameField_topbar");
	private By dailyDealsLink = By.xpath("//a[contains(text(),'Daily Deals')]");
	private By searchBox = By.id("search_value");
	private By userName = By.id("userNameField_topbar");
	private By allCategoriesLink = By.xpath("//*[@id='megaMenuNav']/li[1]");
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	public void getDailyDeals(){
		driver.findElement(dailyDealsLink).click();
	}
	
	public void getAllCategories() {
		driver.findElement(allCategoriesLink).click();
	}
	
	public WebElement getSearchElement() {
		return driver.findElement(searchBox);
	}
	
	public void searchWithKeyword(String keyword) {
		WebElement search = this.getSearchElement();
		search.sendKeys(keyword);
		search.sendKeys(Keys.ENTER);
	}
	
	public String getUserName() {
		return driver.findElement(userName).getText().toString();
	}
	
	public void switchToParentPage() {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs2.get(0));
	}
}
