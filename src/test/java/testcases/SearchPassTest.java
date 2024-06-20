package testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import utilities.Base;
import utilities.ExcelDataReader;
import utilities.ReadProperties;
import pages.HomePage;
import pages.SearchPage;

public class SearchPassTest extends Base {

	HomePage homepage;

	SearchPage searchpage;

	@Test(priority = 2, groups = "Pass")
	public void testProductSearch_1() throws IOException {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		String firstProduct = ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testProductSearch_1: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery(firstProduct);

		searchpage = new SearchPage(getDriver());

		try {

			searchpage.filterByBrand("Apple");

			searchpage.firstProductSS();

			extentTestSS(pathSS + "First Product SS_" + firstProduct + ".png", "First Product SS_" + firstProduct);

			extentTest().log(Status.PASS, "testProductSearch_1: Test Pass");

		} catch (IOException e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestProductSearch_1: Test Fail");
		}

		extentTest().log(Status.INFO, "testProductSearch_1: End Test");

	}

	@Test(priority = 1, groups = "Pass")
	public void testProductSearch_2() throws IOException {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		String secondProduct = ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testProductSearch_2: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input"));

		searchpage = new SearchPage(getDriver());

		try {

			searchpage.firstProductSS();

			extentTestSS(pathSS + "First Product SS_" + secondProduct + ".png", "First Product SS_" + secondProduct);

			extentTest().log(Status.PASS, "testProductSearch_2: Test Pass");

		} catch (IOException e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestProductSearch_2: Test Fail");
		}

		extentTest().log(Status.INFO, "testProductSearch_2: End Test");

	}
}