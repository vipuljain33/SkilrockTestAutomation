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
}
