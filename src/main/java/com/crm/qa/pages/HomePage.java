/**
 * This is Home Page java package
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

/**
 * 
 * @author Ankush Singh Bhadouria
 *
 */

public class HomePage extends TestBase {

	//Page Factory - OR:
	@FindBy(xpath = "//div[contains(text(),'Ankush')]")
//	@CacheLookup
	WebElement userNameLabel;

	
	/**
	 * Initializing the Page Objects:
	 */

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	/**
	 * Function to return Home page title
	 * @return HomepageTitle
	 */
	//
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	/**
	 * Function to validate username displayed on home page
	 * @return boolean status
	 */
	  
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	

}
