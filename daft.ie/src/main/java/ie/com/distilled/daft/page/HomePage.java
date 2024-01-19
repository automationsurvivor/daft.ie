package ie.com.distilled.daft.page;


import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ie.com.distilled.daft.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "search-box-input")
	WebElement txtCountyIreland;

	@FindBy(xpath =  "//*[@data-testid='menu']//span[text()='Dublin (County)']")
	WebElement dpdDublinLocation;

	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void searchCountyInbox() {
		txtCountyIreland.sendKeys("Dublin");
	
	}

	/*
	 * Todo create a method to click in any location with a loop For this test only
	 * require dublin location
	 */

	public SalesPage SalesfindDublinLocationDropdown() throws InterruptedException{
		Thread.sleep(5000);
		dpdDublinLocation.isDisplayed();
		new Actions(driver)
			.sendKeys(Keys.ARROW_DOWN)
			.sendKeys(Keys.ENTER).perform();
		return new SalesPage();

	}

}
