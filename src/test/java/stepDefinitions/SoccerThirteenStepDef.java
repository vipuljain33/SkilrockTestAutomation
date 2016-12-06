package stepDefinitions;

import java.sql.SQLException;

import org.junit.Assert;

import apis.ApiCommonValidationPage;
import apis.PCPOSApi;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.DrawGamePage;
import pages.HomePage;
import pages.LoginPage;
import pages.MiniRoulettePage;
import pages.SoccerThirteenPage;
import pages.SportsLotteryPage;

public class SoccerThirteenStepDef {
	LoginPage loginPage;
	ApiCommonValidationPage ob;
	HomePage hmPage;
	BasePage basePage;
	MiniRoulettePage miniRoulette;
	SoccerThirteenPage soccer13;
	DrawGamePage drawGamePage;
	SportsLotteryPage sportsLotteryPage;
	PCPOSApi pcposapi;
	@Given("^login with valid credentials soccerThirteen$")
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
	@Given("^Draw game option is selected soccerThirteen$")
	public void draw_game_option_is_selected() throws Throwable {
		
		if(!drawGamePage.isDrawgameSelected())
		{
			Assert.fail();
		}

	}
	@Given("^soccerThirteen is selected$")
	public void soccerThirteen_is_selected() throws InterruptedException {
		sportsLotteryPage = drawGamePage.clickSportsLottery();
		if(sportsLotteryPage == null)
		{
			Assert.fail();
		}
		soccer13 =sportsLotteryPage.selectSoccerThirteen();
		if(soccer13 == null)
		{
			Assert.fail();
		}
		 
	}
	
	@Then("^validate soccerThirteen ticket data$")
	public void validate_soccerThirteen_ticket_data() throws InterruptedException, SQLException {
		
		Assert.assertTrue(soccer13.validateTicket());
		
	}
	@When("^(.*) n events are selected$") 
	public void selectNEvents(int arg) {
		soccer13.selectSoccerThirteenEvents(arg);
	}
	@Then("^validate buy button$")
	public void validate_BuyButton() {
		Assert.assertTrue(soccer13.isBuyEnabled());
	}
}





















































































