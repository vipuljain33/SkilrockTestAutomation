package pages.mobilePages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import objectRepository.CommonMobileLocators;
import pages.BasePage;
import pages.DrawGamePage;

public class MobileDrawGamePage extends BasePage {
	private static Logger LOGGER = LoggerFactory.getLogger(DrawGamePage.class);

	public MobileDrawGamePage(WebDriver driver) {
		super(driver);

		WebElement elem = driver.findElement(CommonMobileLocators.headerTextAndroid);
		System.out.println(elem.getText());
		if (elem.getText().equalsIgnoreCase("DRAW GAMES")) {
			System.out.println("Draw Game page is opened");
		} else {
			throw new ElementNotVisibleException("Draw Game Page is not visible");

		}
	}

	public MobileLuckyNumberPage selectLuckyNumbers() {
		buttonClick(CommonMobileLocators.gameSelectDropdownAndroid);
		findElement(By.xpath(CommonMobileLocators.selectDropdownElementAndroid + "Lucky Numbers']"), 5).click();
		// buttonClick(CommonMobileLocators.selectLuckyNumbersAndroid + "Lucky
		// Numbers']");

		if (buttonClick(CommonMobileLocators.buyNowAndroid)) {
			try {
				return new MobileLuckyNumberPage(driver);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return null;
	}
}
