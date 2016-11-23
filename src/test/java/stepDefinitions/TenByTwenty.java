package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import com.sun.jna.platform.win32.WinDef.LONGLONG;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.TenByTwentyLocator;
import pages.BasePage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LuckyNumberPage;
import pages.TenByTwentyPage;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;

public class TenByTwenty {
	LoginPage loginPage;
	WebDriver Driver;
	HomePage homePage;
	LuckyNumberPage lnpage;
	TenByTwentyPage tbt;
	BasePage basePage;

	int flag = 1;

	@Given("^login with given credentials for TenByTwenty$")
	public void login_with_given_credentials() throws Throwable {
		loginPage = new LoginPage(AttachHooks.driver);
		loginPage.LoginWithActiveUser();
		basePage = loginPage.clickLogin();
		if (basePage == null) {
			Assert.fail();
		} else {
			tbt = new TenByTwentyPage(AttachHooks.driver);

		}
	}

	@Given("^select Ten By Twenty game for TenByTwenty$")
	public void select_Ten_By_Twenty_game() throws Throwable {

		if (tbt == null) {
			Assert.fail();
		} else {
			tbt.isTenByTwentySelected();

		}
	}

	/*
	 * @Given("^logged in successfully for TenByTwenty$") public void
	 * logged_in_successfully() throws Throwable { // Write code here that turns
	 * the phrase above into concrete actions
	 * System.out.println("logged in successfully!!"); }
	 * 
	 * @When("^draw game is selected for TenByTwenty$") public void
	 * draw_game_is_selected1() throws Throwable { // Write code here that turns
	 * the phrase above into concrete actions
	 * System.out.println("draw game selected"); }
	 * 
	 * @Then("^ten by twenty should be visible for TenByTwenty$") public void
	 * ten_by_twenty_should_be_visible() throws Throwable {
	 * tbt.isTenByTwentySelected(); }
	 */

	@Given("^direct ten bet type is selected for TenByTwenty$")
	public void direct_ten_bet_type_is_selected() throws Throwable {
		if (!(tbt.isDirectTenSelected())) {
			Assert.fail("DIRECT 10 NOT FOUND!!");
		}

	}

	@When("^Quickpick is selected for TenByTwenty$")
	public void quickpick_is_selected() throws Throwable {
		if (!(tbt.isQPSelected())) {
			Assert.fail("QP NOT FOUND!!");
		}

	}

	@Then("^random number between one to twenty should be selected for TenByTwenty$")
	public void random_number_between_one_to_twenty_should_be_selected() throws Throwable {
		if (!(tbt.NumberBetweenTenToTwenty())) {
			Assert.fail("YOU CAN'T CHHOSE NUMBER GREATER THAN 20");
		}
	}

	@When("^first ten bet type is selected for TenByTwenty$")
	public void first_ten_bet_type_is_selected_for_TenByTwenty() throws Throwable {
		if (!(tbt.isFirstTenSelected())) {
			Assert.fail("FITST 10 NOT FOUND!!");
		}

	}

	@Then("^number picked should be one to ten for TenByTwenty$")
	public void number_picked_should_be_one_to_ten_for_TenByTwenty() throws Throwable {
		if (!(tbt.NumberSelectionFirstTen())) {
			Assert.fail("YOU CAN'T CHOOSE NUMBERS OTHER THAN FIRST TEN");
		}
	}

	@When("^last ten bet type is selected for TenByTwenty$")
	public void last_ten_bet_type_is_selected_for_TenByTwenty() throws Throwable {
		if (!(tbt.isLastTenSelected())) {
			Assert.fail("LAST 10 NOT FOUND!!");
		}
	}

	@Then("^number picked should be eleven to twenty for TenByTwenty$")
	public void number_picked_should_be_eleven_to_twenty_for_TenByTwenty() throws Throwable {
		if (!(tbt.NumberSelectionLastTen())) {
			Assert.fail("YOU CAN'T CHOOSE NUMBERS OTHER THAN LAST TEN");
		}
	}

	@When("^all odd bet type is selected for TenByTwenty$")
	public void all_odd_bet_type_is_selected_for_TenByTwenty() throws Throwable {
		if (!(tbt.isAllOddSelected())) {
			Assert.fail("ALL ODD NOT FOUND!!");
		}
	}

	@Then("^number picked should be odd for TenByTwenty$")
	public void number_picked_should_be_odd_for_TenByTwenty() throws Throwable {
		if (!(tbt.NumberSelectionAllOdd())) {
			Assert.fail("YOU CAN'T CHOOSE EVEN NUMBERS ");
		}
	}

	@When("^all even bet type is selected for TenByTwenty$")
	public void all_even_bet_type_is_selected() throws Throwable {
		if (!(tbt.isAllEvenSelected())) {
			Assert.fail("ALL EVEN NOT FOUND!!");
		}
	}

	@Then("^number picked should be even for TenByTwenty$")
	public void number_picked_should_be_even() throws Throwable {
		if (!(tbt.EvenNumberSelection())) {
			Assert.fail("YOU CAN'T CHOOSE ODD NUMBERS");
		}
	}

	@Then("^QP should not enable for TenByTwenty$")
	public void qp_should_not_enable() throws Throwable {
		if (!(tbt.isQpDisabled())) {
			Assert.fail("QP SHOULD NOT BE ENABLED");
		}
	}

	@When("^evenodd bet type is selected for TenByTwenty$")
	public void evenodd_bet_type_is_selected_for_TenByTwenty() throws Throwable {
		if (!(tbt.isEvenOddSelected())) {
			Assert.fail(" EVENODD NOT FOUND!!");
		}
	}

	@Then("^number picked should be even between one to ten and odd between eleven to twenty for TenByTwenty$")
	public void number_picked_should_be_even_between_one_to_ten_and_odd_between_eleven_to_twenty_for_TenByTwenty()
			throws Throwable {
		if (!(tbt.EvenOddNumberSelection())) {
			Assert.fail("WRONG NUMBER SELECTION");
		}

	}

	@When("^oddeven bet type is selected for TenByTwenty$")
	public void oddeven_bet_type_is_selected_for_TenByTwenty() throws Throwable {
		if (!(tbt.isOddEvenSelected())) {
			Assert.fail(" ODDEVEN NOT FOUND!!");
		}
	}

	@Then("^number picked should be odd between one to ten and even between eleven to twenty for TenByTwenty$")
	public void number_picked_should_be_odd_between_one_to_ten_and_even_between_eleven_to_twenty_for_TenByTwenty()
			throws Throwable {
		if (!(tbt.OddEvenNumberSelection())) {
			Assert.fail("WRONG NUMBER SELECTION");
		}
	}

	@When("^jumpoddeven  bet type is selected for TenByTwenty$")
	public void jumpoddeven_bet_type_is_selected_for_TenByTwenty() throws Throwable {
		if (!(tbt.isJumpOddEvenSelected())) {
			Assert.fail("JUMPODDEVEN NOT FOUND!!");
		}
	}

	@Then("^number picked should be in oddeven pair for TenByTwenty$")
	public void number_picked_should_be_in_oddeven_pair_for_TenByTwenty() throws Throwable {
		List<String> list1 = new ArrayList<String>();
		list1 = tbt.NumbersPicked(TenByTwentyLocator.numpicked1);

		List<String> list2 = new ArrayList<String>();
		list2 = tbt.ListOfJumpOddEven();

		if (list1.equals(list2)) {
			System.out.println("NUMBER SELECTION VERIFIED SUCCESSFULLY!!");
		} else

		{
			Assert.fail("WRONG NUMBER SELECTION");
		}

	}

	@When("^jumpevenodd  bet type is selected for TenByTwenty$")
	public void jumpevenodd_bet_type_is_selected_for_TenByTwenty() throws Throwable {
		if (!(tbt.isJumpEvenOddSelected())) {
			Assert.fail("JUMPEVENODD NOT FOUND!!");
		}
	}

	@Then("^number picked should be in evenodd pair for TenByTwenty$")
	public void number_picked_should_be_in_evenodd_pair_for_TenByTwenty() throws Throwable {
		List<String> list1 = new ArrayList<String>();
		list1 = tbt.NumbersPicked(TenByTwentyLocator.numpicked1);

		List<String> list2 = new ArrayList<String>();
		list2 = tbt.ListOfJumpEvenOdd();

		if (list1.equals(list2)) {
			System.out.println("NUMBER SELECTION VERIFIED SUCCESSFULLY!!");
		} else

		{
			Assert.fail("WRONG NUMBER SELECTION");
		}

	}

	@When("^other bet amount selected five point five$")
	public void other_bet_amount_selected_five_point_five() throws Throwable {
		if (!(tbt.OtherAmountSelected())) {
			Assert.fail("OTHER AMOUNT NOT FOUND!!");
		}
	}

	@Then("^total ticket amount should be five point five$")
	public void total_ticket_amount_should_be_five_point_five() throws Throwable {
		if (!(tbt.VerifyTicketPrice())) {
			Assert.fail("WRONG TICKET PRICE");
		}
	}

}