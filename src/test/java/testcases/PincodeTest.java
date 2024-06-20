package testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.SearchPage;
import pages.ProductPage;
import utilities.ReadProperties;
import utilities.Base;

public class PincodeTest extends Base {

	HomePage homepage;
	
	SearchPage searchpage;
	
	@Test(priority = 1, groups = "Pass")
	public void testPincodePass() {
		
		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testPincodePass: Begin Test");

		homepage = new HomePage(getDriver());
		
		homepage.enterSearchQuery("phone"); //replace
		
		searchpage = new SearchPage(getDriver());
		
		extentTest().log(Status.INFO, "testPincodePass: At Search Page");
		
		searchpage.gotoFirstProduct();
		
		switchTabs();
		
		ProductPage productpage = new ProductPage(getDriver());
		
		productpage.enterPincode("208022"); //replace
		
		extentTest().log(Status.INFO, "testPincodePass: End Test");
		
	}

	@Test(priority = 2, groups = "Fail")
	public void testPincodeFail() {
		
		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testPincodeFail: Begin Test");

		homepage = new HomePage(getDriver());
		
		homepage.enterSearchQuery("phone"); //replace
		
		searchpage = new SearchPage(getDriver());
		
		extentTest().log(Status.INFO, "testPincodeFail: At Search Page");
		
		searchpage.gotoFirstProduct();
		
		switchTabs();
		
		ProductPage productpage = new ProductPage(getDriver());
		
		productpage.enterPincode("10101"); //replace
		
		extentTest().log(Status.INFO, "testPincodeFail: End Test");
		
	}

}
