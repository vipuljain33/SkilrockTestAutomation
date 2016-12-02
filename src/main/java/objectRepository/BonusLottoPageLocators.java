package objectRepository;

import org.openqa.selenium.By;

public class BonusLottoPageLocators {
	
	public static By drawgamelocator = By.id("dg");
	public static By bonusLottoButton=By.xpath(".//button[@gamename='ZimLottoBonus']");
	public static By direct6BetLocator=By.xpath("//*[contains(@betname,'Direct6')]");
	public static By selectedBetLocator=By.xpath("//*[@id='betTypeSection' and @class='bettype' and @style='display: block;']");
	public static By perm6BetLocator=By.xpath(".//*[@id='2']");
	public static By qpCheckBox=By.xpath(("//input[@id='qpCheck']"));
	public static By qpEnteredTxt=By.xpath("//input[@id='zimQpTextbox']");
	public static By qpTicketPrice=By.xpath("//button[@id='buy']//span[@id='tktPrice']");
	public static By perm6Boxes=By.xpath("//div[@class='sixby-game_input']//input[@class='zimBonusLottoPermSix' and @style='display: block;'");
	public static By errorPopup=By.xpath("//div[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By buyNowLoctor=By.xpath("//button[@id='buy']");
	public static By nooflines=By.xpath("//div[@class='draw-list']//div[@class='bt-right']//div[@id='noOfLines']");
	public static By numberPicker=By.xpath("//*[contains(@id,'bonusLottoNum')]");
	public static By quickPickCheckBox=By.xpath("//*[@id='qpCheck']");
	public static By quickPickTextBox=By.xpath("//*[@id='zimQpTextbox']");
	public static By errorPopupPermSix=By.xpath(".//*[@id='error-popup']/div/div");		
	public static By noOflines=By.xpath(".//*[@id='noOfLines']");
	public static By betAmounts=By.xpath("//*[@id='betAmtPrice']/button");
	public static By buyButton=By.xpath("//*[@id='buy']");
	public static By BetTypeLocator=By.className("bettypes");
	public static By numberInputCellsDirectSix=By.xpath(".//*[contains(@id,'zbl')]") ;
	public static By numberInputCellsPermSix=By.xpath(".//*[contains(@class,'zimBonusLottoPermSix')]");
	public static By resetButton=By.xpath("//*[@id='resetZimLottoBonus']/button");
	public static By enterCradnumberPopup=By.xpath(".//div[@id='card-no']");
	public static By enterCradnumberPopupcancel=By.xpath("//*[@id='card-no']//div[@class='button-cancel']");
	public static By insufficienterrorpopup=By.xpath("//*[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By ticketPreview=By.xpath("//div[@id='tktView']");
	public static By txtPreviewTicketPrice=By.xpath(".//*[@id='tktGen']//div[@class='tkt-dt-m border-top']//div[@class='tkt-rw tlam']//span[@class='no-of-tkt']");
	public static By advanceDrawLocator=By.xpath("//*[@id='advDrawSel']/a");
	public static By advanceDraw=By.xpath("//div[@class='ad-draw-check-box']//label[1]");
	public static By ticketnumber=By.xpath("//div[@class='ticket-view']//div[@class='code-img']//span");
	public static By advanceDrawSelection=By.xpath("//*[@id='drawInfo']/div/div");
	public static By advanceDrawSubmit=By.xpath(".//*[@id='drawSubmit']");
}
    