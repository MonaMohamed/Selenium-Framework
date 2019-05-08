package pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyEmailPage{
	WebDriver driver;
	
	public VerifyEmailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By codeTextBox = By.name("code");
	private By verifyBtn = By.xpath("//input[@type='submit']");
	private By error = By.xpath("//div[@class='a-section cvf-alert-section cvf-widget-alert-message']");
	
	public void getCode(String code) {
		driver.findElement(codeTextBox).sendKeys(code);
	}
	
	public void clickVerifyEmail(){
		driver.findElement(verifyBtn).click();
	}
	
	public void verifyEmail(String code) {
		this.getCode(code);
		this.clickVerifyEmail();
	}
	
	public String getVerifyErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(error));
		
		return driver.findElement(error).getText();
	}
}
