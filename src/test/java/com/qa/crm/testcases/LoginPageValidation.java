package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.Base.Base;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class LoginPageValidation extends Base
{
 
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageValidation()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test (priority =1)
	public void is_Company_Logo_Displayed()
	{
		Boolean result  = loginPage.companyLogo();
		Assert.assertTrue(result , "Company logo is not displayed");
	}
	
	
	@Test (priority =2)
	public void validating_Login_Page_Title()
	{
		String actualTitle = loginPage.loginPageTitle();
		Assert.assertEquals(actualTitle, "#1 Free CRM software in the cloud for sales and service" , "wrong title is displayed");
		
	}
	
	@Test (priority =3)
	public void checking_for_successfull_Login()
	{
		homePage = loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void teraDown()
	{
		driver.quit();
	}
}
