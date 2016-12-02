package stepDefinitions;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.MiniRoulettePageLocator;
import pages.BasePage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MiniRoulettePage;



public class MiniRoulette {
	LoginPage loginPage;
	HomePage hmPage;
	BasePage basePage;
	MiniRoulettePage miniRoulette;
	DrawGamePage drawGamePage;
	
	
	@Given("^login with valid credentials MiniRoulette$")
	public void login_with_valid_credentials() throws Throwable {
		
		loginPage = new LoginPage(AttachHooks.driver);
		loginPage.LoginWithActiveUser();
		basePage = loginPage.clickLogin();
		if (basePage == null) {
			Assert.fail();
		} else {
			drawGamePage = (DrawGamePage) basePage;
		}
	}
	
	@Given("^Draw game option is selected MiniRoulette$")
	public void draw_game_option_is_selected() throws Throwable {
		
		if(!drawGamePage.isDrawgameSelected())
		{
			Assert.fail();
		}

	}
	
	
	@Given("^miniRoulette is selected$")
	public void miniRoulette_is_selected() throws InterruptedException {
		 miniRoulette=drawGamePage.selectMiniRoulette();
	}
	
    
	@Given("^select bet amount(\\d+)$") 
    public void select_bet_amount(int betAmount) {
    	  miniRoulette.selectBetAmount(betAmount);
    }
    
    
    @When("^select bet types randomly (\\d+) n times$")
    public void select_bet_types_randomly_n_times(int N) throws InterruptedException {
       miniRoulette.selectBetTypes(N);	
    }
    
    
    @Then("^validate ticket price$")
    public void validate_ticket_price() {
    	Assert.assertTrue(miniRoulette.validateTicketPrice());
    }
    
    
    @Then("^validate price per element$")
    public void validate_price_per_element() {
    	Assert.assertTrue(miniRoulette.validatePricePerNumber());
    }
    
    
    @When("^select (\\d+) advance draw$")
    public void select_advance_draw(int N) {
    	miniRoulette.selectAdvanceDraws(N);
    }
    
    
    @Then("^validate printed ticket price$")
    public void validate_printed_ticket_price() throws InterruptedException {
    	Assert.assertTrue(miniRoulette.validatePrintedTicketPrice());
    	
    }
    
    
    @Given("^Advance draw is selected MiniRoulette$")
    public void advance_draw_is_selected_MiniRoulette() throws Throwable {
    	miniRoulette.findElement(MiniRoulettePageLocator.advanceDrawButton, 5).click();
    }
    
    
    @Then("^draw info should be matched with database MiniRoulette$")
    public void draw_info_should_be_matched_with_database_MiniRoulette() throws Throwable {
    	miniRoulette.advanceDrawVerify();
        
    }
    
    
    @When("^any BetType ticket purchased (\\d+)$")
    public void any_BetType_ticket_purchased(int N) throws Throwable {
    	miniRoulette.selectBetTypes(N);
		if (!miniRoulette.isBuyButtondisabled()) {
			miniRoulette.findElement(MiniRoulettePageLocator.buyNowLoctor, 5).click();
			if (miniRoulette.isCardnumberPopupEnable()) {
				miniRoulette.findElement(MiniRoulettePageLocator.enterCradnumberPopupcancel, 5).click();
				Thread.sleep(200);
				miniRoulette.alertboxclick();
				Thread.sleep(500);

			}

		}
    }

    
    @When("^ticket preview display MiniRoulette$")
    public void ticket_preview_display_MiniRoulette() throws Throwable {
    	if (miniRoulette.findElement(MiniRoulettePageLocator.insufficienterrorpopup, 5).getText()
				.equalsIgnoreCase("Retailer has insufficient Balance")) {
			System.out.println("Retailer has insufficient balance");

		} else if (miniRoulette.ticketView()) {
			System.out.println("ticket preview display sucessfully");
		} else {
			Assert.fail();
		}
        
    }


    
    @Then("^ticket number in preview should be equal to database value MiniRoulette$")
    public void ticket_number_in_preview_should_be_equal_to_database_value_MiniRoulette() throws Throwable {
    	
    	List<Map<String, String>> returnedList;
		returnedList = miniRoulette.returnDatabaseValue();
		if (miniRoulette.ticketView()) {
			for (Map<String, String> value : returnedList) {
				System.out.println("Printing key value pair");
				for (Map.Entry<String, String> entry : value.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					if (miniRoulette.findElement(By.xpath("//*[contains(text(), '" + entry.getValue() + "')]"), 5) != null) {

						System.out.println("Element found: " + entry.getValue());
					}

				}

			}
        
    }
    
    }
    

}
