package stepDefinitions.mobileStepDefinations;

import apis.pmsMobileApis.MobileApiPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.ConfigManager;

public class MobilePmsDGApiStepDef {
	MobileApiPage mobileApiPage = new MobileApiPage();

	@Given("^App user is Authenticated$")
	public void app_user_is_authenticated() throws Throwable {
		mobileApiPage.authenticate(ConfigManager.getProperty("Username"), ConfigManager.getProperty("Password"));
	}

	@When("^Draw game app data is fetched$")
	public void draw_game_data_fetched() throws Throwable {
		mobileApiPage.fetchDrawGameData();
	}

	@Then("^(\\w+) ticket is purchased with (\\w+) and (\\w+) for (\\w+) and (\\d+) in app$")
	public void ticket_is_purchased(String gameCode, String isQP, String pickedNumbers,
			String playType, int noPicked) throws Throwable {
		mobileApiPage.performSale(gameCode, 1, 1, 1, isQP, pickedNumbers, noPicked, playType);
	}
}
