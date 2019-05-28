package pageObjectModel;


import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{
	WebDriver driver;
	MailPage mailPage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		mailPage = new MailPage(driver);
	}
	
    ArrayList<String> tabs2;
	private By signUp = By.id("auth-portal-register");
	private By email  = By.id("email");
	private By signInBtn = By.id("siteLogin");
	private By continueBtn = By.xpath("//span[@id='continue']");
	private By password = By.id("ap_password");
	private By signInBtn2 = By.id("signInSubmit");
	private By forgetPass = By.xpath("//a[@id='auth-fpp-link-bottom']");
	private By contBtn    = By.xpath("//input[@id='continue']");
	private By appEmail = By.id("ap_email");
	private By tempPassword = By.xpath("//*[@id='authportal-main-section']/div[2]/div/div/div/form/div[2]/div/label/input");
	

	public void clickRegister() {
		driver.findElement(signUp).click();
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getAppEmail() {
		return driver.findElement(appEmail);
	}
	
	public void submitLogin() {
		driver.findElement(signInBtn).click();
	}
	
	public void clickForgetPassword() {
		driver.findElement(forgetPass).click();
	}
	
	public void clickSignIn() {
		driver.findElement(signInBtn2).click();
	}
	
	public void clickTempPassword() {
		driver.findElement(tempPassword).click();
	}
	public void clickContinue() {
		driver.findElement(continueBtn).click();
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public void clickContPass() {
		driver.findElement(contBtn).click();
	}
	
	public void login(String email , String password) {
		this.getSignPage(email);
		this.clickContinue();
		this.getPassword().sendKeys(password);
		this.clickSignIn();
	}
	
	public void forgetPassword(String email) {
		this.getSignPage(email);
		WebElement apmail = this.getAppEmail();
		if(apmail.getText().isEmpty()) {
			apmail.sendKeys(email);
		}
		this.clickContinue();
		this.clickForgetPassword();
		this.clickContPass();
		this.clickTempPassword();
		this.clickContPass();
	}
	
	public void getSignPage(String email) {
		this.getEmail().sendKeys(email);
		this.submitLogin();
		driver.navigate().to("https://www.amazon.co.uk/ap/signin?openid.oa2.scope=auth_code&openid.return_to=https://egypt.souq.com/eg-en/login.php?action=handleAmazonAuth&openid.assoc_handle=amzn_souq_egy&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=Souq_Auth_EG_en&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns.oa2=http%3A%2F%2Fwww.amazon.com%2Fap%2Fext%2Foauth%2F2&openid.oa2.client_id=iba%3Aamzn1.application-oa2-client.f876ccb9a39f4b099ae565bb7c11b0fa&language=en_QS&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.oa2.response_type=code&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&server=%2Fap%2Fsignin%3Fie%3DUTF8&rmrMeStringID=ap_rememeber_me_default_message&marketPlaceId=ARBP9OOSHTCHU&clientContext=h3vZgrI4e6Iyi2mxKUmCKwLlpmR1HA&clientParam=eyJhbGciOiJSU0EtT0FFUCIsImVuYyI6IkEyNTZHQ00ifQ.CDjZbyisHoEZrCEjHQC6dOXKaeHybzNwS7xKrZ514sgEbRWZYGFa0dx7vtjQ-4W5n9m7NghHBQciN6A6Iu7cCGRP_o8nx4TluL3CttvrcFgmATW4ZyD2GVVNpIvDyYxm5YJ4JjVHnV8zfrcmSHZHx1LexuLXL8oFsLRL0bFFoUGfkk3KVVjIkC7An2L57ELAoUMtaTZH3PlWCHSBb-JeUhH5VNhznyRYae5ryrnmfrkPEfxZjNNChDlaChFjs-AF-W5rAHbMMjYyzbGUhCUryg3EWRi5VR8GByHqKyqEi9YoKMELDfvs99cq8bddGBfXIMG-9kSe_mmPJhMat6WaXQ.Xm_pMwcHpWdhmWYe.wOLohhI8eQ8qv5fNw2aj2cU-hFGzhc8dUH7h5W6BcoO3qBe477YnS75TC0byWKQtff5XyYVmSCIpVFzvZFwlaAxuuWXyMXQmWFy7mdHn0ORyW2KQdHHG_UdVcNoaZr-lusR1G3hQ9_veHTXFCU__yW6EOKy4KrXOmcS9dSd79uIODoDw3ga02JqKULG3NJK2OdNyWz-H1ytE4j71R_J9uZe_qZABTd9DlSEj_nNZlGEwwClTWWndHOV9TxASJbp4g5gikq8pZbzdfujZJH1uZfIaS9aeH3ftZ3iPg3mSDvxPcbLT1AkAuC0SaIMyxNu0n1E7-7zS05OLulS8pfjWe6SdIaRzROAVF5A4xKptM5pzBI-BTIVvTbBNfF7CMjYyc0CvbXWBvbba_12GCniWRv46CtdiaevqB-ajMJiKY1HzrGN0oAz4KcYWtmAjDljiDCOVxhuiRLYKqBE0Yldgn7bEbCdoGFG4bJpnLtj6JOyRuok5CH9hyK8tjmBar43bmdpJMkquMIKcczImGEZVx_5Ytxu3HdrlxOK4KHLk_KiIW1HXTNr8u8vk3q03FoaMJV-NoQ3EG1tbtkLgTZNmgVw96HduP6SgOPjOPZCzlWH8qpxznBGXE9vNOKfpz6o.VXESIEGF75MslE-CV_IkNw&ref=SOUQID_UTA_WEB_EG_EN");
	}
}
