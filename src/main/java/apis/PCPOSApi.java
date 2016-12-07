package apis;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
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
	public static String drawid;
	public static String gameid;



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

	public boolean fetchDrawGameData() {
		// cookieMap.put("JSESSIONID","69D699F430617EBE241AB2B6238A0210");
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/fetchDrawGameDataPCPOS.action";
		response = given().cookies(cookieMap).contentType("application/json; charset=ISO-8859-1").when().post(url);
		body = response.getBody().asString();
		System.out.println(response.getStatusCode());
		System.out.println("#########*******JSON DATA*********###########");
		System.out.println(body);
		drawid = response.jsonPath().get("games[0].draws[0].drawId").toString();
		gameid = response.jsonPath().get("games[0].gameId").toString();
		System.out.println("GameId : " + gameid);
		System.out.println("DrawId : " + drawid);
		if (response.getStatusCode() == 200) {
			return true;
		} else {
			return false;
		}
		/*
		 * // System.out.println(response.jsonPath().get("games.draws.drawid").
		 * toString());
		 * if(response.jsonPath().get("isSucess").toString().equalsIgnoreCase(
		 * "true")) {
		 * System.out.println(response.jsonPath().get("responseMsg").toString())
		 * ; System.out.println(response.jsonPath().get("games[0].gameCode").
		 * toString()); }
		 */

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

	public HashMap<String, String> cancelApiForLuckyNumber(String ticketNo, String sessionId) {
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

			// String jsonData =
			// "{\"ticketNumber\":\""+ticketNo+"\",\"autoCancel\":false,\"userName\":\"testret\",\"sessionId\":"+sessionId+"\"}";
			System.out.println(response.getStatusCode());
			body = response.getBody().asString();
			System.out.println(body);

			temp.put("ticketnumber", response.jsonPath().get("mainData.ticketNumber").toString());
			temp.put("canceltime", response.jsonPath().get("mainData.cancelTime").toString());
			temp.put("refundamount", response.jsonPath().get("mainData.refundAmount").toString());
			return temp;

		} catch (Exception e) {

			System.out.println("Exception : "+e);

			// String
			// jfdk="{\"barcodeCount\":0,\"gameId\":5,\"isQuickPick\":[1],\"noOfLines\":28,\"noPicked\":8,\"pickedNumbers\":\"04,05,21,28,29,32,35,40\",\"picknumbers\":[\"04,05,21,28,29,32,35,40\"],\"playType\":\"Perm6\",\"betAmtMultiple\":50,\"unitPrice\":280.0,\"promoSaleStatus\":\"SUCCESS\",\"userMappingId\":10030,\"serviceId\":3,\"lastGameId\":0,\"QPPreGenerated\":true,\"drawDateTime\":[],\"drawIdTableMap\":{\"1\":{\"87752\":\"78147\",\"87753\":\"78147\",\"87754\":\"78147\"},\"5\":{\"280\":\"274\",\"281\":\"275\",\"282\":\"276\"},\"12\":{\"145951\":\"5465\",\"145952\":\"5465\",\"145953\":\"5465\"},\"15\":{\"9902\":\"336\",\"9903\":\"336\",\"9904\":\"336\"},\"16\":{\"118\":\"2\",\"119\":\"2\",\"120\":\"2\"},\"17\":{\"749\":\"8\",\"750\":\"8\",\"751\":\"8\"},\"18\":{\"812\":\"9\",\"813\":\"9\",\"814\":\"9\"},\"19\":{\"9673\":\"97\",\"9674\":\"97\",\"9675\":\"97\"},\"20\":{\"9608\":\"96\",\"9609\":\"96\",\"9610\":\"96\"}},\"game_no\":5,\"gameDispName\":\"Bonus
			// Lotto\",\"isAdvancedPlay\":0,\"isPromotkt\":false,\"isRaffelAssociated\":false,\"noOfDraws\":1,\"partyId\":841,\"partyType\":\"RETAILER\",\"purchaseChannel\":\"LMS_Web\",\"raffleNo\":0,\"refMerchantId\":\"WGRL\",\"refTransId\":\"13497824\",\"saleStatus\":\"FAILED\",\"totalPurchaseAmt\":280.0,\"userId\":11917}";


		}
		return null;
	}

	public HashMap<String, String> reprintApiForLuckyNumber(String sessionId) {
		HashMap<String, String> temp = new HashMap<String, String>();
		String jsonData = "{\"userName\":\"testret\",\"sessionId\":\"" + sessionId + "\"}";
		System.out.println(jsonData);
		try {

			String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/reprintTicket.action";
			response = given().contentType("application/json").queryParam("json", jsonData).when().get(url);
			body = response.getBody().asString();
			System.out.println(response.getStatusCode());
			System.out.println(body);

			temp.put("ticketnumber", response.jsonPath().get("mainData.commonReprintData.ticketNumber").toString());
			temp.put("reprintcount", response.jsonPath().get("mainData.commonReprintData.reprintCount").toString());

			temp.put("purchaseamt", response.jsonPath().get("mainData.commonReprintData.purchaseAmt").toString());			
			return temp; 	    
		}
	        
	       
		 catch (Exception e) {

			e.printStackTrace();

		}
		return null;
	}

	public HashMap<String, String> performBonusLottoSale(String betname) {
		HashMap<String, String> temp = new HashMap<String, String>();
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/zimLottoBonusBuy.action";
		String postData = "{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"ZimLottoBonus\"},\"betTypeData\":[{\"noPicked\":\"6\",\"betAmtMul\":1,\"isQp\":false,\"pickedNumbers\":\"12,17,19,25,06,14\",\"betName\":\"Direct6\",\"QPPreGenerated\":false}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"0.2\"}";

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
	
	public HashMap<String, String> performSuperKenoSale(String betname) {
		String postData="";
		HashMap<String, String> temp = new HashMap<String, String>();
		String url = "http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/kenoSixBuy.action";
		if(betname.equals("Direct10"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"10\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"11,34,37,41,44,51,54,68,75,80\",\"betName\":\"Direct10\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if(betname.equals("Direct9"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"9\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"07,09,10,16,23,25,39,43,79\",\"betName\":\"Direct9\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if(betname.equals("Direct8"))		
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"8\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"03,12,22,25,55,62,70,78\",\"betName\":\"Direct8\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if(betname.equals("Direct7"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"7\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"16,23,26,33,60,61,76\",\"betName\":\"Direct7\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";	
		else if(betname.equals("Direct6"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"6\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"09,27,31,38,43,69\",\"betName\":\"Direct6\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if(betname.equals("Direct5"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"5\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"02,07,13,36,61\",\"betName\":\"Direct5\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if(betname.equals("Direct4"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"4\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"01,28,30,53\",\"betName\":\"Direct4\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if(betname.equals("Direct3"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"3\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"02,53,57\",\"betName\":\"Direct3\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else if(betname.equals("Direct2"))
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"2\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"16,33\",\"betName\":\"Direct2\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		else
		postData="{\"commonSaleData\":{\"isAdvancePlay\":false,\"drawData\":[],\"noOfDraws\":1,\"isDrawManual\":true,\"gameName\":\"KenoSix\"},\"betTypeData\":[{\"noPicked\":\"1\",\"betAmtMul\":1,\"isQp\":true,\"pickedNumbers\":\"46\",\"betName\":\"Direct1\",\"QPPreGenerated\":true}],\"noOfPanel\":1,\"totalPurchaseAmt\":\"1\"}";
		
		
		
		response = given().cookies(cookieMap).contentType("application/json").queryParam("json", postData).when().get(url);
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
	

	public HashMap<String, String> performMiniRouleteSale(String betName)
	{
		String picked_data="";
		int size=0;
		String firstRow="3,6,9,12";
		String fourToNine="4,5,6,7,8,9"; 
		String sevenToTwelve="7,8,9,10,11,12";
		String allEvenNumbers="2,4,6,8,10,12";
		String redNumbers ="1,3,5,7,9,11";
		if(betName.equalsIgnoreCase("firstRow"))
		{
			picked_data=firstRow;
			size=4;
		}
		else if(betName.equalsIgnoreCase("fourToNine"))
		{
			picked_data=fourToNine;
			size=6;
		}
		else if(betName.equalsIgnoreCase("sevenToTwelve"))
		{
			picked_data=sevenToTwelve;
			size=6;
		}
		else if(betName.equalsIgnoreCase("allEvenNumbers"))
		{
			picked_data=allEvenNumbers;
			size=6;
			
		}
		else 
		{
			picked_data=redNumbers;
			size=6;
		}
		
		HashMap<String, String> value=new HashMap<String, String>();
		String url="http://192.168.124.73:8180/LMSLinuxNew/com/skilrock/lms/web/drawGames/playMgmt/oneToTwelveRouletteBuy.action";
		String postData="{\n" + "  \"commonSaleData\": {\n" + "    \"isAdvancePlay\": false,\n"
				+ "    \"drawData\": [\n" + "      \n" + "    ],\n" + "    \"noOfDraws\": 1,\n"
				+ "    \"isDrawManual\": true,\n" + "\"gameName\": \"MiniRoulette\"\n" + "  },\n"
				+ "  \"betTypeData\": [\n" + "    {\n" + "      \"noPicked\": "+size+",\n" + "      \"betAmtMul\": 1,\n"
				+ "      \"isQp\": false,\n" + "      \"pickedNumbers\": \""+picked_data+"\",\n"
				+ "      \"betName\": \"" + betName + "\",\n" + "      \"unitPrice\": 10,\n" + "  \"noOfLines\": 4\n" + "   }\n"
				+ "  ],\n" + "  \"noOfPanel\": 1,\n" + "  \"totalPurchaseAmt\": \"10\"\n" + "}";
		response=given()
				.cookies(cookieMap)
				.contentType("application/json")
				.queryParam("json", postData)
				.when()
				.get(url);
		int Status=response.getStatusCode();
		body=response.getBody().asString();
		System.out.println(body);
		System.out.println("status code:"+Status);
		System.out.println(response.asString());
		ticketno=response.jsonPath().get("mainData.commonSaleData.ticketNumber").toString();
		value.put("gameName", response.jsonPath().get("mainData.commonSaleData.gameName").toString());
		value.put("ticketNumber",response.jsonPath().get("mainData.commonSaleData.ticketNumber").toString());
		value.put("purchaseAmt", response.jsonPath().get("mainData.commonSaleData.purchaseAmt").toString());
		value.put("purchaseTime", response.jsonPath().get("mainData.commonSaleData.purchaseTime").toString());
		//value.put("pickedNumbers", response.jsonPath().get("mainData.betTypeData.pickedNumbers").toString());
		
		return value;
		
	}
    public ArrayList<String> matchedPickedNumber()
    {  
    	ArrayList<String> value=new ArrayList<String>();
    	String pickedNumber=response.jsonPath().get("mainData.betTypeData.pickedNumbers").toString();
    	String[] num=pickedNumber.split(",");
    	for(int i=0;i<num.length;i++)
    	{
    		if(num[i].contains("["))
    		{
    		value.add(num[i].replace("[",""));
    		}
    		else if( num[i].contains("]"))
    		{
    		value.add(num[i].replace("]",""));
    		}
    		else
    		{
    			value.add(num[i]);
    		}
    	}
    	
    	
    	return value;
    }

	public HashMap<String, String> cancelApiForSuperKeno(String ticketNo, String sessionId)
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

	public HashMap<String, String> performDrawFreezeForPcPosGame(String apiurl, String drawIdList, String gameno) {
		HashMap<String, String> temp = new HashMap<String, String>();
		String url = apiurl;
		String postData = "{\"draw_id\":0,\"drawIdList\":[" + drawIdList + "],\"freezeTime\":0,\"gameNo\":" + gameno
				+ ",\"postponeMin\":0,\"status\":\"ACTIVE\",\"userId\":0,\"gameId\":0,\"eventId\":0}";

		response = given().header("username", "E49B4EF3-1511-4B8B-86D2-CE78DA0F74D6").header("password", "p@55w0rd")
				.contentType("application/json")
				// .queryParam("requestData", postData)
				.when().body(postData).post(url);
		body = response.getBody().asString();

		System.out.println(response.getStatusCode());
		System.out.println(body);
		System.out.println("Draw Freeze Successfully");
		// ticketno =
		// response.jsonPath().get("mainData.commonSaleData.ticketNumber").toString();
		temp.put("drawid", response.jsonPath().get("responseData.drawScheduleList[0].draw_id").toString());
		temp.put("updatedfreezetime",
				response.jsonPath().get("responseData.drawScheduleList[0].updatedFreezeTime").toString());

		return temp;

	}

	public HashMap<String, String> performResultSubmissionForPcPosGame(String apiurl, String drawIdList,String gameno) {
		HashMap<String, String> temp = new HashMap<String, String>();
		String url = apiurl;
		String postData = " {\"drawIds\":[" + drawIdList
				+ "],\"drawType\":[\"PMEM\"],\"userId\":11002,\"winningNumbers\":[1,2,3,4,5],\"winNumSize\":5,\"gameId\":"
				+ gameno + "}";

		response = given().header("username", "E49B4EF3-1511-4B8B-86D2-CE78DA0F74D6").header("password", "p@55w0rd")
				.contentType("application/json")
				// .queryParam("requestData", postData)
				.when().body(postData).post(url);
		body = response.getBody().asString();

		System.out.println(response.getStatusCode());
		System.out.println(body);
		temp.put("responsemsg", response.jsonPath().get("responseData").toString());
		System.out.println("Result Submission Successful");		
		return temp;

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
