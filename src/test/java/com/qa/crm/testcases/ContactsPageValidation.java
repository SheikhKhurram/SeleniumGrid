package com.qa.crm.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.Base.Base;
import com.qa.crm.pages.NewContactPage;
import com.qa.crm.pages.ContactPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;

public class ContactsPageValidation extends Base 
{
      
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	ContactsPageValidation()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.click_on_contactPage();
	}
	
	
	

	
	
}
