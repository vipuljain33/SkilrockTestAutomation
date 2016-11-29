package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import DataBaseQuery.DBConnection;
import DataBaseQuery.FortuneGameSqlQuery;
import DataBaseQuery.LoginSqlQuery;
import DataBaseQuery.DBConnection;
import DataBaseQuery.LuckyNumberSqlQuery;
import objectRepository.FortuneGameLocator;
import objectRepository.LuckeyNumberPageLocator;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;


public class FortuneGamePage extends BasePage {
	static String txtBuynow;
	static String txtPreviewTktPrice;
	DBConnection con;
	WebDriver driver;
	
	private static Logger LOGGER = LoggerFactory.getLogger(FortuneGamePage.class);
	
	public FortuneGamePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		if(isElementPresent(FortuneGameLocator.fortuneGamelocator, 5))
		{
			System.out.println("Fortune Game page is visible");
		}else
		{
			throw new ElementNotVisibleException("Fortune Game page not visible");
		}
	}

	
    

	public String errorMessageHandle() {
		String errorTxt=driver.findElement(FortuneGameLocator.errorPopuplocator).getText();
		System.out.println(errorTxt);
		return errorTxt;
	}

	public String hintMessageHandle() {
		String hintTxt=driver.findElement(FortuneGameLocator.buyNowMessagelocator).getText();
		System.out.println(hintTxt);
		return hintTxt;
	}
   

	public boolean isQPValueMatched()
    {           
        List<String> qpposselected=new ArrayList<String>();
        ArrayList<String> qpselected=new ArrayList<String>();
        qpposselected=qpposselected(FortuneGameLocator.selectednumlocator);
        qpselected=(ArrayList<String>)isQpSelected(FortuneGameLocator.numPickedlocator);
        
             
      if(qpselected.equals(qpposselected))
      {
       System.out.println("pass");
       return true;
      }
      else
      {
       return false;
      }
     
    }
    
    public List<String> isQpSelected(By by)
	 {
	  String str= findElement(by,5).getText();
	     System.out.println(str);
	  ArrayList<String> qpselected=new ArrayList<String>();
	 
	  
	     for(String number:str.split(","))
	      {
	        
	        qpselected.add(number);
	       
	      }
	    return  qpselected;
	  
	 }
    
    public  List<String> qpposselected(By by){
  	  
	    List<WebElement> qpposselected=new ArrayList<WebElement>();
	     
	       List<String> newlist=new ArrayList<String>();
	       qpposselected=driver.findElements(by);
	   for(WebElement we :qpposselected)
	   {
	    newlist.add(we.getText());
	   }
	    
	   System.out.println("newlist" + newlist);
	   return newlist;
	 }
    public String ticketPriceFortuneGame()
    {
    	String txt=driver.findElement(FortuneGameLocator.buyNowAmountlocator).getText();
    	LOGGER.info("Total ticket price:" + txt);
    	return txt;
    }
    
    public boolean isBuyButtonEnable()
    {
    	
    	if(findElement(FortuneGameLocator.buyNowlocator, 5).isDisplayed())
    	{
    		LOGGER.info("Buy button is enabled for fortune game");
    		txtBuynow=findElement(FortuneGameLocator.buyNowAmountlocator, 5).getText();
    		LOGGER.info("txt buy now: "+txtBuynow);
    		return true;
    	}
    	else
    	{
    		return false;
    	}
     } 
    
    public boolean isCardnumberPopupEnable()
    {
    	if(findElement(FortuneGameLocator.enterCardNumberPopuplocator, 5).isDisplayed())
    	{	
		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
    }
    public void cardPopupCancel()
    {
    	functionLibrary.switchToAlertCancel();
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
    	if(findElement(FortuneGameLocator.ticketPreviewlocator, 5).isDisplayed())
    	{
    		txtPreviewTktPrice=findElement(FortuneGameLocator.txtPreviewTicketPricelocator,5).getText();
    	   LOGGER.info("Ticket preview amount:"+txtPreviewTktPrice);
    	   
    		if(txtPreviewTktPrice.equals(txtBuynow))
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
    
    public List<Map<String, String>> returnDatabaseValue() throws SQLException
	{
		List<Map<String, String>> listitem=new ArrayList<Map<String, String>>();
		String value=ReusableStaticMethods.removeZeroFromticket(findElement(FortuneGameLocator.ticketnumberlocator, 5).getText());
		LOGGER.info("In ticket number zero removed: "+value);
		
		
		con=new DBConnection();
	   
		ResultSet resultset=con.ExecuteQuery(con.CreateConnectionForDGE(),FortuneGameSqlQuery.fortuneticketNumber, value);
		
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
    
	public void advanceDrawVerify() throws SQLException
	{  List<String> databaseValue=new ArrayList<String>();
	   List<WebElement> drawlist=driver.findElements(FortuneGameLocator.advanceDraw);
		con=new DBConnection();
		   
		ResultSet resultset=con.ExecuteQuery(con.CreateConnectionForDGE(),FortuneGameSqlQuery.fortuneadvanceDraw,"active" );
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
}
	

	


