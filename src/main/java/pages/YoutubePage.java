package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Functions;
import utilities.Base;

public class YoutubePage extends BasePage {

	private WebDriver driver;

	public YoutubePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//yt-tab-shape[@tab-title='Videos']")
	WebElement videosTab;
	
	@FindBy(xpath = "//ytd-rich-grid-renderer")
	WebElement allVideos;
	
	public void openVideosTab() {
		
		videosTab.click();
		
	}
	
	public void takeVideosSS() throws IOException {
		
		Functions.screenshotElement(allVideos, Base.pathSS + "testHomePageSocialsYT.png");
		
	}

}
