package com.qa.crm.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.crm.Base.Base;
import com.qa.crm.Utility.Utility;

public class NewContactPage extends Base
{
    @FindBy(id = "first_name")
    WebElement firstname;

    
    @FindBy(id = "surname")
    WebElement lastname;

    @FindBy(id = "image_file")
    WebElement image_file;
    
    @FindBy(xpath = "//form[@id= 'contactForm']//child::tr[8]//input[@value= 'Lookup']")
    WebElement companyname;
    
    @FindBy(xpath = "//input[@name = 'receive_email' and @value = 'N']")
    WebElement receiveEmail;
    
    @FindBy(id = "fieldId_birthday")
    WebElement birthday;
    
    @FindBy(xpath = "//input[@value= 'Load From Company']//following-sibling::input[@value= 'Save']")
    WebElement saveButton;
    
    @FindBy(id = "search")
    WebElement companySearch;
    
    @FindBy(xpath = "//input[@value = 'Search']")
    WebElement searchButtonOfComapany;
    
    NewContactPage()
    {
    	PageFactory.initElements(driver, this);
    }
	
    
    public void createcontact(String firstName , String lastName , String img , String dateOfBirth)
    {
    	firstname.sendKeys(firstName);
    	lastname.sendKeys(lastName);
    	image_file.sendKeys(img);
    	enteringCompanyName();
    	Utility.swithFrame_To_Mainpanel();
    	receiveEmail.click();
    	enteringDateOfBirth(dateOfBirth);
    	saveButton.click();
    }
    
    public void enteringCompanyName()
    {
    	String parentWindow = driver.getWindowHandle();
    	companyname.click();
          for (String windows : driver.getWindowHandles())
          {
        	  if (!parentWindow.equalsIgnoreCase(windows))
        	  {
        		  driver.switchTo().window(windows);
        		  companySearch.sendKeys("mycompany");
        		  searchButtonOfComapany.click();
        		  driver.findElement(By.linkText("mycompany")).click();
        		 
        	  }
          }
          driver.switchTo().window(parentWindow);
    }
    
    public void enteringDateOfBirth(String dateVal)
    {
    	        JavascriptExecutor js = ((JavascriptExecutor)driver);
    	        js.executeScript("arguments[0].setAttribute('value' , '"+dateVal+"');", birthday);
    }
}
