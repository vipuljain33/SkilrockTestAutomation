package pages.mobilePages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.HomePageLocator;
import objectRepository.LoginPageLocators;
import pages.BasePage;
import utils.CommonFunctionLibrary;
import utils.ConfigManager;

public class MobileHomePage extends BasePage {

	CommonFunctionLibrary functionLibrary;

	public MobileHomePage(WebDriver driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);

		buttonClick(LoginPageLocators.drawerImageAndroid);
		if (isElementPresent(LoginPageLocators.LoggedInUserAndroid, 5)) {
			System.out.println("User has logged in");
		} else {
			throw new ElementNotVisibleException("User is not logged in");
		}
	}

}
