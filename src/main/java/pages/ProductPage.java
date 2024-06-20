package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Functions;

public class ProductPage extends BasePage {

	private WebDriver driver;

	public ProductPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "pincodeInputId")
	WebElement pincodeBox;

	@FindBy(xpath = "//span[text()='View Details']")
	WebElement validPincode;

	@FindBy(xpath = "//*[text()='Not a valid pincode']")
	WebElement invalidPincode;
	
	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement addToCartButton;

	public void enterPincode(String pincode) {

		Functions.waitExplicit(driver, pincodeBox);

		logger.info("Phone number box visible");

		pincodeBox.sendKeys(pincode);

		logger.info("Pincode entered: " + pincode);

		pincodeBox.sendKeys(Keys.ENTER);

		try {

			Functions.waitExplicit(driver, validPincode);

			logger.info("Pincode is valid.");

			Assert.assertTrue(validPincode.isDisplayed());

		} catch (Exception e) {

			logger.assertLog(invalidPincode.isDisplayed(), e + "\n\n\nSome Weird Error");

		}

	}
	
	public void clickAddToCart() {
		
		try {

			Functions.waitExplicit(driver, addToCartButton);

			logger.info("Add to Cart Button is visible");

			addToCartButton.click();

		} catch (Exception e) {

			logger.error(e);

		}

	}

}
