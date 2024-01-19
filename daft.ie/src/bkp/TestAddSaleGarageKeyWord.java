package daft.ie;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;



class TestAddSaleGarageKeyWord {
	
	
	WebDriver driver;

	//Setting system properties of ChromeDriver 


	
	@SuppressWarnings("unlikely-arg-type")
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		WebDriver driver;
		
	driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.daft.ie/property-for-sale/dublin-city");
		driver.manage().window().maximize();
	    
	 /*Wait<WebDriver> wait =
			        new FluentWait<>(driver)
			            .withTimeout(Duration.ofSeconds(5))
			            .pollingEvery(Duration.ofMillis(600));
			   
			    wait.until(
			        d -> {
			          driver.findElement(By.id("search-box-input"));
			          return true;
			        });
*/
		// It will return the parent window name as a String
		
		Set<String> windowIds = driver.getWindowHandles();
			for(String windowId : windowIds) {
				
				System.out.println(driver.switchTo().window(windowId));
				driver.findElement(By.id("didomi-notice-agree-button")).click();
				 
				
				
			}
			
			/*
			driver.findElement(By.id("search-box-input")).sendKeys("Dublin");
			Thread.sleep(5000);
			driver.findElements(By.xpath("//*[@data-testid='menu']//span[text()='Dublin (County)']"));
									
		      new Actions(driver)
		                .sendKeys(Keys.ARROW_DOWN)
		                .sendKeys(Keys.ENTER)
		            
		                .perform();
		      */
		      //Filter page
		 	 Wait<WebDriver> wait2 =
				        new FluentWait<>(driver)
				            .withTimeout(Duration.ofSeconds(10))
				            .pollingEvery(Duration.ofMillis(600));
				   
				    wait2.until(
				        d -> {
				          driver.findElement(By.xpath("//*[@data-testid='open-filters-modal']"));
				          return true;
				        });  
		      
		        driver.findElement(By.xpath("//*[@data-testid='open-filters-modal']")).click();
		        
		    	Set<String> windowIdsSalePage = driver.getWindowHandles();
				for(String windowId : windowIdsSalePage ) {
					
					System.out.println(driver.switchTo().window(windowId));
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,350)", "");
					
					
				}
				Thread.sleep(5000);
		        driver.findElement(By.xpath("//*[@data-testid='terms-input-text']")).sendKeys("garage");
				driver.findElement(By.xpath("//*[@data-testid='filters-modal-show-results-button']")).click();
				
				
			
		
				//*[@data-testid='open-filters-modal']
				//*[@data-testid='filters-modal-show-results-button']
			
			//driver.findElement(By.xpath("ul[@data-testid='homepage-dropdown-container]'"));
			//Thread.sleep(2000);
			//driver.findElement(By.xpath("//*[@data-testid='menu']//li//span[text()='Dublin (County)']")).sendKeys(Keys.RETURN);
			
			

					//*[@id="search-box-item-15"]/span
					//ul[contains(@class, 'Co.Dublin']
			
			//driver.navigate().to("https://www.daft.ie/property-for-sale/dublin");
	}
			
			 /*Wait<WebDriver> wait1 =
				        new FluentWait<>(driver)
				            .withTimeout(Duration.ofSeconds(10))
				            .pollingEvery(Duration.ofMillis(600));
				   
				    wait1.until(
				        d -> {
				          driver.findElement(By.xpath("//*[@data-testid='menu']//li//span[text()='Dublin (County)']")).click();
				          return true;
				       			          
				        });
	
				  	 
				    	
					}

			
					
					  
				    
				    
				    //WebElement selectElement = 
				 /*   WebElement selectElement= driver.findElement(By.id("homepage-dropdown-container"));
				    Select select = new Select(selectElement);
				    List<WebElement> selectedOptionList = select.getOptions();
				    		driver.findElement(By.id("homepage-dropdown-container"));
			 
					for(WebElement options : selectedOptionList) {
						
						 System.out.println(options);
						    if(selectedOptionList.equals("Dublin")) {
						    	System.out.println(123);
						    }
						    	
						*/
						
					
						
			
				
				

		
		//driver.findElement(By.id("search-box-input")).sendKeys("Dublin");
		
		
				
	
		
		
		
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
