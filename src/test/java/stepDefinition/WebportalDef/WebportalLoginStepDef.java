package stepDefinition.WebportalDef;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.HomePage;
import pages.WebportalPages.WebportalHome;
import pages.WebportalPages.WebportalLogin;
import stepDefinitions.AttachHooks;

public class WebportalLoginStepDef {
	WebportalLogin WebLogin;
	BasePage basepage;
	WebportalHome WebHome;
	BasePage basePage;
	
	@Given("^login button is selected$")
	public void login_button_is_selected() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			WebLogin=new WebportalLogin(AttachHooks.driver);
			WebLogin.loginButtonSelected();
		} catch (Exception e)
		{
			
		}
	    
	}

	@Given("^Username text box display$")
	public void username_text_box_display() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebLogin.isUserNametxtDisplay();
		
	   
	}

	@When("^entered valid fields value$")
	public void entered_valid_fields_value() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebLogin.enterUsernameTxt("skilrock");
		WebLogin.enterPasswordTxt("12345678");
	    
	}

	@Then("^Homepage should be visible$")
	public void homepage_should_be_visible() throws Throwable 
	{
		basepage=WebLogin.clickLogin();
		if(basepage.getClass().getName().contains("WebportalHome"));
		{
			WebHome=(WebportalHome) basepage;
		}
		
	    // Write code here that turns the phrase above into concrete actions
		
	    
	}


	@When("^invalid username (\\w++) is enter$")
	public void invalid_username_vipul_is_enter(String Username) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebLogin.enterUsernameTxt(Username);
	}

	@When("^invalid password (\\w++) is enter$")
	public void invalid_password_is_enter(String pwd) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebLogin.enterPasswordTxt(pwd);
	}

	@Then("^HomePage should not visible$")
	public void homepage_should_not_visible() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		basePage = WebLogin.clickLogin();
		WebHome = (WebportalHome) basePage;
		if (WebHome == null) {

			// Write code here that turns the phrase above into concrete actions
		 {

				System.out.println("Home page is not visible when invalid credentials entered");
			}
		}
	   
	}

	
@When("^blank username password credentials are entered$")
public void blank_username_password_credentials_are_entered() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	basePage = WebLogin.clickLogin();
  
}

@Then("^validate error msg$")
public void validate_error_msg() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	if(WebLogin.verifyErrorMsg().contains("Username cannot be blank."))
	{
		System.out.println("error message for blank field verified");
	}
	else
	{
		Assert.fail();
	}
}
@When("^only username credential is entered$")
public void only_username_credential_is_entered() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	WebLogin.enterUsernameTxt("nalini");
	WebLogin.clickLogin();
   
}

@Then("^verify error msg for invalid username credentials$")
public void verify_error_msg_for_invalid_username_credentials() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    if(WebLogin.verifyErrorMsg().contains("Password cannot be blank."))
    {
    	System.out.println("password field verified");
    }
    else
    {
    	Assert.fail();
    }
}
@When("^only password credential is entered$")
public void only_password_credential_is_entered() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	WebLogin.enterPasswordTxt("12457");
	WebLogin.clickLogin();
	   
   
}

@Then("^verify error msg for invalid password credentials$")
public void verify_error_msg_for_invalid_password_credentials() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	  if(WebLogin.verifyErrorMsg().contains("Username cannot be blank."))
	    {
	    	System.out.println("Username cannot be blank.");
	    }
	    else
	    {
	    	Assert.fail();
	    }
    
}



}



