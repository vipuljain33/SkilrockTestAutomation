package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import DataBaseQuery.DBConnection;
import DataBaseQuery.LoginSqlQuery;
import objectRepository.LoginPageLocators;
import objectRepository.DrawGamePageLocator;
import objectRepository.HomePageLocator;

import objectRepository.LuckeyNumberPageLocator;
import utils.CommonFunctionLibrary;

public class LoginPage extends BasePage {

	String username = null;
	private static Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
		System.out.println(driver);

		if (isElementPresent(LoginPageLocators.userTextfield, 5)) {
			System.out.println("Userbox is present");
		} else {
			System.out.println("userbox is not present");
		}
		// WebElement elem =
		// driver.findElement(LoginPageLocators.userTextfield);
		WebElement elem = findElement(LoginPageLocators.userTextfield, 5);

		if (elem == null) {
			// throw new IllegalStateException();
			throw new ElementNotVisibleException("User TextField Not Visible");
		}
	}

	public void enterUsername(String username) {
		driver.findElement(LoginPageLocators.userTextfield).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(LoginPageLocators.userPassword).sendKeys(password);

	}

	public BasePage clickLogin() {
		try {
			driver.findElement(LoginPageLocators.loginBtn).click();
			if (functionLibrary.switchFrame("topFrame")) {
				if (isElementPresent(HomePageLocator.currentLoggedUser, 5)
						&& findElement(HomePageLocator.currentLoggedUser, 5).getText().equalsIgnoreCase("bomaster")) {
					System.out.println("Inside home page bouser");
					return new HomePage(driver);
				}
			}
			if (isElementPresent(DrawGamePageLocator.drawgamelocator, 5)) {
				System.out.println("inside retailer home page");
				return new DrawGamePage(driver);
			}
			return null;
			// return new BasePage(driver);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}

	}

	public void verifyerror() {
		boolean flag = false;
		String txt1;
		String txt2;
		String txt3;

		if (isElementPresent(LoginPageLocators.errorMessageWhenUsernameNotEntered, 10)) {
			txt1 = findElement(LoginPageLocators.errorMessageWhenUsernameNotEntered, 10).getText();
			flag = true;
		}
		if (isElementPresent(LoginPageLocators.errorMessageWhenPasswordNotEntered, 10)) {
			txt2 = findElement(LoginPageLocators.errorMessageWhenPasswordNotEntered, 10).getText();
			flag = true;
		}
		if (isElementPresent(LoginPageLocators.errorWhenInvalidCredentialsEntered, 10)) {
			txt3 = findElement(LoginPageLocators.errorWhenInvalidCredentialsEntered, 10).getText();
			flag = true;
		}

		if (flag == false) {
			Assert.fail();
		}

	}

	public void LoginWithActiveUser() throws SQLException {
		DBConnection dbconnection = new DBConnection();
		Connection connection = dbconnection.CreateConnectionForLMS();
		ResultSet rs = dbconnection.ExecuteQuery(connection, dbconnection.getFinalQuery(LoginSqlQuery.activeuser),
				"active", "RETAILER");

		while (rs.next()) {
			System.out.println(username = rs.getString(1));
			username = rs.getString(1);
		}

		enterUsername(username);
		enterPassword("12345678");

	}

}
