/**
 * This is Search item page java package
 */
package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
/**
 * 
 * @author Ankush Singh Bhadouria
 *
 */
public class LogoutPage extends TestBase {
	
	//Page Factory - OR:
		@FindBy(xpath="//*[contains(text(),'Ankush')]")
		WebElement usermenu;
		
		@FindBy(xpath="//a[@href='#']")
		WebElement logOutMenuOption;
		
	public	@FindBy(xpath="//*[contains(text(),'Login & Signup')]")
        WebElement LogoutPageElement;
		
		
		
		//Initializing the Page Objects:
		public LogoutPage(){
			PageFactory.initElements(driver, this);
		}
		
		
		
		/**
		 * Logout method 
		 */
		public void logout()
		{
			       // Clicking on logout
					 Actions action = new Actions(driver);
					 action.moveToElement(usermenu).clickAndHold().build().perform();
					 logOutMenuOption.click(); 
		}
		/**
		 * Logout get page title method 
		 * @return LogoutPage title 
		 */
		public String validateLogoutPageTitle(){
			return driver.getTitle();
		}
		
		
}
