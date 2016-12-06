package pages.mobilePages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import objectRepository.CommonMobileLocators;
import pages.BasePage;

public class MobileSoccer13Page extends BasePage {
	public MobileSoccer13Page(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);

		WebElement elem = driver.findElement(CommonMobileLocators.headerTextAndroid);
		System.out.println(elem.getText());
		if (elem.getText().equalsIgnoreCase("SOCCER 13")) {
			System.out.println("Soccer 13 page is opened");
		} else {
			throw new ElementNotVisibleException("Soccer 13 page is not visible");
		}
	}

	public void validateBetName(String betName) {
	
		buttonClick(CommonMobileLocators.gameSelectDropdownAndroid);
		((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\").textContains(\""+betName+"\")").click();
		//findElement(By.xpath(CommonMobileLocators.selectDropdownElementAndroid + betName +"']"), 5).click();
	/*	if (!(findElement(CommonMobileLocators.gameSelectDropdownAndroid, 5).getText().contains(betName))) {
			Assert.fail();
		}
	*/}

	public void clickSLEEvents(int endNumber, double x1, double x2, int duration, int sleep)
			throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			clickSLE(CommonMobileLocators.SLEList, 0, 2);
			functionLibrary.swipeVertical(endNumber, x1, x2, duration, sleep);
			// swipeVertical(1, 0.80, 0.05, 1000, 500);
		}
	}
}
