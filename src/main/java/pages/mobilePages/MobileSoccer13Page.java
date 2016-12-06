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
		((AndroidDriver) driver)
				.findElementByAndroidUIAutomator(
						"new UiSelector().className(\"android.widget.TextView\").textContains(\"" + betName + "\")")
				.click();
	}

	public void clickSLEEvents(int endNumber, double x1, double x2, int duration, int sleep)
			throws InterruptedException {
		for (int i = 0; i < 4; i++) {
			clickSLE(CommonMobileLocators.SLEList, 0, 2);
			functionLibrary.swipeVertical(endNumber, x1, x2, duration, sleep);
		}
		clickSLE(CommonMobileLocators.SLEList, 2, 2);
	}

	public void confirmBuy(String betName) throws InterruptedException {
		buttonClick(CommonMobileLocators.buyNowSLEAndroid);
		if (!(findElement(CommonMobileLocators.dialogHeaderTextAndroid, 5).getText().contains("CONFIRM"))) {
			Assert.fail();
		}
		buttonClick(CommonMobileLocators.clickConfirmationDoneAndroid);
		if (!(findElement(CommonMobileLocators.subHeaderTextAndroid, 5).getText().contains("PURCHASED TICKET"))) {
			Assert.fail();
		}
		if (!(findElement(CommonMobileLocators.tktPreviewGamenameAndroid, 5).getText().contains(betName))) {
			Assert.fail();
		}
		functionLibrary.swipeVertical(1, .70, .10, 200, 500);
	}
}
