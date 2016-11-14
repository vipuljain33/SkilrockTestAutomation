package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.HomePageLocator;
import objectRepository.LuckeyNumberPageLocator;

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

public List <String> findElements(By locator, int timeoutSeconds)
{
	wait = new WebDriverWait(driver,timeoutSeconds);
	List<WebElement> elem = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	List <String> temp= new ArrayList<String>();
	if(elem != null)
	{
		for(WebElement val : elem)
		{
			temp.add(val.getText());
		}
		return temp;
	}else
	{
		return null;
	}
}


}
