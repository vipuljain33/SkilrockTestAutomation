package pages;

import java.util.List;

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
		public void isPerm1Selected()
		{
			if(findElement(LuckeyNumberPageLocator.selectedBetLocator,5).getAttribute("betname").equalsIgnoreCase("Perm1"))
			{
				LOGGER.info("perm1 is selected");
			}
			else 
			{
				Assert.fail();
			}
		}

		public String errorMessageHandle()
		{
			String errorTxt=driver.findElement(LuckeyNumberPageLocator.errorPopup).getText();
			System.out.println(errorTxt);
			return errorTxt;
		}
		
		public void isPerm2Selected()
		{
			driver.findElement(LuckeyNumberPageLocator.perm2locator).click();
			if(findElement(LuckeyNumberPageLocator.selectedBetLocator,5).getAttribute("betname").equalsIgnoreCase("Perm2"))
			{
				LOGGER.info("perm2 is selected");
			}
			else
			{
				Assert.fail();
			}
		}
		public void isPerm3Selected()
		{
			driver.findElement(LuckeyNumberPageLocator.perm3Locator).click();
			if(findElement(LuckeyNumberPageLocator.selectedBetLocator, 6).getAttribute("betname").equalsIgnoreCase("Perm3"))
			{
				LOGGER.info("perm3 is selected");
			}
			else
			{
				Assert.fail();
			}
		}
		public void isBuyButtonEnabled()
		{
			String txt=driver.findElement(LuckeyNumberPageLocator.buyNowLoctor).getAttribute("disabled");
			System.out.println("buybutton: "+txt);
			if(findElement(LuckeyNumberPageLocator.buyNowLoctor,7).getAttribute("disabled").equalsIgnoreCase("true"))
			{
				LOGGER.info("less than boundary verification pass");
			}
			else
			{
				Assert.fail();
			}
		}
	
		public void isBuyButtonEnabledpermthree()
		{
			String txt=driver.findElement(LuckeyNumberPageLocator.buyNowLoctor).getAttribute("disabled");
			System.out.println("buybutton: "+txt);
			if(findElement(LuckeyNumberPageLocator.buyNowLoctor,7).getAttribute("disabled").equalsIgnoreCase("true"))
			{
				LOGGER.info("less than boundary verification pass for perm3");
			}
			else
			{
				Assert.fail();
			}
		}
	
		public void permoneBoxes()
		{
			List<WebElement> list=driver.findElements(LuckeyNumberPageLocator.perm1boxes);
			if(list.size()==10)
			{
				System.out.println("total number of boxes for perm1 validate");
			}
			else
			{
				Assert.fail();
			}
			
		}
		public void permtwoboxes()
		{
			List<WebElement> list=driver.findElements(LuckeyNumberPageLocator.perm2boxes);
			if(list.size()==20)
			{
				LOGGER.info("total number of boxes are 20");
			}
			else
			{
				Assert.fail();
			}
		}
		public int permthreeboxes()
		{
			List<WebElement> listitem=driver.findElements(LuckeyNumberPageLocator.perm3boxes);
			int size=listitem.size();
			return size;
		}
		public String noofLines()
		{
			String txt=driver.findElement(LuckeyNumberPageLocator.nooflines).getText();
			System.out.println(txt);
			return txt.trim();
		}
        public String ticketPricePermone()
        {
        	String txt=driver.findElement(LuckeyNumberPageLocator.qpTicketPrice).getText();
        	System.out.println("ticket price permone"+txt);
        	return txt.trim();
        }
}
