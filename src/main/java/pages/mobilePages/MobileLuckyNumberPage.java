package pages.mobilePages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;

public class MobileLuckyNumberPage extends BasePage {
	public MobileLuckyNumberPage(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);
		Thread.sleep(10000);
	}

	public void selectDG() {
		buttonClick(LuckeyNumberPageLocator.drawGameAndroid);
		assertEquals("Correct Header text", driver.findElement(LuckeyNumberPageLocator.headerTextAndroid).getText(),
				"DRAW GAMES");
		if (findElement(LuckeyNumberPageLocator.headerTextAndroid, 5) == null) {
			throw new ElementNotVisibleException("Draw Game lobby is not visible");
		}

	}

	public void selectLuckyNumbers() {
		buttonClick(LuckeyNumberPageLocator.gameSelectDropdownAndroid);
		buttonClick(LuckeyNumberPageLocator.selectLuckyNumbersAndroid);
		buttonClick(LuckeyNumberPageLocator.buyNowAndroid);
		System.out.println(driver.findElement(LuckeyNumberPageLocator.subHeaderTextAndroid).getText());
		assertEquals("Correct Sub Header text",
				driver.findElement(LuckeyNumberPageLocator.subHeaderTextAndroid).getText(), "LUCKY NUMBERS");
		if (findElement(LuckeyNumberPageLocator.subHeaderTextAndroid, 5) == null) {
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
		//Assert.assertTrue(nodeDetail(driver.findElement(locator), node));
	}
	
	public void swipe(){
		try {
			functionLibrary.swipingVertical(1, 0.80, 0.10, 400, 300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
