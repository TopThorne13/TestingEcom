package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import utilities.Base;
import utilities.ExcelDataReader;
import utilities.ReadProperties;
import utilities.Functions;
import pages.HomePage;
import pages.FacebookPage;
import pages.TwitterPage;
import pages.YoutubePage;

public class HomePageTest extends Base {

	HomePage homepage;

	@Test
	public void testHomePageURL() {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testHomePageURL: Begin Test");

		homepage = new HomePage(getDriver());

		try {

			Assert.assertEquals(homepage.getURL(), ReadProperties.getConfig("applicationURL"));

			Functions.screenshotFullPage(getDriver(), pathSS + "testHomePageURL.png");

			extentTestSS(pathSS + "testHomePageURL.png", "Homepage");

			extentTest().log(Status.PASS, "URL Assert: URL Pass");

		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\nURL Assert: URL Fail");

		}

		extentTest().log(Status.INFO, "testHomePageURL: End Test");

	}

	@Test
	public void testTopOffer() {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testTopOffer: Begin Test");

		homepage = new HomePage(getDriver());

		try {

			homepage.gotoTopOffer();

			extentTestSS(pathSS + "Top Offer Page.png", "Top Offer");

			extentTest().log(Status.PASS, "testTopOffer: Test Pass");

		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestTopOffer: Test Fail");

		}

		extentTest().log(Status.INFO, "testTopOffer: End Test");

	}

}
