package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.CustomerCarePage;
import pages.HomePage;
import utilities.Functions;
import utilities.ReadProperties;
import utilities.Base;

public class CustomerHelpTest extends Base {

	HomePage homepage;

	@Test(priority = 1, groups = "Pass")
	public void testCutomerCare() {

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testCutomerCare: Begin Test");

		homepage = new HomePage(getDriver());

		try {

			CustomerCarePage customercarepage = new CustomerCarePage(getDriver());
			
			customercarepage.pageVisible();

			extentTestSS(pathSS + "Customer_Care_Page.png", "Homepage");

			extentTest().log(Status.PASS, "testCutomerCare: Test Pass");

		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\ntestCutomerCare: Test Fail");

		}

		extentTest().log(Status.INFO, "testCutomerCare: End Test");

	}
}
