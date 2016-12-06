package stepDefinitions.mobileStepDefinations;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.CommonMobileLocators;
import pages.BasePage;
import pages.mobilePages.MobileHomePage;
import pages.mobilePages.MobileLoginPage;
import pages.mobilePages.MobileSoccer13Page;
import pages.mobilePages.MobileSportsLotteryPage;
import stepDefinitions.AttachHooks;
import utils.CommonFunctionLibrary;
import utils.ConfigManager;

public class MobileSoccer13StepDef {
	MobileLoginPage mobileLoginPage;
	MobileHomePage mobileHomePage;
	BasePage basePage;
	MobileSportsLotteryPage mobileSportsLotteryPage;
	MobileSoccer13Page mobileSoccer13Page;
	CommonFunctionLibrary functionLibrary;

	@Given("^User is logged in app Soccer13$")
	public void user_is_logged_in() throws Throwable {
		try {
			mobileLoginPage = new MobileLoginPage(AttachHooks.driver);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		mobileLoginPage.username(ConfigManager.getProperty("Username"));
		mobileLoginPage.password(ConfigManager.getProperty("Password"));
		mobileHomePage = mobileLoginPage.clickLogin();
		if (mobileHomePage == null) {
			Assert.fail();
		}
	}

	@Given("^Sports Lottery app icon is selected$")
	public void draw_games_icon_is_selected() throws Throwable {
		// mobileHomePage=new MobileHomePage(AttachHooks.driver);
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

	@Given("^(.*) is displayed in app Bet type dropdown$")
	public void bet_name_displayed_in_dropdown(String betName) throws Throwable {
		mobileSoccer13Page.validateBetName(betName);
	}

	@When("^Atleast one team is selected in each app event$")
	public void atlest_one_team_is_selected() throws Throwable {
		mobileSoccer13Page.clickSLEEvents(1, 0.65, 0.10, 1000, 500);
	}

	@Then("^No of lines should be (.*) and Bet amount is (.*) for \\$ (.*) in app$")
	public void ticket_amount_is(String noOfLines, String betAmount, String ticketAmount) throws Throwable {

		if (!(mobileSoccer13Page.findElement(CommonMobileLocators.noOfLinesSLEAndroid, 5).getText()
				.contains(noOfLines))) {
			Assert.fail();
		}

		if (!(mobileSoccer13Page.findElement(CommonMobileLocators.betAmountSLEAndroid, 5).getText()
				.contains(betAmount))) {
			Assert.fail();
		}
		if (!(mobileSoccer13Page.findElement(CommonMobileLocators.ticketAmountSLEAndroid, 5).getText()
				.contains(ticketAmount))) {
			Assert.fail();
		}

	}

	@Then("^SLE Purchased ticket is generated in app$")
	public void sle_Purchased_ticket_is_generated_in_app(String noOfLines, String ticketAmount) throws Throwable {
		mobileSoccer13Page.confirmBuy("Soccer 13");
		if (!(mobileSoccer13Page.findElement(CommonMobileLocators.tktPreviewNoOfLinesAndroid, 5).getText()
				.contains(noOfLines))) {
			Assert.fail();
		}
		if (!(mobileSoccer13Page.findElement(CommonMobileLocators.tktPreviewTotalAmountAndroid, 5).getText()
				.contains(ticketAmount))) {
			Assert.fail();
		}
	}

}
