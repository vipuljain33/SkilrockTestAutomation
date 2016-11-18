package stepDefinitions.mobileStepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.mobilePages.MobileHomePage;
import pages.mobilePages.MobileLoginPage;
import stepDefinitions.AttachHooks;
import utils.CommonFunctionLibrary;

public class MobileLoginStepDef {
	WebDriver driver;
	MobileLoginPage mobileLoginPage;
	CommonFunctionLibrary functionLibrary;
	MobileHomePage mobileHomePage;

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
		mobileLoginPage.username("shreya");
		mobileLoginPage.password("12345678");

		try {
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception in Valid app credentials");
		}
	}

	@Then("^HomeScreen should be visible$")
	public void validateAppHomeScreen_is_visible_android() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// click Login and verify
		mobileHomePage = mobileLoginPage.clickLogin();
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
		mobileLoginPage.clickLogin();
		mobileHomePage = mobileLoginPage.clickLogin();
		if (mobileHomePage != null) {
			Assert.fail();
		}
	}

}
