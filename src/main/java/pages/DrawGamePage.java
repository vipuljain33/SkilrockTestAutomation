package pages;


import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import objectRepository.DrawGamePageLocator;

import objectRepository.LuckeyNumberPageLocator;



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
		if(	findElement(LuckeyNumberPageLocator.drawgamelocator, 5).getCssValue("border-bottom") != null){
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
	
	public MiniRoulettePage selectMiniRoulette(){
		functionLibrary.switchFrame("leftbottom");
		if(findElement(DrawGamePageLocator.miniRouletteButton, 5) != null)
		{
			findElement(DrawGamePageLocator.miniRouletteButton, 5).click();
			System.out.println("Mini Roulette is selected");
			return new MiniRoulettePage(driver);
		}else
		{
			System.out.println("Mini Roulette is not selected");
			return null;
		}
		
		
	}
}
