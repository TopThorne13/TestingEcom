package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.ProductPage;
import pages.CartPage;
import pages.SearchPage;
import utilities.Base;
import utilities.ReadProperties;

public class CartTest extends Base {
	
	HomePage homepage;

	@Test(priority = 1, groups = "Cart")
	public void testEmptyCart() throws IOException {

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testEmptyCart: Begin Test");

		homepage = new HomePage(getDriver());
		
		homepage.clickCartButton();
		
		try {
			
			CartPage cartpage = new CartPage(getDriver());
			
			cartpage.emptyCartSS();
			
			extentTest().log(Status.PASS, "testEmptyCart: Test Pass");
			
		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestEmptyCart: Test Fail");

		}

		extentTest().log(Status.INFO, "testEmptyCart: End Test");
		
	}
	
	@Test(priority = 2, groups = "Cart")
	public void testAddedCart() throws IOException {

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testAddedCart: Begin Test");

		homepage = new HomePage(getDriver());
		
		homepage.enterSearchQuery("Phone"); //Replace
		
		try {

			SearchPage searchpage = new SearchPage(getDriver());
			
			searchpage.gotoFirstProduct();
			
			switchTabs();
			
			ProductPage productpage = new ProductPage(getDriver());
			
			productpage.clickAddToCart();
			
			CartPage cartpage = new CartPage(getDriver());
			
			cartpage.cartSS("testAddedCart");
			
			extentTest().log(Status.PASS, "testAddedCart: Test Pass");
			
		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestAddedCart: Test Fail");

		}

		extentTest().log(Status.INFO, "testAddedCart: End Test");
		
	}
	
	@Test(priority = 3, groups = "Cart")
	public void testSaveLaterCart() throws IOException {

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testSaveLaterCart: Begin Test");

		homepage = new HomePage(getDriver());
		
		homepage.enterSearchQuery("Phone"); //Replace
		
		try {

			SearchPage searchpage = new SearchPage(getDriver());
			
			searchpage.gotoFirstProduct();
			
			switchTabs();
			
			ProductPage productpage = new ProductPage(getDriver());
			
			productpage.clickAddToCart();
			
			CartPage cartpage = new CartPage(getDriver());
			
			cartpage.cartSS("testSaveLaterCart_added");
			
			cartpage.clickSaveForLater();
			
			cartpage.cartSS("testSaveLaterCart_removed");
			
			cartpage.clickMoveToCart();
			
			cartpage.cartSS("testSaveLaterCart_moved");
			
			extentTest().log(Status.PASS, "testSaveLaterCart: Test Pass");
			
		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestSaveLaterCart: Test Fail");

		}

		extentTest().log(Status.INFO, "testSaveLaterCart: End Test");
		
	}
	
}
