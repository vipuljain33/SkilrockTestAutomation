package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isElementPresent(By locator, int timeoutInSeconds)
	{
		try {
			wait = new WebDriverWait(driver,timeoutInSeconds);
			WebElement elem =wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if(elem != null)
			{
				return true;
			}else
			{
				return false;
			}
			
			
			
		} catch (Exception e) {
			return false;
		}
		
	}

	public WebElement findElement(By locator, int timeoutSeconds)
	{
		wait = new WebDriverWait(driver,timeoutSeconds);
		WebElement elem =wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		if(elem != null)
		{
			return elem;
		}else
		{
			return null;
		}
	}
}
