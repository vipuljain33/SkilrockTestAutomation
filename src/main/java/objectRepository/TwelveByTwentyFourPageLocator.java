package objectRepository;

import org.openqa.selenium.By;

public class TwelveByTwentyFourPageLocator {

	public static By drawgamelocator =  By.id("dg");
	public static By TwelveByTwentyFourlocator = By.xpath(".//*[@id='2~15']");
	public static By selectedBetLocator=By.xpath("//button[@class='bettypes select-bet']");
	public static String selectNumber = "//*[@class='number-select']/ul/li[";
	//public static By errorPopup=By.xpath("//div[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By direct12locator=By.xpath("//button[@betname='Direct12']");
	public static By first12locator=By.xpath("//button[@betname='First12']");
	public static By last12locator=By.xpath("//button[@betname='Last12']");
	public static By AllOddLocator=By.xpath("//button[@betname='AllOdd']");
	public static By AllEvenlocator=By.xpath("//button[@betname='AllEven']");
	public static By EvenOddLocator=By.xpath("//button[@betname='EvenOdd']");
	public static By OddEvenlocator=By.xpath("//button[@betname='OddEven']");
	public static By JumpEvenOddLocator=By.xpath("//button[@betname='JumpEvenOdd']");
	public static By JumpOddEvenLocator=By.xpath("//button[@betname='JumpOddEven']");
	public static By Perm12locator=By.xpath("//button[@betname='Perm12']");

	public static By SelectedNum=By.xpath("//div[@class='number-select']/ul/li[@class='pmsnumber selectnumber']/span");
	public static By errorPopup=By.xpath("//div[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By buyNowLocator=By.xpath("//button[@id='buy']");
	public static By direct12boxes=By.xpath("//div[@class='input-area twelveByTwenty-input-area']//input[@class='manualNumberEnter' and @type='text']");
	public static By first12boxes=By.xpath("//*[@id='twelveByTwentyFour']/div[2]/div[1]/input");	
	public static By perm12boxes=By.xpath("//div[@class='input-area twelveByTwenty-input-area permTwelve-block']//input[@class='manualNumberEnter' and @type='text']");
	public static By noOflines=By.xpath("//div[@class='draw-list']//div[@class='bt-right']//div[@id='noOfLines']");
	public static By qpCheckbox=By.xpath("//div[@class='qp-ck']//input[@id='qpCheck']");
	public static By qpEnteredTxt=By.xpath("//input[@id='twelveByTwentyQpBox']");
	public static By TicketPrice=By.xpath("//button[@id='buy']//span[@id='tktPrice']");
	public static By BetTypeLocator=By.className("bettypes");

	public static By advanceDraw=By.xpath("//div[@class='ad-draw-check-box']//label[1]");
	public static By advanceDrawLocator=By.xpath("//*[@id='advDrawSel']/a");
	public static By enterCradnumberPopupcancel=By.xpath("//*[@id='card-no']//div[@class='button-cancel']");
	public static By insufficienterrorpopup=By.xpath("//*[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By ticketPreview=By.xpath("//div[@id='tktView']");
	public static By ticketnumber=By.xpath("//div[@class='ticket-view']//div[@class='code-img']//span");


	
	
}
