package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;




public class CommonFunctionLibrary{
	
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
			driver.switchTo().defaultContent();
			wait = new WebDriverWait(driver, 10);
			
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
	
	/*******************************************************************/
	
	/*public static String getFinalQuery(String value) {
		String[] strArray = null;
		String tempQuery = "";
		String tempQuery1 = "";
		String tempQuery2 = "";
		String tempQuery3= "";
		
		
		
		

		tempQuery = tempQuery.contains("dbLMS") ? tempQuery.replace("dbLMS",
				value) : tempQuery;

		tempQuery = tempQuery.contains("dbDGE") ? tempQuery.replace("dbDGE",
				tempQuery) : tempQuery;

		//changed performed by Amit
		 tempQuery = tempQuery1.contains("dbSLE") ? tempQuery1.replace(
		"dbSLE", tempQuery) : tempQuery1;
		//
		 tempQuery3 = tempQuery2.contains("dbPMS") ?tempQuery2.replace(
		 "dbPMS", QueryFromProperty("dbPMS")) : tempQuery2;
		//
		 finalQuery =  tempQuery3.contains("dbIPE") ?  tempQuery3.replace(
		 "dbIPE", QueryFromProperty("dbIPE")) :  tempQuery3;
		
		System.out.println("Final Query :- " + finalQuery);
		SeleniumDriver.log.info("Final Query :- " + finalQuery);
		return finalQuery;
		
		
		
	}

	
	}*/
	
	
	
	
	
	 
	 
	 
}
