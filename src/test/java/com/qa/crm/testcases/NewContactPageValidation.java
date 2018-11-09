package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.Base.Base;
import com.qa.crm.Utility.Utility;
import com.qa.crm.pages.ContactPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.pages.NewContactPage;

public class NewContactPageValidation extends Base
{
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	NewContactPage newContactPage;
	
	NewContactPageValidation()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		Utility.swithFrame_To_Mainpanel();
		contactPage = homePage.click_on_contactPage();
		newContactPage = contactPage.clicking_on_NewContactPage();
	}

	@Test
	public void creatingContact()
	{
		newContactPage.createcontact("Sheikh", "Khurram", "C:\\Users\\Sheik\\Desktop\\Stuck2.mp4", "25-Sep-1993");
		homePage.click_on_contactPage();
		Assert.assertTrue(contactPage.CheckingContactAdded("Sheikh Khurram"), "Contact is not created");
	}
	
	@AfterMethod
	public void teraDown()
	{
		driver.quit();
	}
}
