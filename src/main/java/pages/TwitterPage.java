package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Functions;
import utilities.Base;

public class TwitterPage extends BasePage {

	private WebDriver driver;

	public TwitterPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//article)[1]")
	WebElement firstTweet;
	
	public void firstTweetSS() throws IOException {
		
		Functions.screenshotElement(firstTweet, Base.pathSS + "testHomePageSocialsTwitter.png");
		
	}

}
