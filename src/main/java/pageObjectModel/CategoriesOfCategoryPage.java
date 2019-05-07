package pageObjectModel;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoriesOfCategoryPage{
	WebDriver driver;
	
	public CategoriesOfCategoryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By itemsList = By.xpath("//div[@class='row campaigns-grid']");
	private By block = By.xpath("//div[@class='small-6 medium-3 columns']");
	
	public List<WebElement> listItems(){
		return driver.findElements(itemsList);
	}
	
	public WebElement getblockRow(int rowIndex){
		List<WebElement> itemsList = this.listItems();
		return itemsList.get(rowIndex);
	}
	
	public void getblock(int blockIndex,int rowIndex) {
		WebElement row = this.getblockRow(rowIndex);
		row.findElements(block).get(blockIndex).click();
	}
	
	
}
