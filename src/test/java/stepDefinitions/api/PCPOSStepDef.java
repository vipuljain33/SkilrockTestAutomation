package stepDefinitions.api;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import apis.ApiCommonValidationPage;
import apis.PCPOSApi;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LuckyNumberPage;

public class PCPOSStepDef {
	private static Logger LOGGER = LoggerFactory.getLogger(PCPOSStepDef.class);
	PCPOSApi pcposapi = new PCPOSApi();
	ApiCommonValidationPage apicommonfunctionlibrary = new ApiCommonValidationPage();
	public static boolean flag = false;

	@Given("^authenticate User$")
	public void authenticate_User() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (!pcposapi.authenticate("testret", "12345678")) {
			System.out.println("authenticat fail");
			LOGGER.info("authenticat fail");
			Assert.fail();
		}
	}

	@When("^(.*) is selected and Sale Performed By API$")
	public void perm_is_selected_and_Sale_Performed_By_API(String arg1) throws Throwable {

		flag = apicommonfunctionlibrary.isVerifySaleResponceWithDB(arg1);
		if (flag) {
			System.out.println("API And DB DATA Matched");
			LOGGER.info("API And DB DATA Matched");
		} else {
			Assert.fail();
		}		
	}

	@Then("^(.*) validate responce data from API$")
	public void perm_validate_responce_data_from_API(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (flag) {
			System.out.println("API And DB DATA Matched for : " + arg1);
			LOGGER.info("API And DB DATA Matched");
		} else {
			Assert.fail();
		}

	}
	
	@Then("^validate Ticket Cancelatilon for (.*)  By API after sale$")
	public void validate_Ticket_Cancelatilon_for_Perm_By_API(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		if(apicommonfunctionlibrary.isVerifySaleResponceWithDB(arg1)){
			System.out.println("**************Last Ticket Cancelled for ******** " );
			if(apicommonfunctionlibrary.isVarifyCancleData(arg1)){
				System.out.println("Last Ticket Cancelled for  : " + arg1);
				LOGGER.info("Last Ticket Cancelled for  : " + arg1);	
			}else{
				LOGGER.info("Last Ticket Cancelled Unsucessful !!!");
				Assert.fail();
			}
		}
		
	}
	
	
	@Then("^validate Ticket Reprint for (.*)  By API after sale$")
	public void validate_Ticket_Reprint_for_Perm_By_API_after_sale(String arg1) throws Throwable {
		if(apicommonfunctionlibrary.isVerifySaleResponceWithDB(arg1)){
			System.out.println("******************REPRINT*******************");
			if(apicommonfunctionlibrary.isVarifyReprintData(arg1)){
				System.out.println("Ticket Reprint Verified for " + arg1);
				LOGGER.info("Ticket Reprint Verified for " + arg1);	
			}else{
				LOGGER.info("Ticket Reprint Unsucessful !!!");
				Assert.fail();
			}
		}
		
		
	}
	
	@When("^(.*) is selected and Sale Performed By API for BonusLotto$")
	public void perm_is_selected_and_Sale_Performed_By_API_BonusLotto(String arg1) throws Throwable {

		flag = apicommonfunctionlibrary.isVerifySaleResponceWithDBforBonusLotto(arg1);
		if (flag) {
			System.out.println("API And DB DATA Matched");
			LOGGER.info("API And DB DATA Matched");
		} else {
			Assert.fail();
		}		
	}
	
	@Then("^(.*) validate responce data from API for BonusLotto$")
	public void perm_validate_responce_data_from_API_BonusLotto(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		if (flag) {
			System.out.println("API And DB DATA Matched for : " + arg1);
			LOGGER.info("API And DB DATA Matched");
		} else {
			Assert.fail();
		}

	}
	
	@Then("^validate Ticket Cancelatilon for (.*)  By API after sale for BonusLotto$")
	public void validate_Ticket_Cancelatilon_for_Perm_By_API_BonusLotto(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		if(apicommonfunctionlibrary.isVerifySaleResponceWithDBforBonusLotto(arg1)){
			System.out.println("**************Last Ticket Cancelled for ******** " );
			if(apicommonfunctionlibrary.isVarifyCancleDataBonusLotto(arg1)){
				System.out.println("Last Ticket Cancelled for  : " + arg1);
				LOGGER.info("Last Ticket Cancelled for  : " + arg1);	
			}else{
				LOGGER.info("Last Ticket Cancelled Unsucessful !!!");
				Assert.fail();
			}
		}
		
	}
	
	@Then("^validate Ticket Reprint for (.*)  By API after sale for BonusLotto$")
	public void validate_Ticket_Reprint_for_Perm_By_API_after_sale_BonusLotto(String arg1) throws Throwable {
		if(apicommonfunctionlibrary.isVerifySaleResponceWithDBforBonusLotto(arg1)){
			System.out.println("******************REPRINT*******************");
			if(apicommonfunctionlibrary.isVarifyReprintDataBonusLotto(arg1)){
				System.out.println("Ticket Reprint Verified for " + arg1);
				LOGGER.info("Ticket Reprint Verified for " + arg1);	
			}else{
				LOGGER.info("Ticket Reprint Unsucessful !!!");
				Assert.fail();
			}
		}
		
		
	}
	
	
	
	
	
	@Given("^perform sale for single bet type and capture sale data$")
	public void perform_sale_for_single_bet_type_and_capture_sale_data() throws Throwable {
		if(!pcposapi.fetchDrawGameData()){
			Assert.fail();
		}
	}
	
	@Given("^authenticate BackOffice User$")
	public void authenticate_BackOffice_User() throws Throwable {
		/*if (!pcposapi.authenticate("testret", "12345678")) {
			System.out.println("authenticat fail");
			LOGGER.info("authenticat fail");
			Assert.fail();
		}*/
		System.out.println("backoffice user");
	}
	
	@Then("^validate Freeze API Response with DB for LuckyNumber$")
	public void validate_Freeze_API_Response_with_DB_for_LuckyNumber() throws Throwable {
		System.out.println("game name  : LuclyNumber");
		if(apicommonfunctionlibrary.isVerifyDrawFreezeDataForLuckyNumber()){
			LOGGER.info("Draw Freeze Sucessfully");
			System.out.println("Draw Freeze Sucessfully");
		}else{
			Assert.fail();
		}
	    
	}
	
	@Given("^fetch DrawGame data For PCPOS Game$")
	public void fetch_DrawGame_data_For_PCPOS_Game() throws Throwable {
		if(!pcposapi.fetchDrawGameData()){
			Assert.fail();
		}
	}

	@Then("^validate Result Submission API Response with DB for LuckyNumber$")
	public void validate_Result_Submission_API_Response_with_DB_for_LuckyNumber() throws Throwable {
		if(!apicommonfunctionlibrary.isVerifyResultSubmissionDataForLuckyNumber()){
			Assert.fail();
		}
		
	}

	
}
