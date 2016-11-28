package stepDefinitions.mobileStepDefinations;

import org.junit.Assert;

import cucumber.api.java.en.Given;
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
	MobileSportsLotteryPage mobileSportsLottery;
	MobileSoccer13Page mobileSoccer13Page;
	CommonFunctionLibrary functionLibrary;

	@Given("^Sports Lottery app icon is selected$")
	public void draw_games_icon_is_selected() throws Throwable {
		mobileSportsLottery = mobileHomePage.selectSportsLottery();
		if (mobileSportsLottery == null) {
			Assert.fail();
		}
	}

	@Given("^Soccer13 app game is selected$")
	public void lucky_numbers_game_is_selected() throws Throwable {
		mobileSoccer13Page = mobileSportsLottery.selectSoccer13();
		if (mobileSoccer13Page == null) {
			Assert.fail();
		}
	}
}
