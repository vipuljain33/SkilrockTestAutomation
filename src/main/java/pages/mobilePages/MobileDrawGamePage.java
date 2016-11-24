package pages.mobilePages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;
import pages.DrawGamePage;

public class MobileDrawGamePage extends BasePage {
	private static Logger LOGGER = LoggerFactory.getLogger(DrawGamePage.class);

	public MobileDrawGamePage(WebDriver driver) {
		super(driver);

		WebElement elem = driver.findElement(LuckeyNumberPageLocator.headerTextAndroid);
		System.out.println(elem.getText());
		if (elem.getText().equalsIgnoreCase("DRAW GAMES")) {
			System.out.println("Draw Game page is opened");
		} else {
			throw new ElementNotVisibleException("Draw Game Page is not visible");

		}
	}

	public MobileLuckyNumberPage selectLuckyNumbers() {
		buttonClick(LuckeyNumberPageLocator.gameSelectDropdownAndroid);
		buttonClick(LuckeyNumberPageLocator.selectLuckyNumbersAndroid);

		if (buttonClick(LuckeyNumberPageLocator.buyNowAndroid)) {
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
