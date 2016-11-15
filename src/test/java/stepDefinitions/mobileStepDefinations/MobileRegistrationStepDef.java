package stepDefinitions.mobileStepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.LoginPageLocators;
import pages.mobilePages.MobileLoginPage;
import pages.mobilePages.MobileRegistrationPage;
import stepDefinitions.AttachHooks;
import utils.CommonFunctionLibrary;

public class MobileRegistrationStepDef {
	WebDriver driver;
	MobileRegistrationPage mobileRegistrationPage;
	CommonFunctionLibrary functionLibrary;
	MobileLoginPage mobileLoginPage;

	@Given("^Open Registration popup$")
	public void reg_popup_is_opened_android() throws Throwable {
		try {
			mobileRegistrationPage = new MobileRegistrationPage(AttachHooks.driver);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	}

	@When("^Valid app enteries are entered$")
	public void valid_app_enteries_android() throws Throwable {
		mobileRegistrationPage.generateUsername();
		mobileRegistrationPage.generateMobileNo();
		mobileRegistrationPage.dob();
		mobileRegistrationPage.emailId("abc@skilrock.com");
	}

	@Then("^Login popup should be visible$")
	public void login_popup_is_visible_android() throws Throwable {
		mobileLoginPage = mobileRegistrationPage.clickLetsPlay();
		if (mobileLoginPage == null) {
			Assert.fail();
		}
	}

	@When("^Invalid app data is entered on the page$")
	public void enter_invalid_data_on_the_page(DataTable dataTable) throws Throwable {
		mobileRegistrationPage.enterformValues(dataTable);
		try {
			if (LoginPageLocators.registerUserAndroid == null) {
				Assert.fail();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// @When("^blank app username (\\d+) and mobile (\\d+) and email \"(.*?)\"
	// is entered$")
	// public void blank_app_enteries_android(String username, String mobileNo,
	// String emailId) throws Throwable {
	// mobileRegistrationPage.username(username);
	// mobileRegistrationPage.dob();
	// mobileRegistrationPage.mobileNo(mobileNo);
	// mobileRegistrationPage.emailId(emailId);
	// }
	//
	// @When("^duplicate app credentials (\\w+) (\\w+) (\\w+) are entered$")
	// public void duplicate_app_enteries_android(String username, String
	// mobileNo, String emailId) throws Throwable {
	// mobileRegistrationPage.username(username);
	// mobileRegistrationPage.dob();
	// mobileRegistrationPage.mobileNo(mobileNo);
	// mobileRegistrationPage.emailId(emailId);
	// }
	//
	// @Then("^Login popup should not be visible$")
	// public void login_popup_is_not_visible_android() throws Throwable {
	// mobileLoginPage = mobileRegistrationPage.clickLetsPlay();
	// if (mobileLoginPage != null) {
	// Assert.fail();
	// }
	// }
}
