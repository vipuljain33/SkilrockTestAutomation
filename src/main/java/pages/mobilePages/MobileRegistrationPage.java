package pages.mobilePages;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import io.appium.java_client.android.AndroidKeyCode;
import objectRepository.LoginPageLocators;
import pages.BasePage;
import utils.ReusableStaticMethods;

public class MobileRegistrationPage extends BasePage {

	public MobileRegistrationPage(WebDriver driver) throws InterruptedException {
		super(driver);
		System.out.println(driver);
		Thread.sleep(10000);

		initiate();
		if (isElementPresent(LoginPageLocators.mobileNoAndroid, 10)) {
			System.out.println("Registration popup is present");
		} else {
			System.out.println("Registration popup is not present");
		}
		WebElement elem = findElement(LoginPageLocators.mobileNoAndroid, 10);

		if (elem == null) {
			throw new ElementNotVisibleException("Registration popup is not visible");
		}
	}

	public void initiate() {
		functionLibrary.deviceKeyAndroid(AndroidKeyCode.BACK);
		buttonClick(LoginPageLocators.drawerImageAndroid);
		buttonClick(LoginPageLocators.loginAndroid);
		buttonClick(LoginPageLocators.registerAndroid);
	}

	public void generateUsername() {
		List<Integer> list = ReusableStaticMethods.randomNumber(1, 9, 5);
		String userName = ReusableStaticMethods.IntegerListToString(list, "test");
		sendKeys(LoginPageLocators.usernameAndroid, userName);
	}

	public void username(String userName) {
		sendKeys(LoginPageLocators.usernameAndroid, userName);
	}

	public void dob() {
		buttonClick(LoginPageLocators.dobAndroid);
		buttonClick(LoginPageLocators.clickOKAndroid);
	}

	public void mobileNo(String mobileNo) {
		sendKeys(LoginPageLocators.mobileNoAndroid, mobileNo);
	}

	public void generateMobileNo() {
		List<Integer> list = ReusableStaticMethods.randomNumber(1, 9, 5);
		String mobileNo = ReusableStaticMethods.IntegerListToString(list, "99999");
		sendKeys(LoginPageLocators.mobileNoAndroid, mobileNo);
	}

	public void emailId(String emailId) {
		sendKeys(LoginPageLocators.emailIdAndroid, emailId);
	}

	public MobileLoginPage clickLetsPlay() {
		try {
			buttonClick(LoginPageLocators.registerUserAndroid);
			buttonClick(LoginPageLocators.clickSMSDone);
			return new MobileLoginPage(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void enterformValues(DataTable dataTable) {
		List<Map<String, String>> maps = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> row : maps) {
			sendKeys(LoginPageLocators.usernameAndroid, row.get("username"));
			sendKeys(LoginPageLocators.mobileNoAndroid, row.get("mobileNo"));
			sendKeys(LoginPageLocators.emailIdAndroid, row.get("emailId"));
			dob();
			buttonClick(LoginPageLocators.registerUserAndroid);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}

		// List<String> list = new ArrayList<String>();
		// System.out.println("\nFilling form with below data\n");
		//
		// for (String k : m.keySet()) {
		// System.out.println("Key -> " + k + " Value -> " + m.get(k));
		// list.add(m.get(k));
		// }

		// sendKeys(LoginPageLocators.usernameAndroid, list.get(0));
		// sendKeys(LoginPageLocators.mobileNoAndroid, list.get(1));
	}

}
