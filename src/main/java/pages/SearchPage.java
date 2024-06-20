package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.ui.Select;

import utilities.Functions;
import utilities.Base;

public class SearchPage extends BasePage {

	private WebDriver driver;

	public SearchPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@data-id])[1]")
	WebElement firstProduct;

	@FindBy(id = "fk-compare-page")
	WebElement comparisonChart;

	@FindBy(xpath = "(//img[@height='21'])[1]")
	WebElement fkAssuredFilter;

	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBox;

	@FindBy(xpath = "//input[@placeholder='Search Brand']")
	WebElement searchBrandBox;

	@FindBy(xpath = "//span[text()='Clear all']")
	WebElement clearAllButton;

	@FindBy(xpath = "//span[text()='Add to Compare']")
	List<WebElement> addToCompareButtons;

	@FindBy(xpath = "//span[text()='COMPARE']")
	WebElement compareButton;

	@FindBy(xpath = "//span[text()='Show only differences']")
	WebElement onlyDifferences;

	@FindBy(xpath = "//select[1]")
	WebElement minDropDown;

	@FindBy(xpath = "//select[2]")
	WebElement maxDropDown;

	public void selectSecondMin() {

		try {

			Functions.waitExplicit(driver, minDropDown);

			logger.info("Setting Minimum price");

			Select select = new Select(minDropDown);

			select.selectByIndex(1);

			logger.info("Minimum Price selected");

		} catch (Exception e) {

			logger.error(e);

		}

	}
	
	public void selectSecondMax() {

		try {

			Functions.waitExplicit(driver, maxDropDown);

			logger.info("Setting Maximum price");

			Select select = new Select(maxDropDown);

			int lastIndex = select.getOptions().size() - 1;
			
			select.selectByIndex(lastIndex);

			logger.info("Maximum Price selected");

		} catch (Exception e) {

			logger.error(e);

		}

	}

	public void filterByBrand(String brandName) {

		Functions.waitExplicit(driver, searchBrandBox);

		logger.info("Filtering by Brand Name");

		searchBrandBox.sendKeys(brandName);

		logger.info("Brand Name entered: " + brandName);

		try {

			String xpath = String.format("//div[text()='%s']", brandName);

			WebElement searchBrandBoxFirstResult = driver.findElement(By.xpath(xpath));

			searchBrandBoxFirstResult.click();

			Functions.waitExplicit(driver, clearAllButton);

			logger.info("Clear All button is visible");

			Assert.assertTrue(clearAllButton.isDisplayed());

		} catch (Exception e) {

			logger.error(e);

		}

		logger.info("Brand Search filtered");

	}

	public void gotoFirstProduct() {

		try {

			Functions.waitExplicit(driver, firstProduct);

			logger.info("First Product present");

			Assert.assertTrue(firstProduct.isDisplayed());

			firstProduct.click();

		} catch (Exception e) {

			logger.error(e);

			e.printStackTrace();
		}

	}

	public void firstProductSS() throws IOException {

		try {

			Functions.waitExplicit(driver, firstProduct);

			logger.info("First Product present");

			Assert.assertTrue(firstProduct.isDisplayed());

			Functions.screenshotElement(firstProduct,
					Base.pathSS + "First Product SS_" + searchBox.getAttribute("value") + ".png");

			System.out.println(Base.pathSS + "First Product SS_" + searchBox.getAttribute("value") + ".png");

		} catch (Exception e) {

			logger.error(e);

			e.printStackTrace();
		}

	}

	public void clickFirstNButtons(int n) {

		for (int i = 0; i < n; i++) {

			try {

				addToCompareButtons.get(i).click();

			} catch (StaleElementReferenceException e) {

				logger.info("StaleElementReferenceException caught. Retrying click...");

				addToCompareButtons = driver.findElements(By.xpath("//span[text()='Add to Compare']"));

				addToCompareButtons.get(i).click();

			}
		}
	}

	public void comparisonChartSS() {

		compareButton.click();

		Functions.waitExplicit(driver, onlyDifferences);

		try {

			Functions.waitExplicit(driver, comparisonChart);

			logger.info("Comparison Chart visible");

			Functions.screenshotElement(comparisonChart, Base.pathSS + "Comparison Chart.png");

		} catch (Exception e) {

			logger.error(e);

		}

	}

}
