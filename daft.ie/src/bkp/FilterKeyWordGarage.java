package ie.com.distilled.daft.test;

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
	
	public FilterKeyWordGarage() {
		super();
	}

	
	@BeforeMethod
	public void setup() throws InterruptedException {
		chrome();
		agreementPage= new AgreementPage();
		agreementPage.clickAgreeBtn();
		homePage = new HomePage();
		homePage.searchCountyInbox();
		homePage.SalesfindDublinLocationDropdown();
		salesPage = new SalesPage();
		salesPage.clickOnFilterDpd();
		filterPage = new FilterPage();
		filterPage.keyWordsInbox();
		filterPage.showResultsBtn();
		salesPage = new SalesPage();
		salesPage.clickOnFilterDpd();
	  
	
	
	}
	
	@Test
	public void searchKeyWordGarage() throws InterruptedException {

		 filterPage = new FilterPage();
		 filterPage.keyWordsInbox();
		 filterPage.showResultsBtn();
		 
	}
	
	@AfterMethod
	public void tearDown() {
	
		
	}
	
}
