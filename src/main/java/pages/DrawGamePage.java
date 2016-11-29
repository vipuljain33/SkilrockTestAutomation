package pages;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import objectRepository.BonusLottoPageLocators;
import objectRepository.DrawGamePageLocator;
import objectRepository.FortuneGameLocator;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.TenByTwentyLocator;
import objectRepository.TwelveByTwentyFourPageLocator;
import utils.CommonFunctionLibrary;

public class DrawGamePage extends RetailerTopHeaderPage {

	private static Logger LOGGER = LoggerFactory.getLogger(DrawGamePage.class);

	public DrawGamePage(WebDriver driver) {
		super(driver);

		if (functionLibrary.switchFrame("topFrame")) {

			System.out.println("Successfully switched frame");
		} else {
			throw new ElementNotVisibleException("topframe not visible");
		}

		WebElement elem = findElement(DrawGamePageLocator.drawgamelocator, 5);
		if (elem != null) {
			System.out.println("Draw Game page is opened");
		} else {
			throw new ElementNotVisibleException("Draw Game Page is not visible");

		}
	}

	public boolean isDrawgameSelected() {
		if (findElement(DrawGamePageLocator.drawgamelocator, 5).getCssValue("border-bottom") != null) {
			LOGGER.info("Draw Game Is Selected");
			return true;
		} else {
			LOGGER.error("Unable To Select DG");
			return false;
		}

	}

	public LuckyNumberPage selectLuckyNumber() {
		functionLibrary.switchFrame("leftbottom");
		if (findElement(LuckeyNumberPageLocator.luckynumberlocator, 5) != null) {
			findElement(LuckeyNumberPageLocator.luckynumberlocator, 5).click();
			System.out.println("Lucky Number is selected");
			return new LuckyNumberPage(driver);
		} else {
			System.out.println("Lucky Number is not selected");
			return null;
		}

	}

	public BonusLottoPage selectBonusLotto() {
		functionLibrary.switchFrame("leftbottom");
		if (findElement(BonusLottoPageLocators.bonusLottoButton, 5) != null) {
			findElement(BonusLottoPageLocators.bonusLottoButton, 5).click();
			System.out.println("Bonus Lotto is selected");
			return new BonusLottoPage(driver);
		} else {
			System.out.println("Bonus Lotto  is not selected");
			return null;
		}

	}

	public FortuneGamePage selectFortuneGame()
	{
		functionLibrary.switchFrame("leftbottom");
		if(findElement(FortuneGameLocator.fortuneGamelocator, 5) != null)
		{
			findElement(FortuneGameLocator.fortuneGamelocator, 5).click();
			System.out.println("Fortune Game is selected");
			return new FortuneGamePage(driver);
		}else
		{
			System.out.println("Lucky Number is not selected");
			return null;
		}
		
	}
	public boolean isFortuneGameSelected()
	{
		functionLibrary.switchFrame("leftbottom");
		
		if(findElement(FortuneGameLocator.fortuneGamelocator, 5).getAttribute("gamename").equalsIgnoreCase("OneToTwelve"))
		{
			LOGGER.info("Fortune Game is selected");
			
			return true;
		}
		else
		{
			LOGGER.info("Fortune Game is selected");
			return false;
		}
	}
	
	public MiniRoulettePage selectMiniRoulette() {
		functionLibrary.switchFrame("leftbottom");
		if (findElement(DrawGamePageLocator.miniRouletteButton, 5) != null) {
			findElement(DrawGamePageLocator.miniRouletteButton, 5).click();
			System.out.println("Mini Roulette is selected");
			return new MiniRoulettePage(driver);
		} else {
			System.out.println("Mini Roulette is not selected");
			return null;
		}

	}

	public TenByTwentyPage selectTENBYTWENTY() {
		functionLibrary.switchFrame("leftbottom");
		if (findElements(TenByTwentyLocator.TBTlocator, 5) != null) {
			findElement(TenByTwentyLocator.TBTlocator, 5).click();
			System.out.println("Ten By Twenty Game Is Selected");
			return new TenByTwentyPage(driver);
		} else {
			System.out.println("Ten By Twenty Game Is Not Selected");
			return null;
		}

	}

	public boolean isTenByTwentyGameSelected() {
		functionLibrary.switchFrame("leftbottom");
		if (findElement(TenByTwentyLocator.TBTlocator, 5).getAttribute("gamename").equalsIgnoreCase("TenByTwenty")) {
			return true;
		} else {
			return false;
		}

	}

	public TwelveByTwentyFourPage selectTwelveByTwentyFour(){
		functionLibrary.switchFrame("leftbottom");
		if (findElement(TwelveByTwentyFourPageLocator.TwelveByTwentyFourlocator, 5) != null) {
			findElement(TwelveByTwentyFourPageLocator.TwelveByTwentyFourlocator, 5).click();
			System.out.println("TwelveByTwentyFourPage is selected");
			return new TwelveByTwentyFourPage(driver);
		} else {
			System.out.println("TwelveByTwentyFourPage");
			return null;
		}

	}	
}
