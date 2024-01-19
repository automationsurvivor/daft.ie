package ie.com.distilled.daft.page;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ie.com.distilled.daft.base.TestBase;

public class AgreementPage extends TestBase {

	@FindBy(id = "didomi-notice-agree-button")
	WebElement btnAgree;

	public AgreementPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickAgreeBtn() {

		Set<String> windowIds = driver.getWindowHandles();
		for (String windowId : windowIds) {

			System.out.println(driver.switchTo().window(windowId));
			(btnAgree).click();

		}
	}

}
