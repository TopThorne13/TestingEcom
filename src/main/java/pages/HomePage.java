package pages;

import org.testng.Assert;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Base;
import utilities.Functions;

public class HomePage extends BasePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Cart']")
	WebElement cartButton;

	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBox;

	@FindBy(xpath = "(//*[text()='Login'])[1]")
	WebElement loginButton;

	@FindBy(xpath = "//*[text()='Recently Viewed']")
	WebElement recentlyViewed;

	@FindBy(xpath = "//img[@alt='Facebook']")
	WebElement facebookButton;

	@FindBy(xpath = "//img[@alt='Twitter']")
	WebElement twitterButton;

	@FindBy(xpath = "//img[@alt='YouTube']")
	WebElement youtubeButton;
	
	@FindBy(xpath = "//span[text()='Top Offer']")
	WebElement topOffer;

	public void clickCartButton() {

		Functions.waitExplicit(driver, cartButton);

		cartButton.click();

		logger.info("Cart Button clicked");

	}

	public void enterSearchQuery(String query) {

		Functions.waitExplicit(driver, searchBox);

		searchBox.sendKeys(query);

		logger.info("Search query entered: " + query);

		searchBox.sendKeys(Keys.ENTER);

		logger.info("Search Sent");

	}

	public void clickLoginButton() {

		Functions.waitExplicit(driver, loginButton);

		loginButton.click();

		logger.info("Login Button Clicked");

	}

	public void isRecentlyViewedDisplayed() throws IOException {

		try {

			Functions.waitExplicit(driver, recentlyViewed);

			logger.info("Recently Viewed present");

			Assert.assertTrue(recentlyViewed.isDisplayed());

		} catch (Exception e) {

			logger.error("Recently Viewed not present");

			Functions.screenshotFullPage(driver, Base.pathSS + "Recently Viewed not Present.png");

		}
	}

	public String getURL() {

		logger.info("URL Fetched");

		return driver.getCurrentUrl();

	}

	public String getTitle() {

		logger.info("Title Fetched");

		return driver.getTitle();

	}
	
	public void clickFacebookButton() {

		Functions.waitExplicit(driver, facebookButton);

		facebookButton.click();

		logger.info("Facebook Button Clicked");

	}

	public void clickTwitterButton() {

		Functions.waitExplicit(driver, twitterButton);

		twitterButton.click();

		logger.info("Twitter Button Clicked");

	}
	
	public void clickYouTubeButton() {

		Functions.waitExplicit(driver, youtubeButton);

		youtubeButton.click();

		logger.info("YouTube Button Clicked");

	}
	
	public void gotoTopOffer() throws IOException {
		
		try {

			Functions.waitExplicit(driver, topOffer);

			logger.info("Top Offer present");

			Assert.assertTrue(topOffer.isDisplayed());
			
			topOffer.click();
			
			Functions.screenshotFullPage(driver, Base.pathSS + "Top Offer Page.png");

		} catch (Exception e) {

			logger.error("Top Offer not present");

			Functions.screenshotFullPage(driver, Base.pathSS + "Top Offer not Present.png");

		}
		
	}
	
	public void gotoPhoneNumberLogin() {
		
		loginButton.click();
		
		
		
	}

}
