package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;


public class CommonFunctionLibrary {
	
	WebDriver driver ;
	WebDriverWait wait;
	
	public CommonFunctionLibrary(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public boolean switchFrame(String frameId)

	{
		try
		{
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		//driver.switchTo().frame(frameId);
			System.out.println(driver.getWindowHandle());
			return true;
		}catch (Exception e) {
			return false;
		}
		
	
	}

	public  void embedScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			try{
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
