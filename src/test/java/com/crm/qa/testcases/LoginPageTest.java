/**
 * This is Login page Test Class
 */
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.LogoutPage;


/**
* This is Login page Test Class
* @author Ankush Singh bhadouria
* test cases should be separated -- independent with each other
* before each test case -- launch the browser and login
* @test -- execute test case
*after each test case -- close the browser
*/
public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	LogoutPage logout;
	
	
	/**
	 * Page setup method to initialize page
	 */
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		logout= new LogoutPage();
	}
	/**
	 * Test case 1 to validate login page
	 */
	@Test(priority=1)
	public void Testcase1_loginPageTitleTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Login Page assertion failed");
	}

	/**
	 * Tear down method to close browser 
	 */
	@AfterClass
	public void tearDown(){
		logout.logout();
		driver.quit();
	}
	
	
	
	

}
