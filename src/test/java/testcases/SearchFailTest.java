package testcases;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.SearchPage;
import utilities.ReadProperties;
import utilities.Base;
import utilities.ExcelDataReader;

public class SearchFailTest extends Base {

	HomePage homepage;

	SearchPage searchpage;

	@Test(priority = 2)
	public void testProductSearchFail_1() throws IOException {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		String firstProduct = ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testProductSearchFail_1: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery(firstProduct);

		searchpage = new SearchPage(getDriver());

		try {

			searchpage.firstProductSS();

			extentTestSS(pathSS + "First Product SS_" + firstProduct + ".png", "First Product SS_" + firstProduct);

			extentTest().log(Status.PASS, "testProductSearchFail_1: Test Pass");

		} catch (IOException e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestProductSearchFail_1: Test Fail");
		}

		extentTest().log(Status.INFO, "testProductSearchFail_1: End Test");

	}

	@Test(priority = 1)
	public void testProductSearchFail_2() throws IOException {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		String firstProduct = ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testProductSearchFail_2: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery(firstProduct); // Replace

		searchpage = new SearchPage(getDriver());

		try {

			searchpage.filterByBrand(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "additionalInput"));

			searchpage.firstProductSS();

			extentTestSS(pathSS + "First Product SS_" + firstProduct + ".png", "First Product SS_" + firstProduct);

			extentTest().log(Status.PASS, "testProductSearchFail_2: Test Pass");

		} catch (IOException e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestProductSearchFail_2: Test Fail");
		}

		extentTest().log(Status.INFO, "testProductSearchFail_2: End Test");

	}

}
