package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DataBaseQuery.DBConnection;
import DataBaseQuery.LuckyNumberSqlQuery;
import DataBaseQuery.TwelveByTwentyFourSqlQuery;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.TwelveByTwentyFourPageLocator;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;

public class TwelveByTwentyFourPage extends BasePage {

	private static Logger LOGGER = LoggerFactory.getLogger(TwelveByTwentyFourPage.class);
	static String txtBuynow;

	public static Map<String, String> betNumberMap = null;
	static {
		betNumberMap = new HashMap<String, String>();
		betNumberMap.put("FIRST12", "01,02,03,04,05,06,07,08,09,10,11,12");
		betNumberMap.put("LAST12", "13,14,15,16,17,18,19,20,21,22,23,24");
		betNumberMap.put("ALLODD", "01,03,05,07,09,11,13,15,17,19,21,23");
		betNumberMap.put("ALLEVEN", "02,04,06,08,10,12,14,16,18,20,22,24");
		betNumberMap.put("ODDEVEN", "01,03,05,07,09,11,14,16,18,20,22,24");
		betNumberMap.put("EVENODD", "02,04,06,08,10,12,13,15,17,19,21,23");
		betNumberMap.put("JUMPEVENODD", "03,04,07,08,11,12,15,16,19,20,23,24");
		betNumberMap.put("JUMPODDEVEN", "01,02,05,06,09,10,13,14,17,18,21,22");
	}

	public static Map<String, String> bettypestbtf = null;
	static {
		bettypestbtf = new HashMap<String, String>();
		bettypestbtf.put("DIRECT12", "1");
		bettypestbtf.put("FIRST12", "2");
		bettypestbtf.put("LAST12", "3");
		bettypestbtf.put("ALLODD", "4");
		bettypestbtf.put("ALLEVEN", "5");
		bettypestbtf.put("ODDEVEN", "6");
		bettypestbtf.put("EVENODD", "7");
		bettypestbtf.put("JUMPEVENODD", "8");
		bettypestbtf.put("JUMPODDEVEN", "9");
		bettypestbtf.put("PERM12", "10");
	}

	private static Logger logger = LoggerFactory.getLogger(TwelveByTwentyFourPage.class);
	CommonFunctionLibrary functionLibrary = new CommonFunctionLibrary(driver);

	public TwelveByTwentyFourPage(WebDriver driver) {
		super(driver);
	}

	public void isDrawgameSelected() {
		if (findElement(TwelveByTwentyFourPageLocator.drawgamelocator, 5).getCssValue("border-bottom") != null) {
			logger.info("Draw Game Is Selected");
		} else {
			logger.error("Unable To Select DG");
			Assert.fail();
		}
	}

	public boolean isTwelveByTwentyFourSelected() {

		try {

			functionLibrary.switchFrame("leftbottom");
			// System.out.println("okay");
			driver.findElement(TwelveByTwentyFourPageLocator.TwelveByTwentyFourlocator).click();
			if (findElement(TwelveByTwentyFourPageLocator.direct12locator, 5).getAttribute("betname")
					.equalsIgnoreCase("Direct12")) {
				// System.out.println("okay");
				logger.info("TwelveByTwentyFour Game Is Selected");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isFirst12bettypeSelected() {
		try {

			driver.findElement(TwelveByTwentyFourPageLocator.first12locator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 2).getAttribute("betname")
					.equalsIgnoreCase("First12")) {
				logger.info("First12 is selected");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isLast12bettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.last12locator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("Last12")) {
				logger.info("Last12 is selected");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public boolean isAllOddbettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.AllOddLocator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("AllOdd")) {
				logger.info("AllOdd is selected");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;

	}

	public boolean isAllEvenbettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.AllEvenlocator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("AllEven")) {
				logger.info("AllEven is selected");
				return true;
			}
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		return false;

	}

	public boolean isOddEvenbettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.OddEvenlocator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("OddEven")) {
				logger.info("OddEven is selected");
				return true;
			}
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		return false;
	}

	public boolean isEvenOddbettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.EvenOddLocator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("EvenOdd")) {
				logger.info("EvenOdd is selected");
				return true;
			}
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		return false;
	}

	public boolean isJumpEvenOddbettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.JumpEvenOddLocator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("JumpEvenOdd")) {
				logger.info("JumpEvenOdd is selected");
				return true;
			}
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		return false;
	}

	public boolean isJumpOddEvenbettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.JumpOddEvenLocator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("JumpOddEven")) {
				logger.info("JumpOddEven is selected");
				return true;
			}
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		return false;
	}

	public boolean isPerm12bettypeSelected() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.Perm12locator).click();
			if (findElement(TwelveByTwentyFourPageLocator.selectedBetLocator, 5).getAttribute("betname")
					.equalsIgnoreCase("Perm12")) {
				logger.info("perm 12 is selected");
				return true;
			}
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		return false;
	}

	public void NoOfBoxes() throws InterruptedException {
		List<WebElement> list = driver.findElements(TwelveByTwentyFourPageLocator.first12boxes);
		// Thread.sleep(20000);
		if (list.size() == 12) {
			System.out.println("total number of boxes for first12 validate");
		} else {
			Assert.fail();
		}
	}

	public void NoOfBoxesPerm12() throws InterruptedException {
		List<WebElement> list = driver.findElements(TwelveByTwentyFourPageLocator.perm12boxes);
		// Thread.sleep(20000);
		if (list.size() == 14) {
			System.out.println("total number of boxes for perm12 validate");
		} else {
			Assert.fail();
		}
	}

	public boolean isBuyButtonDisabled() {
		try {
			String txt = driver.findElement(TwelveByTwentyFourPageLocator.buyNowLocator).getAttribute("disabled");
			System.out.println("buybutton: " + txt);
			if (findElement(TwelveByTwentyFourPageLocator.buyNowLocator, 7).getAttribute("disabled")
					.equalsIgnoreCase("true")) {
				logger.info("less than boundary verification pass");
				System.out.println("buy now button disabled");
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public String errorMessageHandle() {
		String errorTxt = driver.findElement(TwelveByTwentyFourPageLocator.errorPopup).getText();
		System.out.println(errorTxt);
		return errorTxt;
	}

	public boolean first12SelectedNum() {
		try {

			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "FIRST12";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean last12SelectedNum() {
		try {
			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "LAST12";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean alloddSelectedNum() {
		try {
			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "ALLODD";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean allEvenSelectedNum() {
		try {
			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "ALLEVEN";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean OddEvenSelectedNum() {
		try {
			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "ODDEVEN";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean EvenOdddSelectedNum() {
		try {
			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "EVENODD";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean JumpEvenOdddSelectedNum() {
		try {
			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "JUMPEVENODD";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean JumpOddEvenSelectedNum() {
		try {
			List<WebElement> selectedNumList = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
			// SelectedNumList.toArray();
			String betType = "JUMPODDEVEN";
			String[] betNumbers = betNumberMap.get(betType).split(",");
			System.out.println(betNumbers);
			boolean status;
			for (int i = 0; i < selectedNumList.size(); i++) {
				status = selectedNumList.get(i).getText().equalsIgnoreCase(betNumbers[i]);
				if (!status) {
					logger.info("Wrong Selection");
					break;
				}
				logger.info("Correct Selection : " + selectedNumList.get(i).getText());
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickQP() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.qpCheckbox).click();
			return true;
		} catch (Exception e) {
			return false; // TODO: handle exception
		}
	}

	public void printSelectedNum() {
		List<WebElement> selectedNumD12 = driver.findElements(TwelveByTwentyFourPageLocator.SelectedNum);
		if (selectedNumD12 != null) {
			logger.info("Selected numbers are :");
			for (WebElement ele : selectedNumD12) {
				System.out.println(ele.getText());
			}
		} else

			Assert.fail();
	}

	public boolean QPButtonDisable() {
		try {
			driver.findElement(TwelveByTwentyFourPageLocator.qpCheckbox).getAttribute("disabled");
			if (findElement(TwelveByTwentyFourPageLocator.qpCheckbox, 7).getAttribute("disabled")
					.equalsIgnoreCase("true")) {
				logger.info("QP button disabled");
				return true;
			}
		} catch (Exception e) {
			return false;// TODO: handle exception
		}
		return false;
	}

	public String noOfLines() {
		String txt = driver.findElement(TwelveByTwentyFourPageLocator.noOflines).getText();
		System.out.println(txt);
		return txt.trim();
	}

	public String ticketPriceFirstTwelve() {
		String txt = driver.findElement(TwelveByTwentyFourPageLocator.TicketPrice).getText();
		System.out.println("ticket price firstTwelve" + txt);
		return txt.trim();
	}

	public boolean verifyBetTypes() throws SQLException{
			int gameNo = 15;
			DBConnection dbconnection = new DBConnection();
			Connection con = DBConnection.getDBConnectionDge();
			ResultSet rs=dbconnection.executeQuery(con, TwelveByTwentyFourSqlQuery.TwelveByTwentyFourActiveBetType, gameNo);
			List<String> dbbettype= new ArrayList<String>();
    		boolean flag=false;
			while(rs.next()){
				System.out.println("Fetched bet types : " + rs.getString("bet_type"));
				dbbettype.add(rs.getString("bet_type"));
				}
			List<String> uibettype= new ArrayList<String>();
			while (rs.next()){
				dbbettype.add(rs.getString(1));
			}
			uibettype=findElements(TwelveByTwentyFourPageLocator.BetTypeLocator, 5);
			System.out.println(uibettype);
			if(dbbettype.equals(uibettype));   		
			{
    			flag=true;
				LOGGER.info("DB and UI Bet types verified");
			}
    		return flag;
		}
	
	
	
	public void verifyAdvanceDraw() throws SQLException {
		List<String> dbadvancedraws = new ArrayList<>();

		List<WebElement> advancedraws = driver.findElements(TwelveByTwentyFourPageLocator.advanceDraw);
		DBConnection dbconnection = new DBConnection();
		Connection con = DBConnection.getDBConnectionDge();

		ResultSet rs = dbconnection.ExecuteQuery(con, TwelveByTwentyFourSqlQuery.advanceDraw, "active");
		while (rs.next()) {
			for (int j = 1; j <= rs.getMetaData().getColumnCount(); j++) {
				dbadvancedraws.add(rs.getString(j));
				System.out.println(rs.getString(j));
			}
		}

		for (int i = 0; i < advancedraws.size(); i++) {

			String value = ReusableStaticMethods.convertsToDateFormate(advancedraws.get(i).getText().trim())
					.concat(".0");

			if (value.equals(dbadvancedraws.get(i))) {

				System.out.println("database value: " + dbadvancedraws.get(i) + " match with front end: " + value);
			} else {
				System.out.println("value not matched");

			}
		}
	}

	public boolean isBuyButtonEnabled() {

		if (findElement(TwelveByTwentyFourPageLocator.buyNowLocator, 5).isDisplayed()) {
			LOGGER.info("Twelve By Twenty Four Buy now button is enabled");
			txtBuynow = findElement(TwelveByTwentyFourPageLocator.TicketPrice, 5).getText();
			LOGGER.info("txt buy now: " + txtBuynow);
			return true;
		} else {
			return false;
		}
	}

	public boolean isCardnumberPopupEnable() {
		if (findElement(TwelveByTwentyFourPageLocator.enterCradnumberPopupcancel, 5).isDisplayed()) {
			return true;
		} else {
			return false;
		}

	}

	public void alertboxclick() {
		// if(functionLibrary.alertMessage().contains("Do you want to
		// purchase"))
		{
			functionLibrary.switchToAlertOk();
		}
	}

	public boolean ticketView() {
		if (findElement(TwelveByTwentyFourPageLocator.ticketPreview, 5).isDisplayed()) {
			String txtPreviewTktPrice = findElement(LuckeyNumberPageLocator.txtPreviewTicketPrice, 5).getText();
			LOGGER.info("ticket preview amount:" + txtPreviewTktPrice);

			if (ReusableStaticMethods.covertStringToTwoDecimalNum(txtPreviewTktPrice)
					.equals(ReusableStaticMethods.covertStringToTwoDecimalNum(txtBuynow))) {
				return true;
			} else {
				return false;
			}

		} else {
			return false;

		}
	}

	public List<Map<String, String>> returnDatabaseValue() throws SQLException {
		List<Map<String, String>> listitem = new ArrayList<Map<String, String>>();
		String value = ReusableStaticMethods
				.removeZeroFromticket(findElement(TwelveByTwentyFourPageLocator.ticketnumber, 5).getText());
		LOGGER.info("In ticket number zero removed: " + value);
		DBConnection dbconnection = new DBConnection();
		Connection con = DBConnection.getDBConnectionDge();
		ResultSet resultset = dbconnection.ExecuteQuery(con, LuckyNumberSqlQuery.ticketNumber, value);
		while (resultset.next()) {
			for (int i = 1; i <= resultset.getMetaData().getColumnCount(); i++) {
				HashMap<String, String> hashmap = new HashMap<String, String>();
				hashmap.put(resultset.getMetaData().getColumnName(i), resultset.getString(i));
				listitem.add(hashmap);

			}

		}

		return listitem;
	}
}
