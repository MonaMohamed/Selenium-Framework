package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By userNameTextBox = By.id("vapulusId");
	private By passwordTextBox = By.id("password");
	private By loginButton = By.xpath("//button[@class='btn btn--orange']");
	private By errorMessage = By.className("error-alert");
	
	public void login(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLogin();
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void setPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}

	public void setUserName(String userName) {
		driver.findElement(userNameTextBox).sendKeys(userName);
	}

	public String getLoginErrorMessage() throws InterruptedException {
		String error = driver.findElement(errorMessage).getText();
		return error;
	}
}
