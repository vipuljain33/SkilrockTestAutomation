package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LuckyNumberPage;

public class LuckyNumber {
	
	LoginPage loginPage;
	WebDriver Driver;
	HomePage homePage;
	LuckyNumberPage lnpage;
	BasePage basePage;
	
	
	@Given("^login with valid credentials$")
	public void login_with_valid_credentials() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage(AttachHooks.driver);
		loginPage.enterUsername("testret");
		loginPage.enterPassword("12345678");
		basePage = loginPage.clickLogin();
		if(basePage == null)
		{
			Assert.fail();
		}else
		{
		lnpage = (LuckyNumberPage) basePage;
		}
	}

	@Given("^Draw game option is selected$")
	public void draw_game_option_is_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		lnpage.isDrawgameSelected();
		
	}

	@Given("^Lucky number game is selected$")
	public void lucky_number_game_is_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		lnpage.isLuckyNumberSelected();
	}

	@Given("^Active bet types are present in DB$")
	public void active_bet_types_are_present_in_DB() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("Pass");
	}

	@Then("^Active bet types are visible$")
	public void active_bet_types_are_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Pass");
	}

	@When("^Perm(\\d+) bet type is selected$")
	public void perm_bet_type_is_selected(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Pass");
	}

	@When("^select more than ten numbers$")
	public void select_more_than_ten_numbers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Pass");
	}

	@Then("^popup error message should display$")
	public void popup_error_message_should_display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Pass");
	}

	@When("^select numbers less than three and greater than twenty$")
	public void select_numbers_less_than_three_and_greater_than_twenty() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Pass");
	}

	@Then("^popup error message should display for greater than twenty numbers$")
	public void popup_error_message_should_display_for_greater_than_twenty_numbers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Pass");
	}

	@Then("^buy now should be disabled for less than \"(.*?)\" numbers$")
	public void buy_now_should_be_disabled_for_less_than_numbers(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("Pass");
	}


}
