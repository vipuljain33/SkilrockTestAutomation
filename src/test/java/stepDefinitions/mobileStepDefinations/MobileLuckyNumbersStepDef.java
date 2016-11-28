package stepDefinitions.mobileStepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import DataBaseQuery.LuckyNumberSqlQuery;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;
import pages.mobilePages.MobileDrawGamePage;
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
	MobileDrawGamePage mobileDrawGamePage;
	CommonFunctionLibrary functionLibrary;

	@Given("^User is logged in app$")
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

	@Given("^Draw games app icon is selected$")
	public void draw_games_icon_is_selected() throws Throwable {
		mobileDrawGamePage = mobileHomePage.selectDrawGame();
		if (mobileDrawGamePage == null) {
			Assert.fail();
		}
	}

	@Given("^Lucky numbers app game is selected$")
	public void lucky_numbers_game_is_selected() throws Throwable {
		mobileLuckyNumPage = mobileDrawGamePage.selectLuckyNumbers();
		if (mobileLuckyNumPage == null) {
			Assert.fail();
		}
	}

	@Given("^(\\w+) and Pick New is selected in app$")
	public void bet_type_and_Pick_New_is_selected(String betType) throws Throwable {
		mobileLuckyNumPage.validateBetName(LuckeyNumberPageLocator.betTypeSelectAndroid, betType);
		mobileLuckyNumPage.validatePickType(LuckeyNumberPageLocator.pickNewAndroid, "checked");
	}

	@Given("^(\\d+) are picked in app$")
	public void numbers_are_picked(int numbers) throws Throwable {
		mobileLuckyNumPage.swipe(1, 0.80, 0.10, 600, 400);
		List<Integer> randomNumbers;
		if (mobileLuckyNumPage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(0, 89, numbers);
			for (int i = 0; i < randomNumbers.size(); i++) {
				mobileLuckyNumPage
						.findElement(
								By.xpath(LuckeyNumberPageLocator.pickRandomNumAndroid + randomNumbers.get(i) + "']"), 5)
						.click();
			}
		}
		mobileLuckyNumPage.buttonClick(LuckeyNumberPageLocator.clickOKAndroid);

	}

	@Given("^(\\w+) and Quick Pick is selected in app$")
	public void permOne_bet_type_and_Pick_New_is_selected(String betType) throws Throwable {
		mobileLuckyNumPage.validateBetName(LuckeyNumberPageLocator.betTypeSelectAndroid, betType);
		mobileLuckyNumPage.validatePickType(LuckeyNumberPageLocator.quickPickAndroid, "checked");
	}

	@Given("^qp (\\d+) are picked in app$")
	public void qp_numbers_are_picked(int numbers) throws Throwable {
		mobileLuckyNumPage.clickMultiple(LuckeyNumberPageLocator.increaseNumbersAndroid, numbers);
	}

	@When("^number of lines selected are (\\w+) and NumberSelected (\\w+) for bet type (\\w+) in app$")
	public void validate_number_of_lines_selected_pick_new(String noOfLines, String numberSelected, String betType)
			throws Throwable {
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.noOfLinesAndroid, 5).getText()
				.contains(noOfLines))) {
			Assert.fail();
		}
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.selectedNumbersAndroid, 5).getText()
				.contains(numberSelected))) {
			Assert.fail();
		}
	}

	@When("^number of lines selected are (\\w+) and NumberSelected (\\w+) for bet type (\\w+) QP in app$")
	public void validate_number_of_lines_selected_quick_pick(String noOfLines, String numberSelected, String betType)
			throws Throwable {
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.noOfLinesAndroid, 5).getText()
				.contains(noOfLines))) {
			Assert.fail();
		}
		if (betType.contains("Perm1")) {
			if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.selectedNumbersAndroid, 5).getText()
					.contains(numberSelected))) {
				Assert.fail();
			}
		} else if (betType.contains("Perm2") && betType.contains("Perm3")) {
			if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.selectQPNumbersAndroid, 5).getText()
					.contains(numberSelected))) {
				Assert.fail();
			}
		}
	}

	@When("^increase app betAmount by (\\d+)$")
	public void increase_bet_amount(int clickBetAmt) throws Throwable {
		mobileLuckyNumPage.clickMultiple(LuckeyNumberPageLocator.increaseBetAndroid, clickBetAmt);
	}

	@Then("^Purchase amount is \\$ (.*) in app$")
	public void betamount_and_NumberPicked_and_PurchaseAmt_$(String amount) throws Throwable {
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.finalAmountAndroid, 5).getText()
				.contains(amount))) {
			Assert.fail();
		}
	}

	@Then("^Purchased ticket is generated in app$")
	public void purchased_ticket_is_generated() throws Throwable {
		mobileLuckyNumPage.confirmBuy();
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.tktPreviewGamenameAndroid, 5).getText()
				.contains("LUCKY NUMBERS"))) {
			Assert.fail();
		}
	}

	@Given("^Active bet types in app are present in DB$")
	public void active_bet_types_are_present_in_DB_Mobile() throws Throwable {
		mobileLuckyNumPage.buttonClick(LuckeyNumberPageLocator.changeBetTypeAndroid);
		if (mobileLuckyNumPage.verifyActiveBetType(LuckeyNumberPageLocator.betNameAndroid,
				LuckyNumberSqlQuery.LuckyNumberActiveBetType, "active")) {
			System.out.println("DB and UI Bet types verified");
		} else {
			Assert.fail("Did not receive bet types from UI");
		}

	}

	@Then("^Active bet types are visible in app$")
	public void active_bet_types_are_visible_Android() throws Throwable {
		System.out.println("Active Bet Type Visibility Verified");
	}

	@Then("^ticket should not be generated in app$")
	public void ticket_is_not_generated() throws Throwable {
		mobileLuckyNumPage.buttonClick(LuckeyNumberPageLocator.buyNowAndroid);
		if ((mobileLuckyNumPage.isElementPresent(LuckeyNumberPageLocator.confirmDialogHeaderAndroid, 5))) {
			Assert.fail();
		}
		System.out.println("Ticket is not generated");
	}

	@Then("^Maximum Numbers should be displayed in (\\d+) in app$")
	public void maximum_numbers_selected(String numberSelected) throws Throwable {
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.selectedNumbersAndroid, 5).getText()
				.contains(numberSelected))) {
			Assert.fail();
		}
	}

	@When("^select multiple draws$")
	public void no_of_draws_selected_are() throws Throwable {
		mobileLuckyNumPage.drawSelect();
	}

	@When("^Advance draws are selected in app$")
	public void advance_draws_are_selected() throws Throwable {
		mobileLuckyNumPage.buttonClick(LuckeyNumberPageLocator.advanceDrawAndroid);
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.popupHeaderName, 5).getText()
				.contains("SELECT DRAWS"))) {
			Assert.fail();
		}
	}

	@Then("^app draw info should be matched with database$")
	public void app_draw_info_should_match_with_database() throws Throwable {
		mobileLuckyNumPage.advanceDrawListVerify(LuckeyNumberPageLocator.drawListAndroid,
				LuckeyNumberPageLocator.textViewAndroid, "SELECT DRAWS", LuckyNumberSqlQuery.advanceDraw, "active",
				"dd-MM-yyyy HH:mm");

	}
}
