package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllCategoriesPage{
	WebDriver driver;
	WebDriverWait wait;

	public AllCategoriesPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 50);
		
	}
	
	private By toyCategory = By.xpath("//*[@id=\"content-body\"]/div/div/div[2]/div/div[2]/div[10]/ul/li[3]/a");
	
	public void getCategory(){
		driver.findElement(toyCategory).click();
	}
	
	
}
