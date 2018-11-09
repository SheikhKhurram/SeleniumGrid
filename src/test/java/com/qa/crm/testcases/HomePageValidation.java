package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.Base.Base;
import com.qa.crm.Utility.Utility;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class HomePageValidation extends Base
{
 
	LoginPage loginPage;
	HomePage homePage;
	
	HomePageValidation()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void validating_userName_in_HomePage()
	{
		Utility.swithFrame_To_Mainpanel();
		Assert.assertTrue(homePage.verify_username_in_homePage() , "Username is not matching");
	}
	
	@Test(priority = 2)
	public void validating_Homepage_Title()
	{
		String actualTitle = homePage.homepage_Title();
		Assert.assertEquals(actualTitle, "CRMPRO" , "Homepage title is not matching");
	}
	
	
	
	@AfterMethod
	public void teraDown()
	{
		driver.quit();
	}
	
}
