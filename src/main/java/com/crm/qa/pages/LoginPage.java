/**
 * This is Login page java package
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

 public class LoginPage extends TestBase{
	
	
	//Page Factory - OR:
	
	@FindBy(xpath="//span[contains(text(),'Enter Email')]//preceding::input[@type='text'][1]")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Login')]//following::button")
	WebElement loginBtn;
	
	
	
	
	/**
	 * Initializing the Page Objects:
	 */
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Function to return login page title
	 * @return loginPageTitle
	 */
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	
	/**
	 * Function for login 
	 * @param username
	 * @param password
	 * @return HomePageObject
	 */
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	 
		return new HomePage();
	}
	
}
