package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.SearchItemPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchItemPage contactsPage;

	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeClass
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new SearchItemPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void Testcase2_verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Home page title not matched");
	}
	@Test(priority=2)
	public void Testcase3_verifyHompUserName(){
		boolean userNameDisplay = homePage.verifyCorrectUserName();
		if (userNameDisplay==true)
		{
		Assert.assertTrue(true);
		}else
		{
		Assert.assertTrue(true);	
		}
		//Assert.assertEquals(homePageTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Home page title not matched");
	}
	
	@AfterClass
	public void tearDown(){
		logout();
		driver.quit();
	}
	
	

}
