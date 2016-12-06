package pages;

import static com.jayway.restassured.RestAssured.given;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.restassured.response.Response;

import DataBaseQuery.BonusLottoSqlQuery;
import DataBaseQuery.DBConnection;
import DataBaseQuery.SuperKenoSqlQuery;
import apis.PCPOSApi;
import objectRepository.BonusLottoPageLocators;
import objectRepository.SuperKenoPageLocators;
import utils.CommonFunctionLibrary;
import utils.ReusableStaticMethods;

public class SuperKenoPage extends BasePage {

	private static Logger logger = LoggerFactory.getLogger(BonusLottoPage.class);
	CommonFunctionLibrary functionLibrary;
	public static Map<String, String> cookieMap;
	DBConnection dbconnection = new DBConnection();
	static String ticketno;
	int noOfDraws = 1;
	boolean isQp = false;
	Connection con;
	static String txtPreviewTktPrice;
	public Response response;
	public String body;
	String sessionId;

	public SuperKenoPage(WebDriver driver) {
		super(driver);
		functionLibrary = new CommonFunctionLibrary(driver);

	}

	public boolean isVerifySaleResponceWithTicketforSuperKeno(String arg1) throws SQLException {
		authenticate("testret", "12345678");
		HashMap<String, String> apidata = new HashMap<String, String>();
		System.out.println("**********************************");
		apidata = performSuperKenoSale(arg1);
		if(apidata.get("ticketNumber")!=null)
		return true;
	return false;	
	}
	
	public boolean authenticate(String username, String password) {
		try {
			String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/loginMgmt/userLogin.action ";
			String jsonData = "{\"userName\":\"" + username + "\",\"password\":\"" + password + "\"}\n";

			response = given().contentType("application/json").queryParam("json", jsonData).get(url);
			body = response.getBody().asString();
			System.out.println(response);
			System.out.println(response.getStatusCode());
			System.out.println(body);
			cookieMap = response.getCookies();
			for (String key : cookieMap.keySet()) {
				System.out.println("Printing cookie keys value");
				System.out.println(key);
				System.out.println(cookieMap.get(key));
			}

			sessionId = response.jsonPath().get("data.sessionId").toString();
			System.out.println("Session id = " + sessionId);
			if (sessionId != null) {
				return true;
			}

		} catch (Exception e) {
			System.out.println("Exception :" + e);

		}
		return false;
	}
	
	public HashMap<String, String> performSuperKenoSale(String betname) {
		String postData = "";
		HashMap<String, String> temp = new HashMap<String, String>();
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/kenoSixBuy.action";
		if (betname.equals("Direct10"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"10\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"11,34,37,41,44,51,54,68,75,80\",\"betName\":\"Direct10\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct9"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"9\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"07,09,10,16,23,25,39,43,79\",\"betName\":\"Direct9\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct8"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"8\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"03,12,22,25,55,62,70,78\",\"betName\":\"Direct8\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct7"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"7\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"16,23,26,33,60,61,76\",\"betName\":\"Direct7\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct6"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"6\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"09,27,31,38,43,69\",\"betName\":\"Direct6\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct5"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"5\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"02,07,13,36,61\",\"betName\":\"Direct5\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct4"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"4\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"01,28,30,53\",\"betName\":\"Direct4\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct3"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"3\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"02,53,57\",\"betName\":\"Direct3\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if (betname.equals("Direct2"))
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"2\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"16,33\",\"betName\":\"Direct2\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else
			postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"1\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"46\",\"betName\":\"Direct1\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";

		response = given().cookies(cookieMap).contentType("application/json").queryParam("json", postData).when()
				.get(url);
		body = response.getBody().asString();

		System.out.println(response.getStatusCode());
		System.out.println(body);
		System.out.println("Sale done successfully");
		ticketno = response.jsonPath().get("mainData.commonSaleData.ticketNumber").toString();
		temp.put("gameName", response.jsonPath().get("mainData.commonSaleData.gameName").toString());
		temp.put("ticketNumber", response.jsonPath().get("mainData.commonSaleData.ticketNumber").toString());
		temp.put("purchaseAmt", response.jsonPath().get("mainData.commonSaleData.purchaseAmt").toString());
		temp.put("purchaseTime", response.jsonPath().get("mainData.commonSaleData.purchaseTime").toString());
		temp.put("pickedNumbers", response.jsonPath().get("mainData.betTypeData.pickedNumbers").toString());
		return temp;

	}

	public boolean ticketView() {
		if (findElement(SuperKenoPageLocators.ticketPreview, 5).isDisplayed()) {
			txtPreviewTktPrice = findElement(SuperKenoPageLocators.txtPreviewTicketPrice, 5).getText();
			logger.info("ticket preview amount:" + txtPreviewTktPrice);

			return true;
		} else {
			return false;
		}

	}
	
	
	
	public boolean isVarifyReprintDataSuperKeno(String arg1) throws SQLException {
		
		HashMap<String, String> apiReprintData = new HashMap<String, String>();
		apiReprintData =reprintApiForLuckyNumber(SuperKenoPage.ticketno);
		
		findElement(SuperKenoPageLocators.superKenoThirteenSetting,5).click();
		findElement(SuperKenoPageLocators.superKenoThirteenReprint,5).click();
		long temp;
		String tempticketNumber="";
		String ticketNumber="";
		boolean found=true;
		if (ticketView()) {
					
					if(apiReprintData.get("ticketnumber")!=null){
						tempticketNumber=apiReprintData.get("ticketnumber");
						ticketNumber=tempticketNumber.substring(0,tempticketNumber.length()-1);
						
					}

					if (findElement(By.xpath("//*[contains(text(), '" + ticketNumber+ "')]"),
							5) != null) {

						return true;
					

				}
					

		}
		return false;
		}
		
		
		
	
	
	public HashMap<String, String> reprintApiForLuckyNumber(String sessionId)
	{
		HashMap<String, String> temp = new HashMap<String, String>();
		String jsonData = "{\"userName\":\"testret\",\"sessionId\":\""+sessionId+"\"}";
		System.out.println(jsonData);
		try
		{
			
			String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/reprintTicket.action";
			response = given()
	                .contentType("application/json")
	                .queryParam("json", jsonData)
	                .when()
	                .get(url);
			body = response.getBody().asString();
	        System.out.println(response.getStatusCode());
	        System.out.println(body);
	        
	        temp.put("ticketnumber", response.jsonPath().get("mainData.commonReprintData.ticketNumber").toString());
			temp.put("reprintcount", response.jsonPath().get("mainData.commonReprintData.reprintCount").toString());
			temp.put("purchaseamt", response.jsonPath().get("mainData.commonReprintData.purchaseAmt").toString());			
			return temp; 	        
	        
	      
		}catch (Exception e ) {
			e.printStackTrace();
			
		}
		return null;
	}
}
