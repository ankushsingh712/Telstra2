package com.crm.qa.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class SearchItemPage extends TestBase {

	@FindBy(xpath = "//input[@name='q']")
	WebElement searchInput;
	
	@FindBy(xpath = "//*[@class='col col-6-12']/button")
	WebElement btnAddToCart;
	
	// Initiating test data object
	Object[][] searchData=TestUtil.getTestData("Item");
	WebDriverWait wait = new WebDriverWait(driver,15);
	
	
	// Initializing the Page Objects:
	public SearchItemPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		
		return searchInput.isDisplayed();
	}
	
	public void searchProduct()
	{
		searchData=TestUtil.getTestData("Item");
		System.out.println("data "+searchData[0][0].toString());
		System.out.println("data "+searchData[0][1].toString());
		//WebElement searchinputbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']]")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchInput.sendKeys(searchData[0][0].toString());
		searchInput.sendKeys(Keys.RETURN);
		//Selecting product by name
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement productName = driver.findElement(By.xpath("//div[contains(text(),'"+searchData[0][1].toString()+"')]"));
		 
		// WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+searchData[0][1].toString()+"')]")));
		 if (!productName.isDisplayed())
		 {
			driver.findElement(By.xpath("//nav[@class='_1ypTlJ']/descendant::a[2]")).click();
			 // nav[@class='_1ypTlJ']/descendant::a[2]
		 }else
		 {productName.click();}
		 // Switch window 
		  Set<String> winHandles = driver.getWindowHandles();
		  System.out.println("windowcount:"+winHandles.size());
		  for(String handle: winHandles){
	        
			  if (driver.getTitle().contains(searchData[0][1].toString()))
			  {
				  System.out.println("Title of the new window: " +  driver.getTitle()); 
				  break;
			  }
	          driver.switchTo().window(handle);
	          
	      }
		 
		  btnAddToCart.click();
		
		  driver.switchTo().defaultContent(); 
	}
	
	public boolean verify_productaddedToCart()
	{
		boolean blnStatus=false;
				
		System.out.println("data "+searchData[0][1].toString());
		System.out.println("PageTitle "+driver.getTitle());
				
		if(driver.findElement(By.xpath("//a[contains(text(),'"+searchData[0][1].toString()+"')]")).isDisplayed())
			{
			System.out.println("add to cart "+blnStatus);
			blnStatus=true;
		}else
		{
			System.out.println("add to cart "+blnStatus);
			blnStatus=false;
		}
		return blnStatus;
	}
	
	

}
