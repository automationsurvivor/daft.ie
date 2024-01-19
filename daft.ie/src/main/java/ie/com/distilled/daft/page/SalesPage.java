package ie.com.distilled.daft.page;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.distilled.daft.utillities.Helper;

import ie.com.distilled.daft.base.TestBase;

public class SalesPage extends TestBase {

	@FindBy(xpath = "//*[@data-testid='open-filters-modal']")
	WebElement dpdFilter;

	@FindBy(xpath = "//*[@data-testid='search-h1']")
	WebElement propertiesToSaleGarage;

	@FindBy(xpath = "//*[@data-testid='pagination-results']")
	WebElement paginationResults;

	@FindBy(xpath = "//*[@data-testid='results']")
	WebElement resultsAds;

	Helper helper;

	private int countAdd;

	public SalesPage() throws InterruptedException {
		Thread.sleep(5000);
		PageFactory.initElements(driver, this);
	}

	public void clickOnFilterDpd() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(600));

		wait.until(d -> {
			dpdFilter.isDisplayed();
			return true;
		});
		Thread.sleep(5000);
		dpdFilter.click();

		Set<String> windowIdsSalePage = driver.getWindowHandles();
		for (String windowId : windowIdsSalePage) {

			System.out.println(driver.switchTo().window(windowId));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");

		}

	}

	public String getTextResultSearch() {
		String totalOfPropertiesForsale = propertiesToSaleGarage.getText();
		String totalPropertiesGarage = totalOfPropertiesForsale.substring(0, 3);
		return totalPropertiesGarage;
	}

	public String paginationResults() {
		String pagination = paginationResults.getText();
		String totalPagination = pagination.substring(18, 21);
		return totalPagination;
	}

	public int searchKeyWordGarage() throws InterruptedException {
		int totalAds =0;
		String pageSource = driver.getPageSource();
		String keyWordGarage = "garage";
		countAdd = 0;
		//FilterPage filterPage = new FilterPage();
		//filterPage.closeFilterPage();
		List<WebElement> listAds = resultsAds.findElements(By.tagName("div"));
		Thread.sleep(5000);
		for (WebElement element : listAds) {
			
			element.sendKeys(Keys.TAB);
			
			element.click();
			if(pageSource.contains(keyWordGarage)){
			  totalAds = countAdd++;
				if (countAdd == 3) {
					driver.navigate().back();
					break;
				}
			}
}
		return totalAds;

}
}

