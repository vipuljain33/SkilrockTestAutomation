package stepDefinitions.mobileStepDefinations;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.mobilePages.MobileHomePage;
import pages.mobilePages.MobileLoginPage;
import pages.mobilePages.MobileSoccer13Page;
import pages.mobilePages.MobileSportsLotteryPage;
import utils.CommonFunctionLibrary;

public class MobileSoccer13StepDef {
	MobileLoginPage mobileLoginPage;
	MobileHomePage mobileHomePage;
	BasePage basePage;
	MobileSportsLotteryPage mobileSportsLotteryPage;
	MobileSoccer13Page mobileSoccer13Page;
	CommonFunctionLibrary functionLibrary;

	@Given("^Sports Lottery app icon is selected$")
	public void draw_games_icon_is_selected() throws Throwable {
		mobileSportsLotteryPage = mobileHomePage.selectSportsLottery();
		if (mobileSportsLotteryPage == null) {
			Assert.fail();
		}
	}

	@Given("^Soccer13 app bet is selected$")
	public void lucky_numbers_game_is_selected() throws Throwable {
		mobileSoccer13Page = mobileSportsLotteryPage.selectSoccerGame();
		if (mobileSoccer13Page == null) {
			Assert.fail();
		}
	}

	@Given("^(\\w+) is displayed in app Bettype dropdown$")
	public void bet_name_displayed_in_dropdown(String betName) throws Throwable {
		mobileSoccer13Page.validateBetName(betName);
	}

	@When("^atlest one team is selected in each app event$")
	public void atlest_one_team_is_selected() throws Throwable {
		mobileSoccer13Page.clickSLEEvents(1, 0.80, 0.05, 1000, 500);
	}

	@Then("^No of lines should be (\\d+) and Bet amount is (\\d+) for \\$ (.*) in app$")
	public void ticket_amount_is(int noOfLines, int betAmount, String ticketAmount) throws Throwable {

	}

}
