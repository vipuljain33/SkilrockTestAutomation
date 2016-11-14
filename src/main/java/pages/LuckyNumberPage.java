package pages;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import DataBaseQuery.DBConnection;
import DataBaseQuery.LoginSqlQuery;
import DataBaseQuery.LuckyNumberSqlQuery;
import objectRepository.LuckeyNumberPageLocator;
import utils.CommonFunctionLibrary;


public class LuckyNumberPage extends BasePage {
	private static Logger LOGGER = LoggerFactory.getLogger(LuckyNumberPage.class);
	CommonFunctionLibrary functionLibrary;
	public LuckyNumberPage(WebDriver driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);
		if(isElementPresent(LuckeyNumberPageLocator.drawgamelocator, 5))
		{
			System.out.println("Draw game page is visible");
		}else
		{
			throw new ElementNotVisibleException("Draw Game page not visible");
		}
	}

	public void isDrawgameSelected(){
	if(	findElement(LuckeyNumberPageLocator.drawgamelocator, 5).getCssValue("border-bottom") != null){
		LOGGER.info("Draw Game Is Selected");
	}
	else{
		LOGGER.error("Unable To Select DG");	
		Assert.fail();
	}
		
	}
	
	public void isLuckyNumberSelected(){
		
		functionLibrary.switchFrame("leftbottom");
	
		if(findElement(LuckeyNumberPageLocator.luckynumberlocator, 5).getAttribute("gamename").equalsIgnoreCase("KenoTwo"))
		{
			//System.out.println(true);
			LOGGER.info("Lucky Number Game Is Selected");
		}
		else
		{
			//System.out.println(false);
			Assert.fail();
		}
		
		/*
		if(	findElement(LuckeyNumberPageLocator.luckynumberlocator, 10).getAttribute("class").equalsIgnoreCase("sideMenuList select-game")){
			LOGGER.info("Luckey Number Is Selected");
		}
		else{
			LOGGER.error("Unable To Select DG");	
			Assert.fail();
		}*/
	}
		public void isPerm1Selected()
		{
			if(findElement(LuckeyNumberPageLocator.selectedBetLocator,5).getAttribute("betname").equalsIgnoreCase("Perm1"))
			{
				LOGGER.info("perm1 is selected");
			}
			else 
			{
				Assert.fail();
			}
		}

		public String errorMessageHandle()
		{
			String errorTxt=driver.findElement(LuckeyNumberPageLocator.errorPopup).getText();
			System.out.println(errorTxt);
			return errorTxt;
		}
		
		public void isPerm2Selected()
		{
			driver.findElement(LuckeyNumberPageLocator.perm2locator).click();
			if(findElement(LuckeyNumberPageLocator.selectedBetLocator,5).getAttribute("betname").equalsIgnoreCase("Perm2"))
			{
				LOGGER.info("perm2 is selected");
			}
			else
			{
				Assert.fail();
			}
		}
		public void isPerm3Selected()
		{
			driver.findElement(LuckeyNumberPageLocator.perm3Locator).click();
			if(findElement(LuckeyNumberPageLocator.selectedBetLocator, 6).getAttribute("betname").equalsIgnoreCase("Perm3"))
			{
				LOGGER.info("perm3 is selected");
			}
			else
			{
				Assert.fail();
			}
		}
		public void isBuyButtonEnabled()
		{
			String txt=driver.findElement(LuckeyNumberPageLocator.buyNowLoctor).getAttribute("disabled");
			System.out.println("buybutton: "+txt);
			if(findElement(LuckeyNumberPageLocator.buyNowLoctor,7).getAttribute("disabled").equalsIgnoreCase("true"))
			{
				LOGGER.info("less than boundary verification pass");
			}
			else
			{
				Assert.fail();
			}
		}
	
		public void isBuyButtonEnabledpermthree()
		{
			String txt=driver.findElement(LuckeyNumberPageLocator.buyNowLoctor).getAttribute("disabled");
			System.out.println("buybutton: "+txt);
			if(findElement(LuckeyNumberPageLocator.buyNowLoctor,7).getAttribute("disabled").equalsIgnoreCase("true"))
			{
				LOGGER.info("less than boundary verification pass for perm3");
			}
			else
			{
				Assert.fail();
			}
		}
	
		public void permoneBoxes()
		{
			List<WebElement> list=driver.findElements(LuckeyNumberPageLocator.perm1boxes);
			if(list.size()==10)
			{
				System.out.println("total number of boxes for perm1 validate");
			}
			else
			{
				Assert.fail();
			}
			
		}
		public void permtwoboxes()
		{
			List<WebElement> list=driver.findElements(LuckeyNumberPageLocator.perm2boxes);
			if(list.size()==20)
			{
				LOGGER.info("total number of boxes are 20");
			}
			else
			{
				Assert.fail();
			}
		}
		public int permthreeboxes()
		{
			List<WebElement> listitem=driver.findElements(LuckeyNumberPageLocator.perm3boxes);
			int size=listitem.size();
			return size;
		}
		public String noofLines()
		{
			String txt=driver.findElement(LuckeyNumberPageLocator.nooflines).getText();
			System.out.println(txt);
			return txt.trim();
		}
        public String ticketPricePermone()
        {
        	String txt=driver.findElement(LuckeyNumberPageLocator.qpTicketPrice).getText();
        	System.out.println("ticket price permone"+txt);
        	return txt.trim();
        }
        
        public boolean verifyActiveBetType() throws SQLException{
        	DBConnection dbconnection= new DBConnection();	
        	Connection connection=dbconnection.getDBConnectionDge();
    		ResultSet rs = dbconnection.ExecuteQuery(connection, LuckyNumberSqlQuery.LuckyNumberActiveBetType,1,"active");
    		List<String> dbbettype= new ArrayList<String>();
    		List<String> uibettype= new ArrayList<String>();
    		boolean flag=false;
    		while (rs.next()) {
    			dbbettype.add(rs.getString(1));
    			System.out.println(rs.getString(1));    			
    		}    		
    		uibettype=findElements(LuckeyNumberPageLocator.BetTypeLocator, 5);
    		
    		if(dbbettype.equals(uibettype));   		
    		{
    			flag=true;
    			LOGGER.info("DB and UI Bet types verified");
    		}
    		return flag;
        }
        
        
        public boolean isQPValueMatched()
        {           
            List<String> qpposselected=new ArrayList<String>();
            ArrayList<String> qpselected=new ArrayList<String>();
            
            qpselected=(ArrayList<String>)isQpSelected(LuckeyNumberPageLocator.numpicked);
            qpposselected=qpposselected(LuckeyNumberPageLocator.selectednum);          
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
        
        public boolean isQPValueMatchedForParm2()
        {           
            List<String> qpposselected=new ArrayList<String>();
            ArrayList<String> qpselected=new ArrayList<String>();
            
            qpselected=(ArrayList<String>)isQpSelected(LuckeyNumberPageLocator.numpicked);
            qpposselected=qpposselected(LuckeyNumberPageLocator.selectednum);          
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
        
        public boolean isQPValueMatchedForParm3()
        {           
            List<String> qpposselected=new ArrayList<String>();
            ArrayList<String> qpselected=new ArrayList<String>();
            
            qpselected=(ArrayList<String>)isQpSelected(LuckeyNumberPageLocator.numpicked);
            qpposselected=qpposselected(LuckeyNumberPageLocator.selectednum);          
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
   	        System.out.println(number);
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
    	    
    	   System.out.println("newlist" +newlist);
    	   return newlist;
    	 }
        
}
