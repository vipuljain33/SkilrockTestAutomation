package pages;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.MultiHashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DataBaseQuery.DBConnection;
import DataBaseQuery.TenByTwentySqlQuery;
import junit.framework.Assert;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.TenByTwentyLocator;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;

public class TenByTwentyPage extends BasePage {
	CommonFunctionLibrary functionLibrary;
	int flag = 1;
	int price1;
	static String txtBuynow;
	DBConnection con;
	public static String txtPreviewTktPricee;
	WebDriver driver;
	private static Logger LOGGER = LoggerFactory.getLogger(TenByTwentyPage.class);

	public TenByTwentyPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		functionLibrary = new CommonFunctionLibrary(driver);
	}

	public void isTenByTwentySelected() {
		functionLibrary.switchFrame("leftbottom");
		if (isElementPresent(TenByTwentyLocator.TBTlocator, 5)) {
			findElement(TenByTwentyLocator.TBTlocator, 5).click();
		} else {
			Assert.fail("TEN_BY_TWENTY NOT FOUND!!");
		}

	}

	public boolean isDirectTenSelected() {
		if (isElementPresent(TenByTwentyLocator.dierct10locator, 5)) {
			findElement(TenByTwentyLocator.dierct10locator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean isQPSelected() {
		if (isElementPresent(TenByTwentyLocator.qpLocator, 5)) {
			findElement(TenByTwentyLocator.qpLocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberBetweenTenToTwenty() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);

		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num < 1000 && num > 20) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isFirstTenSelected() {
		if (isElementPresent(TenByTwentyLocator.firsttenlocator, 5)) {
			findElement(TenByTwentyLocator.firsttenlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberSelectionFirstTen() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num > 10) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isLastTenSelected() {
		if (isElementPresent(TenByTwentyLocator.lasttenlocator, 5)) {
			findElement(TenByTwentyLocator.lasttenlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberSelectionLastTen() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num < 11) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isAllOddSelected() {
		if (isElementPresent(TenByTwentyLocator.alloddlocator, 5)) {
			findElement(TenByTwentyLocator.alloddlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean NumberSelectionAllOdd() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num % 2 == 0) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isAllEvenSelected() {
		if (isElementPresent(TenByTwentyLocator.allevenlocator, 5)) {
			findElement(TenByTwentyLocator.allevenlocator, 5).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean EvenNumberSelection() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num % 2 != 0) {
				flag = 0;
				break;
			}
		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isQpDisabled() {
		if (isElementPresent(TenByTwentyLocator.qpLocator, 5)) {
			if (findElement(TenByTwentyLocator.qpLocator, 5).getAttribute("disabled").equalsIgnoreCase("true")) {
				System.out.println("QP is disabled");
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isEvenOddSelected() {
		if (isElementPresent(TenByTwentyLocator.evenoddlocator, 5)) {
			findElement(TenByTwentyLocator.evenoddlocator, 5).click();
			System.out.println(" EVENODD FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public boolean EvenOddNumberSelection() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num < 11) {
				if (num % 2 != 0) {
					flag = 0;
					break;
				}
			}
			if (num > 10) {
				if (num % 2 == 0) {
					flag = 0;
					break;
				}
			}

		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}
	}

	public boolean isOddEvenSelected() {
		if (isElementPresent(TenByTwentyLocator.oddevenlocator, 5)) {
			findElement(TenByTwentyLocator.oddevenlocator, 5).click();
			System.out.println(" ODDEVEN FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public boolean OddEvenNumberSelection() {
		List<String> pickednum = new ArrayList<String>();
		pickednum = NumbersPicked(TenByTwentyLocator.numpicked1);
		for (String val : pickednum) {
			int num = Integer.parseInt(val);
			if (num > 10) {
				if (num % 2 != 0) {
					flag = 0;
					break;
				}
			}
			if (num < 11) {
				if (num % 2 == 0) {
					flag = 0;
					break;
				}
			}

		}
		if (flag == 0) {
			return false;
		} else {
			System.out.println("pass");
			return true;
		}

	}

	public boolean isJumpOddEvenSelected() {
		if (isElementPresent(TenByTwentyLocator.jumpoddevenlocator, 5)) {
			findElement(TenByTwentyLocator.jumpoddevenlocator, 5).click();
			System.out.println("JUMPODDEVEN FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public List<String> NumbersPicked(By by) {
		String str = findElement(by, 5).getText();
		System.out.println(str);
		ArrayList<String> qpselected = new ArrayList<String>();

		for (String number : str.split(",")) {
			System.out.println(number);
			qpselected.add(number);

		}
		return qpselected;

	}

	public List<String> ListOfJumpOddEven() {
		List<String> pickednum2 = new ArrayList<String>();
		pickednum2.add("01");
		pickednum2.add("02");
		pickednum2.add("05");
		pickednum2.add("06");
		pickednum2.add("09");
		pickednum2.add("10");
		pickednum2.add("13");
		pickednum2.add("14");
		pickednum2.add("17");
		pickednum2.add("18");
		return pickednum2;
	}

	public boolean isJumpEvenOddSelected() {
		if (isElementPresent(TenByTwentyLocator.jumpevenoddlocator, 5)) {
			findElement(TenByTwentyLocator.jumpevenoddlocator, 5).click();
			System.out.println("JUMPEVENODD FOUND!!");
			return true;
		} else {
			return false;
		}
	}

	public List<String> ListOfJumpEvenOdd() {
		List<String> pickednum2 = new ArrayList<String>();
		pickednum2.add("03");
		pickednum2.add("04");
		pickednum2.add("07");
		pickednum2.add("08");
		pickednum2.add("11");
		pickednum2.add("12");
		pickednum2.add("15");
		pickednum2.add("16");
		pickednum2.add("19");
		pickednum2.add("20");
		return pickednum2;
	}

	public boolean OtherAmountSelected() {
		if (isElementPresent(TenByTwentyLocator.otheramt, 5)) {
			findElement(TenByTwentyLocator.amnt, 5).click();
			System.out.println("element clicked!!");
			// findElement(TenByTwentyLocator.otheramtentered, 5).sendKeys("5");
			//System.out.println("amount entered");
			return true;
		} else {
			return false;
		}
	}

	String price;

	public boolean VerifyTicketPrice() {
		double NoOfLine = Double.parseDouble(findElement(TenByTwentyLocator.NoOfLines, 5).getText());
		double amount = Double.parseDouble(findElement(TenByTwentyLocator.amnt, 5).getText());

		double price = Double.parseDouble(findElement(TenByTwentyLocator.tktprice, 5).getText());

		double Tktprice = NoOfLine * amount;

		if (price == Tktprice) {
			System.out.println("TICKET PRICE VALIDATED SUCCEFULLY");
			return true;
		} else {
			return false;
		}
	}
	
	
	/*************************************************************/
	
	//CommonFunctionLibrary functionLibrary;

	public boolean isDirectTenBetTypeSelected() {
		functionLibrary.switchFrame("leftbottom");
		if (findElement(TenByTwentyLocator.dierct10locator,5).getAttribute("betname")
				.equalsIgnoreCase("Direct10")) {

			System.out.println("Direct 10 Bet type selected");
			return true;
		} else {
			System.out.println("DirectTen Bet Type Selection faild");
			return false;
		}

	}

	public boolean isQuickPickSelected() {
		// functionLibrary.switchFrame("leftbottom");
		if (findElement(TenByTwentyLocator.qpLocator, 10).getAttribute("type").equalsIgnoreCase("checkbox")) {

			findElement(TenByTwentyLocator.qpLocator, 5).click();
			System.out.println(findElement(TenByTwentyLocator.qpLocator, 5));
			return true;
		} else {
			System.out.println("QP not selected");
			return false;
		}
	}

	public boolean isTenNumbersselected() {
		// int size=0;
		List<String> newlist = new ArrayList<String>();
		newlist = qpposselectedForTBT(TenByTwentyLocator.noselectedLocator);
		int size = newlist.size();
		if (newlist.size() != 0) {
			return true;
		} else {

			return false;
		}

	}

	public List<String> qpposselectedForTBT(By by) {

		List<WebElement> qpposselected = new ArrayList<WebElement>();

		List<String> newlist = new ArrayList<String>();
		qpposselected = driver.findElements(by);
		for (WebElement we : qpposselected) {
			newlist.add(we.getText());
		}

		System.out.println("newlist" + newlist);
		return newlist;
	}

	public Boolean isFirst10BettypeSelected() {
		if (findElement(TenByTwentyLocator.firstTen, 3).getAttribute("betname").equalsIgnoreCase("First10")) {
			findElement(TenByTwentyLocator.firstTen, 3).click();
			System.out.println("Successfully Clicked on First10 bettype");
			return true;

		} else {
			return false;
		}
	}

	public Boolean isLastTenBettypeSelected() {
		if (findElement(TenByTwentyLocator.lastTen, 3).getAttribute("betname").equalsIgnoreCase("Last10")) {
			findElement(TenByTwentyLocator.lastTen, 3).click();
			System.out.println("Successfully Clicked on Last10 bettype");
			if (isBuyButtonEnable()) {
				System.out.println("Buy Button enabled");
				return true;
			} else {
				Assert.fail();
				return false;
			}
		} else {
			return false;
		}
	}

	public Boolean isALLODDBettypeSelected() {
		if (findElement(TenByTwentyLocator.allODD, 3).getAttribute("betname").equalsIgnoreCase("AllOdd")) {
			findElement(TenByTwentyLocator.allODD, 3).click();
			System.out.println("Successfully Clicked on ALLODD bettype");
			if (isBuyButtonEnable()) {
				System.out.println("Buy Button enabled");
				return true;
			} else {
				Assert.fail();
				return false;
			}
		} else {
			return false;
		}

	}

	public Boolean isALLEVENBettypeSelected() {
		if (findElement(TenByTwentyLocator.allEVEN, 3).getAttribute("betname").equalsIgnoreCase("AllEven")) {
			findElement(TenByTwentyLocator.allEVEN, 3).click();
			System.out.println("Successfully Clicked on ALLODD bettype");
			if (isBuyButtonEnable()) {
				System.out.println("Buy Button enabled");
				return true;
			} else {
				Assert.fail();
				return false;
			}
		} else {
			return false;
		}

	}

	public boolean isODDEVENBettypeSelected() {
		if (findElement(TenByTwentyLocator.oddEVEN, 3).getAttribute("betname").equalsIgnoreCase("OddEven")) {
			findElement(TenByTwentyLocator.oddEVEN, 3).click();
			System.out.println("Successfully Clicked on ODDEVEN bettype");
			if (isBuyButtonEnable()) {
				System.out.println("Buy Button enabled");
				return true;
			} else {
				Assert.fail();
				return false;
			}
		} else {
			return false;

		}

	}

	public Boolean isEvenOddBettypeSelected() {
		if (findElement(TenByTwentyLocator.evenODD, 3).getAttribute("betname").equalsIgnoreCase("EvenOdd")) {
			findElement(TenByTwentyLocator.evenODD, 3).click();
			System.out.println("Successfully Clicked on EVENODD bettype");
			if (isBuyButtonEnable()) {
				System.out.println("Buy Button enabled");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public Boolean isJumpOddEvenBettypeSelected() {
		if (findElement(TenByTwentyLocator.jumpODDEven, 3).getAttribute("betname").equalsIgnoreCase("JumpOddEven")) {
			findElement(TenByTwentyLocator.jumpODDEven, 3).click();
			System.out.println("Successfully Clicked on JumpOddEven bettype");
			if (isBuyButtonEnable()) {
				System.out.println("Buy Button enabled");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public Boolean isJumpEvenOddBettypeSelected() {
		if (findElement(TenByTwentyLocator.jumpEvenODD, 3).getAttribute("betname").equalsIgnoreCase("JumpEvenOdd")) {
			findElement(TenByTwentyLocator.jumpEvenODD, 3).click();
			System.out.println("Successfully Clicked on JumpEvenOdd bettype");
			if (isBuyButtonEnable()) {
				System.out.println("Buy Button enabled");
				return true;
			} else {

				return false;
			}
		} else {

			return false;
		}

	}

	// TICKET VIEW SHOWN

	public boolean ticketView() {
		if (findElement(TenByTwentyLocator.cancelpopup, 4).getText().equalsIgnoreCase("Please enter card number")) {
			System.out.println("Canceld popup");
			findElement(TenByTwentyLocator.close, 3).click();

		}

		CommonFunctionLibrary library = new CommonFunctionLibrary(driver);
		library.switchToAlertOk();

		if (findElement(TenByTwentyLocator.ticketPreview, 5).isDisplayed()) {
			txtPreviewTktPricee = findElement(TenByTwentyLocator.txtPreviewTicketPrice, 5).getText();
			System.out.println("ticket preview amount:" + txtPreviewTktPricee);

			if (ReusableStaticMethods.covertStringToTwoDecimalNum(txtPreviewTktPricee)
					.equals(ReusableStaticMethods.covertStringToTwoDecimalNum(txtBuynow))) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}
	}

	// BUY BUTTON ENABLE
	public boolean clickonBuyButton() {
		if (isBuyButtonEnable()) {
			findElement(TenByTwentyLocator.buyNowLoctor, 3).click();
			return true;
		} else {
			return false;
		}
	}

	public boolean isBuyButtonEnable() {

		if (findElement(TenByTwentyLocator.buyNowLoctor, 5).isDisplayed()) {
			System.out.println("Buy button is enabled");
			txtBuynow = findElement(TenByTwentyLocator.qpTicketPrice, 5).getText();
			System.out.println("txt buy now: " + txtBuynow);
			return true;
		} else {
			return false;
		}
	}

	public void isAdvanceDrawSelected() {
		int count = 0;
		WebElement ele = driver.findElement(TenByTwentyLocator.advancedrawinfo);
		List<WebElement> adEvements = new ArrayList<WebElement>();
		adEvements = ele.findElements(By.className("col-span-4"));
		if (findElement(TenByTwentyLocator.advancedraw, 5) != null) {
			findElement(TenByTwentyLocator.advancedraw, 5).click();
			for (WebElement e : adEvements) {
				e.click();
				count++;
				if (count == adEvements.size()) {
					if (findElement(TenByTwentyLocator.adSubmit, 3) != null) {
						driver.findElement(TenByTwentyLocator.adSubmit).click();
						System.out.println("Advance Draw Selected");
					} else {
						Assert.fail();
					}
				}
			}

		} else {
			Assert.fail();
		}
	}

	public boolean dbadvanceDrawVerify() throws SQLException {
		driver.findElement(TenByTwentyLocator.advancedraw).click();
		List<String> databaseValue = new ArrayList<String>();
		List<WebElement> drawlist = driver.findElements(TenByTwentyLocator.adlable);
		con = new DBConnection();

		ResultSet resultset = con.ExecuteQuery(con.CreateConnectionForDGE(), TenByTwentySqlQuery.advanceDraw, "active");

		while (resultset.next()) {
			for (int j = 1; j <= resultset.getMetaData().getColumnCount(); j++) {
				databaseValue.add(resultset.getString(j));
			}
		}

		int size = databaseValue.size();
		int count = 0;
		for (int i = 0; i < drawlist.size(); i++) {

			String value = ReusableStaticMethods.convertsToDateFormate(drawlist.get(i).getText().trim()).concat(".0");

			if (value.equals(databaseValue.get(i))) {

				System.out.println("database value: " + databaseValue.get(i) + " match with front end: " + value);
				count++;
			} else {
				System.out.println("value not matched");

			}
		}

		if (count == size) {
			return true;
		} else {
			return false;
		}

	}

	public Boolean isAdvanceDrawClicked() {
		findElement(TenByTwentyLocator.advancedraw, 3).click();
		WebElement ele = findElement(TenByTwentyLocator.advancedrawinfo, 5);
		List<WebElement> listele = new ArrayList<WebElement>();
		listele = ele.findElements(TenByTwentyLocator.adlable);
		int cc = 0;
		for (WebElement e : listele) {
			if (e.getAttribute("for").equalsIgnoreCase("checkBox1")) {
				e.click();
				System.out.println(e.getText());
				cc++;
			}
		}
		if (cc == listele.size()) {
			System.out.println("All Advance Draw Selected");
			findElement(TenByTwentyLocator.adSubmit, 3).click();
			return true;
		} else {
			System.out.println("All Advance Draw Option Is Not Selected");
			return false;
		}

	}

	// *******************************************************
	// **********************************************************

	public List<Map<String, String>> returnDatabaseValue() throws SQLException {
		List<Map<String, String>> listitem = new ArrayList<Map<String, String>>();
		boolean status = ticketView();
		if (status) {
			String ele = driver.findElement(TenByTwentyLocator.ticketNo).getText();
			System.out.println(ele);
			String value = ReusableStaticMethods.removeZeroFromticket(ele);
			LOGGER.info("In ticket number zero removed: " + value);

			DBConnection con1 = new DBConnection();
			ResultSet resultset = con1.ExecuteQuery(DBConnection.getDBConnectionDge(), TenByTwentySqlQuery.ticketNumber,
					value);

			while (resultset.next()) {
				System.out.println(resultset.getString(2));
				// for(int i=1;i<=resultset.getMetaData().getColumnCount();i++)
				// {
				/*
				 * System.out.println("For loop");
				 */
				HashMap hashmap = new MultiHashMap();
				hashmap.put(resultset.getString(0), resultset.getString(1));
				hashmap.put(resultset.getString(0), resultset.getString(2));
				hashmap.put(resultset.getString(0), resultset.getString(3));
				listitem.add(hashmap);
				// }

			}
		} else {
			listitem = null;
		}
		return listitem;
	}

}

	
