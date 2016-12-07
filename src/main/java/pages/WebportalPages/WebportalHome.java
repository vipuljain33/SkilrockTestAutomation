package pages.WebportalPages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import objectRepository.LoginPageLocators;
import pages.BasePage;

public class WebportalHome extends BasePage {
	
	public WebportalHome(WebDriver driver)
	{
		super(driver);
		if(findElement(LoginPageLocators.homeLinkLocator,5).getText().equalsIgnoreCase("HOME"))
		{
			System.out.println("Home page is visible");
		}
		else
		{
			throw new ElementNotVisibleException("element not visible");
		}
		
		
	}

}
