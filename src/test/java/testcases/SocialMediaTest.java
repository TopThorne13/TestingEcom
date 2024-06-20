package testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pages.FacebookPage;
import pages.HomePage;
import pages.TwitterPage;
import pages.YoutubePage;
import utilities.Functions;
import utilities.ReadProperties;
import utilities.Base;

public class SocialMediaTest extends Base {
	
	HomePage homepage;
	
	@Test(priority = 1, groups = "Socials")
	public void testHomePageSocialsFacebook() {

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testHomePageSocialsFB: Begin Test");

		homepage = new HomePage(getDriver());
		
		FacebookPage facebookpage;

		try {
			
			homepage.clickFacebookButton();
			
			facebookpage = new FacebookPage(getDriver());
			
			facebookpage.closePrompt();
			
			facebookpage.titleVisible();
			
			Functions.screenshotFullPage(getDriver(), pathSS + "testHomePageSocialsFB.png");

			extentTestSS(pathSS + "testHomePageSocialsFB.png", "Facebook Page");

			extentTest().log(Status.PASS, "Social Assert Facebook: Pass");

		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\nSocial Assert Facebook: Fail");

		}

		extentTest().log(Status.INFO, "testHomePageSocialsFB: End Test");

	}
	
	@Test(priority = 2, groups = "Socials")
	public void testHomePageSocialsTwitter() {

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testHomePageSocialsTwitter: Begin Test");

		homepage = new HomePage(getDriver());
		
		TwitterPage twitterpage;

		try {
			
			homepage.clickTwitterButton();
			
			twitterpage = new TwitterPage(getDriver());
			
			twitterpage.firstTweetSS();

			extentTestSS(pathSS + "testHomePageSocialsTwitter.png", "Twitter Page");

			extentTest().log(Status.PASS, "Social Assert Twitter: Pass");

		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\nSocial Assert Twitter: Fail");

		}

		extentTest().log(Status.INFO, "testHomePageSocialsTwitter: End Test");

	}
	
	@Test(priority = 3, groups = "Socials")
	public void testHomePageSocialsYouTube() {

		getDriver().get(ReadProperties.getConfig("applicationURL"));

		extentTest().log(Status.INFO, "testHomePageSocialsYT: Begin Test");

		homepage = new HomePage(getDriver());
		
		YoutubePage youtubepage;

		try {
			
			homepage.clickYouTubeButton();
			
			youtubepage = new YoutubePage(getDriver());
			
			youtubepage.openVideosTab();
			
			youtubepage.takeVideosSS();

			extentTestSS(pathSS + "testHomePageSocialsYT.png", "Twitter Page");

			extentTest().log(Status.PASS, "Social Assert YouTube: Pass");

		} catch (Exception e) {

			extentTest().log(Status.FAIL, e + "\n\n\nSocial Assert YouTube: Fail");

		}

		extentTest().log(Status.INFO, "testHomePageSocialsYT: End Test");

	}
}
