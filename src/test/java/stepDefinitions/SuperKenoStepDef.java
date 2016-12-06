package stepDefinitions;


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
import pages.SuperKenoPage;
import utils.ReusableStaticMethods;

public class SuperKenoStepDef {
	
	LoginPage loginPage;
	HomePage homePage;
	BasePage basePage;
	DrawGamePage drawGamePage;
	SuperKenoPage superKenoPage;
	@Given("^login with valid credentials SuperKeno$")
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

	@Given("^SuperKeno Game is selected$")
	public void super_keno_Game_is_selected() throws Throwable {
		try
		{
		superKenoPage=drawGamePage.selectSuperKeno();
		if(superKenoPage==null){	
			Assert.fail();	
		}
		}catch (Exception e) {
			Assert.fail();
		}
	}  
	
	@Then("^validate Ticket Reprint for (.*)  By API after sale for SuperKenoHybrid$")
	public void validate_Ticket_Reprint_for_Perm_By_API_after_sale_SuperKenoHybrid(String arg1) throws Throwable {
		
		
		if(superKenoPage.isVerifySaleResponceWithTicketforSuperKeno(arg1)){
			System.out.println("******************REPRINT*******************");
			if(superKenoPage.isVarifyReprintDataSuperKeno(arg1)){
				System.out.println("Ticket Reprint Verified for " + arg1);
			}else{
				Assert.fail();
			}
		}
		
		
	}
	
	
	
}

