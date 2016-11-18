package objectRepository;

import org.openqa.selenium.By;

public class LuckeyNumberPageLocator {

	public static By drawgamelocator = By.id("dg");
	public static By luckynumberlocator = By.xpath("//*[@class='sideMenuList select-game']");
	public static By selectedBetLocator = By.xpath("//button[@class='bettypes select-bet']");
	// public static By luckynumberlocator = By.id("0~1");
	public static String selectNumber = "//*[@class='lnum-no-select']/ul/li[";
	public static By errorPopup = By.xpath("//div[@id='error-popup']//div[@class='modal-bodyWrap']//div[@id='error']");
	public static By perm2locator = By.xpath("//button[@betname='Perm2']");
	public static By perm3Locator = By.xpath("//button[@betname='Perm3']");
	public static By buyNowLoctor = By.xpath("//button[@id='buy']");
	public static By perm1boxes = By.xpath(
			"//div[@class='lnum-input-area perm1-block']//input[@class='kenoTwoNumberEnter' and @style='display: block;']");
	public static By perm2boxes = By.xpath(
			"//div[@class='lnum-input-area t-box perm2-block']//input[@class='kenoTwoNumberEnter' and @style='display: block;']");
	public static By perm3boxes = By.xpath(
			"//div[@class='lnum-input-area t-box perm3-block']//input[@class='kenoTwoNumberEnter' and @style='display: block;']");
	public static By nooflines = By.xpath("//div[@class='draw-list']//div[@class='bt-right']//div[@id='noOfLines']");
	public static By qpCheckbox = By.xpath("//div[@class='qp-ck']//input[@id='qpCheck']");
	public static By qpEnteredTxt = By.xpath("//input[@id='numToBePickedFN']");
	public static By qpTicketPrice = By.xpath("//button[@id='buy']//span[@id='tktPrice']");

	// Android App Locators
	public static By drawGameAndroid = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/menu_name' and @text='Draw Games']");
	public static By headerTextAndroid = By.id("com.skilrock.lms.ui:id/header_text");
	public static By subHeaderTextAndroid = By.id("com.skilrock.lms.ui:id/header_sub_text");
	public static By popupHeaderName = By.id("com.skilrock.lms.ui:id/header_name");
	public static By gameSelectDropdownAndroid = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/spinner_text']");
	public static By selectLuckyNumbersAndroid = By.xpath(
			"//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/spinner_text' and @text='Lucky Numbers']");
	public static By changeBetTypeAndroid = By.id("com.skilrock.lms.ui:id/change_bet_type");
	public static By buyNowAndroid = By.id("com.skilrock.lms.ui:id/buy_now");
	public static By betName = By.id("com.skilrock.lms.ui:id/bet_name");
	public static By perm1Android = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/bet_name' and @text='Perm1']");
	public static By perm2Android = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/bet_name' and @text='Perm2']");
	public static By perm3Android = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/bet_name' and @text='Perm3']");
	public static By noOfLinesAndroid = By.id("com.skilrock.lms.ui:id/no_of_lines");
	public static By quickPickAndroid = By.id("com.skilrock.lms.ui:id/quick_pick");
	public static By lastPickAndroid = By.id("com.skilrock.lms.ui:id/last_picked");
	public static By pickNewAndroid = By.id("com.skilrock.lms.ui:id/select_nos");
	public static String pickRandomNumAndroid = "//android.widget.GridView[@resource-id='com.skilrock.lms.ui:id/no_grid']/android.widget.LinearLayout[@index='";
	public static By increaseAndroid = By.id("com.skilrock.lms.ui:id/inc");
	public static By decreaseAndroid = By.id("com.skilrock.lms.ui:id/dec");
	public static By finalAmountAndroid = By.id("com.skilrock.lms.ui:id/final_amt");
	public static By clickOKAndroid = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/buy_now' and @text='OK']");

}
