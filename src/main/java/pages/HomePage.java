package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import objectRepository.HomePageLocator;
import utils.CommonFunctionLibrary;

public class HomePage extends BasePage {
	
	

	public HomePage(WebDriver driver) {
		super(driver);
		
		
		if(functionLibrary.switchFrame("topFrame"))
		{
			System.out.println("Successfully switched frame");
		}else
		{
			throw new ElementNotVisibleException("topframe not visible");
		}
		//new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.sw)
		WebElement elem = findElement(HomePageLocator.currentLoggedUser, 5);
		if(elem != null)
		{
			System.out.println("Home page is opened");
		}else
		{
			throw new ElementNotVisibleException("Home Page is not visible");
			
		}
		
		
		
	}

	
}
