package pages;

import org.testng.Assert;

import utilities.Functions;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement enterPhoneNumberBox;
	
	@FindBy(xpath = "//span[contains(text(), 'new here')]")
	WebElement newUserPrompt;
	
	@FindBy(xpath = "//span[contains(text(),'Please enter a valid Mobile number')]")
	WebElement invalidNumberPrompt;
	
	public void fillPhoneNumber(String number) {
		
		Functions.waitExplicit(driver, enterPhoneNumberBox);
		
		logger.info("Phone number box visible");
		
		enterPhoneNumberBox.sendKeys(number);
		
		logger.info("Number entered: " + number);
		
		enterPhoneNumberBox.sendKeys(Keys.ENTER);
		
		try {
			
			Functions.waitExplicit(driver, newUserPrompt);
			
			logger.info("New User found. Phone number is valid.");
			
			Assert.assertTrue(newUserPrompt.isDisplayed());
			
		} catch(Exception e) {
			
			logger.error(e);
			
			logger.assertLog(invalidNumberPrompt.isDisplayed(), "Some Weird Error");
			
		}
		
	}

}
