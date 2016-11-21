package pages.mobilePages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;

public class MobileLuckyNumberPage extends BasePage {
	public MobileLuckyNumberPage(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);
		Thread.sleep(10000);

		WebElement elem = driver.findElement(LuckeyNumberPageLocator.subHeaderTextAndroid);
		System.out.println(elem.getText());
		if (elem.getText().equalsIgnoreCase("LUCKY NUMBERS")) {
			System.out.println("Lucky page is opened");
		} else {
			throw new ElementNotVisibleException("Lucky Number lobby is not visible");
		}
	}

	public void validateBetType(By locator, String betName) {
		buttonClick(LuckeyNumberPageLocator.changeBetTypeAndroid);
		assertEquals("Correct Header name", driver.findElement(LuckeyNumberPageLocator.popupHeaderName).getText(),
				"SELECT BET");
		// select bet name
		buttonClick(locator);
		assertEquals("Correct Bet Type", driver.findElement(LuckeyNumberPageLocator.betName).getText(), betName);

	}

	public void validatePickType(By locator, String node) {
		// select pick type
		buttonClick(locator);
		// validate selected pick type
		// Assert.assertTrue(nodeDetail(driver.findElement(locator), node));
	}

	public void swipe(int endNumber, double x1, double x2, int duration, int sleep) {
		try {
			functionLibrary.swipeVertical(endNumber, x1, x2, duration, sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOK() {
		buttonClick(LuckeyNumberPageLocator.clickOKAndroid);
	}

	public void clickMultiple(By locator, int clickTimes) {
		for (int clk = 0; clk < clickTimes; clk++) {
			buttonClick(locator);
		}
	}

}
