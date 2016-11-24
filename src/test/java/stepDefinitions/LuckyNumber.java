package stepDefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import com.sun.jna.platform.win32.WinDef.LONGLONG;

import com.sun.jna.platform.win32.WinDef.LONGLONG;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper.Null;
import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LuckyNumberPage;
import utils.ReusableStaticMethods;

public class LuckyNumber {

	LoginPage loginPage;
	WebDriver Driver;
	HomePage homePage;
	LuckyNumberPage lnpage;
	BasePage basePage;
    DrawGamePage drawGamePage;

	@Given("^login with valid credentials$")
	public void login_with_valid_credentials() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage(AttachHooks.driver);
		loginPage.LoginWithActiveUser();
		basePage = loginPage.clickLogin();
		if (basePage == null) {
			Assert.fail();
		} else {
			drawGamePage = (DrawGamePage) basePage;
		}
	}

	@Given("^Draw game option is selected$")
	public void draw_game_option_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!drawGamePage.isDrawgameSelected()) {
			Assert.fail();
		}

	}

	@Given("^Lucky number game is selected$")
	public void lucky_number_game_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("test step");
		lnpage = drawGamePage.selectLuckyNumber();
		if (lnpage != null) {
			System.out.println("Lucky number page returned");

		} else {
			System.out.println("Lucky Number page not returned");
			Assert.fail();
		}
	}

	@Given("^Active bet types are present in DB$")
	public void active_bet_types_are_present_in_DB() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		if (lnpage.verifyActiveBetType()) {
			System.out.println("DB and UI Bet types verified");
		} else {
			Assert.fail("Did not receive bet types from CB");
		}

	}

	@Then("^Active bet types are visible$")
	public void active_bet_types_are_visible() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		System.out.println("Active Bet Type Visibility Verified");
	}

	@When("^Permone bet type is selected$")
	public void permone_bet_type_is_selected() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		lnpage.isPerm1Selected();
	}

	@When("^select more than ten numbers$")
	public void select_more_than_ten_numbers() throws Throwable {
		List<Integer> randomNumbers;

		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, 11);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();
			}
		}

	}

	@Then("^popup error message should display$")
	public void popup_error_message_should_display() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		String txt = lnpage.errorMessageHandle();
		if (txt.equalsIgnoreCase("You can select 10 numbers only!!")) {
			System.out.println("error message perm1 verify");
		} else {
			// Write code here that turns the phrase above into concrete actions
			if (txt.equalsIgnoreCase("You can select 10 numbers only!!")) {
				System.out.println("error message perm1 verify");
			} else {
				Assert.fail("Not able to verify error message :" + txt);
			}
		}
	}

	@When("^Permtwo bet type is selected$")
	public void permtwo_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.isPerm2Selected();

	}

	@When("^select more than twenty numbers$")
	public void select_more_than_twenty_numbers() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNum;
		if (lnpage != null) {
			randomNum = ReusableStaticMethods.randomNumber(1, 90, 21);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNum)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}
	}

	@Then("^popup error message should display for greater than twenty numbers$")
	public void popup_error_message_should_display_for_greater_than_twenty_numbers() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		String txt = lnpage.errorMessageHandle();
		if (txt.equalsIgnoreCase("You can select 20 numbers only!!")) {
			System.out.println("error message perm2 verify  ");
		} else {
			Assert.fail("Not able to verify error message :" + txt);
		}
	}

	@When("^Permthree bet type is selected$")
	public void permthree_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.isPerm3Selected();
	}

	@Then("^popup error message for permthree should display$")
	public void popup_error_message_for_permthree_should_display() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String txt = lnpage.errorMessageHandle();
		if (txt.equalsIgnoreCase("You can select 20 numbers only!!")) {
			System.out.println("error message perm3 verify  ");
		} else {
			Assert.fail("Not able to verify error message :" + txt);
		}

	}

	@When("^QP is selected$")
	public void qp_is_selected() throws Throwable {
		lnpage.findElement(LuckeyNumberPageLocator.qplocator, 5).click();

	}

	@Then("^verify selected numbers on purches details$")
	public void verify_selected_numbers_on_purches_details() throws Throwable {
		if (lnpage.isQPValueMatched()) {
			System.out.println("pass");
		} else {
			Assert.fail();
		}
	}

	@When("^qpfield enable$")
	public void qpfield_enable() throws Throwable {
		lnpage.findElement(LuckeyNumberPageLocator.qpfield, 5).sendKeys("5");

	}

	@Then("^verify selected numbers for parmtwo on purches details$")
	public void verify_selected_numbers_for_parmtwo_on_purches_details() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		if (lnpage.isQPValueMatchedForParm2()) {
			System.out.println("pass");
		} else {
			Assert.fail();
		}

	}

	@Then("^verify selected numbers for parmthree on purches details$")
	public void verify_selected_numbers_for_parmthree_on_purches_details() throws Throwable {
		if (lnpage.isQPValueMatchedForParm3()) {
			System.out.println("pass");
		} else {
			Assert.fail();
		}

	}

	@When("^all three draws are selected$")
	public void all_three_draws_are_selected() throws Throwable {
		lnpage.findElement(LuckeyNumberPageLocator.advdraw, 5).clear();
		lnpage.findElement(LuckeyNumberPageLocator.advdraw, 5).sendKeys("3");
	}

	String price;

	@When("^QP is selected for ticketprice$")
	public void qp_is_selected_for_ticketprice() throws Throwable {
		lnpage.findElement(LuckeyNumberPageLocator.qpCheckbox, 10).click();

	}

	@Then("^sum of panel price should be three$")
	public void sum_of_panel_price_should_be_three() throws Throwable {
		String tprice = Integer.toString(3);
		price = lnpage.findElement(LuckeyNumberPageLocator.qpTicketPrice, 5).getText();

		if (price.equals(tprice)) {
			System.out.println("pass");
		} else {
			Assert.fail();
		}

	}

	// Write code here that turns the phrase above into concrete actions

	@When("^select more than twenty numbers for permthree bet type$")
	public void select_more_than_twenty_numbers_for_permthree_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNum;
		if (lnpage != null) {
			randomNum = ReusableStaticMethods.randomNumber(1, 90, 21);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNum)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@When("^Select numbers less than three$")
	public void select_numbers_less_than_three() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, 2);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^buy now button should be disabled for permtwo$")
	public void buy_now_button_should_be_disabled_for_permtwo() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.isBuyButtondisabled();

	}

	@When("^Select numbers less than four$")
	public void select_numbers_less_than_four() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, 3);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^buy now button should be disabled for permthree$")
	public void buy_now_button_should_be_disabled_for_permthree() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.isBuyButtonEnabledpermthree();
	}

	@Then("^Number of boxes should be ten$")
	public void number_of_boxes_should_be_ten() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.permoneBoxes();
	}

	@Then("^Number of boxes should be twenty$")
	public void number_of_boxes_should_be_twenty() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.permtwoboxes();
	}

	@Then("^Number of boxes should be twenty for permthree$")
	public void number_of_boxes_should_be_twenty_for_permthree() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (lnpage.permthreeboxes() == 20) {
			System.out.println("total number of boxes for perm3 is 20");
		}

	}

	@When("^numbers are picked for permone bet type$")
	public void numbers_are_picked_for_permone_bet_type() throws Throwable {
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, 10);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^number of lines should be ten$")
	public void number_of_lines_should_be_ten() throws Throwable {
		if (lnpage.noofLines().equals("10")) {
			System.out.println("no of lines equal to 10");
		} else {
			Assert.fail();
		}

	}

	@When("^selected numbers given (\\d+)$")
	public void selected_numbers_given(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, arg1);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^Number of lines should be (\\w+)$")
	public void number_of_lines_should_be(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (lnpage.noofLines().equals(arg1)) {
			System.out.println("number of lines is correct for perm2");
		} else {
			Assert.fail();
		}

	}

	@When("^selected numbers given (\\d+) for permthree$")
	public void selected_numbers_given_for_permthree(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, arg1);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^Number of lines should be (\\w+) for permthree$")
	public void number_of_lines_should_be_for_permthree(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (lnpage.noofLines().equals(arg1)) {
			System.out.println("number of lines is correct for perm3");
		} else {
			Assert.fail();
		}

	}

	@When("^selected numbers ten are given$")
	public void selected_numbers_ten_are_given() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, 10);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^total ticket amount should be one$")
	public void total_ticket_amount_should_be_one() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (lnpage.ticketPricePermone().equals("1")) {
			System.out.println("ticket price of perm1 is correct");
		} else {
			Assert.fail();
		}
	}

	@When("^selected (\\d+) are given$")
	public void selected_are_given(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, arg1);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^total ticket amount for permtwo should be (.*)$")
	public void total_ticket_amount_for_permtwo_should_be(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		String ticketPrice = ReusableStaticMethods.covertStringToTwoDecimalNum(lnpage.ticketPricePermtwo());
		if (ticketPrice.equals(arg1)) {
			System.out.println("perm2 ticket price matched");
			// change value

		} else {
			Assert.fail();
		}
	}

	@When("^selected (\\d+) for permthree are given$")
	public void selected_for_permthree_are_given(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, arg1);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@Then("^total ticket amount for permthree should be (.*)$")
	public void total_ticket_amount_for_permthree_should_be(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String ticketPrice = ReusableStaticMethods.covertStringToTwoDecimalNum(lnpage.ticketPricePermtwo());
		if (ticketPrice.equals(arg1)) {
			System.out.println("perm3 ticket price matched");
		} else {
			Assert.fail();
		}

	}

	@When("^permone quickpick option is selected$")
	public void permone_quickpick_option_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.findElement(LuckeyNumberPageLocator.qpCheckbox, 5).click();
		// lnpage.findElement(LuckeyNumberPageLocator.qpEnteredTxt, 5).click();

	}

	@When("^buynow button selected$")
	public void buynow_button_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (lnpage.isBuyButtonEnable()) {
			lnpage.findElement(LuckeyNumberPageLocator.buyNowLoctor, 5).click();
		}

		else {
			Assert.fail();
		}

	}

	@When("^In popup alert box accepted$")
	public void in_popup_alert_box_accepted() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (lnpage.isCardnumberPopupEnable()) {
			lnpage.findElement(LuckeyNumberPageLocator.enterCradnumberPopupcancel, 5).click();
			Thread.sleep(200);
			lnpage.alertboxclick();
			Thread.sleep(500);

		} else {
			Assert.fail();
		}

	}

	@Then("^ticket should be puchased$")
	public void ticket_should_be_puchased() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String popupMessage = lnpage.findElement(LuckeyNumberPageLocator.insufficienterrorpopup, 5).getText();
		System.out.println("pop up message: " + popupMessage);
		if (lnpage.findElement(LuckeyNumberPageLocator.insufficienterrorpopup, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {

			Assume.assumeTrue("Retailer has insufficient balance", false);
			// System.out.println("not sufficient balance");

		}

		else if (lnpage.ticketView()) {
			System.out.println("purchased sucessfully");
		} else {
			Assert.fail();
		}

	}

	@When("^Numbers are picked for permtwo bet type$")
	public void numbers_are_picked_for_permtwo_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, 12);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}

	}

	@When("^permthree quickpick option is selected$")
	public void permthree_quickpick_option_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.permthreeQpselected();
	}

	@When("^permtwo ticket purchased$")
	public void permtwo_ticket_purchased() throws Throwable {
		lnpage.isPerm2Selected();
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (lnpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 90, 13);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				lnpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();

			}

		}
		if (lnpage.isBuyButtonEnable()) {
			lnpage.findElement(LuckeyNumberPageLocator.buyNowLoctor, 5).click();
			if (lnpage.isCardnumberPopupEnable()) {
				lnpage.findElement(LuckeyNumberPageLocator.enterCradnumberPopupcancel, 5).click();
				Thread.sleep(200);
				lnpage.alertboxclick();
				Thread.sleep(500);

			}

		}

	}

	@When("^ticket preview display$")
	public void ticket_preview_display() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (lnpage.findElement(LuckeyNumberPageLocator.insufficienterrorpopup, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {
			System.out.println("Retailer has insufficient balance");

		} else if (lnpage.ticketView()) {
			System.out.println("ticket preview display sucessfully");
		} else {
			Assert.fail();
		}
	}

	@Then("^ticket number in preview should be equal to database value$")
	public void ticket_number_in_preview_should_be_equal_to_database_value() throws Throwable {
		List<Map<String, String>> returnedList;
		// Write code here that turns the phrase above into concrete actions
		returnedList = lnpage.returnDatabaseValue();
		if (lnpage.ticketView()) {
			for (Map<String, String> value : returnedList) {
				System.out.println("Printing key value pair");
				for (Map.Entry<String, String> entry : value.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					if (lnpage.findElement(By.xpath("//*[contains(text(), '" + entry.getValue() + "')]"), 5) != null) {

						System.out.println("Element found: " + entry.getValue());
					}

				}

			}
		}

	}
	
	@When("^Advance draw is selected$")
	 public void advance_draw_is_selected() throws Throwable {
	  // Write code here that turns the phrase above into concrete actions
	  lnpage.findElement(LuckeyNumberPageLocator.advanceDrawLocator, 5).click();

	 }

	 @Then("^draw info should be matched with database$")
	 public void draw_info_should_be_matched_with_database() throws Throwable {
	  // Write code here that turns the phrase above into concrete actions
	  lnpage.advanceDrawVerify();
	 }
	

}
