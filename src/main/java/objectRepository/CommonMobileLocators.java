package objectRepository;

import org.openqa.selenium.By;

public class CommonMobileLocators {
	// Android App Locators

	public static By textViewAndroid = By.xpath(".//*[@class='android.widget.TextView']");
	public static By checkBoxAndroid = By.xpath(".//*[@class='android.widget.CheckBox']");

	// Headers & Subheaders
	public static By headerTextAndroid = By.id("com.skilrock.lms.ui:id/header_text");
	public static By subHeaderTextAndroid = By.id("com.skilrock.lms.ui:id/header_sub_text");
	public static By popupHeaderName = By.id("com.skilrock.lms.ui:id/header_name");
	public static By dialogHeaderTextAndroid = By.id("com.skilrock.lms.ui:id/dialogHeaderText");
	public static By confirmDialogHeaderAndroid = By.xpath(
			"//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/dialogHeaderText' and @text='CONFIRM']");

	// Game Selection
	public static By drawGameAndroid = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/menu_name' and @text='Draw Games']");
	public static By sportsLotteryAndroid = By.xpath(
			"//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/menu_name' and @text='Sports Lottery']");
	public static By instantWinAndroid = By.xpath(
			"//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/menu_name' and @text='Instant Win']");
	public static By scratchCardsAndroid = By.xpath(
			"//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/menu_name' and @text='Scratch Cards']");

	// Dropdown
	public static By gameSelectDropdownAndroid = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/spinner_text']");
	public static String selectDropdownElementAndroid = "//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/spinner_text' and @text='";

	// Draw selection
	public static By advanceDrawAndroid = By.id("com.skilrock.lms.ui:id/advance_menu");
	public static By drawListAndroid = By.id("com.skilrock.lms.ui:id/contact_list");
	public static By clickDoneAndroid = By.id("com.skilrock.lms.ui:id/done");

	// BetTypes
	public static By changeBetTypeAndroid = By.id("com.skilrock.lms.ui:id/change_bet_type");
	public static By betNameAndroid = By.id("com.skilrock.lms.ui:id/bet_name");
	public static String betTypeSelectAndroid = "//android.widget.TextView[@text='";

	// PickTypes
	public static By quickPickAndroid = By.id("com.skilrock.lms.ui:id/quick_pick");
	public static By lastPickAndroid = By.id("com.skilrock.lms.ui:id/last_picked");
	public static By pickNewAndroid = By.id("com.skilrock.lms.ui:id/select_nos");

	// Pick random numbers
	public static String pickRandomNumAndroid = "//android.widget.GridView[@resource-id='com.skilrock.lms.ui:id/no_grid']/android.widget.LinearLayout[@index='";
	public static By clickOKAndroid = By
			.xpath("//android.widget.TextView[@resource-id='com.skilrock.lms.ui:id/buy_now' and @text='OK']");

	// UI vadilations
	public static By noOfLinesAndroid = By.id("com.skilrock.lms.ui:id/no_of_lines");
	public static By selectedNumbersAndroid = By.id("com.skilrock.lms.ui:id/selected_nos");
	public static By selectQPNumbersAndroid = By.id("com.skilrock.lms.ui:id/qp_nos");
	public static By noOfLinesSLEAndroid = By.id("com.skilrock.lms.ui:id/txt_line_no");
	public static By betAmountSLEAndroid = By.id("com.skilrock.lms.ui:id/txt_bet_amount");
	public static By ticketAmountSLEAndroid = By.id("com.skilrock.lms.ui:id/txt_ticket_amount");

	// Increase/Decrease bet amount
	public static By increaseBetAndroid = By.id("com.skilrock.lms.ui:id/inc");
	public static By decreaseBetAndroid = By.id("com.skilrock.lms.ui:id/dec");
	public static By incBetAmountSLEAndroid = By.id("com.skilrock.lms.ui:id/img_bet_inc");
	public static By decBetAmountSLEAndroid = By.id("com.skilrock.lms.ui:id/img_bet_dec");

	// Increase/Decrease qp numbers
	public static By incQpNumbersAndroid = By.id("com.skilrock.lms.ui:id/qp_inc");
	public static By decQpNumbersAndroid = By.id("com.skilrock.lms.ui:id/qp_dec");

	// GamePlay Purchase amount
	public static By finalAmountAndroid = By.id("com.skilrock.lms.ui:id/final_amt");

	// Sports Lottery Selection
	public static By clickHomeAndroid = By.id("com.skilrock.lms.ui:id/cb_home");
	public static By clickDrawAndroid = By.id("com.skilrock.lms.ui:id/cb_draw");
	public static By clickAwayAndroid = By.id("com.skilrock.lms.ui:id/cb_away");

	// BUYNOW
	public static By buyNowAndroid = By.id("com.skilrock.lms.ui:id/buy_now");
	public static By buyNowSLEAndroid = By.id("com.skilrock.lms.ui:id/btn_proceed");
	// Confirmation
	public static By clickConfirmationDoneAndroid = By.id("com.skilrock.lms.ui:id/dialogDone");

	// Ticket Preview
	public static By tktPreviewGamenameAndroid = By.id("com.skilrock.lms.ui:id/gameName");

}
