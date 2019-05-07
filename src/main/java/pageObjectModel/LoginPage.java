package pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By signUp = By.id("auth-portal-register");

	public void clickRegister() {
		driver.findElement(signUp).click();
	}
		
}
