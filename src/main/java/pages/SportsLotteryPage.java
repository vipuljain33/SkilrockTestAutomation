package pages;

import org.apache.log4j.Logger;
import org.jboss.netty.handler.codec.spdy.SpdyNoOpFrame;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import objectRepository.DrawGamePageLocator;
import objectRepository.SportsLotteryPageLocators;

public class SportsLotteryPage extends BasePage {

	public SportsLotteryPage(WebDriver driver) {
		super(driver);

		if (isElementPresent(SportsLotteryPageLocators.sportsLotterylocator, 5)) {
			System.out.println("Sports Lottery Page Located");
		} else {
			throw new ElementNotVisibleException("topframe not visible");
		}
	}

	public SoccerThirteenPage selectSoccerThirteen() {
		functionLibrary.switchFrame("leftbottom");
		if (findElement(SportsLotteryPageLocators.soccerThirteenButton, 5) != null) {
			findElement(SportsLotteryPageLocators.soccerThirteenButton, 5).click();
			System.out.println("Soccer Thirteen is selected");
			return new SoccerThirteenPage(driver);
		} else {
			System.out.println("Soccer Thirteen is not selected");
			return null;
		}
	}
}
