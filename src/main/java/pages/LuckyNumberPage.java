package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import objectRepository.LuckeyNumberPageLocator;
import utils.CommonFunctionLibrary;


public class LuckyNumberPage extends BasePage {
	private static Logger LOGGER = LoggerFactory.getLogger(LuckyNumberPage.class);
	CommonFunctionLibrary functionLibrary;
	public LuckyNumberPage(WebDriver driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);
		if(isElementPresent(LuckeyNumberPageLocator.drawgamelocator, 5))
		{
			System.out.println("Draw game page is visible");
		}else
		{
			throw new ElementNotVisibleException("Draw Game page not visible");
		}
	}

	public void isDrawgameSelected(){
	if(	findElement(LuckeyNumberPageLocator.drawgamelocator, 5).getCssValue("border-bottom") != null){
		LOGGER.info("Draw Game Is Selected");
	}
	else{
		LOGGER.error("Unable To Select DG");	
		Assert.fail();
	}
		
	}
	
	public void isLuckyNumberSelected(){
		
		functionLibrary.switchFrame("leftbottom");
	
		if(findElement(LuckeyNumberPageLocator.luckynumberlocator, 5).getAttribute("gamename").equalsIgnoreCase("KenoTwo"))
		{
			//System.out.println(true);
			LOGGER.info("Lucky Number Game Is Selected");
		}
		else
		{
			//System.out.println(false);
			Assert.fail();
		}
		
		/*
		if(	findElement(LuckeyNumberPageLocator.luckynumberlocator, 10).getAttribute("class").equalsIgnoreCase("sideMenuList select-game")){
			LOGGER.info("Luckey Number Is Selected");
		}
		else{
			LOGGER.error("Unable To Select DG");	
			Assert.fail();
		}*/
			
		}
	
	
	

}
