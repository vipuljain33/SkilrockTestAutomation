package stepDefinitions.mobileStepDefinations;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

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
		mobileHomePage = mobileLoginPage.clickLogin();
		if (mobileHomePage == null) {
			Assert.fail();
		}
	}

	@Given("^Draw games icon is selected$")
	public void draw_games_icon_is_selected() throws Throwable {
		mobileDrawGamePage = mobileHomePage.selectDrawGame();
		if (mobileDrawGamePage == null) {
			Assert.fail();
		}
		// mobileLuckyNumPage.selectDG();
	}

	@Given("^Lucky numbers game is selected$")
	public void lucky_numbers_game_is_selected() throws Throwable {
		mobileLuckyNumPage = mobileDrawGamePage.selectLuckyNumbers();
		if (mobileLuckyNumPage == null) {
			Assert.fail();
		}
		// mobileLuckyNumPage.selectLuckyNumbers();
	}

	@Given("^PermOne bet type and Pick New is selected$")
	public void permOne_bet_type_and_Pick_New_is_selected() throws Throwable {
		mobileLuckyNumPage.validateBetType(LuckeyNumberPageLocator.perm1Android, "Perm1");
		mobileLuckyNumPage.validatePickType(LuckeyNumberPageLocator.pickNewAndroid, "checked");
	}

	@Given("^numbers (\\d+) are picked$")
	public void numbers_are_picked(int numPicked) throws Throwable {
		mobileLuckyNumPage.swipe(1, 0.80, 0.10, 600, 400);
		List<Integer> randomNumbers;
		if (mobileLuckyNumPage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(0, 89, numPicked);
			for (int i = 0; i < randomNumbers.size(); i++) {
				mobileLuckyNumPage
						.findElement(
								By.xpath(LuckeyNumberPageLocator.pickRandomNumAndroid + randomNumbers.get(i) + "']"), 5)
						.click();
			}
		}
		mobileLuckyNumPage.buttonClick(LuckeyNumberPageLocator.clickOKAndroid);

	}

	@When("^number of lines selected are (\\w+) and NumberSelected (\\w+) and increase betAmount by (\\d+)$")
	public void number_of_lines_selected_are_ten(String noOfLines, String numberSelected, int clickBetAmt)
			throws Throwable {
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.noOfLinesAndroid, 5).getText()
				.contains(noOfLines))) {
			Assert.fail();
		}

		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.selectedNumbersAndroid, 5).getText()
				.contains(numberSelected))) {
			Assert.fail();
		}
		mobileLuckyNumPage.clickMultiple(LuckeyNumberPageLocator.increaseAndroid, clickBetAmt);
	}

	@Then("^PurchaseAmt \\$ (.*)$")
	public void betamount_and_NumberPicked_and_PurchaseAmt_$(String amount) throws Throwable {
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.finalAmountAndroid, 5).getText()
				.contains(amount))) {
			Assert.fail();
		}
	}

	@Then("^Purchased ticket is generated$")
	public void purchased_ticket_is_generated() throws Throwable {
		mobileLuckyNumPage.confirmBuy();
		if (!(mobileLuckyNumPage.findElement(LuckeyNumberPageLocator.tktPreviewGamenameAndroid, 5).getText()
				.contains("LUCKY NUMBERS"))) {
			Assert.fail();
		}
	}

}
