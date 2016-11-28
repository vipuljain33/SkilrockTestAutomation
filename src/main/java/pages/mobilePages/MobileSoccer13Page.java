package pages.mobilePages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.CommonMobileLocators;
import pages.BasePage;

public class MobileSoccer13Page extends BasePage {
	public MobileSoccer13Page(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);

		WebElement elem = driver.findElement(CommonMobileLocators.subHeaderTextAndroid);
		System.out.println(elem.getText());
		if (elem.getText().equalsIgnoreCase("SOCCER 13")) {
			System.out.println("Soccer 13 page is opened");
		} else {
			throw new ElementNotVisibleException("Soccer 13 page is not visible");
		}
	}
}
