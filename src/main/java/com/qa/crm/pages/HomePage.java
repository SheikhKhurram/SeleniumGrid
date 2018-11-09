package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.Base.Base;
import com.qa.crm.Utility.Utility;

public class HomePage extends Base
{
      
	@FindBy(xpath= "//td[contains(text() , 'User: sheikh khurram')]")
	WebElement username;
	
    
	@FindBy(xpath = "//a[contains(text() , 'Contacts')]")
	WebElement contact;
	
    
	@FindBy(xpath = "//a[contains(text() , 'Deals')]")
	WebElement deals;
	
    
	@FindBy(xpath = "//a[contains(text() , 'Tasks')]")
	WebElement tasks;
	
	public HomePage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public boolean verify_username_in_homePage()
	{
		return username.isDisplayed();
	}
	
	public String homepage_Title()
	{
		return driver.getTitle();
	}
	
	public ContactPage click_on_contactPage()
	{
		contact.click();
		
		return new ContactPage();
	}
	
	public DealsPage click_on_dealsPage()
	{
		deals.click();
		
		return new DealsPage();
	}
	
	public TasksPage click_on_tasksPage()
	{
		tasks.click();
		
		return new TasksPage();
	}
	
	
	
}
