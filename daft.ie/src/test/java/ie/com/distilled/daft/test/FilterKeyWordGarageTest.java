package ie.com.distilled.daft.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ie.com.distilled.daft.base.TestBase;
import ie.com.distilled.daft.page.AgreementPage;
import ie.com.distilled.daft.page.FilterPage;
import ie.com.distilled.daft.page.HomePage;
import ie.com.distilled.daft.page.SalesPage;

public class FilterKeyWordGarageTest extends TestBase {

	AgreementPage agreementPage;
	HomePage homePage;
	SalesPage salesPage;
	FilterPage filterPage;
	String urlGarage = "https://www.daft.ie/property-for-sale/dublin-city?terms=garage";

	public FilterKeyWordGarageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		chrome();
		agreementPage = new AgreementPage();
		agreementPage.clickAgreeBtn();
		homePage = new HomePage();
		homePage.searchCountyInbox();
		homePage.SalesfindDublinLocationDropdown();
		salesPage = new SalesPage();
		salesPage.clickOnFilterDpd();

	}

	@Test
	// verify Url with Key word Garage
	public void urlKeyWordGarageTest() throws InterruptedException {

		filterPage = new FilterPage();
		filterPage.keyWordsInbox();
		filterPage.showResultsBtn();
		String CurrentWordGarageUrl = driver.getCurrentUrl();
		assertEquals(CurrentWordGarageUrl,urlGarage);

	}

	@Test
	// compare the results total results keyword garage in the filter in the result
	// Page
	public void compareTotalAdsGarageKeyWordTest() throws InterruptedException {

		filterPage = new FilterPage();
		filterPage.keyWordsInbox();
		filterPage.showResultsBtn();
		salesPage.clickOnFilterDpd();
		String garageShowResultsBtn = filterPage.getTextFromShowResultsButton();
		String garageShowResultsPage = salesPage.getTextResultSearch();
		assertEquals(garageShowResultsBtn, garageShowResultsPage);

	}


	public void totalPaginationTest() throws InterruptedException {

		filterPage = new FilterPage();
		filterPage.keyWordsInbox();
		filterPage.showResultsBtn();
		salesPage.clickOnFilterDpd();
		String garageShowResultsBtn = filterPage.getTextFromShowResultsButton();
		String totalPagination = salesPage.paginationResults();
		assertEquals(garageShowResultsBtn, totalPagination);
	}
	
	//open 3 ads to verify Key wordGarage in the description
	@Test(enabled = false)
	public void searchKeyWordGarageTest() throws InterruptedException {
		filterPage = new FilterPage();
		filterPage.keyWordsInbox();
		filterPage.showResultsBtn();
		int totalAds = salesPage.searchKeyWordGarage();
		
	}
		

	@AfterMethod
	public void tearDown() {
		driver.quit();
          
	}

}
