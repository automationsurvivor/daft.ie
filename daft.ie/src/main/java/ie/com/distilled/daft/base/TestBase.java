package ie.com.distilled.daft.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {

	public static WebDriver driver;
	static Properties prop;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream propertiesFile = new FileInputStream("C:\\Users\\Davson Ramos\\eclipse-workspace"
					+ "\\daft.ie\\src\\main\\java\\ie\\com\\distilled\\daft\\config\\config.properties");
			
			prop.load(propertiesFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void chrome() {
         	ChromeOptions options = new ChromeOptions();
         	options.setAcceptInsecureCerts(true);
         	options.setPageLoadStrategy(PageLoadStrategy.EAGER);
           	driver = new ChromeDriver();
    		driver.manage().deleteAllCookies();
    		driver.manage().window().maximize();
    		driver.get(prop.getProperty("url"));	
  	
	}

}
