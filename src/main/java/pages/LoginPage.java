package pages;

import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import objectRepository.LoginPageLocators;
import stepDefinitions.AttachHooks;
import utils.CommonFunctionLibrary;

public class LoginPage extends BasePage {
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
			throw new ElementNotVisibleException("UserText field not visible");
		}
	}

	public void enterUsername(String username) {
		driver.findElement(LoginPageLocators.userTextfield).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(LoginPageLocators.userPassword).sendKeys(password);

	}

	public HomePage clickLogin() {
		try {
			driver.findElement(LoginPageLocators.loginBtn).click();
			return new HomePage(driver);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			return null;
		}

	}

	public void verifyerror()
	{
		boolean flag = false;
		String txt1 ;
		String txt2;
		String txt3;
		
	
		if(isElementPresent(LoginPageLocators.errorMessageWhenUsernameNotEntered, 10))
		{
			txt1 = findElement(LoginPageLocators.errorMessageWhenUsernameNotEntered, 10).getText();
			flag = true;
		}
		if(isElementPresent(LoginPageLocators.errorMessageWhenPasswordNotEntered, 10))
		{
			txt2 = findElement(LoginPageLocators.errorMessageWhenPasswordNotEntered, 10).getText();
			flag = true;
		}
		if(isElementPresent(LoginPageLocators.errorWhenInvalidCredentialsEntered, 10))
		{
			txt3 = findElement(LoginPageLocators.errorWhenInvalidCredentialsEntered, 10).getText();
			flag= true;
		}
		
		if(flag == false)
		{
			Assert.fail();
		}
		
		
		
		
	}

}
