package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DailyDealsPage{
	WebDriver driver;
	WebDriverWait wait;

	public DailyDealsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 50);
		
	}
	
	private By category = By.xpath("//li[@class='level0 menu-link fmcg-menu-link is-dropdown-submenu-parent opens-right']");
	
	public void getCategory(){
		driver.findElement(category).click();
	}
	
	
}
