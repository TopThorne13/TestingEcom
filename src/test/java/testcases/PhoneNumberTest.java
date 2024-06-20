package testcases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.LoginPage;
import utilities.ReadProperties;
import utilities.Base;
import utilities.ExcelDataReader;

public class PhoneNumberTest extends Base {

	HomePage homepage;

	@Test(priority = 1, groups = "Pass")
	public void testPhoneNumberPass() {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testPhoneNumberPass: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.gotoPhoneNumberLogin();

		LoginPage loginpage = new LoginPage(getDriver());

		try {

			loginpage.fillPhoneNumber(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input"));

		} catch (Exception e) {

			extentTest().fail("\n\n\ntestPhoneNumberPass: Test Fail");

		}

		extentTest().log(Status.INFO, "testPhoneNumberPass: End Test");

	}

	@Test(priority = 2, groups = "Fail")
	public void testPhoneNumberFail() {

		if (ExcelDataReader.getExecutionRequired(Thread.currentThread().getStackTrace()[1].getMethodName()))

			throw new SkipException("Skipping this test case as per condition.");

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testPhoneNumberFail: Begin Test");

		homepage = new HomePage(getDriver());

		homepage.gotoPhoneNumberLogin();

		LoginPage loginpage = new LoginPage(getDriver());

		try {

			loginpage.fillPhoneNumber(ExcelDataReader.getData(Thread.currentThread().getStackTrace()[1].getMethodName(), "input"));

		} catch (Exception e) {

			extentTest().fail("\n\n\ntestPhoneNumberFail: Test Fail");

		}

		extentTest().log(Status.INFO, "testPhoneNumberFail: End Test");

	}

}
