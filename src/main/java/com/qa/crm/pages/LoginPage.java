package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.Base.Base;

public class LoginPage extends Base
{
   //PageFactory----OR (Object repository)
	@FindBy(name = "username")
    WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//img[@class = 'img-responsive']")
	WebElement logo;
	
	//Initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public HomePage loginToApplication(String us , String psw)
	{
		username.sendKeys(us);
		password.sendKeys(psw);
		submitButton.click();
		return new HomePage();
	}
	
	public String loginPageTitle ()
	{
		return driver.getTitle();
	}
	
	public boolean companyLogo()
	{
		return logo.isDisplayed();
	}
	
}
