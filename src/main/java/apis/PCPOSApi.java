package apis;

import static com.jayway.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.restassured.response.Response;

public class PCPOSApi {
	public Response response;
	public String body;
	public static Map<String, String> cookieMap;
	public static String sessionId;
	public static String ticketno;

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

			String sessionId = response.jsonPath().get("data.sessionId").toString();
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
			//String jsonData = "{\"ticketNumber\":\""+ticketNo+"\",\"autoCancel\":false,\"userName\":\"testret\",\"sessionId\":"+sessionId+"\"}";
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
			//String jfdk="{\"barcodeCount\":0,\"gameId\":5,\"isQuickPick\":[1],\"noOfLines\":28,\"noPicked\":8,\"pickedNumbers\":\"04,05,21,28,29,32,35,40\",\"picknumbers\":[\"04,05,21,28,29,32,35,40\"],\"playType\":\"Perm6\",\"betAmtMultiple\":50,\"unitPrice\":280.0,\"promoSaleStatus\":\"SUCCESS\",\"userMappingId\":10030,\"serviceId\":3,\"lastGameId\":0,\"QPPreGenerated\":true,\"drawDateTime\":[],\"drawIdTableMap\":{\"1\":{\"87752\":\"78147\",\"87753\":\"78147\",\"87754\":\"78147\"},\"5\":{\"280\":\"274\",\"281\":\"275\",\"282\":\"276\"},\"12\":{\"145951\":\"5465\",\"145952\":\"5465\",\"145953\":\"5465\"},\"15\":{\"9902\":\"336\",\"9903\":\"336\",\"9904\":\"336\"},\"16\":{\"118\":\"2\",\"119\":\"2\",\"120\":\"2\"},\"17\":{\"749\":\"8\",\"750\":\"8\",\"751\":\"8\"},\"18\":{\"812\":\"9\",\"813\":\"9\",\"814\":\"9\"},\"19\":{\"9673\":\"97\",\"9674\":\"97\",\"9675\":\"97\"},\"20\":{\"9608\":\"96\",\"9609\":\"96\",\"9610\":\"96\"}},\"game_no\":5,\"gameDispName\":\"Bonus Lotto\",\"isAdvancedPlay\":0,\"isPromotkt\":false,\"isRaffelAssociated\":false,\"noOfDraws\":1,\"partyId\":841,\"partyType\":\"RETAILER\",\"purchaseChannel\":\"LMS_Web\",\"raffleNo\":0,\"refMerchantId\":\"WGRL\",\"refTransId\":\"13497824\",\"saleStatus\":\"FAILED\",\"totalPurchaseAmt\":280.0,\"userId\":11917}";
			
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
	        
	       // System.out.println("Reprint api checked");
		}catch (Exception e ) {
			e.printStackTrace();
			
		}
		return null;
	}

}
