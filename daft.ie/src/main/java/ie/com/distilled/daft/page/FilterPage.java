package ie.com.distilled.daft.page;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.distilled.daft.utillities.Helper;

import ie.com.distilled.daft.base.TestBase;

public class FilterPage extends TestBase {

	@FindBy(xpath = "//*[@data-testid='terms-input-text']")
	WebElement txtKeyWords;

	@FindBy(xpath = "//*[@data-testid='filters-modal-show-results-button']")
	WebElement btnShowResults;
	
	@FindBy(xpath = "//*[@data-testid='close-filters-modal']")
	WebElement closeFilterPage;

	Helper helper;
	SalesPage salepage;

	public FilterPage() {
		PageFactory.initElements(driver, this);
	}

	public void keyWordsInbox() throws InterruptedException {
		Thread.sleep(5000);
		txtKeyWords.sendKeys("garage");

	}

	public void showResultsBtn() {
		btnShowResults.click();


	}

	public String getTextFromShowResultsButton() {
	    String buttonTextFilter = btnShowResults.getText();
	    String totalbuttonTextFilter = buttonTextFilter.substring(5,8 );

		return totalbuttonTextFilter;
	}
	
	public void closeFilterPage() {
		Set<String> windowIdsSalePage = driver.getWindowHandles();
		for (String windowId : windowIdsSalePage) {

			System.out.println(driver.switchTo().window(windowId));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");

		}
		closeFilterPage.click();
	}

}
