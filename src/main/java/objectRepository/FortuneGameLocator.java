package objectRepository;

import org.openqa.selenium.By;

public class FortuneGameLocator {
	public static By drawgamelocator = By.id("dg");
	public static By fortuneGamelocator = By.xpath("//*[@id='8~19']");
	public static String selectNumberlocator ="//div[@class='number-select-12']/ul/li[";
	public static By errorPopuplocator = By.xpath("//div[@id='error-popup']//div[@id='error']");
	public static By qpCheckboxlocator = By.xpath("//*[@id='qpCheck']");
	public static By notobePickedlocator = By.xpath("//*[@id='numToBePicked']");
	public static By numofDrawsSelectedlocator = By.xpath("//*[@id='numOfDrawsSelected']");
	public static By otherbetAmountlocator = By.xpath("//*[@id='otherBtn']");
	public static By otherbetAmountAmtlocator = By.xpath("//*[@id='otherAmt']");
	public static By buyNowlocator = By.xpath("//*[@id='buy']");
	public static By buyNowMessagelocator = By.xpath("//*[@id='buyMessage']");
	public static By numofAdvancedDrawslocator = By.xpath("//*[@id='advDrawSel']/a");
	public static By numPickedlocator=By.xpath("//*[@id='numPicked']");
	public static By  selectednumlocator = By.xpath("//*[contains(@class,'selected-number')]/span[1]");
	public static By  selectednumManlocator=By.xpath("//*[@class='input-area-12']/input");
	public static By  buyNowAmountlocator=By.xpath("//*[@id='tktPrice']");
	public static String betAmountlocator ="//*[@id='betAmtPrice']/button[";
	public static By enterCardNumberPopupcancellocator =By.xpath("//*[@id='card-no']//div[@class='button-cancel']");
	public static By enterCardNumberPopuplocator =By.xpath("//div[@id='card-no']");
	public static By txtPreviewTicketPricelocator=By.xpath("//*[@id='tktGen']//div[@class='tkt-dt-m border-top']//div[@class='tkt-rw tlam']//span[@class='no-of-tkt']");
	public static By ticketnumberlocator=By.xpath("//div[@class='ticket-view']//div[@class='code-img']//span");
	public static By timerDisplaylocator=By.xpath("//*[@id='kenoTwo']//div[@class='timer-KenoTwo timer-div']");
	public static By advanceDraw=By.xpath("//div[@class='ad-draw-check-box']//label[1]");
	public static By advanceDrawlocator=By.xpath("//*[@id='advDrawSel']/a");
	public static By insufficienterrorpopuplocator=By.xpath("//*[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By ticketPreviewlocator=By.xpath("//div[@id='tktView']");

}
