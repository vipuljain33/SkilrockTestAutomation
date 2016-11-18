package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import DataBaseQuery.DBConnection;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;


public class LoginFeatureStepDef {

	LoginPage loginPage;
	WebDriver driver;
	HomePage homePage;
	BasePage basePage;
	DBConnection bdconnection;
	DrawGamePage drawGamePage;

	@Given("^Login page is opened$")
	public void login_page_is_opened() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// validate if login page is opened
		try {
			loginPage = new LoginPage(AttachHooks.driver);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@When("^valid credentials are entered$")
	public void valid_credentials_are_entered() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		// enter valid credentials
		loginPage.LoginWithActiveUser();
	}

	@Then("^HomePage should be visible$")
	public void validateHomePage() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		// click Login and verify
		basePage = loginPage.clickLogin();
		System.out.println(basePage.getClass().getName());
		if (basePage.getClass().getName().contains("DrawGamePage")) {
			drawGamePage = (DrawGamePage) basePage;
		}
		if (basePage.getClass().getName().contains("HomePage")) {
			homePage = (HomePage) basePage;
		}

		if (homePage == null && drawGamePage == null) {

			// Write code here that turns the phrase above into concrete actions
			// click Login and verify
			homePage = (HomePage) loginPage.clickLogin();
			if (homePage == null) {

				Assert.fail();
			}
		}
	}

	@Then("^HomePage should not be visible$")
	public void validateHomePageNotVisible() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		// click Login and verify
		basePage = loginPage.clickLogin();
		homePage = (HomePage) basePage;
		if (homePage == null) {

			// Write code here that turns the phrase above into concrete actions
			// click Login and verify
			homePage = (HomePage) loginPage.clickLogin();
			if (homePage == null) {

				System.out.println("Home page is not visible when invalid credentials entered");
			}
		}
	}

	@When("^invalid username (\\w+) is entered$")
	public void invalid_vipul_is_entered(String username) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername(username);

	}

	@When("^invalid password (\\w+) is entered$")
	public void invalid_password_is_entered(String pwd) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterPassword(pwd);

	}

	@When("^blank credentials are entered$")
	public void blank_credentials_are_entered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername(" ");
		loginPage.enterPassword(" ");
		loginPage.clickLogin();
	}

	@Then("^verify error msg$")
	public void verify_error_msg() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// System.out.println("this is error Message");
		loginPage.verifyerror();

	}

	@When("^only username credentials are entered$")
	public void only_username_credentials_are_entered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername("bomaster");
		loginPage.enterPassword(" ");
		loginPage.clickLogin();
	}

	@When("^only password credentials are entered$")
	public void only_password_credentials_are_entered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername(" ");
		loginPage.enterPassword("12345678");
		loginPage.clickLogin();
	}

	@When("^wrong username and password credentials are entered$")
	public void wrong_username_and_password_credentials_are_entered() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername("fduifhduighlsiedu");
		loginPage.enterPassword("4567834899045");
	}

}
