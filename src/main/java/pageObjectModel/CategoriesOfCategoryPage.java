package pageObjectModel;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategoriesOfCategoryPage{
	WebDriver driver;
	
	public CategoriesOfCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By itemsList = By.xpath("//div[@class='row campaigns-grid']");
	private By block = By.xpath(".//div[@class='small-6 medium-3 columns']");
	
	public List<WebElement> listItems(){
		return driver.findElements(itemsList);
	}
	
	public void getblock(int blockIndex,int rowIndex) {
		int i = 0,j=0;
		List<WebElement> rows = this.listItems();
		for(WebElement row: rows) {
			if(i==rowIndex) {
				List<WebElement> blocks = row.findElements(block);
				for(WebElement block : blocks) {
					if(blockIndex == j) {
						Actions action = new Actions(driver);
						action.moveToElement(block).click().perform();
					}
					j++;
				}
			}
			i++;
		}
	}
	
	
}
