package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import apis.PCPOSApi;
import objectRepository.SoccerThirteenPageLocator;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;

public class SoccerThirteenPage extends BasePage {
	
	public SoccerThirteenPage(WebDriver driver) {
		super(driver);
		
	}
	public void selectSoccerThirteenEvents(int arg) {
		 List<Integer> randList=ReusableStaticMethods.randomNumber(0, arg-1, arg);
		 List<WebElement> lElements=new ArrayList<WebElement>();
		 lElements.add(findElement(SoccerThirteenPageLocator.firstEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.secondEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.thirdEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.fourthEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.fifthEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.sixthEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.seventhEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.eigthEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.ninthEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.tenthEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.eleventhEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.twelthEvent,3));
		 lElements.add(findElement(SoccerThirteenPageLocator.thirteenthEvent,3));
		 for(int i=0;i<arg;i++) {
			 lElements.get(randList.get(i)).click();
		 }
		 
	}
	public boolean validateTicket() throws InterruptedException {
		
		
		 findElement(SoccerThirteenPageLocator.soccerThirteenSetting,3).click();
		 findElement(SoccerThirteenPageLocator.soccerThirteenReprint,3).click();
		
		 String ticketPrice=findElement(SoccerThirteenPageLocator.ticketPrice,2).getText();
		 String ticketNumberwithExtraDigits=findElement(SoccerThirteenPageLocator.ticketNumber,2).getText();
		 String ticketNumber=ticketNumberwithExtraDigits.substring(0,ticketNumberwithExtraDigits.length()-1);
		 
		 System.out.println(ticketNumber);
		
		 
		 if(PCPOSApi.soccerThirteenData.get("Ticket Number").equals(ticketNumber) && PCPOSApi.soccerThirteenData.get("Ticket Price").equals(ticketPrice)) {
			  return true; 
		 }
		 
		 
		 else {return false;}
	}
	public boolean isBuyEnabled() {
	       return(findElement(SoccerThirteenPageLocator.buyButton,3).isEnabled());
	    	   
	       
	}
    
}
