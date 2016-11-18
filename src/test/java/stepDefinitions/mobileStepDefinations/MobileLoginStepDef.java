package stepDefinitions.mobileStepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.mobilePages.MobileHomePage;
import pages.mobilePages.MobileLoginPage;
import stepDefinitions.AttachHooks;
import utils.CommonFunctionLibrary;
import utils.ConfigManager;

public class MobileLoginStepDef {
	WebDriver driver;
	MobileLoginPage mobileLoginPage;
	CommonFunctionLibrary functionLibrary;
	MobileHomePage mobileHomePage;
	BasePage basePage;

	@Given("^Login popup is opened$")
	public void login_popup_is_opened_android() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// validate if login page is opened

		try {
			mobileLoginPage = new MobileLoginPage(AttachHooks.driver);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Valid app credentials are entered$")
	public void valid_credentials_are_entered_android() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// enter valid credentials
		try {
			mobileLoginPage.username(ConfigManager.getProperty("Username"));
			mobileLoginPage.password(ConfigManager.getProperty("Password"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Valid app credentials");
		}
	}

	@Then("^HomeScreen should be visible$")
	public void validateAppHomeScreen_is_visible_android() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// click Login and verify
		basePage = mobileLoginPage.clickLogin();
		if (mobileHomePage == null) {
			Assert.fail();
		}

	}

	@When("^invalid app username (\\w+) is entered$")
	public void valid_app_username_entered_android(String username) throws Throwable {
		mobileLoginPage.username(username);
	}

	@When("^invalid app password (\\w+) is entered$")
	public void valid_app_password_entered_android(String password) throws Throwable {
		mobileLoginPage.password(password);
	}

	@Then("^HomeScreen should not be visible$")
	public void AppHomeScreen_not_visible_android() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// click Login and verify
		basePage = mobileLoginPage.clickLogin();
		if (basePage != null) {
			Assert.fail();
		}
	}

}
