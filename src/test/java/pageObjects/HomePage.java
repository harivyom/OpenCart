package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyaccount1;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	//Action
	public void clickMyAccount()
	{
		lnkMyaccount1.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
}
