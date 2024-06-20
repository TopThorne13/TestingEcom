package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Base;
import utilities.Functions;

public class CustomerCarePage extends BasePage {

	private WebDriver driver;

	public CustomerCarePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1")
	WebElement customerCare;
	
	public void pageVisible() throws IOException {
		
		try {
			
			Functions.waitExplicit(driver, customerCare);
			
			logger.info("Customer Care Page is visible");
			
			Functions.screenshotFullPage(driver, Base.pathSS + "Customer_Care_Page.png");
			
			logger.info("Customer Care Page SS captured");
			
		} catch (IOException e) {

			logger.error(e);
			
		}
		
	}
}

