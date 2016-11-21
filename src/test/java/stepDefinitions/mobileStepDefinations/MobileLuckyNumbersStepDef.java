package stepDefinitions.mobileStepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;
import pages.mobilePages.MobileHomePage;
import pages.mobilePages.MobileLoginPage;
import pages.mobilePages.MobileLuckyNumberPage;
import stepDefinitions.AttachHooks;
import utils.CommonFunctionLibrary;
import utils.ConfigManager;
import utils.ReusableStaticMethods;

public class MobileLuckyNumbersStepDef {

	MobileLoginPage mobileLoginPage;
	MobileHomePage mobileHomePage;
	MobileLuckyNumberPage mobileLuckyNumPage;
	BasePage basePage;
	CommonFunctionLibrary functionLibrary;

	@Given("^User is logged in$")
	public void user_is_logged_in() throws Throwable {
		try {
			mobileLoginPage = new MobileLoginPage(AttachHooks.driver);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		mobileLoginPage.username(ConfigManager.getProperty("Username"));
		mobileLoginPage.password(ConfigManager.getProperty("Password"));
		basePage = mobileLoginPage.clickLogin();
		if (basePage == null) {
			Assert.fail();
		} else {
			mobileLuckyNumPage = (MobileLuckyNumberPage) basePage;
		}
	}

	@Given("^Draw games icon is selected$")
	public void draw_games_icon_is_selected() throws Throwable {
		mobileLuckyNumPage.selectDG();
	}

	@Given("^Lucky numbers game is selected$")
	public void lucky_numbers_game_is_selected() throws Throwable {
		mobileLuckyNumPage.selectLuckyNumbers();
	}

	@Given("^PermOne bet type and Pick New is selected$")
	public void permOne_bet_type_and_Pick_New_is_selected() throws Throwable {
		mobileLuckyNumPage.validateBetType(LuckeyNumberPageLocator.perm1Android, "Perm1");
		mobileLuckyNumPage.validatePickType(LuckeyNumberPageLocator.pickNewAndroid, "checked");
	}

	@Given("^numbers (\\d+) are picked$")
	public void numbers_are_picked(int numberSelected) throws Throwable {
		mobileLuckyNumPage.swipe(1, 0.80, 0.10, 400, 300);
		List<Integer> randomNumbers;
		if (mobileLuckyNumPage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(0, 89, numberSelected);
			for (int i = 0; i < randomNumbers.size(); i++) {
				mobileLuckyNumPage
						.findElement(
								By.xpath(LuckeyNumberPageLocator.pickRandomNumAndroid + randomNumbers.get(i) + "']"), 5)
						.click();
			}
		}
	}

	@When("^Number of lines selected are (\\w+)$")
	public void number_of_lines_selected_are_ten(String noOfLines) throws Throwable {
		mobileLuckyNumPage.validateExpected("Validate No of lines", LuckeyNumberPageLocator.noOfLinesAndroid,
				noOfLines);
	}

	@Then("^betAmount (\\d+) and NumberPicked (\\d+) and PurchaseAmt \\$(.*)$")
	public void betamount_and_NumberPicked_and_PurchaseAmt_$(int clickBetAmt, int numPicked, String amount)
			throws Throwable {

	}

	@Then("^Purchased ticket is generated$")
	public void purchased_ticket_is_generated() throws Throwable {

	}

}
