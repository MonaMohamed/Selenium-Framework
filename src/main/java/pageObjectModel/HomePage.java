package pageObjectModel;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	private By logout = By.xpath("//ul[@id='userName_topbar']/li[8]");
	
	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
		
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
		//driver.close();
		driver.switchTo().window(tabs2.get(0));
	}
	
	public void logout() {
		WebElement logoutElem = driver.findElement(logout);
		this.clickLogin();
		Actions builder = new Actions(driver);   
		builder.moveToElement(logoutElem).click().build().perform();
	}
}
