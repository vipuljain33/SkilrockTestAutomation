package objectRepository;

import org.openqa.selenium.By;

public class TenByTwentyLocator {
	public static By drawgamelocator = By.xpath(".//*[@id='dg']/a");
	public static By TBTlocator = By.xpath("//button[@gamename='TenByTwenty']");
	public static By dierct10locator = By.xpath("//button[@id='1']");
	public static By firsttenlocator = By.xpath("//button[@id='2']");
	public static By lasttenlocator = By.xpath("//button[@id='3']");
	public static By alloddlocator = By.xpath("//button[@id='4']");
	public static By allevenlocator = By.xpath("//button[@id='5']");
	public static By oddevenlocator = By.xpath("//button[@id='6']");
	public static By evenoddlocator = By.xpath("//button[@id='7']");
	public static By jumpoddevenlocator = By.xpath("//button[@id='8']");
	public static By jumpevenoddlocator = By.xpath("//button[@id='9']");
	public static By inputarea = By.xpath("//input[@class='tenByTwentyManualNumberEnter']");
	public static By qpLocator = By.xpath("//*[@id='qpCheck']");
	public static By numpicked1 = By.xpath("//div[@id='numPicked']");
	public static By selectednum1 = By.xpath("//*[contains(@class,'selectnumber')]");
	public static By otheramt = By.xpath("//button[@id='otherBtn']");
	public static By otheramtentered = By.xpath("//input[@id='otherAmt']");
	public static By tktprice = By.xpath("//*[@id='buy']/span[1]/span");
	public static By amnt = By.xpath(".//*[@id='betAmtPrice']/button[4]");
	public static By NoOfLines = By.xpath(".//*[@id='noOfLines']");
	
	//***************************************************************
	//public static By drawgamelocator = By.xpath("//*[@id='dg']/a");
	//public static By TBTlocator = By.xpath("//button[@id='7~16']");
	//public static By dierct10locator = By.xpath("//button[@id='1']");
	//public static By inputarea = By.xpath("//input[@class='tenByTwentyManualNumberEnter']");
	//public static By qpLocator = By.xpath("//*[@id='qpCheck']");
	public static By tenbytwentylocator = By.id("7~16");
	public static By tenByTwenty = By.xpath("//button[@gamename='TenByTwenty']");
	public static By noselectedLocator = By.xpath(".//*[@id='numPicked']");
	public static By firstTen = By.xpath("//*[@id='2']");
	public static By lastTen = By.xpath("//*[@id='3']");
	public static By allODD = By.xpath("//*[@id='4']");
	public static By allEVEN = By.xpath("//*[@id='5']");
	public static By oddEVEN = By.xpath("//*[@id='6']");
	public static By evenODD = By.xpath("//*[@id='7']");
	public static By jumpODDEven = By.xpath("//*[@id='8']");
	public static By jumpEvenODD = By.xpath("//*[@id='9']");
	public static By ticketPreview = By.xpath("//div[@id='tktView']");
	public static By txtPreviewTicketPrice = By.xpath(
			"//*[@id='tktGen']//div[@class='tkt-dt-m border-top']//div[@class='tkt-rw tlam']//span[@class='no-of-tkt']");
	public static By buyNowLoctor = By.xpath("//button[@id='buy']");
	public static By qpTicketPrice = By.xpath("//button[@id='buy']//span[@id='tktPrice']");
	public static By cancelpopup = By.xpath("//*[@id='card-no']/div/h5");
	public static By close = By.xpath(".//*[@id='cardClose']");
	public static By advancedraw = By.xpath("//*[@id='advDrawSel']/a");
	public static By advancedrawinfo = By.xpath("//*[@id='drawInfo']");// Store
																		// the
																		// elements
																		// in
																		// array
																		// list
	public static By adSubmit = By.xpath("//*[@id='drawSubmit']");
	public static By adlable = By.xpath("//*[@id='drawInfo']/div/div/label[1]");
	public static By ticketNo = By.xpath("//*[@id='tktGen']/div/div[2]/div[1]/span[2]");

}
