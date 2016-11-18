package pages.mobilePages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.android.AndroidKeyCode;
import objectRepository.LoginPageLocators;
import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;
import pages.LoginPage;
import pages.LuckyNumberPage;

public class MobileLoginPage extends BasePage {
	private static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

	public MobileLoginPage(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);
		Thread.sleep(10000);

		initiate();
		if (isElementPresent(LoginPageLocators.usernameAndroid, 5)) {
			System.out.println("Login popup is present");
		} else {
			System.out.println("Login popup is not present");
		}
		WebElement elem = findElement(LoginPageLocators.usernameAndroid, 5);

		if (elem == null) {
			throw new ElementNotVisibleException("Login popup is not visible");
		}
	}

	public void initiate() {
		functionLibrary.deviceKeyAndroid(AndroidKeyCode.BACK);
		buttonClick(LoginPageLocators.drawerImageAndroid);
		buttonClick(LoginPageLocators.loginAndroid);
	}

	public BasePage clickLogin() {

		try {

			if (isElementPresent(LoginPageLocators.loginAndroid, 5)) {
				buttonClick(LoginPageLocators.loginAndroid);
				if (isElementPresent(LoginPageLocators.dismissNotification, 5)) {
					if (buttonClick(LoginPageLocators.dismissNotification)) {
						System.out.println("Notification dismissed");
					}
				}
				return new MobileHomePage(driver);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public void username(String username) {
		sendKeys(LoginPageLocators.usernameAndroid, username);
	}

	public void password(String password) {
		sendKeys(LoginPageLocators.passwordAndroid, password);
	}

}
