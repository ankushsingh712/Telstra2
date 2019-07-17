

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

public class SearchIteamTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchItemPage searchitemPage;

	String sheetName = "Item";

	

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		searchitemPage = new SearchItemPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

	}
	
	@Test(priority = 1)
	public void Testcase4_searchProduct() {
		searchitemPage.searchProduct();
	}

	@Test(priority = 2,enabled =false)
	public void Testcase5_verify_productaddedToCart() {
        System.out.println("title:"+driver.getTitle());
		
		boolean blnResult = searchitemPage.verify_productaddedToCart();
		if (blnResult == true) {
			Assert.assertTrue(blnResult);
		} else {
			Assert.assertTrue(blnResult);
		}
	}

	@AfterClass
	public void tearDown() {
		logout();
		driver.quit();
	}

}
