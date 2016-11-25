package pages;

import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import objectRepository.DrawGamePageLocator;
import objectRepository.HomePageLocator;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.TwelveByTwentyFourPageLocator;
import utils.CommonFunctionLibrary;

public class DrawGamePage extends RetailerTopHeaderPage {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DrawGamePage.class);
	

	public DrawGamePage(WebDriver driver) {
		super(driver);
		
		if(functionLibrary.switchFrame("topFrame"))
		{
			
			System.out.println("Successfully switched frame");
		}else
		{
			throw new ElementNotVisibleException("topframe not visible");
		}
		//new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.sw)
		WebElement elem = findElement(DrawGamePageLocator.drawgamelocator, 5);
		if(elem != null)
		{
			System.out.println("Draw Game page is opened");
		}else
		{
			throw new ElementNotVisibleException("Draw Game Page is not visible");			
		}
	}
	
	public boolean isDrawgameSelected(){
		if(	findElement(DrawGamePageLocator.drawgamelocator, 5).getCssValue("border-bottom") != null){
			LOGGER.info("Draw Game Is Selected");
			return true;
		}
		else{
			LOGGER.error("Unable To Select DG");	
			return false;
		}
			
		}

	public LuckyNumberPage selectLuckyNumber()
	{
		functionLibrary.switchFrame("leftbottom");
		if(findElement(LuckeyNumberPageLocator.luckynumberlocator, 5) != null)
		{
			findElement(LuckeyNumberPageLocator.luckynumberlocator, 5).click();
			System.out.println("Lucky Number is selected");
			return new LuckyNumberPage(driver);
		}else
		{
			System.out.println("Lucky Number is not selected");
			return null;
		}
		
	}
	
	public TwelveByTwentyFourPage selectTwelveByTwentyFour()
	{
		functionLibrary.switchFrame("leftbottom");
		if(findElement(TwelveByTwentyFourPageLocator.TwelveByTwentyFourlocator, 5) != null)
		{
			findElement(TwelveByTwentyFourPageLocator.TwelveByTwentyFourlocator, 5).click();
			System.out.println("TwelveByTwentyFour is selected");
			return new TwelveByTwentyFourPage(driver);
		}else
		{
			System.out.println("TwelveByTwentyFour is not selected");
			return null;
		}
		
	}
	
	
	public boolean isLuckyNumberSelected()
	{
		functionLibrary.switchFrame("leftbottom");
		
		if(findElement(LuckeyNumberPageLocator.luckynumberlocator, 5).getAttribute("gamename").equalsIgnoreCase("KenoTwo"))
		{
			LOGGER.info("Lucky Number Game Is Selected");
			
			return true;
		}
		else
		{
			LOGGER.info("Lucky Number Game Is Not Selected");
			return false;
		}
	}
	
	public boolean isTwelveByTwentyFourSelected()
	{
		functionLibrary.switchFrame("leftbottom");
		
		if(findElement(TwelveByTwentyFourPageLocator.TwelveByTwentyFourlocator, 5).getAttribute("gamename").equalsIgnoreCase("TwelveByTwentyFour"))
		{
			LOGGER.info("TwelveByTwentyFour Game Is Selected");
			
			return true;
		}
		else
		{
			LOGGER.info("TwelveByTwentyFour Game Is Not Selected");
			return false;
		}
	}
	
}
