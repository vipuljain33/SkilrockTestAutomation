package pages.mobilePages;

import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.android.AndroidKeyCode;
import objectRepository.LoginPageLocators;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class MobileLoginPage extends BasePage {
	private static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

	public MobileLoginPage(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);
		Thread.sleep(5000);

		functionLibrary.deviceKeyAndroid(AndroidKeyCode.BACK);
		buttonClick(LoginPageLocators.drawerImageAndroid);
		buttonClick(LoginPageLocators.loginAndroid);

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

	public MobileHomePage clickLogin() {

		try
		{
			buttonClick(LoginPageLocators.loginAndroid);
			if(isElementPresent(LoginPageLocators.dismissNotification, 5))
			{
				if(buttonClick(LoginPageLocators.dismissNotification))
				{
					System.out.println("Notification dismissed");
					//drawerClick();
				}
			}
			
			return new MobileHomePage(driver);
		}catch (Exception e) {
			return null;
		}
	}

	public void username(String username) {
		sendKeys(LoginPageLocators.usernameAndroid, username);
	}

	public void password(String password) {
		sendKeys(LoginPageLocators.passwordAndroid, password);
	}

	

}
