package apis;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;
import com.jayway.restassured.response.Response;

public class SaleApi {
	
	public Response response;
	public String body;
	Map<String, String> cookieMap;
	String sessionId ;
	
	
	public String authenticate()
	{
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/loginMgmt/userLogin.action ";
		String jsonData = "{\"userName\":\"testret\",\"password\":\"12345678\"}\n";
		
		response = given()
                .contentType("application/json")
                .queryParam("json", jsonData)
                .get(url);
        body = response.getBody().asString();
        System.out.println(response);
        System.out.println(response.getStatusCode());
        System.out.println(body);
        cookieMap =  response.getCookies();
        for(String key : cookieMap.keySet())
        {
        	System.out.println("Printing cookie keys value");
        	System.out.println(key);
        	System.out.println(cookieMap.get(key));
        }
        
        String sessionId = response.jsonPath().get("data.sessionId").toString();
        System.out.println("Session id = " + sessionId);
        return sessionId;
        
	}
	
	public void fetchDrawGameData()
	{
		//cookieMap.put("JSESSIONID","69D699F430617EBE241AB2B6238A0210");
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/fetchDrawGameDataPCPOS.action";
		response = given()
                .cookies(cookieMap)
                .contentType("application/json; charset=ISO-8859-1")
                .when()
                .post(url);
        body = response.getBody().asString();
        System.out.println(response.getStatusCode());
        System.out.println(body);
        if(response.jsonPath().get("responseMsg") != null)
        {
        	if(response.jsonPath().get("responseMsg").toString().equalsIgnoreCase("success"))
        	{
        		System.out.println(response.jsonPath().get("responseMsg").toString());
        		System.out.println(response.jsonPath().get("games[0].gameCode").toString());
        	}
        }
        	
	}
	
	public void performSale()
	{
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/kenoTwoBuy.action";
		String postData = "{\n" +
                "  \"commonSaleData\": {\n" +
                "    \"isAdvancePlay\": false,\n" +
                "    \"drawData\": [\n" +
                "      \n" +
                "    ],\n" +
                "    \"noOfDraws\": 1,\n" +
                "    \"isDrawManual\": true,\n" +
                "    \"gameName\": \"KenoSix\"\n" +
                "  },\n" +
                "  \"betTypeData\": [\n" +
                "    {\n" +
                "      \"noPicked\": \"20\",\n" +
                "      \"betAmtMul\": 1,\n" +
                "      \"isQp\": true,\n" +
                "      \"pickedNumbers\": \"07,08,13,24,31,42,53,100,80,86\",\n" +
                "      \"betName\": \"Perm1\",\n" +
                "      \"QPPreGenerated\": true\n" +
                "    }\n" +
                "  ],\n" +
                "  \"noOfPanel\": 1,\n" +
                "  \"totalPurchaseAmt\": \"1\"\n" +
                "}";
				response = given()
                .cookies(cookieMap)
                .contentType("application/json")
                .queryParam("json", postData)
                .when()
                .get(url);
		body = response.getBody().asString();
        System.out.println(response.getStatusCode());
        System.out.println(body);
        System.out.println("Sale done successfully");
		
		
	}
	
	public void reprintApi(String sessionId)
	{
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
	        System.out.println("Reprint api checked");
		}catch (Exception e ) {
			e.printStackTrace();
			
		}
	}
	
	public void cancelApi(String ticketNo, String sessionId)
	{
		try {
			
			String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/cancelTicket.action";
			String jsonData = "{\"ticketNumber\":null,\"autoCancel\":false,\"userName\":\"testret\",\"sessionId\":\"}";
			response = given()
	                .cookies(cookieMap)
	                .contentType("application/json")
	                .queryParam("json", jsonData)
	                .when()
	                .get(url);
		} catch (Exception e) {
			
		}
	}
	public static void main(String[] args) {
		
		SaleApi api = new SaleApi();
		String session = api.authenticate();
		//api.fetchDrawGameData();
		api.performSale();
		//api.reprintApi(session);
		//api.authenticate();
		
		
	}

}
