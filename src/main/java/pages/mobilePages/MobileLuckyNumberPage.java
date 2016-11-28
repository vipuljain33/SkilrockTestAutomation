package pages.mobilePages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;

public class MobileLuckyNumberPage extends BasePage {
	static String txtPreviewTktPrice;

	public MobileLuckyNumberPage(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);

		WebElement elem = driver.findElement(LuckeyNumberPageLocator.subHeaderTextAndroid);
		System.out.println(elem.getText());
		if (elem.getText().equalsIgnoreCase("LUCKY NUMBERS")) {
			System.out.println("Lucky page is opened");
		} else {
			throw new ElementNotVisibleException("Lucky Number lobby is not visible");
		}
	}

	public void validateBetName(String locator, String betName) {
		buttonClick(LuckeyNumberPageLocator.changeBetTypeAndroid);
		if (!(findElement(LuckeyNumberPageLocator.popupHeaderName, 5).getText().contains("SELECT BET"))) {
			Assert.fail();
		}
		// select bet name
		driver.findElement(By.xpath(locator + betName + "']")).click();
		if (!(findElement(LuckeyNumberPageLocator.betNameAndroid, 5).getText().contains(betName))) {
			Assert.fail();
		}
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

	public void clickMultiple(By locator, int clickTimes) {
		for (int clk = 0; clk < clickTimes; clk++) {
			buttonClick(locator);
		}
	}

	public void confirmBuy() {
		buttonClick(LuckeyNumberPageLocator.buyNowAndroid);
		if (!(findElement(LuckeyNumberPageLocator.dialogHeaderTextAndroid, 5).getText().contains("CONFIRM"))) {
			Assert.fail();
		}
		buttonClick(LuckeyNumberPageLocator.clickDoneAndroid);
		if (!(findElement(LuckeyNumberPageLocator.subHeaderTextAndroid, 5).getText().contains("PURCHASED TICKET"))) {
			Assert.fail();
		}
	}

	public void drawSelect() {
		buttonClick(LuckeyNumberPageLocator.advanceDrawAndroid);
		if (!(findElement(LuckeyNumberPageLocator.popupHeaderName, 5).getText().contains("SELECT DRAWS"))) {
			Assert.fail();
		}
		List<WebElement> list = getChildElements(LuckeyNumberPageLocator.drawListAndroid,
				LuckeyNumberPageLocator.checkBoxAndroid);
		if (list != null) {
			for (WebElement elem : list) {
				if (!Boolean.valueOf(elem.getAttribute("checked"))) {
					elem.click();
				}
			}
		} else {
			Assert.fail();
		}
		buttonClick(LuckeyNumberPageLocator.checkDoneAndroid);
	}
}
