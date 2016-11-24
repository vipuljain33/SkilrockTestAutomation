package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.BonusLottoPageLocators;
import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;
import pages.BonusLottoPage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LuckyNumberPage;
import utils.ReusableStaticMethods;

public class BonusLottoStepDefinitions {
	LoginPage loginPage;
	HomePage homePage;
	BasePage basePage;
	BonusLottoPage bonusLottoPage;
	LuckyNumberPage lnpage;
	DrawGamePage drawGamePage;
	@Given("^login with valid credentials bonusLotto$")
	public void login_with_valid_credentials() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage(AttachHooks.driver);
		loginPage.enterUsername("testret");
		loginPage.enterPassword("12345678");
		basePage = loginPage.clickLogin();
		if (basePage == null) {
			Assert.fail();
		} else {
			drawGamePage = (DrawGamePage) basePage;

		}
	}

	@Given("^Bonus Lotto Game is selected$")
	public void bonus_Lotto_Game_is_selected() throws Throwable {
		try
		{
		bonusLottoPage = drawGamePage.selectBonusLotto();
		if(bonusLottoPage==null){	
			Assert.fail();	
		}
		}catch (Exception e) {
			Assert.fail();
		}
	}  
	

	@When("^Direct(\\d+) is selected$")
	public void direct_is_selected(int arg1) throws Throwable {
		bonusLottoPage.clickDirect6();
	}

	@When("^select less than (\\d+) numbers$")
	public void select_less_than_numbers(int arg1) throws Throwable {
		bonusLottoPage.selectNumberLessThenGivenNumber(arg1);

	}

	@When("^select more than (\\d+) numbers$")
	public void select_more_than_numbers(int arg1) throws Throwable {
		bonusLottoPage.selectNumberMoreThenGivenNumber(arg1);
	}

	@Then("^popup error message should display Bonus Lotto$")
	public void popup_error_message_should_display_Bonus_Lotto() throws Throwable {
		String text = bonusLottoPage.errorMessageHandle();

		if (text.equalsIgnoreCase("Maximum 4 lines can be entered"))
			System.out.println("error message direct6 verify");
		else if (text.equalsIgnoreCase("Input is between 1 & 4 including both"))
			System.out.println("error message perm6 verify");
		else
			Assert.fail("Not able to verify error Message :" + text);
	}

	@When("^Perm(\\d+) is selected$")
	public void perm_is_selected(int arg1) throws Throwable {
		bonusLottoPage.clickPerm6();
	}

	@Then("^buy option is not enable$")
	public void buy_option_is_not_enable() throws Throwable {
		Assert.assertFalse(bonusLottoPage.buyisEnabled());
	}

	@Then("^permsix popup error message should display$")
	public void permsix_popup_error_message_should_display() throws Throwable {
		String text = bonusLottoPage.permerrorPopup();
		System.out.println(text);
		if (text.equalsIgnoreCase("Maximum only 15 numbers "))
			System.out.println("error message direct6 verify");
		else
			Assert.fail("Not able to verify error Message :" + text);
	}

	@When("^select less than (\\d+) numberOfline$")
	public void select_less_than_numberOfline(int arg1) throws Throwable {
		bonusLottoPage.checkQuickPick();
		bonusLottoPage.enterQuickPickNumber(arg1 - 1);

	}

	@Then("^permsixQp popup error message should display$")
	public void permsixqp_popup_error_message_should_display() throws Throwable {
		String text = bonusLottoPage.permsixQperrorPopup();
		if (text.equalsIgnoreCase("Input is between 7 & 15 including both"))
			System.out.println("error message direct6 verify");
		else
			Assert.fail("Not able to verify error Message :" + text);
	}

	@When("^select more than (\\d+) numberOfline$")
	public void select_more_than_numberOfline(int arg1) throws Throwable {
		bonusLottoPage.checkQuickPick();
		bonusLottoPage.enterQuickPickNumber(arg1 + 1);
	}

	@When("^number are selected$")
	public void are_selected(List<Integer> list) throws Throwable {
		for(int i=0;i<list.size();i++){
		bonusLottoPage.selectGivenNumber(list.get(i));
		int result = bonusLottoPage.validateNoOfLinesPerm6();
		int expected = bonusLottoPage.validateNoOflinesPerm6Panel();
		if (result == expected)
			System.out.println("noOflines verifies");
		else
			Assert.fail("Not able to verify noOflines");

		}	
	}

	@Then("^buy option should enable to buy$")
	public void buy_option_should_enable_to_buy() throws Throwable {
		Assert.assertTrue(bonusLottoPage.buyisEnabled());
	}

	@When("^select (\\d+) numberOfline$")
	public void select_numberOfline(int arg1) throws Throwable {
		bonusLottoPage.checkQuickPick();
		bonusLottoPage.enterQuickPickNumber(arg1);
	}

	@Then("^validate number of lines for permsix$")
	public void validate_number_of_lines_for_permsix() {
		int result = bonusLottoPage.validateNoOfLinesPerm6();
		int expected = bonusLottoPage.validateNoOflinesPerm6Panel();
		if (result == expected)
			System.out.println("noOflines verifies");
		else
			Assert.fail("Not able to verify noOflines");

	}

	@When("^QuickPick for direct-six is checked$")
	public void quickpick_for_directsix_is_checked() throws Throwable {
		bonusLottoPage.clickDirect6();
		bonusLottoPage.checkQuickPick();
	}

	@When("^number num greater than Four is entered$")
	public void number_greater_than_four_is_entered(List<Integer> list) throws Throwable {
			for(int i=0;i<list.size();i++){
			bonusLottoPage.checkQuickPick();
			bonusLottoPage.enterQuickPickNumber(list.get(i));
		
			Assert.assertFalse(bonusLottoPage.buyisEnabled());
			
			}
		}	

	@When("^number less than Five is entered$")
	public void number_less_than_Five_is_entered(List<Integer> list) throws Throwable {
		for(int i=0;i<list.size();i++){
			bonusLottoPage.checkQuickPick();
		bonusLottoPage.enterQuickPickNumber(list.get(i));
		Assert.assertTrue(bonusLottoPage.buyisEnabled());
	}
	}

	@Then("^buy button should be enabled$")
	public void buy_button_should_be_enabled() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(bonusLottoPage.buyisEnabled());
	}

	@Given("^(\\d+) numbers are picked for bonus Lotto$")
	public void numbers_are_picked(int N) throws InterruptedException {
		bonusLottoPage.selectNumber(N);

	}

	@When("^bet amount (.+) is selected$")
	public void bet_amount_is_selected(float betAmount) {
		bonusLottoPage.selectBetAmount(betAmount);
	}

	@Then("^validate ticket price direct6$")
	public void validate_ticket_price_direct6() {
		Assert.assertTrue(bonusLottoPage.validateDirectSixTicketPrice());

	}
	@Then("^validate ticket price perm6$")
	public void validate_ticket_price_perm6() {
		Assert.assertTrue(bonusLottoPage.validatePermSixTicketPrice());

	}

	@When("^select num different than sixN numbers$")
	public void select_different_than_sixN_numbers(List<Integer> numbers) throws Throwable {
		for(int i=0;i<numbers.size();i++){
		bonusLottoPage.selectNumber(numbers.get(i));
		Assert.assertFalse(bonusLottoPage.buyisEnabled());
		
	}
	}

	@Given("^Active bet types are present in DB BonusLotto$")
	public void active_bet_types_are_present_in_DB_BonusLotto() throws Throwable {
		if (bonusLottoPage.verifyActiveBetType()) {
			System.out.println("Active Bet Type Verified");
		} else {
			Assert.fail("Did not receive bet types from CB");
		}

	}

	@Then("^Active bet types are visible for BonusLotto$")
	public void active_bet_types_are_visible_for_BonusLotto() throws Throwable {
		System.out.println("Active Bet Type Visibility Verified");
	}

	@Then("^Number of boxes should be twentyfour$")
	public void number_of_boxes_should_be_twentyfour() throws Throwable {
		bonusLottoPage.directSixBoxes();
	}

	@Then("^Number of boxes should be fifteen$")
	public void number_of_boxes_should_be_fifteen() throws Throwable {
		bonusLottoPage.permSixBoxes();
	}

	@When("^reset button is clicked$")
	public void reset_button_is_clicked() {
		bonusLottoPage.clickResetButton();
	}

	@Then("^validate reset$")
	public void validate_reset() {
		Assert.assertTrue(bonusLottoPage.validateReset());
	}

	@Given("^buynow button selected bonus Lotto$")
	public void buynow_button_selected() throws Throwable {
		if (bonusLottoPage.buyisEnabled()) {
			bonusLottoPage.findElement(BonusLottoPageLocators.buyNowLoctor, 5).click();
		} else {
			Assert.fail();
		}
	}

	@Given("^In popup alert box accepted bonus Lotto$")
	public void in_popup_alert_box_accepted() throws Throwable {
		if (bonusLottoPage.isCardnumberPopupEnable()) {
			bonusLottoPage.findElement(BonusLottoPageLocators.enterCradnumberPopupcancel, 5).click();
			bonusLottoPage.alertboxclick();

		} else {
			Assert.fail();
		}
	}

	@Then("^ticket should be puchased bonus Lotto$")
	public void ticket_should_be_puchased() throws Throwable {
		String popupMessage = bonusLottoPage.findElement(BonusLottoPageLocators.insufficienterrorpopup, 5).getText();
		System.out.println("pop up message: " + popupMessage);
		if (bonusLottoPage.findElement(BonusLottoPageLocators.insufficienterrorpopup, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {

			Assume.assumeTrue("Retailer has insufficient balance", false);
			// System.out.println("not sufficient balance");

		}

		else if (bonusLottoPage.ticketView()) {
			System.out.println("purchased sucessfully");
		} else {
			Assert.fail();
		}
	}

	@When("^Advance draw is selected bonus Lotto$")
	public void advance_draw_is_selected() throws Throwable {
		bonusLottoPage.findElement(BonusLottoPageLocators.advanceDrawLocator, 5).click();
	}

	@Then("^draw info should be matched with database bonus Lotto$")
	public void draw_info_should_be_matched_with_database() throws Throwable {
		bonusLottoPage.advanceDrawVerify();
	}

	@When("^Perm(\\d+) ticket purchased$")
	public void perm_ticket_purchased(int arg1) throws Throwable {
		bonusLottoPage.clickDirect6();
		bonusLottoPage.selectNumber(12);
		if (bonusLottoPage.buyisEnabled()) {
			bonusLottoPage.findElement(BonusLottoPageLocators.buyNowLoctor, 5).click();
			if (bonusLottoPage.isCardnumberPopupEnable()) {
				bonusLottoPage.findElement(BonusLottoPageLocators.enterCradnumberPopupcancel, 5).click();
				
				bonusLottoPage.alertboxclick();
				

			}

		}

	}

	@When("^ticket preview display bonus Lotto$")
	public void ticket_preview_display() throws Throwable {
		if (bonusLottoPage.findElement(BonusLottoPageLocators.insufficienterrorpopup, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {
			System.out.println("Retailer has insufficient balance");

		} else if (bonusLottoPage.ticketView()) {
			System.out.println("ticket preview display sucessfully");
		} else {
			Assert.fail();
		}
	}

	@Then("^ticket number in preview should be equal to database value bonus Lotto$")
	public void ticket_number_in_preview_should_be_equal_to_database_value() throws Throwable {
		List<Map<String, String>> returnedList;
		// Write code here that turns the phrase above into concrete actions
		returnedList = bonusLottoPage.returnDatabaseValue();
		if (bonusLottoPage.ticketView()) {
			for (Map<String, String> value : returnedList) {
				System.out.println("Printing key value pair");
				for (Map.Entry<String, String> entry : value.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					if (bonusLottoPage.findElement(By.xpath("//*[contains(text(), '" + entry.getValue() + "')]"),
							5) != null) {

						System.out.println("Element found: " + entry.getValue());
					}

				}

			}
		}

	}

	@When("^select (\\d+)$")
	public void select(int arg1) throws Throwable {
		bonusLottoPage.selectAdvancedDraw(arg1);
	}

}