package testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.SearchPage;
import pages.ProductPage;
import utilities.ReadProperties;
import utilities.Base;
import utilities.ExcelDataReader;

public class PincodeTest extends Base {

	HomePage homepage;

	SearchPage searchpage;

	@Test(priority = 1, groups = "Pass")
	public void testPincodePass() {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testPincodePass: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input"));

		searchpage = new SearchPage(getDriver());

		extentTest().log(Status.INFO, "testPincodePass: At Search Page");

		searchpage.gotoFirstProduct();

		switchTabs();

		ProductPage productpage = new ProductPage(getDriver());

		productpage.enterPincode(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "additionalInput"));

		extentTest().log(Status.INFO, "testPincodePass: End Test");

	}

	@Test(priority = 2, groups = "Fail")
	public void testPincodeFail() {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testPincodeFail: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input"));

		searchpage = new SearchPage(getDriver());

		extentTest().log(Status.INFO, "testPincodeFail: At Search Page");

		searchpage.gotoFirstProduct();

		switchTabs();

		ProductPage productpage = new ProductPage(getDriver());

		productpage.enterPincode(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "additionalInput"));

		extentTest().log(Status.INFO, "testPincodeFail: End Test");

	}

}
