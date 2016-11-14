package objectRepository;

import org.openqa.selenium.By;

public class LuckeyNumberPageLocator {
	
	public static By drawgamelocator = By.id("dg");
	public static By luckynumberlocator = By.xpath("//*[@class='sideMenuList select-game']");
	public static By selectedBetLocator=By.xpath("//button[@class='bettypes select-bet']");
	//public static By luckynumberlocator = By.id("0~1");
	public static String selectNumber = "//*[@class='lnum-no-select']/ul/li[";
	public static By errorPopup=By.xpath("//div[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By perm2locator=By.xpath("//button[@betname='Perm2']");
	public static By perm3Locator=By.xpath("//button[@betname='Perm3']");
	public static By buyNowLoctor=By.xpath("//button[@id='buy']");
	public static By perm1boxes=By.xpath("//div[@class='lnum-input-area perm1-block']//input[@class='kenoTwoNumberEnter' and @style='display: block;']");
	public static By perm2boxes=By.xpath("//div[@class='lnum-input-area t-box perm2-block']//input[@class='kenoTwoNumberEnter' and @style='display: block;']");
	public static By perm3boxes=By.xpath("//div[@class='lnum-input-area t-box perm3-block']//input[@class='kenoTwoNumberEnter' and @style='display: block;']");
	public static By nooflines=By.xpath("//div[@class='draw-list']//div[@class='bt-right']//div[@id='noOfLines']");
	public static By qpCheckbox=By.xpath("//div[@class='qp-ck']//input[@id='qpCheck']");
	public static By qpEnteredTxt=By.xpath("//input[@id='numToBePickedFN']");
	public static By qpTicketPrice=By.xpath("//button[@id='buy']//span[@id='tktPrice']");
	
	public static By BetTypeLocator=By.className("bettypes");
	
//***************************************	
	 public static By qplocator = By.xpath(".//*[@id='qpCheck']");
	 public static By numpicked = By.xpath(".//*[@id='numPicked']");
	 public static By selectednum = By.xpath("//*[contains(@class,'selectnumber')]");
	 
	 public static By qpfield = By.xpath("html/body/div[2]/div[2]/div[2]/div[3]/div[7]/input");
	 
	
	
}
