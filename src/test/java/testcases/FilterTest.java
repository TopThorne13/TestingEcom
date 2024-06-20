package testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.SearchPage;
import utilities.Base;
import utilities.ReadProperties;

public class FilterTest extends Base {

	HomePage homepage;

	SearchPage searchpage;

	@Test(priority = 2, groups = "Filter")
	public void testFilterMin() throws IOException {

		String firstProduct = "Book"; // replace

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testFilterMin: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery("Book"); // Replace

		searchpage = new SearchPage(getDriver());

		try {

			searchpage.selectSecondMin();

			searchpage.firstProductSS();

			extentTestSS(pathSS + "First Product SS_" + firstProduct + ".png", "First Product SS_" + firstProduct);

			extentTest().log(Status.PASS, "testFilterMin: Test Pass");

		} catch (IOException e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestFilterMin: Test Fail");
		}

		extentTest().log(Status.INFO, "testFilterMin: End Test");

	}
	
	@Test(priority = 1, groups = "Filter")
	public void testFilterMax() throws IOException {

		String firstProduct = "Pen"; // replace

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testFilterMax: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.enterSearchQuery("Book"); // Replace

		searchpage = new SearchPage(getDriver());

		try {

			searchpage.selectSecondMax();

			searchpage.firstProductSS();

			extentTestSS(pathSS + "First Product SS_" + firstProduct + ".png", "First Product SS_" + firstProduct);

			extentTest().log(Status.PASS, "testFilterMax: Test Pass");

		} catch (IOException e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestFilterMax: Test Fail");
		}

		extentTest().log(Status.INFO, "testFilterMax: End Test");

	}
	
}
