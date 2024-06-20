package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Functions;

public class FacebookPage extends BasePage {
	
	private WebDriver driver;
	
	public FacebookPage(WebDriver driver) {
		
		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "(//i)[7]")
	WebElement initialPromptCloseButton;
	
	@FindBy(xpath="//h1")
	WebElement title;
	
	public void closePrompt() {
		
		try {

			Functions.waitExplicit(driver, initialPromptCloseButton);

			Assert.assertTrue(initialPromptCloseButton.isDisplayed());
			
			initialPromptCloseButton.click();
			
			logger.info("Normal Execution for FacebookPage");

		} catch (Exception e) {

			logger.error(e);

		}
		
	}
	
	public void titleVisible() {
		
		Functions.waitClickable(driver, title);
		
	}

}
