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

public class CompareProductsTest extends Base {

	HomePage homepage;

	SearchPage searchpage;

	@Test(priority = 2)
	public void testProductComparison() throws IOException {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testProductComparison: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input"));

		searchpage = new SearchPage(getDriver());

		try {

			searchpage.clickFirstNButtons(4);

			searchpage.comparisonChartSS();

			extentTestSS(Base.pathSS + "Comparison Chart.png", "Comparison Chart");

			extentTest().log(Status.PASS, "testProductComparison: Test Pass");

		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestProductComparison: Test Fail");
		}

		extentTest().log(Status.INFO, "testProductComparison: End Test");

	}
}
