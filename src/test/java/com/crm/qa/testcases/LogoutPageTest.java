package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LogoutPage;

/**
* This is Logout page Test Class
* @author Ankush Singh bhadouria
* test cases should be separated -- independent with each other
* before each test case -- launch the browser and login
* @test -- execute test case
*after each test case -- close the browser
*/
public class LogoutPageTest extends TestBase{
	
	LogoutPage logoutpage;
	
	/**
	 * Page setup method to initialize page
	 */	
	@BeforeClass
	public void setUp() {
		//initialization();
		logoutpage = new LogoutPage();
		
	}
	/**
	 * Test case 1 to to verify home page title
	 */
	
	@Test(priority=1)
	public void Testcase5_verifyLogoutPageElement(){
		Assert.assertTrue(logoutpage.LogoutPageElement.isDisplayed());
		
	}
	

}
