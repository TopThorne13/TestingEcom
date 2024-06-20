package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.Base;
import utilities.Functions;

public class CartPage extends BasePage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='container']")
	WebElement cart;

	@FindBy(xpath = "//span[text()='Place Order']")
	WebElement placeOrderButton;

	@FindBy(xpath = "//*[text()='Save for later']")
	WebElement saveForLaterButton;

	@FindBy(xpath = "//*[text()='Move to cart']")
	WebElement moveToCartButton;

	@FindBy(xpath = "//*[text()='Remove']")
	WebElement removeButton;

	@FindBy(xpath = "//*[text()='Missing Cart items?']")
	WebElement emptyCart;

	public void emptyCartSS() throws IOException {

		Functions.waitExplicit(driver, emptyCart);

		logger.info("Empty Cart Found");

		Functions.screenshotElement(cart, Base.pathSS + "Empty Cart.png");

	}

	public void cartSS(String comment) throws IOException {

		Functions.waitExplicit(driver, removeButton);

		logger.info("CartSS: " + comment);

		Functions.screenshotElement(cart, Base.pathSS + "Cart_" + comment + ".png");

	}

	public void clickSaveForLater() {

		try {

			Functions.waitExplicit(driver, saveForLaterButton);

			logger.info("Save for Later Button Found");

			Assert.assertTrue(saveForLaterButton.isDisplayed());

			saveForLaterButton.click();

			logger.info("Save for Later Button Clicked");

		} catch (Exception e) {

			logger.error(e);

		}

	}

	public void clickMoveToCart() {

		try {

			Functions.waitExplicit(driver, moveToCartButton);

			logger.info("Move To Cart Button Found");

			Assert.assertTrue(moveToCartButton.isDisplayed());

			moveToCartButton.click();

			logger.info("Move To Cart Button Clicked");

		} catch (Exception e) {

			logger.error(e);

		}

	}

}
