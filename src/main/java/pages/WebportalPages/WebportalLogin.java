package pages.WebportalPages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import objectRepository.LoginPageLocators;
import pages.BasePage;


public class WebportalLogin extends BasePage {
	
	public WebportalLogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		if(isElementPresent(LoginPageLocators.loginbuttonWebportal, 5))
		{
			System.out.println("login button is visible");
			WebElement elem=findElement(LoginPageLocators.loginbuttonWebportal, 5);
			if(elem==null)
			{
				throw new ElementNotVisibleException("element is not visible");
			}
		}
		else
		{
			throw new ElementNotVisibleException("element is not visible");
		}
		
	}
	public void loginButtonSelected()
	{
		if(isElementPresent(LoginPageLocators.loginbuttonWebportal, 10))
		{
			findElement(LoginPageLocators.loginbuttonWebportal, 10).click();
		}
		else
		{
			System.out.println("login button is not visible");
		}
	}
	public boolean isUserNametxtDisplay()
	
	{
		if(isElementPresent(LoginPageLocators.userNametxt, 5))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	public void enterUsernameTxt(String username)
	{
		findElement(LoginPageLocators.userNametxt, 5).sendKeys(username);
	}
    public void enterPasswordTxt(String password)
    {
    	findElement(LoginPageLocators.passwordTxt, 5).sendKeys(password);
    }
    public BasePage clickLogin()
    {
    	if(isElementPresent(LoginPageLocators.portalLoginBtn, 5))
    	{
    		findElement(LoginPageLocators.portalLoginBtn, 5).click();
    		return new WebportalHome(driver);
    	}
    	else
    	{
    		return null;
    	}
    	
    }
    public String verifyErrorMsg()
    {
    	String txt=findElement(LoginPageLocators.portalerrormsg, 10).getText();
    	return txt;
    }
}
