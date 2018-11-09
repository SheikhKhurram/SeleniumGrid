package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.crm.pages.NewContactPage;

import com.qa.crm.Base.Base;

public class ContactPage extends Base
{
   
	@FindBy(linkText = "Contacts")
	WebElement contacts;
	
	@FindBy(xpath = "//input[@value= 'New Contact']")
	WebElement newContact;
	
	
	ContactPage()
	    {
	    	PageFactory.initElements(driver, this);
	    }
		
	
	public boolean CheckingContactAdded(String contactName)
	{
		return driver.findElement(By.xpath("//form[@id = 'vContactsForm']//td//following::a[@_name = '"+contactName+"']")).isDisplayed();
	}
	
	
	public NewContactPage clicking_on_NewContactPage()
	{
		newContact.click();
		return new NewContactPage();
	}
	
	
	
	
	
	
}
