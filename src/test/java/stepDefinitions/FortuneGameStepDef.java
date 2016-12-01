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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.LoggerFactory;

import com.sun.jna.platform.win32.WinDef.LONGLONG;

import com.sun.jna.platform.win32.WinDef.LONGLONG;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.mapper.Mapper.Null;
import objectRepository.FortuneGameLocator;
import objectRepository.LuckeyNumberPageLocator;
import pages.BasePage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LuckyNumberPage;
import pages.FortuneGamePage;
import utils.ReusableStaticMethods;




public class FortuneGameStepDef {

	
	LoginPage loginPage;
	WebDriver driver=AttachHooks.driver;
	HomePage homePage;
	FortuneGamePage fgpage;
	BasePage basePage;
	DrawGamePage drawGamePage;

	@Given("^Login with valid credentials fg$")
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

	@Given("^Draw game option is selected fg$")
	public void draw_game_option_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if(!drawGamePage.isDrawgameSelected())
		{
			Assert.fail();
		}

	}
	
	@Given("^Fortune game is selected$")
	public void lucky_number_game_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("test step");
		fgpage = drawGamePage.selectFortuneGame();
		if(fgpage != null)
		{
			System.out.println("Fortune Game page returned");
			
		}else
		{
			System.out.println("Fortune Game page not returned");
			Assert.fail();
		}
	}
	
	@When("^We select more than five numbers$")
	public void we_select_more_than_five_numbers() throws Throwable {
		List<Integer> randomNumbers;
		if (fgpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 12, 6);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				fgpage.findElement(By.xpath(FortuneGameLocator.selectNumberlocator + val + "]"), 5).click();
			}
		}
	}
	
	@Then("^Popup error message should be displayed for more than five numbers$")
	public void popup_error_message_should_be_displayed_for_more_than_five_numbers() throws Throwable {

		// Write code here that turns the phrase above into concrete actions
		String txt = fgpage.errorMessageHandle();
		if (txt.equalsIgnoreCase("Maximum 5 numbers can be selected")) {
			System.out.println("error message for max numbers verified");
		} else {
				Assert.fail("Not able to verify error message :" + txt);
			}
		}
	
	@When("^We click on number of draws field$")
	public void we_click_on_number_of_draws_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).click();
	}

	@When("^Enter more than three numbers$")
	public void enter_more_than_three_numbers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).click();
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).clear();
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).sendKeys("5"); 
	}

	@Then("^Popup error message should be displayed for more than three numbers$")
	public void popup_error_message_should_be_displayed_for_more_than_three_numbers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String txt = fgpage.errorMessageHandle();
		if (txt.equalsIgnoreCase("Maximum 3 draws can be selected!")) {
			System.out.println("error message for max draws verified");
		} else {
				Assert.fail("Not able to verify error message :" + txt);
			}
		}
	

	@When("^We click on quick pick checkbox$")
	public void we_click_on_quick_pick_checkbox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.qpCheckboxlocator, 5).click();
	}

	@When("^Enter more than five numbers in text field$")
	public void enter_more_than_five_numbers_in_text_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.notobePickedlocator, 5).sendKeys("6"); 
	}

	@Then("^Popup error message should be displayed for more than five numbers in qp$")
	public void popup_error_message_should_be_displayed_for_more_than_five_numbers_in_qp() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String txt = fgpage.errorMessageHandle();
		if (txt.equalsIgnoreCase("Total numbers can be selected between 1 to 5")) {
			System.out.println("error message for max numbers verified");
		} else {
				Assert.fail("Not able to verify error message :" + txt);
			}
	}

	@When("^We click on other option of Bet Amount$")
	public void we_click_on_other_option_of_Bet_Amount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.otherbetAmountlocator, 5).click();
	}
	@When("^Enter an amount greater than hundred$")
	public void enter_an_amount_greater_than_hundred() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.otherbetAmountAmtlocator, 5).sendKeys("120"); 
	}

	@Then("^Popup error message should be displayed for greater than hundred amount$")
	public void popup_error_message_should_be_displayed_for_greater_than_hundred_amount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String txt = fgpage.errorMessageHandle();
		if (txt.equalsIgnoreCase("Price must less than 100 and a multiple of 1")) {
			System.out.println("error message for max bet amount verified");
		} else {
				Assert.fail("Not able to verify error message :" + txt);
			}
	
	}

	@When("^We do not select any number$")
	public void we_do_not_select_any_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("^Hover on Buy Now button case1$")
	public void click_on_Buy_Now_button_case1() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(FortuneGameLocator.buyNowlocator);
		action.moveToElement(we).build().perform();
	}

	@Then("^A hint should appear case1$")
	public void a_hint_should_appear_case1() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String expected="Please select either QP or manual numbers !!! ";
		String txt = fgpage.hintMessageHandle();
		if(expected.trim().equalsIgnoreCase(txt.trim()))
		{
			System.out.println("hint message for case 1 verified");
		}else
		{
			Assert.fail("Not able to verify hint message :" + txt);
		}
		
	}

	@When("^We select any number$")
	public void we_select_any_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		List<Integer> randomNumbers;
		if (fgpage != null) {
			randomNumbers = ReusableStaticMethods.randomNumber(1, 12, 3);
			for (String val : ReusableStaticMethods.convertIntegerListToString(randomNumbers)) {
				fgpage.findElement(By.xpath(FortuneGameLocator.selectNumberlocator + val + "]"), 5).click();
			}
		}
	}

	@When("^Do not select bet amount\\(by clicking on other and not entering any bet amount\\)$")
	public void do_not_select_bet_amount_by_clicking_on_other_and_not_entering_any_bet_amount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.otherbetAmountlocator, 5).click();
	}


	@When("^Hover on Buy Now button case2$")
	public void click_on_Buy_Now_button_case2() throws Throwable {
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(FortuneGameLocator.buyNowlocator);
		action.moveToElement(we).build().perform();
	}

	@Then("^A hint should appear case2$")
	public void a_hint_should_appear_case2() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String expected="Please select bet amount !!! ";
		
		String txt = fgpage.hintMessageHandle();
		if(expected.trim().equalsIgnoreCase(txt.trim()))
		{
			System.out.println("hint message for case 2 verified");
		}else
		{
			Assert.fail("Not able to verify hint message :" + txt);
		}
	}
	
	@When("^QP checkbox is selected$")
	public void qP_checkbox_is_selected() throws Throwable {
		fgpage.findElement(FortuneGameLocator.qpCheckboxlocator, 5).click();
	}
	
	
	@When("^Enter a number in no to be selected field$")
	public void enter_a_number_in_no_to_be_selected_field() throws Throwable {
		fgpage.findElement(FortuneGameLocator.notobePickedlocator, 5).sendKeys("5");
	}
	
	
	@When("^Verify selected numbers in purchase details qp$")
	public void verify_selected_numbers_in_purchase_details_qp() throws Throwable {

		if (fgpage.isQPValueMatched()) {
			System.out.println("Numbers verified for quick pick");
		} else {
			Assert.fail("Numbers not verified for quick pick");
		}
	}
	
	
	@When("^We select numbers (\\w+),bet amount (\\w+) and number of draws (\\w+)$")
	public void we_select_numbers_bet_amount_and_no_of_draws(String arg1, String arg2, String arg3) throws Throwable {
		
		fgpage.findElement(FortuneGameLocator.qpCheckboxlocator, 5).click();
		
		fgpage.findElement(FortuneGameLocator.notobePickedlocator, 5).sendKeys(arg1);
	
		fgpage.findElement(By.xpath(FortuneGameLocator.betAmountlocator + arg2 + "]"), 5).click();

		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).click();
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).clear();
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).sendKeys(arg3);
	
	}
		

	@Then("^Total amount (\\w+) should be equal to number count multiplied by No of draws multiplied by Bet amount$")
	public void total_amount_should_be_equal_to_No_of_draws_multiplied_by_Bet_amount(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions

		String ticketPrice = fgpage.ticketPriceFortuneGame();
		
				if (ticketPrice.equals(arg1))
				{
			System.out.println("Fortune Game ticket price matched");
		} 
				else {
			Assert.fail();
		}
	}

	@When("^Advance draw is selected fg$")
	public void advance_draw_is_selected_fg() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		fgpage.findElement(FortuneGameLocator.advanceDrawlocator, 5).click();

	}

	@Then("^Draw info should be matched with database fg$")
	public void draw_info_should_be_matched_with_database_fg() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		fgpage.advanceDrawVerify();
	}

	/*@When("^Fortune game ticket purchased$")
	public void fortune_game_ticket_purchased() throws Throwable {
		
		fgpage.findElement(FortuneGameLocator.qpCheckboxlocator, 5).click();
		
		fgpage.findElement(FortuneGameLocator.notobePickedlocator, 5).sendKeys("3");
		
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).click();
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).clear();
		fgpage.findElement(FortuneGameLocator.numofDrawsSelectedlocator, 5).sendKeys("2");
	
		if (fgpage.isBuyButtonEnable()) 
		{
			fgpage.findElement(FortuneGameLocator.buyNowlocator, 5).click();
			if (fgpage.isCardnumberPopupEnable())
			{
				fgpage.findElement(FortuneGameLocator.enterCardNumberPopupcancellocator, 10).click();
				fgpage.alertboxclick();
			}
		}
	}
		
	@When("^Ticket preview is displayed$")
	public void ticket_preview_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (fgpage.findElement(FortuneGameLocator.insufficienterrorpopuplocator, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {
			System.out.println("Retailer has insufficient balance");

		} else if (fgpage.ticketView()) {
			System.out.println("Ticket preview is displayed sucessfully");
		} else {
			Assert.fail();
		}
	}

	@Then("^Ticket number in preview should be equal to database value fg$")
	public void ticket_number_in_preview_should_be_equal_to_database_value_fg() throws Throwable {
		List<Map<String, String>> returnedList;
		returnedList = fgpage.returnDatabaseValue();
		if (fgpage.ticketView()) {
			for (Map<String, String> value : returnedList) {
				System.out.println("Printing key value pair");
				for (Map.Entry<String, String> entry : value.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					if (fgpage.findElement(By.xpath("//*[contains(text(), '" + entry.getValue() + "')]"), 5) != null) {

						System.out.println("Element found: " + entry.getValue());
					}
				}
			}}
	}
*/
	
}

	
	

