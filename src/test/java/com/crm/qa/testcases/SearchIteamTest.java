
/**
 * This is Search Item page Test Class
 */
package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LogoutPage;
import com.crm.qa.pages.SearchItemPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

/**
	* This is Login page Test Class
	* @author Ankush Singh bhadouria
	* test cases should be separated -- independent with each other
	* before each test case -- launch the browser and login
	* @test -- execute test case
	*after each test case -- close the browser
	*/
public class SearchIteamTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	SearchItemPage searchitemPage;
	LogoutPage logout;
	
	String sheetName = "Item";

	
	/**
	 * Page setup method to initialize page
	 */
	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		searchitemPage = new SearchItemPage();
		loginPage = new LoginPage();
		logout= new LogoutPage();
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

	}
	/**
	 * Test case 1 to search product page
	 */	@Test(priority = 1)
	public void Testcase4_searchProduct() {
		// Initiating test data object
		String productSearch=null;
		 Object[][] searchData=TestUtil.getTestData("Item");
		System.out.println("Iteam:-"+searchData[0][1]);
		productSearch= searchitemPage.searchProduct();
		
		
		if(productSearch.contains(searchData[0][1].toString()))
		{
			Assert.assertTrue(true, "Product successfully found");
		}else{
			Assert.assertTrue(false,"Product searched is not corrent ");
		}
		System.out.println("Iteam page title"+productSearch);
	}
	 /**
		 * Test case 2 to validate if product has been added to cart
		 */
	@Test(priority = 2,enabled =false)
	public void Testcase5_verify_productaddedToCart() {
        System.out.println("title:"+driver.getTitle());
		
		boolean blnResult = searchitemPage.verify_productaddedToCart();
		if (blnResult == true) {
			Assert.assertTrue(blnResult,"Product Added to cart");
		} else {
			Assert.assertTrue(blnResult,"could not add product to cart");
		}
	}
	
	/**
	 * Tear down method to close browser 
	 */
	@AfterClass
	public void tearDown() {
		logout.logout();
		//driver.quit();
	}

}
