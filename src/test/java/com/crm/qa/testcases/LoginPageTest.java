package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void Testcase1_loginPageTitleTest(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title = loginPage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!","Login Page assertion failed");
	}

	
	@AfterClass
	public void tearDown(){
		logout();
		driver.quit();
	}
	
	
	
	

}
