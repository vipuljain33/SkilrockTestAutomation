package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Assume;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.TwelveByTwentyFourPageLocator;
import pages.BasePage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TwelveByTwentyFourPage;
import utils.ReusableStaticMethods;

public class TwelveByTwentyFour {

	LoginPage loginPage;// global varaibles
	WebDriver driver;
	HomePage homePage;
	TwelveByTwentyFourPage tbtfpage;
	BasePage basePage;
	DrawGamePage drawGamePage;

	@Given("^login with valid credentials tbtf$")
	public void login_with_valid_credentials_tbtf() throws Throwable {
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

	@Given("^draw game option is selected tbtf$")
	public void draw_game_option_is_selected_tbtf() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!drawGamePage.isDrawgameSelected()) {
			Assert.fail();
		}
	}

	@Then("^TwelveByTwentyfour game is selected$")
	public void twelvebytwentyfour_game_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage = drawGamePage.selectTwelveByTwentyFour();
		if (!tbtfpage.isTwelveByTwentyFourSelected()) {
			Assert.fail("12/24 not selected");
		}
	}

	@Given("^Active bet types are present in DB tbtf$")
	public void active_bet_types_are_present_in_DB_tbtf() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.verifyBetTypes()) {
			Assert.fail("error in fetching bet types from DB");
		}
	}

	@Then("^Active bet types are visible tbtf$")
	public void active_bet_types_are_visible_tbtf() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Active Bet Type Visibility Verified");
	}

	@When("^First Twelve bet type is selected$")
	public void first_Twelve_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isFirst12bettypeSelected()) {
			Assert.fail("error in first twelve selection");
		}
	}

	@Then("^one to twelve numbers selected automatically$")
	public void one_to_twelve_numbers_selected_automatically() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.first12SelectedNum()) {
			Assert.fail("error in selection");
		}
	}

	@Then("^quick pick should be disbale$")
	public void quick_pick_should_be_disbale() throws Throwable {
		if (!tbtfpage.QPButtonDisable()) {
			Assert.fail("error in selection of QP button");
		}
	}
	
	@When("^Last Twelve bet type is selected$")
	public void last_Twelve_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isLast12bettypeSelected()) {
			Assert.fail("error in last twelve selection");
		}
	}

	@Then("^Twelve to TwentyFour numbers selected automatically$")
	public void twelve_to_TwentyFour_numbers_selected_automatically() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.last12SelectedNum()) {
			Assert.fail("error in selection");
		}

	}

	@When("^AllOdd bet type is selected for AllOdd bet type$")
	public void allodd_bet_type_is_selected_for_AllOdd_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isAllOddbettypeSelected()) {
			Assert.fail("error in all odd selection");
		}
	}

	@Then("^Twelve Odd numbers selected automatically for AllOdd bet type$")
	public void twelve_Odd_numbers_selected_automatically_for_AllOdd_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.alloddSelectedNum()) {
			Assert.fail("error in selection");
		}
	}

	@When("^AllEven bet type is selected for AllEven bet type$")
	public void alleven_bet_type_is_selected_for_AllEven_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isAllEvenbettypeSelected()) {
			Assert.fail("error in all even selection");
		}
	}

	@Then("^Twelve Even numbers selected automatically for AllEven bet type$")
	public void twelve_Even_numbers_selected_automatically_for_AllEven_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.allEvenSelectedNum()) {
			Assert.fail("error in selection");
		}
	}

	@When("^OddEven bet type is selected$")
	public void oddeven_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isOddEvenbettypeSelected()) {
			Assert.fail("error in odd even selection");
		}
	}

	@Then("^Twelve Odd and Even numbers selected automatically for OddEven bet type$")
	public void twelve_Odd_and_Even_numbers_selected_automatically_for_OddEven_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.OddEvenSelectedNum()) {
			Assert.fail("error in selection");
		}
	}

	@When("^EvenOdd bet type is selected$")
	public void evenodd_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isEvenOddbettypeSelected()) {
			Assert.fail("error in even odd selection");
		}
	}

	@Then("^Twelve Even and Odd numbers selected automatically for EvenOdd bet type$")
	public void twelve_Even_and_Odd_numbers_selected_automatically_for_EvenOdd_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.EvenOdddSelectedNum()) {
			Assert.fail("error in selection");
		}
	}

	@When("^JumpEvenOdd bet type is selected$")
	public void alleven_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isJumpEvenOddbettypeSelected()) {
			Assert.fail("error in jump even odd selection");
		}
	}

	@Then("^Twelve Even and Oddd numbers selected in pair automatically for JumpEvenOdd bet type$")
	public void twelve_Even_and_Oddd_numbers_selected_in_pair_automatically_for_JumpEvenOdd_bet_type()
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.JumpEvenOdddSelectedNum()) {
			Assert.fail("error in selection");
		}
	}

	@When("^JumpOddEven bet type is selected$")
	public void jumpoddeven_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isJumpOddEvenbettypeSelected()) {
			Assert.fail("error in jump odd even selection");
		}
	}

	@Then("^Twelve Even and Odd numbers selected in pair automatically for JumpOddEven bet type$")
	public void twelve_Even_and_Odd_numbers_selected_in_pair_automatically_for_JumpOddEven_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.JumpOddEvenSelectedNum()) {
			Assert.fail("error in selection");
		}

	}

	@Then("^Number of boxes should be Twelve for  FirstTwelve$")
	public void number_of_boxes_should_be_Twelve_for_FirstTwelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isFirst12bettypeSelected()) {
			Assert.fail("error in first twelve selection");
		}
		tbtfpage.NoOfBoxes();
	}

	@When("^Perm twelve bet type is selected$")
	public void perm_twelve_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isPerm12bettypeSelected()) {
			Assert.fail("error in perm twelve selection");
		}
	}

	@When("^Select numbers less than thirteen$")
	public void select_numbers_less_than_thirteen() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		if (tbtfpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 24, 12);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				tbtfpage.findElement(By.xpath(TwelveByTwentyFourPageLocator.selectNumber + val + "]"), 5).click();
			}
		}
	}

	@Then("^buy now button should be disabled for perm twelve$")
	public void buy_now_button_should_be_disabled_for_perm_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isBuyButtonDisabled()) {
			Assert.fail("error in seletion of buy button");
		}

	}

	@When("^Select numbers greater than fourteen for tbtf$")
	public void select_numbers_greater_than_fourteen_for_tbtf() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.isPerm12bettypeSelected();
		List<Integer> randomNumbers;
		if (tbtfpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 24, 15);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				tbtfpage.findElement(By.xpath(TwelveByTwentyFourPageLocator.selectNumber + val + "]"), 5).click();
			}

		}
	}

	@Then("^popup error message for permthree should display for tbtf$")
	public void popup_error_message_for_permthree_should_display_for_tbtf() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.errorMessageHandle();
	}

	@Then("^Number of boxes should be Twelve for perm Twelve$")
	public void number_of_boxes_should_be_Twelve_for_perm_Twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isPerm12bettypeSelected()) {
			Assert.fail("error in perm twelve selection");
		}
		tbtfpage.NoOfBoxesPerm12();
	}

	@When("^selected bet type is direct twelve$")
	public void selected_bet_type_is_direct_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isTwelveByTwentyFourSelected()) {
			Assert.fail("error in seletion of direct twelve");
		}
	}

	@Then("^Random number should be selected for direct twelve$")
	public void random_number_should_be_selected_for_direct_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.clickQP()) {
			Assert.fail("error in QP selection");
		}
		tbtfpage.printSelectedNum();
	}

	// Need to implemented after bug resolve
	@When("^Perm twelve is selected$")
	public void perm_twelve_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// tbtfpage.isTwelveByTwentyFourSelected();
		// tbtfpage.isPerm12bettypeSelected();
	}

	@When("^select (\\d+) for perm twelve$")
	public void select_for_perm_twelve(int arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// tbtfpage.clickQP();
		// tbtfpage.findElement(TwelveByTwentyFourPageLocator.qpEnteredTxt,
		// 5).sendKeys("arg1");
	}

	@Then("^Random number should be selected for perm twelve$")
	public void random_number_should_be_selected_for_perm_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// tbtfpage.printSelectedNum();
		// System.out.println("selected numbers for perm12 qp are : ");
	}

	@When("^AllOdd is selected$")
	public void allodd_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.isTwelveByTwentyFourSelected();
		if (!tbtfpage.isAllOddbettypeSelected()) {
			Assert.fail("error in all odd bet type selection");
		}
	}



	@When("^AllEven is selected$")
	public void alleven_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.isTwelveByTwentyFourSelected();
		if (!tbtfpage.isAllEvenbettypeSelected()) {
			Assert.fail("error in all even bet type selection");
		}
	}

	@When("^JumpOddEven is selected$")
	public void jumpoddeven_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.isTwelveByTwentyFourSelected();
		if (!tbtfpage.isJumpOddEvenbettypeSelected()) {
			Assert.fail("error in jump odd even bet type selection");
		}
	}

	@When("^JumpEvenOdd is selected$")
	public void jumpevenodd_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.isTwelveByTwentyFourSelected();
		if (!tbtfpage.isJumpEvenOddbettypeSelected()) {
			Assert.fail("error in jump odd even bet type selection");
		}
	}

	@When("^Perm Twelve bet type is selected$")
	public void perm_Twelve_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isPerm12bettypeSelected()) {
			Assert.fail("error in perm twelve bet type selection");
		}
	}

	@When("^selected numbers given (\\d+) for perm Twelve$")
	public void selected_numbers_given_for_perm_Twelve(int arg1) throws Throwable {
		List<Integer> clickRandomNumbers;
		if (tbtfpage != null) {
			clickRandomNumbers = ReusableStaticMethods.randomNumber(1, 24, arg1);
			for (String val : ReusableStaticMethods.convertIntegerListToString(clickRandomNumbers)) {
				tbtfpage.findElement(By.xpath(TwelveByTwentyFourPageLocator.selectNumber + val + "]"), 5).click();
			}
		}
	}

	@Then("^Number of lines should be (\\d+) for perm Twelve$")
	public void number_of_lines_should_be_for_perm_Twelve(int arg1) throws Throwable {
		if (tbtfpage.noOfLines().equals(String.valueOf(arg1))) {
			System.out.println("number of lines is correct for perm12");
		} else {
			Assert.fail();
		}
	}

	// new 2
	@When("^select direct twelve$")
	public void select_direct_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.isTwelveByTwentyFourSelected();
		List<Integer> clickRandomNumbers;
		if (tbtfpage != null) {
			clickRandomNumbers = ReusableStaticMethods.randomNumber(1, 24, 12);
			for (String val : ReusableStaticMethods.convertIntegerListToString(clickRandomNumbers)) {
				tbtfpage.findElement(By.xpath(TwelveByTwentyFourPageLocator.selectNumber + val + "]"), 5).click();
			}
		}
	}

	@Then("^Number of lines should be (\\d+) for tbtf$")
	public void number_of_lines_should_be_for_tbtf(int arg1) throws Throwable {
		if (tbtfpage.noOfLines().equals(String.valueOf(arg1))) {
			System.out.println("number of lines is correct for  bet types");
		} else {
			Assert.fail();
		}
	}

	@When("^select first twelve$")
	public void select_first_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isFirst12bettypeSelected()) {
			Assert.fail("error in jump odd even bet type selection");
		}
		tbtfpage.printSelectedNum();
	}

	// amount
	@When("^first twelve bet type is selected$")
	public void first_twelve_bet_type_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isFirst12bettypeSelected()) {
			Assert.fail("error in first twelve bet type selection");
		}

	}

	@When("^selected numbers twelve are given$")
	public void selected_numbers_twelve_are_given() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Numbers selected Automatically");
	}

	@Then("^total ticket amount should be one for first twelve$")
	public void total_ticket_amount_should_be_one_for_first_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (tbtfpage.ticketPriceFirstTwelve().equals("0.50")) {
			System.out.println("ticket price of first twelve is correct");
		} else {
			Assert.fail();
		}
	}

	//
	@When("^select first twelve bet type$")
	public void select_first_twelve_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isFirst12bettypeSelected()) {
			Assert.fail("error in first twelve bet type selection");
		}
	}

	@When("^select perm twelve bet type$")
	public void select_perm_twelve_bet_type() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isPerm12bettypeSelected()) {
			Assert.fail("error in first twelve bet type selection");
		}
		
	}

	@When("^Advance draw is selected for perm twelve$")
	public void advance_draw_is_selected_for_perm_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.findElement(TwelveByTwentyFourPageLocator.advanceDrawLocator, 3).click();
	}

	@Then("^draw info should be matched with db$")
	public void draw_info_should_be_matched_with_db() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.verifyAdvanceDraw();
	}

	// new
	@When("^direct twelve quickpick option is selected$")
	public void direct_twelve_quickpick_option_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!tbtfpage.isTwelveByTwentyFourSelected()) {
			Assert.fail("error in first twelve bet type selection");
		}
		tbtfpage.clickQP();
	}

	@When("^buy now button selected$")
	public void buy_now_button_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (tbtfpage.isBuyButtonEnabled()) {
			tbtfpage.findElement(TwelveByTwentyFourPageLocator.buyNowLocator, 5).click();
		}

		else {
			Assert.fail();
		}

	}

	@When("^popup alert box accepted$")
	public void popup_alert_box_accepted() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (tbtfpage.isCardnumberPopupEnable()) {
			tbtfpage.findElement(TwelveByTwentyFourPageLocator.enterCradnumberPopupcancel, 5).click();
			Thread.sleep(200);
			tbtfpage.alertboxclick();
			Thread.sleep(500);

		} else {
			Assert.fail();
		}

	}

	@Then("^ticket should be puchased for direct twelve$")
	public void ticket_should_be_puchased_for_direct_twelve() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		String popupMessage = tbtfpage.findElement(TwelveByTwentyFourPageLocator.insufficienterrorpopup, 5).getText();
		System.out.println("pop up message: " + popupMessage);
		if (tbtfpage.findElement(TwelveByTwentyFourPageLocator.insufficienterrorpopup, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {
			Assume.assumeTrue("Retailer has insufficient balance", false);
			// System.out.println("not sufficient balance");

		}

		else if (tbtfpage.ticketView()) {
			System.out.println("purchased sucessfully");
		} else {
			Assert.fail();
		}

	}

	// new1
	@When("^direct twelve ticket purchased$")
	public void direct_twelve_ticket_purchased() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		tbtfpage.isTwelveByTwentyFourSelected();
		// Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		// Write code here that turns the phrase above into concrete actions
		if (tbtfpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 24, 12);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				tbtfpage.findElement(By.xpath(LuckeyNumberPageLocator.selectNumber + val + "]"), 5).click();
			}
		}
	}

	@When("^ticket preview display for direct twelve$")
	public void ticket_preview_display_for_direct_twelve() throws Throwable {
		
		if (tbtfpage.findElement(TwelveByTwentyFourPageLocator.insufficienterrorpopup, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {
			System.out.println("Retailer has insufficient balance");

		} else if (tbtfpage.ticketView()) 
		{
			System.out.println("ticket preview display sucessfully");
		} else {
			Assert.fail();
		}
	}

	@Then("^ticket number in preview should be equal to db value$")
	public void ticket_number_in_preview_should_be_equal_to_db_value() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<Map<String, String>> returnedList;
		// Write code here that turns the phrase above into concrete actions
		returnedList = tbtfpage.returnDatabaseValue();
		if (tbtfpage.ticketView()) {
			for (Map<String, String> value : returnedList) {
				System.out.println("Printing key value pair");
				for (Map.Entry<String, String> entry : value.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					if (tbtfpage.findElement(By.xpath("//*[contains(text(), '" + entry.getValue() + "')]"),
							5) != null) {
						System.out.println("Element found: " + entry.getValue());
					}

				}

			}
		}

	}
}
