package pages;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import DataBaseQuery.DBConnection;
import DataBaseQuery.LuckyNumberSqlQuery;
import DataBaseQuery.MiniRouletteSqlQuery;
import objectRepository.LuckeyNumberPageLocator;
import objectRepository.MiniRoulettePageLocator;
import utils.ReusableStaticMethods;

public class MiniRoulettePage extends BasePage {
	int betAmount;
	int totalBetTypeSelected;
	int totalAdvanceDraws;
	DBConnection con;
	static String txtBuynow;
    double[] tracker=new double[13];
    static String txtPreviewTktPrice;
	
     
	public MiniRoulettePage(WebDriver driver) {
		super(driver);
		
	}
	public boolean validatePrintedTicketPrice() throws InterruptedException {
		WebElement e1=findElement(MiniRoulettePageLocator.buyNowLoctor,3);
		e1.click();
		String parent=driver.getWindowHandle();
		Set<String> handleList=driver.getWindowHandles();
		Iterator<String> iterator=handleList.iterator();
		String child;
		while(iterator.hasNext()) {
			 child =iterator.next();
			 if(!child.equals(parent)) {
				 driver.switchTo().window(child);
			 }
		}
		findElement(MiniRoulettePageLocator.cancelButton,3).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		WebElement e2=findElement(MiniRoulettePageLocator.printedTicketPrice,6);
		return(e1.getText().contains(e2.getText()));
		
	}
	
	
	
	public void selectBetAmount(int betAmount) {
		this.betAmount=betAmount;
		WebElement e=null;
		switch(betAmount) {
		  case 10:
			  e=findElement(MiniRoulettePageLocator.betAmount10,3);
			  e.click();
			  break;
		  case 20:
			  e=findElement(MiniRoulettePageLocator.betAmount20,3);
			  e.click();
			  break;
		  case 50:
			  e=findElement(MiniRoulettePageLocator.betAmount50,3);
			  e.click();
			  break;
		  case 100:
			  e=findElement(MiniRoulettePageLocator.betAmount100,3);
			  e.click();
			  break;
		  default:
			  e=findElement(MiniRoulettePageLocator.betAmount500,3); 
			  e.click();
			  break;
		}
	}
	
	
	
	public void selectBetTypes(int N) throws InterruptedException {
		
		totalBetTypeSelected=N;
		
		List<WebElement> betTypes=new ArrayList<WebElement>();
		
		
		betTypes.add(findElement(MiniRoulettePageLocator.zeroBetType,3));
		betTypes.addAll(driver.findElements(MiniRoulettePageLocator.roulette));
		
		betTypes.add(findElement(MiniRoulettePageLocator.allOddNumbers,3));
		betTypes.add(findElement(MiniRoulettePageLocator.allEvenNumbers,3));
		betTypes.add(findElement(MiniRoulettePageLocator.redNumbers,3));
		betTypes.add(findElement(MiniRoulettePageLocator.blackNumbers,3));
		betTypes.add(findElement(MiniRoulettePageLocator.firstRow,3));
		betTypes.add(findElement(MiniRoulettePageLocator.secondRow,3));
		betTypes.add(findElement(MiniRoulettePageLocator.thirdRow,3));
		betTypes.add(findElement(MiniRoulettePageLocator.oneToSix,3));
		betTypes.add(findElement(MiniRoulettePageLocator.fourToNine,3));
		betTypes.add(findElement(MiniRoulettePageLocator.sevenToTwelve,3));
		betTypes.add(findElement(MiniRoulettePageLocator.firstQuarter,3));
		betTypes.add(findElement(MiniRoulettePageLocator.thirdQuarter,3));
		betTypes.add(findElement(MiniRoulettePageLocator.sixthQuarter,3));
		betTypes.add(findElement(MiniRoulettePageLocator.secondQuarter,3));
		betTypes.add(findElement(MiniRoulettePageLocator.fourthQuarter,3));
		betTypes.add(findElement(MiniRoulettePageLocator.fifthQuarter,3));
		betTypes.add(findElement(MiniRoulettePageLocator.firstColumn,3));
		betTypes.add(findElement(MiniRoulettePageLocator.secondColumn,3));
		betTypes.add(findElement(MiniRoulettePageLocator.thirdColumn,3));
		betTypes.add(findElement(MiniRoulettePageLocator.fourthColumn,3));
		List<Integer> li=ReusableStaticMethods.randomNumber(0, 32, N);
		 for(int i=0;i<N;i++) {
				
			    
				betTypes.get(li.get(i)).click();
				String text=betTypes.get(li.get(i)).getText();
				String newString="";
				if(text.contains("\n"))
					newString=text.split("\n")[0];
				
				
			
				
				String idVal=betTypes.get(li.get(i)).getAttribute("id");
		
			   if(idVal.equals("parent_2-1-r1")) {
					for(int j=0,k=0;j<4;j++,k=k+3) {
						
						tracker[3+k]+=(double)betAmount/4;
					}
				}
			   
				else if(idVal.equals("parent_2-1-r2")) {
					for(int j=0,k=0;j<4;j++,k=k+3) {
						
						tracker[2+k]+=(double)betAmount/4;
					}
				}
				else if(idVal.equals("parent_4-9")) {
					 for(int j=0;j<6;j++) {
						 tracker[4+j]+=(double)betAmount/6;
					 }
				}
				else if(idVal.equals("parent_1-6")) {
					 for(int j=0;j<6;j++) {
						 tracker[1+j]+=(double)betAmount/6;
					 }
				}
				else if(idVal.equals("parent_7-12")) {
					 for(int j=0;j<6;j++) {
						 tracker[7+j]+=(double)betAmount/6;
					 }
				}
				else if(idVal.equals("parent_2-1-r3"))  {
					for(int j=0,k=0;j<4;j++,k=k+3) {
						
						tracker[1+k]+=(double)betAmount/4;
					}
				}
				
				
				else if(idVal.equals("parent_even")) {
					    for(int j=0,k=0;j<6;k=k+2,j++) {
					    	
					    	 tracker[2+k]+=(double)betAmount/6;
					    }
				}
				else if(idVal.equals("parent_odd")) {
						for(int j=0,k=0;j<6;k=k+2,j++) {
							
							tracker[1+k]+=(double)betAmount/6;
						}
				}
				else if(idVal.equals("parent_red")) {
						for(int j=0,k=0;j<6;k=k+2,j++) {
							
							tracker[1+k]+=(double)betAmount/6;
						}
				}
				else if(idVal.equals("parent_gray")) {
						for(int j=0,k=0;j<6;k=k+2,j++) {
							
					    	 tracker[2+k]+=(double)betAmount/6;
					    }
				}
				else if(text.equals("3\n6\n2\n5")) {
					  tracker[2]+=(double)betAmount/4;
					  tracker[3]+=(double)betAmount/4;
					  tracker[5]+=(double)betAmount/4;
					  tracker[6]+=(double)betAmount/4;
				}
				else if(text.equals("6\n9\n5\n8")) {
					  tracker[5]+=(double)betAmount/4;
					  tracker[6]+=(double)betAmount/4;
					  tracker[8]+=(double)betAmount/4;
					  tracker[9]+=(double)betAmount/4;
				}
				else if(text.equals("9\n12\n8\n11")) {
					  tracker[8]+=(double)betAmount/4;
					  tracker[9]+=(double)betAmount/4;
					  tracker[11]+=(double)betAmount/4;
					  tracker[12]+=(double)betAmount/4;
				}
				else if(text.equals("2\n5\n1\n4")) {
					  tracker[1]+=(double)betAmount/4;
					  tracker[2]+=(double)betAmount/4;
					  tracker[4]+=(double)betAmount/4;
					  tracker[5]+=(double)betAmount/4;
				}
				else if(text.equals("5\n8\n4\n7")) {
					  tracker[4]+=(double)betAmount/4;
					  tracker[5]+=(double)betAmount/4;
					  tracker[7]+=(double)betAmount/4;
					  tracker[8]+=(double)betAmount/4;
				}
				else if(text.equals("8\n11\n7\n10")) {
					  tracker[7]+=(double)betAmount/4;
					  tracker[8]+=(double)betAmount/4;
					  tracker[10]+=(double)betAmount/4;
					  tracker[11]+=(double)betAmount/4;
				}
				else if(text.equals("3\n2\n1")) {
					for(int j=0;j<3;j++) {
					  tracker[1+j]+=(double)betAmount/3;
					  
					}
					  
				}
				else if(text.equals("6\n5\n4")) {
					for(int j=0;j<3;j++) {
					  tracker[4+j]+=(double)betAmount/3;
					  
					}
					  
				}
				else if(text.equals("9\n8\n7")) {
					for(int j=0;j<3;j++) {
					  tracker[7+j]+=(double)betAmount/3;
					 
					}
				}
				else if(text.equals("12\n11\n10")) {
					for(int j=0;j<3;j++) {
					tracker[10+j]+=(double)betAmount/3;
					
					}
				}
				
				else if(newString.equals("12")) {
					
					tracker[12]+=betAmount;
					
				}
				else if(newString.equals("11")) {
					
					tracker[11]+=betAmount;
					
				}
				else if(newString.equals("10")) {
					
					tracker[10]+=betAmount;
					
				}
				else if(newString.equals("9")) {
					
					tracker[9]+=betAmount;
					
				}
				else if(newString.equals("8")) {
					
					tracker[8]+=betAmount;
					
				}
				else if(newString.equals("7")) {
					
					tracker[7]+=betAmount;
					
				}
				else if(newString.equals("6")) {
					
					tracker[6]+=betAmount;
					
				}
				else if(newString.equals("5")) {
					
					tracker[5]+=betAmount;
				}
				else if(newString.equals("4")) {
					
					tracker[4]+=betAmount;
				}
				
				else if(newString.equals("3")) {
					
					tracker[3]+=betAmount;
				}
				else if(newString.equals("2")) {
					
					tracker[2]+=betAmount;
				}
				else if(newString.equals("1")) {
					
					tracker[1]+=betAmount;
				}
			   
				else if(newString.equals("0")) {
					
					tracker[0]+=betAmount;
				}
				else {
					
				}
				Thread.sleep(100);
							
		 }
		
		
	}
	
	public boolean validateTicketPrice() {
		 int val=betAmount*totalBetTypeSelected*totalAdvanceDraws;
		 WebElement buyButton=findElement(MiniRoulettePageLocator.buyNowLoctor,3);
		 String actual=buyButton.getText();
		 String expected=new Integer(val).toString();
		 if(actual.contains(expected)) {
			 return true;
		 }
		 else {return false;}
		 
	}
	public void selectAdvanceDraws(int N) {
		totalAdvanceDraws=N;
		findElement(MiniRoulettePageLocator.advanceDrawButton,3);
		List<Integer> li=ReusableStaticMethods.randomNumber(0, 2, N);
		findElement(MiniRoulettePageLocator.advanceDrawButton,3).click();
		Set<String> windList=   driver.getWindowHandles();
		Iterator<String> iterator=windList.iterator();
		String parent=driver.getWindowHandle();
		String s;
		while(iterator.hasNext()) {
			s=iterator.next();
			if(!s.equals(parent)) {
				driver.switchTo().window(s);
			}
		}
		List<WebElement> listOfAdvanceDraws=driver.findElements(MiniRoulettePageLocator.advanceDraws);
		for(int i=0;i<N;i++) {
			listOfAdvanceDraws.get(li.get(i)).click();
		}
		findElement(MiniRoulettePageLocator.advanceDrawSubmit,3).click();
		
	}
	public boolean validatePricePerNumber() {
		List<WebElement> lst=new ArrayList<WebElement>();
		DecimalFormat ob=new DecimalFormat("#.#");
		lst.add(findElement(MiniRoulettePageLocator.zero,3));
		lst.add(findElement(MiniRoulettePageLocator.one,3));
		lst.add(findElement(MiniRoulettePageLocator.two,3));
		lst.add(findElement(MiniRoulettePageLocator.three,3));
		lst.add(findElement(MiniRoulettePageLocator.four,3));
		lst.add(findElement(MiniRoulettePageLocator.five,3));
		lst.add(findElement(MiniRoulettePageLocator.six,3));
		lst.add(findElement(MiniRoulettePageLocator.seven,3));
		lst.add(findElement(MiniRoulettePageLocator.eight,3));
		lst.add(findElement(MiniRoulettePageLocator.nine,3));
		lst.add(findElement(MiniRoulettePageLocator.ten,3));
		lst.add(findElement(MiniRoulettePageLocator.eleven,3));
		lst.add(findElement(MiniRoulettePageLocator.twelve,3));
	
		int i=0;
		String str=null;
		String s;
		for(WebElement w: lst) {
			str=w.getText();
			s=ob.format(tracker[i]);
			if(!(str.equals(s) || str.contains("0"))) {
				return false;
			}
			i++;
		}
		    
		return true;
		
	
	}
	
	public void advanceDrawVerify() throws SQLException
	{  
	    List<String> databaseValue=new ArrayList<String>();
	    List<WebElement> drawlist=driver.findElements(MiniRoulettePageLocator.advanceDraw);
		con=new DBConnection();
		   
		ResultSet resultset=con.ExecuteQuery(con.CreateConnectionForDGE(),MiniRouletteSqlQuery.advanceDraw,"active" );
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
	
	public boolean isBuyButtondisabled()
	{
		
		if(findElement(MiniRoulettePageLocator.buyNowLoctor,7).isEnabled()){
		txtBuynow=findElement(MiniRoulettePageLocator.qpTicketPrice, 5).getText();	
		return false;
		}
		return true;
		
	}
	
	 public boolean isCardnumberPopupEnable()
     {
     	if(findElement(MiniRoulettePageLocator.enterCradnumberPopup, 5).isDisplayed())
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
     	
     	{
     		functionLibrary.switchToAlertOk();
     	}
     	
     }
     
     public boolean ticketView()
     {
     	if(findElement(MiniRoulettePageLocator.ticketPreview, 5).isDisplayed())
     	{
     		txtPreviewTktPrice=findElement(MiniRoulettePageLocator.txtPreviewTicketPrice,5).getText();
     	   
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
	
     public List<Map<String, String>> returnDatabaseValue() throws SQLException
 	{
 		List<Map<String, String>> listitem=new ArrayList<Map<String, String>>();
 		String value=ReusableStaticMethods.removeZeroFromticket(findElement(LuckeyNumberPageLocator.ticketnumber, 5).getText());

 		
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
	
	
	
	
	
	
	
	

}



















