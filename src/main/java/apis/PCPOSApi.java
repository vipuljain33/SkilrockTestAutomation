package apis;

import static com.jayway.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.jayway.restassured.response.Response;

import objectRepository.SoccerThirteenPageLocator;

public class PCPOSApi {
	public Response response;
	public String body;
	public static Map<String, String> cookieMap;
	public static String sessionId;
	public static String ticketno;
	public static Map<String, String> soccerThirteenData;

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

	public HashMap<String, String> performLuckyNumberSale(String betname) {
		HashMap<String, String> temp = new HashMap<String, String>();
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/kenoTwoBuy.action";
		String postData = "{\n" + "  \"commonSaleData\": {\n" + "    \"isAdvancePlay\": false,\n"
				+ "    \"drawData\": [\n" + "      \n" + "    ],\n" + "    \"noOfDraws\": 1,\n"
				+ "    \"isDrawManual\": true,\n" + "    \"gameName\": \"KenoSix\"\n" + "  },\n"
				+ "  \"betTypeData\": [\n" + "    {\n" + "      \"noPicked\": \"10\",\n" + "      \"betAmtMul\": 1,\n"
				+ "      \"isQp\": false,\n" + "      \"pickedNumbers\": \"34,32,45,67,23,12,89,03,05,15\",\n"
				+ "      \"betName\": \"" + betname + "\",\n" + "      \"QPPreGenerated\": true\n" + "    }\n"
				+ "  ],\n" + "  \"noOfPanel\": 1,\n" + "  \"totalPurchaseAmt\": \"1\"\n" + "}";

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
	
	public HashMap<String, String> cancelApiForLuckyNumber(String ticketNo, String sessionId)
	{
		HashMap<String, String> temp = new HashMap<String, String>();
		try {
			
			String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/cancelTicket.action";
			String jsonData = "{\"ticketNumber\":\""+ticketNo+"\",\"autoCancel\":false,\"userName\":\"testret\",\"sessionId\":\""+sessionId+"\"}";
			response = given()
	                .cookies(cookieMap)
	                .contentType("application/json")
	                .queryParam("json", jsonData)
	                .when()
	                .get(url);
			System.out.println(response.getStatusCode());
			body = response.getBody().asString();
			System.out.println(body);
			
			temp.put("ticketnumber", response.jsonPath().get("mainData.ticketNumber").toString());
			temp.put("canceltime", response.jsonPath().get("mainData.cancelTime").toString());
			temp.put("refundamount", response.jsonPath().get("mainData.refundAmount").toString());			
			return temp;
			
		} catch (Exception e) {
			System.out.println("Exception : "+e);
			
			
		}
		return null;
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
	public void performSoccerThirteenSale(String s) {
		
		String url1="http://115.111.246.156:8082/SportsLottery/com/skilrock/sle/web/merchantUser/playMgmt/action/sportsLotteryPurchaseTicket.action";
		String inputDataAllH="{\"merchantCode\":\"RMS\",\"userName\":\"testret\",\"sessionId\":\""+sessionId+"\",\"noOfBoard\":\"1\",\"gameId\":\"1\",\"drawInfo\":[{\"drawId\":\"987\",\"betAmtMul\":\"1\",\"eventData\":[{\"eventId\":\"4786\",\"eventSelected\":\"H\"},{\"eventId\":\"4774\",\"eventSelected\":\"H\"},{\"eventId\":\"4775\",\"eventSelected\":\"H\"},{\"eventId\":\"4783\",\"eventSelected\":\"H\"},{\"eventId\":\"4776\",\"eventSelected\":\"H\"},{\"eventId\":\"4784\",\"eventSelected\":\"H\"},{\"eventId\":\"4777\",\"eventSelected\":\"H\"},{\"eventId\":\"4785\",\"eventSelected\":\"H\"},{\"eventId\":\"4778\",\"eventSelected\":\"H\"},{\"eventId\":\"4779\",\"eventSelected\":\"H\"},{\"eventId\":\"4780\",\"eventSelected\":\"H\"},{\"eventId\":\"4781\",\"eventSelected\":\"H\"},{\"eventId\":\"4782\",\"eventSelected\":\"H\"}]}],\"gameTypeId\":\"1\",\"totalPurchaseAmt\":\"1\"}";
		String inputDataAllA="{\"merchantCode\":\"RMS\",\"userName\":\"testret\",\"sessionId\":\""+sessionId+"\",\"noOfBoard\":\"1\",\"gameId\":\"1\",\"drawInfo\":[{\"drawId\":\"987\",\"betAmtMul\":\"1\",\"eventData\":[{\"eventId\":\"4786\",\"eventSelected\":\"A\"},{\"eventId\":\"4774\",\"eventSelected\":\"A\"},{\"eventId\":\"4775\",\"eventSelected\":\"A\"},{\"eventId\":\"4783\",\"eventSelected\":\"A\"},{\"eventId\":\"4776\",\"eventSelected\":\"A\"},{\"eventId\":\"4784\",\"eventSelected\":\"A\"},{\"eventId\":\"4777\",\"eventSelected\":\"A\"},{\"eventId\":\"4785\",\"eventSelected\":\"A\"},{\"eventId\":\"4778\",\"eventSelected\":\"A\"},{\"eventId\":\"4779\",\"eventSelected\":\"A\"},{\"eventId\":\"4780\",\"eventSelected\":\"A\"},{\"eventId\":\"4781\",\"eventSelected\":\"A\"},{\"eventId\":\"4782\",\"eventSelected\":\"A\"}]}],\"gameTypeId\":\"1\",\"totalPurchaseAmt\":\"1\"}";
		String inputDataRandom="{\"merchantCode\":\"RMS\",\"userName\":\"testret\",\"sessionId\":\""+sessionId+"\",\"noOfBoard\":\"1\",\"gameId\":\"1\",\"drawInfo\":[{\"drawId\":\"987\",\"betAmtMul\":\"1\",\"eventData\":[{\"eventId\":\"4786\",\"eventSelected\":\"H\"},{\"eventId\":\"4774\",\"eventSelected\":\"H\"},{\"eventId\":\"4775\",\"eventSelected\":\"H\"},{\"eventId\":\"4783\",\"eventSelected\":\"H\"},{\"eventId\":\"4776\",\"eventSelected\":\"H\"},{\"eventId\":\"4784\",\"eventSelected\":\"H\"},{\"eventId\":\"4777\",\"eventSelected\":\"H\"},{\"eventId\":\"4785\",\"eventSelected\":\"H\"},{\"eventId\":\"4778\",\"eventSelected\":\"H\"},{\"eventId\":\"4779\",\"eventSelected\":\"H\"},{\"eventId\":\"4780\",\"eventSelected\":\"H\"},{\"eventId\":\"4781\",\"eventSelected\":\"H,D\"},{\"eventId\":\"4782\",\"eventSelected\":\"H,A\"}]}],\"gameTypeId\":\"1\",\"totalPurchaseAmt\":\"4\"}";
        String inputDataAllD="{\"merchantCode\":\"RMS\",\"userName\":\"testret\",\"sessionId\":\""+sessionId+"\",\"noOfBoard\":\"1\",\"gameId\":\"1\",\"drawInfo\":[{\"drawId\":\"987\",\"betAmtMul\":\"1\",\"eventData\":[{\"eventId\":\"4786\",\"eventSelected\":\"D\"},{\"eventId\":\"4774\",\"eventSelected\":\"D\"},{\"eventId\":\"4775\",\"eventSelected\":\"D\"},{\"eventId\":\"4783\",\"eventSelected\":\"D\"},{\"eventId\":\"4776\",\"eventSelected\":\"D\"},{\"eventId\":\"4784\",\"eventSelected\":\"D\"},{\"eventId\":\"4777\",\"eventSelected\":\"D\"},{\"eventId\":\"4785\",\"eventSelected\":\"D\"},{\"eventId\":\"4778\",\"eventSelected\":\"D\"},{\"eventId\":\"4779\",\"eventSelected\":\"D\"},{\"eventId\":\"4780\",\"eventSelected\":\"D\"},{\"eventId\":\"4781\",\"eventSelected\":\"D\"},{\"eventId\":\"4782\",\"eventSelected\":\"D\"}]}],\"gameTypeId\":\"1\",\"totalPurchaseAmt\":\"1\"}";

        String inputData;
        if(s.equals("Random")) {
        	inputData=inputDataRandom;
        }
        else if(s.equals("All-H")) {
        	inputData=inputDataAllH;
        }
        else if(s.equals("All-D")) {
        	inputData=inputDataAllD;
        }
        else {
        	inputData=inputDataAllA;
        }
		response =given()
				.contentType("application/json")
				.queryParam("requestData", inputData)
				.post(url1);
		
		soccerThirteenData  = new HashMap<String, String>();
		
		String temp=response.jsonPath().get("tktData.ticketNo").toString();
		soccerThirteenData.put("Ticket Number", temp.substring(0, temp.length()-1));
		soccerThirteenData.put("Ticket Price", response.jsonPath().get("tktData.ticketAmt").toString());
		System.out.println("Ticket Number from response :"+soccerThirteenData.get("Ticket Number"));
		
		
		
	}
	

}
