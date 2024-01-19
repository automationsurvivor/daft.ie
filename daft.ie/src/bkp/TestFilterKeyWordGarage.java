ackage ie.com.distilled.daft.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ie.com.distilled.daft.page.HomePage;

public class TestFilterKeyWordGarage {
	
	
	
	
	
	public void test() {
		
		WebDriver driver;
	    driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.daft.ie/property-for-sale/dublin-city");
		driver.manage().window().maximize();
		
		
		
	}
	


}
