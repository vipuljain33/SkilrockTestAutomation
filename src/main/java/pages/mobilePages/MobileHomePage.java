package pages.mobilePages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import objectRepository.CommonMobileLocators;
import objectRepository.DrawGamePageLocator;
import objectRepository.LoginPageLocators;
import pages.BasePage;
import utils.CommonFunctionLibrary;

public class MobileHomePage extends BasePage {

	CommonFunctionLibrary functionLibrary;

	public MobileHomePage(WebDriver driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);

		// isElementPresent(By.xpath("//android.widget.ImageView[@content-desc='Banner']"),
		// 5);

		buttonClick(LoginPageLocators.drawerImageAndroid);
		if (isElementPresent(LoginPageLocators.LoggedInUserAndroid, 5)) {
			System.out.println("User has logged in");
		} else {
			throw new ElementNotVisibleException("User is not logged in");
		}
		buttonClick(LoginPageLocators.drawerImageAndroid);
	}

	public MobileDrawGamePage selectDrawGame() {
		if (buttonClick(CommonMobileLocators.drawGameAndroid)) {
			return new MobileDrawGamePage(driver);
		} else {
			return null;
		}

	}

	public MobileSportsLotteryPage selectSportsLottery() {
		if (buttonClick(CommonMobileLocators.sportsLotteryAndroid)) {
			return new MobileSportsLotteryPage(driver);
		} else {
			return null;
		}

	}
}
