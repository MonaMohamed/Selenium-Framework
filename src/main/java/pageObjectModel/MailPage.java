package pageObjectModel;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
	
	WebDriver driver;
	ArrayList<String> tabs2;
		
	public MailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.xpath("//input[@type='email']");
	private By nextBtn = By.id("identifierNext");
	private By password = By.xpath("//*[@id='password']/div[1]/div/div[1]/input");
	private By passNext = By.id("passwordNext");
	private By messageRow = By.xpath("//tr[@draggable='true']");
	private By code = By.xpath("//tbody/tr[2]/td/p[2]");
	private By deleteMes = By.xpath("//*[@id=':4']/div[2]/div[1]/div/div[2]/div[3]");
	
	public String getCodeFromMail(String email,String pass) {
	    this.getMailPage(email);
		this.signIn(email,pass);
		this.openResetPasswordMessage();
		String code = this.getCode();
		
		return code;
	}
	
	public void getMailPage(String email) {
		((JavascriptExecutor)driver).executeScript("window.open('https://mail.google.com/','_blank');");
		tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(tabs2.size()-1));
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public void clickNext() {
		driver.findElement(nextBtn).click();
	}
	
	public WebElement getPassword() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		
		return driver.findElement(password);
	}
	
	public void clickPasswordNext() {
		driver.findElement(passNext).click();
	}
	
	public void signIn(String email,String pass) {
		this.getEmail().sendKeys(email);
		this.clickNext();
		tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(tabs2.size()-1));
		this.getPassword().sendKeys(pass);
		this.clickPasswordNext();
	}
	
	public WebElement getMessageRow() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(messageRow));
		
		return driver.findElement(messageRow);
	}
	
	public void openResetPasswordMessage() {
		WebElement messageRow = this.getMessageRow();
		String messageHeader = messageRow.getText().toString();
		assertTrue(messageHeader.contains("Amazon password assistance"));
		messageRow.click();
	}
	
	public void clickDeleteMsg() {
		 WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 100);
		 wait.until(ExpectedConditions.presenceOfElementLocated(deleteMes));

		driver.findElement(deleteMes).click();
	}
	
	public String getCode() {
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(code));
		
		String codeStr = driver.findElement(code).getText().toString();
		this.clickDeleteMsg();
		return codeStr;
	}
}
