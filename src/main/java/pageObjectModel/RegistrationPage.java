package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By signUp = By.xpath("//a[@class='login_to_register']");
	private By loginButton = By.xpath("//button[@class='truncate userNameField']");
	private By userNameTextBox = By.id("ap_customer_name");
	private By emailTextBox = By.id("ap_email");
	private By passwordTextBox = By.name("password");
	private By passCheckBox = By.name("passwordCheck");
	private By submitBtn = By.id("continue");
	private By errorMessage = By.className("error-alert");
	private By alertMessage = By.xpath("//div[@class='a-box-inner a-alert-container']");
	
	public void register(String userName, String email,String password) {
		this.setUserName(userName);
		this.setEmail(email);
		this.setPassword(password);
		this.checkPassword(password);
		this.clickRegister();
	}

	public void setUserName(String userName) {
		driver.findElement(userNameTextBox).sendKeys(userName);
	}
	
	public void setEmail(String email) {
		driver.findElement(emailTextBox).sendKeys(email);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordTextBox).sendKeys(password);
	}
	
	public void checkPassword(String password) {
		driver.findElement(passCheckBox).sendKeys(password);
	}
	
	public void clickRegister() {
		driver.findElement(submitBtn).click();
	}
	
	public String getLoginErrorMessage() throws InterruptedException {
		return driver.findElement(errorMessage).getText();
		
	}
	
	public String getAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
		return driver.findElement(alertMessage).getText();
	}
	
	public boolean getAlertNotExist() {
		return driver.findElements(alertMessage).isEmpty();
	}
}
