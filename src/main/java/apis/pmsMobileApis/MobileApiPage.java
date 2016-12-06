package apis.pmsMobileApis;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import com.jayway.restassured.response.Response;

public class MobileApiPage {
	public Response response;
	public String body;
	Map<String, String> headerMap;
	static String sessionId;
	static String playerId;
	//Headers headers;

	public String authenticate(String userName, String password) {
		String url = "http://115.111.246.156:8082/PMS/com/skilrock/pms/mobile/loginMgmt/Action/playerLogin.action?userName="
				+ userName + "&password=" + password + "&deviceName=Android&deviceType=Phone&currentVersion=4.6";
		response = given()
				.headers("reqChannel", "Android", "appVersion", "4.6")
				.contentType("application/json")
				.post(url);
		body = response.getBody().asString();
		System.out.println("RESPONSE :: " + response);
		System.out.println(response.getStatusCode());
		System.out.println("Body :: " + body);
		sessionId = response.jsonPath().get("sessionId").toString();
		playerId = response.jsonPath().get("playerId").toString();
		System.out.println("Session id :: " + sessionId);
		return sessionId;
	}

	public void fetchDrawGameData() {
		String url = "http://115.111.246.156:8082/DGE_Scheduler/services/tpDataMgmt/fetchGameData";
		String jsonData = "{\"merchantCode\": \"PMS\"}";
		response = given()
				.headers("reqChannel", "Android", "appVersion", "4.6", "userName", "4jQzx531KsmLqbz8/ZUY9Q==",
						"password", "O5ZbpopS5W2bHB8EsjxpWA==")
				.contentType("application/json")
				.when()
				.body(jsonData)
				.post(url);
		body = response.getBody().asString();
		System.out.println(response.getStatusCode());
		System.out.println("Body :: " + body);
		//headers = response.getHeaders();
		if (response.jsonPath().get("responseMsg") != null) {
			if (response.jsonPath().get("responseMsg").toString().equalsIgnoreCase("success")) {
				System.out.println(response.jsonPath().get("responseMsg").toString());
			}
		}
	}

	public void performSale(String gameCode, int noOfDraws, int noOfPanel,int betAmtMul, String isQP,
			String pickedNumbers, int noPicked,String playType) {
		String url = "http://115.111.246.156:8082/DGE_Scheduler/services/tpPlayMgmt/purchaseTicket";
		String qpData = "{\n" + 
		                " \"gameCode\": \"" + gameCode + "\",\n" + 
				        " \"isAdvancePlay\": false,\n" + 
		                " \"merchantCode\": \"PMS\",\n" + 
				        " \"noOfDraws\": " + noOfDraws + ",\n" + 
		                " \"noOfPanel\": " + noOfPanel + ",\n" + 
				        " \"sessionId\": \"" + sessionId + "\",\n" + 
		                " \"userId\": \""+playerId+"\",\n" + 
				        " \"drawData\": [{\n" + 
		                "  \"drawId\": \"\"\n" + " }],\n" + 
				        " \"panelData\": [{\n" + 
		                "  \"betAmtMul\": " + betAmtMul + ",\n" + 
				        "  \"isQP\": " + isQP + ",\n" + 
		                "  \"pickedNumbers\": \"" + pickedNumbers + "\",\n" + 
				        "  \"noPicked\": \"" + noPicked + "\",\n" + 
		                "  \"playType\": \""+playType+"\"\n" + " }]\n" +
				        "}";
		response = given()
				.headers("reqChannel", "Android", "appVersion", "4.6", "userName", "4jQzx531KsmLqbz8/ZUY9Q==",
						"password", "O5ZbpopS5W2bHB8EsjxpWA==")
				.contentType("application/json")
				.when()
				.body(qpData)
				.post(url);
		body = response.getBody().asString();
		System.out.println(response.getStatusCode());
		System.out.println("Body :: " + body);
		System.out.println("Sale done successfully");
	}

//	public static void main(String[] args) {
//		MobileApiPage api = new MobileApiPage();
//		api.authenticate("shreya", "12345678");
//		api.fetchDrawGameData();
//		api.performSale("KenoTwo", 1, 1, 1, "true", "QP", 10,"Perm1" );
//		api.performSale("ZimLottoBonus",1, 1, 1, "true", "QP", 10,"Direct6");
//		api.performSale("KenoTwo", 1, 1, 1, "false", "1,2,3,4,5,6,7,8,9,10", 10, "Perm1");
//
//	}
}
