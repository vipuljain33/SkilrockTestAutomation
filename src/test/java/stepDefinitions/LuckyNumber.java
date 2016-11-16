package stepDefinitions;

import java.util.List;

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
import pages.BasePage;
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
	


	@Given("^login with valid credentials$")
	public void login_with_valid_credentials() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage(AttachHooks.driver);
		loginPage.enterUsername("testret");
		loginPage.enterPassword("12345678");
		basePage = loginPage.clickLogin();
		if (basePage == null) {
			Assert.fail();
		} else {
			lnpage = (LuckyNumberPage) basePage;
		}
	}

	@Given("^Draw game option is selected$")
	public void draw_game_option_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.isDrawgameSelected();

	}

	@Given("^Lucky number game is selected$")
	public void lucky_number_game_is_selected() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		lnpage.isLuckyNumberSelected();
	}

	@Given("^Active bet types are present in DB$")
	public void active_bet_types_are_present_in_DB() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		
		if(lnpage.verifyActiveBetType()){
			System.out.println("Active Bet Type Verified");	
			
			
			
		}else{
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
			Assert.fail("Not able to verify error message :" + txt);
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
		lnpage.isBuyButtonEnabled();

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
	  @When("^QP is selected$")
	    public void qp_is_selected() throws Throwable {
	    lnpage.findElement(LuckeyNumberPageLocator.qplocator,5).click();
	   
	     }
	    
	    @Then("^verify selected numbers on purches details$")
	    public void verify_selected_numbers_on_purches_details() throws Throwable {
	    	 if(lnpage.isQPValueMatched())
		     {
		      System.out.println("pass");
		     }
		     else
		     {
		     Assert.fail();
		     }
	    }
	    
	    @When("^qpfield enable$")
	    public void qpfield_enable() throws Throwable {
	    	 lnpage.findElement(LuckeyNumberPageLocator.qpfield,5).sendKeys("5");
	        
	    }

	    @Then("^verify selected numbers for parmtwo on purches details$")
	    public void verify_selected_numbers_for_parmtwo_on_purches_details() throws Throwable {
	        // Write code here that turns the phrase above into concrete actions
	    	
	    	if(lnpage.isQPValueMatchedForParm2())
		     {
		      System.out.println("pass");
		     }
		     else
		     {
		     Assert.fail();
		     }
	    	
	    }

	    @Then("^verify selected numbers for parmthree on purches details$")
	    public void verify_selected_numbers_for_parmthree_on_purches_details() throws Throwable {
	    	if(lnpage.isQPValueMatchedForParm3())
		     {
		      System.out.println("pass");
		     }
		     else
		     {
		     Assert.fail();
		     }
	    	
	    }
	    
	    @When("^all three draws are selected$")
	     public void all_three_draws_are_selected() throws Throwable 
	     {
	      lnpage.findElement(LuckeyNumberPageLocator.advdraw, 5).clear();
	      lnpage.findElement(LuckeyNumberPageLocator.advdraw, 5).sendKeys("3");
	     }
	     String price;
	     
	     @When("^QP is selected for ticketprice$")
	     public void qp_is_selected_for_ticketprice() throws Throwable 
	     {
	      lnpage.findElement(LuckeyNumberPageLocator.qpCheckbox, 10).click();
	            
	     }

	     @Then("^sum of panel price should be three$")
	     public void sum_of_panel_price_should_be_three() throws Throwable
	     {  
	      String tprice= Integer.toString(3);
	         price=lnpage.findElement(LuckeyNumberPageLocator.qpTicketPrice, 5).getText();
	      
	     
	      if(price.equals(tprice))
	       {
	        System.out.println("pass");
	       }
	       else
	       {
	       Assert.fail();
	       }
	        
	     }  

	    
}
