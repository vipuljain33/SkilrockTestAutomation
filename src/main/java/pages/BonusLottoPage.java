package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import DataBaseQuery.BonusLottoSqlQuery;
import DataBaseQuery.DBConnection;

import org.slf4j.Logger;
import objectRepository.BonusLottoPageLocators;
import objectRepository.LuckeyNumberPageLocator;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;

public class BonusLottoPage extends BasePage {
	private static Logger logger = LoggerFactory.getLogger(BonusLottoPage.class);
	CommonFunctionLibrary functionLibrary;
	int totalNumbersPicked;
	float directSixBetAmount=0.2f;
	static String txtPreviewTktPrice;
	static String txtBuynow;
	DBConnection con;
	int noOfDraws=1;
	boolean isQp=false;
	public BonusLottoPage(WebDriver driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);

	}

	public void clickDirect6() {

		findElement(BonusLottoPageLocators.direct6BetLocator, 5).click();

	}

	public void selectNumberLessThenGivenNumber(int num) throws InterruptedException {
		List<WebElement> list = driver.findElements(BonusLottoPageLocators.numberPicker);
		List<Integer> lst = ReusableStaticMethods.randomNumber(1, 42, num - 1);
		for (int i = 0; i < lst.size(); i++) {
			list.get(lst.get(i)).click();
			
		}
	}

	public void selectNumberMoreThenGivenNumber(int num) throws InterruptedException {
		List<WebElement> list = driver.findElements(BonusLottoPageLocators.numberPicker);
		List<Integer> lst = ReusableStaticMethods.randomNumber(1, 41, num + 1);
		for (int i = 0; i < lst.size(); i++) {
			list.get(lst.get(i)).click();
			
		}
	}

	public boolean buyisEnabled() throws InterruptedException {
		if(findElement(BonusLottoPageLocators.buyNowLoctor, 5).isEnabled()){
    		logger.info("bonus Lotto Buy button is enabled");
    		txtBuynow=findElement(BonusLottoPageLocators.qpTicketPrice, 5).getText();
    		logger.info("txt buy now: "+txtBuynow);
    		if(isQp)
    			clickResetButton();
    		Thread.sleep(1000);
    		return true;
    	}
		clickResetButton();
		return false;
	}
		
	
    	
		
	

	public String errorMessageHandle() {
		String errorTxt = driver.findElement(BonusLottoPageLocators.errorPopup).getText();
		System.out.println(errorTxt);
		return errorTxt;
	}

	public String errorAlertDifferent() {
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		return alertText;
	}

	public void clickPerm6() {
		findElement(BonusLottoPageLocators.perm6BetLocator, 10).click();
	}

	public String permerrorPopup() {
		try {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			alert.accept();
			return text;
		} catch (UnhandledAlertException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void checkQuickPick() {
		if (!findElement(BonusLottoPageLocators.quickPickCheckBox, 3).isSelected()) {
			findElement(BonusLottoPageLocators.quickPickCheckBox, 3).click();
			isQp=true;
		}
	}

	public void enterQuickPickNumber(int r) throws InterruptedException {
		Integer i = new Integer(r);
		findElement(BonusLottoPageLocators.quickPickTextBox, 3).sendKeys(i.toString());
	}

	public String permsixQperrorPopup() {
		String errorTxt = driver.findElement(BonusLottoPageLocators.errorPopupPermSix).getText();
		System.out.println(errorTxt);
		return errorTxt;
	}

	public void selectGivenNumber(int num) throws InterruptedException {
		List<WebElement> list = driver.findElements(BonusLottoPageLocators.numberPicker);
		List<Integer> lst = ReusableStaticMethods.randomNumber(1, 41, num);
		totalNumbersPicked = num;
		for (int i = 0; i < lst.size(); i++) {
			list.get(lst.get(i)).click();
		}
	}

	public int validateNoOfLinesPerm6() {
		int noOfLines = ReusableStaticMethods.calculateNoOfline(totalNumbersPicked, 6);
		return noOfLines;
	}

	public int validateNoOflinesPerm6Panel() {
		String text = driver.findElement(BonusLottoPageLocators.noOflines).getText();
		int expected = Integer.parseInt(text);
		clickResetButton();
		return expected;
	}

	public void selectNumber(int num) throws InterruptedException {
		List<WebElement>list = driver.findElements(BonusLottoPageLocators.numberPicker);
		List<Integer> ls = ReusableStaticMethods.randomNumber(1, 40, num);
		for (int i = 0; i < ls.size(); i++) {
			list.get(ls.get(i)).click();
		}
		totalNumbersPicked = num;
	}

	public void selectBetAmount(float betAmount) {
		List<WebElement> lst = driver.findElements(BonusLottoPageLocators.betAmounts);
		for (WebElement w : lst) {
			if (w.getText().equals(new Float(betAmount).toString())) {
				w.click();
			}
		}
		directSixBetAmount = betAmount;
	}

	public boolean validateDirectSixTicketPrice() {
		WebElement w = findElement(BonusLottoPageLocators.buyButton, 2);
		String text = w.getText();
		float actualAmount = directSixBetAmount * (totalNumbersPicked / 6)*noOfDraws;
		if (text.contains(new Float(actualAmount).toString())) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validatePermSixTicketPrice() {
		WebElement w = findElement(BonusLottoPageLocators.buyButton, 2);
		String text = w.getText();
		int noOfLines = ReusableStaticMethods.calculateNoOfline(totalNumbersPicked, 6);
		float actualAmount = directSixBetAmount * noOfLines*noOfDraws;
		if (text.contains(new Float(actualAmount).toString())) {
			return true;
		} else {
			return false;
		}

	}

	public boolean verifyActiveBetType() throws SQLException {
		DBConnection dbconnection = new DBConnection();
		Connection connection = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(connection, BonusLottoSqlQuery.BonusLottoActiveBetType, 5, "active");
		List<String> dbbettype = new ArrayList<String>();
		List<String> uibettype = new ArrayList<String>();
		boolean flag = false;
		while (rs.next()) {
			dbbettype.add(rs.getString(1).toUpperCase());
			System.out.println(rs.getString(1));
		}
		Collections.sort(dbbettype);
		uibettype = findElements(BonusLottoPageLocators.BetTypeLocator, 5);
		if (dbbettype.equals(uibettype)) {
			flag = true;
			logger.info("DB and UI Bet types verified");
		}
		return flag;
	}

	public void directSixBoxes() {
		List<WebElement> list = driver.findElements(BonusLottoPageLocators.numberInputCellsDirectSix);
		if (list.size() == 24) {
			System.out.println("total number of boxes for direct6 validate");
		} else {
			Assert.fail();
		}

	}

	public void permSixBoxes() {
		List<WebElement> list = driver.findElements(BonusLottoPageLocators.numberInputCellsPermSix);
		if (list.size() == 15) {
			System.out.println("total number of boxes for perm6 validate");
		} else {
			Assert.fail();
		}
	}

	public void clickResetButton() {
		findElement(BonusLottoPageLocators.resetButton, 3).click();
	}

	public boolean validateReset() {
		List<WebElement> list = driver.findElements(BonusLottoPageLocators.numberInputCellsDirectSix);
		for (WebElement w : list) {
			if (!w.getText().equals("")) {
				return false;
			}
		}
		return true;
	}
	public boolean isCardnumberPopupEnable()
    {
    	if(findElement(BonusLottoPageLocators.enterCradnumberPopup, 5).isDisplayed())
    	{	
		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
    }
	public void alertboxclick()
    {
    	//if(functionLibrary.alertMessage().contains("Do you want to purchase"))
    	{
    		functionLibrary.switchToAlertOk();
    	}
    	
    }
	public boolean ticketView()
    {
    	if(findElement(BonusLottoPageLocators.ticketPreview, 5).isDisplayed())
    	{
    		txtPreviewTktPrice=findElement(BonusLottoPageLocators.txtPreviewTicketPrice,5).getText();
    		logger.info("ticket preview amount:"+txtPreviewTktPrice);
    	   
    		if(ReusableStaticMethods.covertStringToTwoDecimalNum(txtPreviewTktPrice).equals(ReusableStaticMethods.covertStringToTwoDecimalNum(txtBuynow)))
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    		
    	}
    	else
    	{
    		return false;
    		
    	}
    }
	public void advanceDrawVerify() throws SQLException{
	List<String> databaseValue=new ArrayList<String>();
	   List<WebElement> drawlist=driver.findElements(BonusLottoPageLocators.advanceDraw);
		con=new DBConnection();
		   
		ResultSet resultset=con.ExecuteQuery(con.CreateConnectionForDGE(),BonusLottoSqlQuery.advanceDraw,"active" );
		while(resultset.next())
		{
			for(int j=1;j<=resultset.getMetaData().getColumnCount();j++)
			{
			databaseValue.add(resultset.getString(j));
			}
		}
		for(int i=0;i<drawlist.size();i++)
			{
			   
				String value=ReusableStaticMethods.convertsToDateFormate(drawlist.get(i).getText().trim()).concat(".0");
				
				if(value.equals(databaseValue.get(i)))
				{
					
					System.out.println("database value: "+databaseValue.get(i)+" match with front end: "+value);
				}
				else
				{
					System.out.println("value not matched");
				}
			}
		
		
	}
	
	public List<Map<String, String>> returnDatabaseValue() throws SQLException
	{
		List<Map<String, String>> listitem=new ArrayList<Map<String, String>>();
		String value=ReusableStaticMethods.removeZeroFromticket(findElement(BonusLottoPageLocators.ticketnumber, 5).getText());
		logger.info("In ticket number zero removed: "+value);
		
		
		con=new DBConnection();
	   
		ResultSet resultset=con.ExecuteQuery(con.CreateConnectionForDGE(),BonusLottoSqlQuery.ticketNumber, value);
		
		while(resultset.next())
		{
			
			for(int i=1;i<=resultset.getMetaData().getColumnCount();i++)
			{
				HashMap<String, String> hashmap=new HashMap<String, String>();
				hashmap.put(resultset.getMetaData().getColumnName(i),resultset.getString(i));
				listitem.add(hashmap);
				
			}
			
		}
		
		return listitem;
	}
	public void selectAdvancedDraw(int arg1){
		List<WebElement> drawlist=driver.findElements(BonusLottoPageLocators.advanceDrawSelection);
		noOfDraws=arg1;
		for(int i=0;i<arg1;i++){
		drawlist.get(i).click();		
		}
		findElement(BonusLottoPageLocators.advanceDrawSubmit,5).click();		
	}
}