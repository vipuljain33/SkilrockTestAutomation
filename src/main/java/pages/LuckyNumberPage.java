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
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import DataBaseQuery.DBConnection;
import DataBaseQuery.LoginSqlQuery;
import DataBaseQuery.DBConnection;
import DataBaseQuery.LuckyNumberSqlQuery;
import objectRepository.LuckeyNumberPageLocator;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;


public class LuckyNumberPage extends BasePage {
	static String txtBuynow;
	static String txtPreviewTktPrice;
	DBConnection con;
	
	private static Logger LOGGER = LoggerFactory.getLogger(LuckyNumberPage.class);
	
	public LuckyNumberPage(WebDriver driver) {
		super(driver);
		
		if(isElementPresent(LuckeyNumberPageLocator.luckynumberlocator, 5))
		{
			System.out.println("Lucky Number game page is visible");
		}else
		{
			throw new ElementNotVisibleException("Lucky Number Game page not visible");
		}
	}

	/*public void isDrawgameSelected(){
	if(	findElement(LuckeyNumberPageLocator.drawgamelocator, 5).getCssValue("border-bottom") != null){
		LOGGER.info("Draw Game Is Selected");
	}
	else{
		LOGGER.error("Unable To Select DG");	
		Assert.fail();
	}
		
	}*/
	
	/*public void isLuckyNumberSelected(){
		
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
		
		
		if(	findElement(LuckeyNumberPageLocator.luckynumberlocator, 10).getAttribute("class").equalsIgnoreCase("sideMenuList select-game")){
			LOGGER.info("Luckey Number Is Selected");
		}
		else{
			LOGGER.error("Unable To Select DG");	
			Assert.fail();
		}
	}*/
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

		public void isBuyButtondisabled()
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
    			//System.out.println(rs.getString(1));    			
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
        

        public String ticketPricePermtwo()
        {
        	String txt=driver.findElement(LuckeyNumberPageLocator.qpTicketPrice).getText();
        	LOGGER.info("perm 2 ticket price:" +txt);
        	return txt;
        }
        public String ticketPricePermthree()
        {
        	String txt=driver.findElement(LuckeyNumberPageLocator.qpTicketPrice).getText();
        	LOGGER.info("perm 3 ticket price:" +txt);
        	return txt;
        }
        
        public boolean isBuyButtonEnable()
        {
        	
        	if(findElement(LuckeyNumberPageLocator.buyNowLoctor, 5).isDisplayed())
        	{
        		LOGGER.info("luckey number button is enabled");
        		txtBuynow=findElement(LuckeyNumberPageLocator.qpTicketPrice, 5).getText();
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
        	if(findElement(LuckeyNumberPageLocator.enterCradnumberPopup, 5).isDisplayed())
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
        	if(findElement(LuckeyNumberPageLocator.ticketPreview, 5).isDisplayed())
        	{
        		txtPreviewTktPrice=findElement(LuckeyNumberPageLocator.txtPreviewTicketPrice,5).getText();
        	   LOGGER.info("ticket preview amount:"+txtPreviewTktPrice);
        	   
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
	 public void permthreeQpselected()
	 {
		 findElement(LuckeyNumberPageLocator.perm3Locator, 5).click();
		 findElement(LuckeyNumberPageLocator.qpCheckbox, 5).click();
		 findElement(LuckeyNumberPageLocator.qpEnteredTxt, 5).sendKeys("8");
	 }
	public List<Map<String, String>> returnDatabaseValue() throws SQLException
	{
		List<Map<String, String>> listitem=new ArrayList<Map<String, String>>();
		String value=ReusableStaticMethods.removeZeroFromticket(findElement(LuckeyNumberPageLocator.ticketnumber, 5).getText());
		LOGGER.info("In ticket number zero removed: "+value);
		
		
		con=new DBConnection();
	   
		ResultSet resultset=con.ExecuteQuery(con.CreateConnectionForDGE(),LuckyNumberSqlQuery.ticketNumber, value);
		
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
	   List<WebElement> drawlist=driver.findElements(LuckeyNumberPageLocator.advanceDraw);
		con=new DBConnection();
		   
		ResultSet resultset=con.ExecuteQuery(con.CreateConnectionForDGE(),LuckyNumberSqlQuery.advanceDraw,"active" );
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
