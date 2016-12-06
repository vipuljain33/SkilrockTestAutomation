package pages;

import org.openqa.selenium.WebDriver;

import objectRepository.DrawGamePageLocator;
import objectRepository.SportsLotteryPageLocators;

public class RetailerTopHeaderPage extends BasePage {

	public RetailerTopHeaderPage(WebDriver driver) {
		super(driver);
		
	}
	
	public SportsLotteryPage clickSportsLottery(){
		try{
			if (isElementPresent(SportsLotteryPageLocators.sportsLotterylocator, 5)) {
				findElement(SportsLotteryPageLocators.sportsLotterylocator, 5).click();
				System.out.println("SportsLottry Game is Selected");
				return new SportsLotteryPage(driver);
			}
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		return null;
		}
}
