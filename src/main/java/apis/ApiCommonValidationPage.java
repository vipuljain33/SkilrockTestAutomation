package apis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import DataBaseQuery.BonusLottoSqlQuery;
import DataBaseQuery.DBConnection;
import DataBaseQuery.LuckyNumberSqlQuery;
import DataBaseQuery.MiniRouletteSqlQuery;
import DataBaseQuery.SuperKenoSqlQuery;
public class ApiCommonValidationPage {
	private static Logger LOGGER = LoggerFactory.getLogger(ApiCommonValidationPage.class);
	PCPOSApi pcposapi = new PCPOSApi();
	DBConnection dbconnection = new DBConnection();
	Connection con;
	String pickednum;

	public boolean isVerifySaleResponceWithDB(String arg1) throws SQLException {
		HashMap<String, String> apidata = new HashMap<String, String>();
		HashMap<String, String> dbdata = new HashMap<String, String>();
		System.out.println("**********************************");
		boolean flag = false;
		apidata = pcposapi.performLuckyNumberSale(arg1);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, LuckyNumberSqlQuery.apiticketdetails, PCPOSApi.ticketno);
		while (rs.next()) {

			dbdata.put("gamename", rs.getString(1));
			dbdata.put("ticketNumber", rs.getString(2));
			dbdata.put("purchaseAmt", rs.getString(3));
			dbdata.put("purchaseTime", rs.getString(4));
			dbdata.put("pickedNumbers", "[" + rs.getString(5) + "]");
		}
		System.out.println("API Data : " + apidata);
		System.out.println("DB Data : " + dbdata);

		Iterator iterator = apidata.keySet().iterator();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			// System.out.println(key);
			if (key.equalsIgnoreCase("gameName")) {
				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("ticketNumber")) {

				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("purchaseAmt")) {

				if (Float.parseFloat(apidata.get(key)) == Float.parseFloat(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}

			if (key.equalsIgnoreCase("purchaseTime")) {
				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("pickedNumbers")) {
				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
		return flag;

		/*
		 * if(flag){ return true; } return false;
		 */
	}

	public boolean isVarifyCancleData(String atg1) throws SQLException {
		HashMap<String, String> apiCancelData = new HashMap<String, String>();
		HashMap<String, String> dbcanceldata = new HashMap<String, String>();
		apiCancelData = pcposapi.cancelApiForLuckyNumber(PCPOSApi.ticketno, PCPOSApi.sessionId);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, LuckyNumberSqlQuery.apiticketcanceldetails, PCPOSApi.ticketno);
		while (rs.next()) {
			dbcanceldata.put("ticketnumber", rs.getString(1) + "0");
			dbcanceldata.put("canceltime", rs.getString(2));
			dbcanceldata.put("refundamount", rs.getString(3));
		}
		System.out.println("API Data : " + apiCancelData);
		System.out.println("DB Data : " + dbcanceldata);
		Iterator iterator = apiCancelData.keySet().iterator();
		boolean flag = false;
		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			// System.out.println(key);
			if (key.equalsIgnoreCase("cancelTime")) {
				/*
				 * String s[]=dbcanceldata.get(key).split(".");
				 * System.out.println("DB Date : " + s[0]);
				 */
				if (dbcanceldata.get(key).contains(apiCancelData.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("ticketNumber")) {

				if (apiCancelData.get(key).equalsIgnoreCase(dbcanceldata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("refundAmount")) {

				if (Float.parseFloat(apiCancelData.get(key)) == Float.parseFloat(dbcanceldata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
		return flag;
	}

	public boolean isVarifyReprintData(String arg1) throws SQLException {

		HashMap<String, String> apiReprintData = new HashMap<String, String>();
		HashMap<String, String> dbReprintdata = new HashMap<String, String>();
		apiReprintData = pcposapi.reprintApiForLuckyNumber(PCPOSApi.ticketno);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, LuckyNumberSqlQuery.apiticketreprintdetails, PCPOSApi.ticketno);
		while (rs.next()) {
			dbReprintdata.put("ticketnumber", rs.getString(1).concat("1"));
			dbReprintdata.put("reprintcount", rs.getString(2));
			dbReprintdata.put("purchaseamt", rs.getString(3));
		}
		System.out.println("API Data : " + apiReprintData);
		System.out.println("DB Data : " + dbReprintdata);
		Iterator iterator = apiReprintData.keySet().iterator();
		boolean flag = false;
		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			// System.out.println(key);
			if (key.equalsIgnoreCase("reprintcount")) {
				/*
				 * String s[]=dbcanceldata.get(key).split(".");
				 * System.out.println("DB Date : " + s[0]);
				 */
				if (dbReprintdata.get(key).contains(apiReprintData.get(key))) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (key.equalsIgnoreCase("ticketNumber")) {

				if (apiReprintData.get(key).equalsIgnoreCase(dbReprintdata.get(key))) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (key.equalsIgnoreCase("purchaseamt")) {

				if (Float.parseFloat(apiReprintData.get(key)) == Float.parseFloat(dbReprintdata.get(key))) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}

		}
		return flag;
	}

	public boolean isVerifySaleResponceWithDBforBonusLotto(String arg1) throws SQLException {
		HashMap<String, String> apidata = new HashMap<String, String>();
		HashMap<String, String> dbdata = new HashMap<String, String>();
		System.out.println("**********************************");
		boolean flag = false;
		apidata = pcposapi.performBonusLottoSale(arg1);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, BonusLottoSqlQuery.apiticketdetails, PCPOSApi.ticketno);
		while (rs.next()) {

			dbdata.put("gamename", rs.getString(1));
			dbdata.put("ticketNumber", rs.getString(2));
			dbdata.put("purchaseAmt", rs.getString(3));
			dbdata.put("purchaseTime", rs.getString(4));
			
			dbdata.put("pickedNumbers", "[" + rs.getString(5) + "]");
		}
		
		System.out.println("API Data : " + apidata);
		System.out.println("DB Data : " + dbdata);

		Iterator iterator = apidata.keySet().iterator();

		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			// System.out.println(key);
			if (key.equalsIgnoreCase("gameName")) {
				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("ticketNumber")) {

				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("purchaseAmt")) {

				if (Float.parseFloat(apidata.get(key)) == Float.parseFloat(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}

			if (key.equalsIgnoreCase("purchaseTime")) {
				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("pickedNumbers")) {
				if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
		return flag;

		/*
		 * if(flag){ return true; } return false;
		 */
	}

	public boolean isVarifyCancleDataBonusLotto(String atg1) throws SQLException {
		HashMap<String, String> apiCancelData = new HashMap<String, String>();
		HashMap<String, String> dbcanceldata = new HashMap<String, String>();
		apiCancelData = pcposapi.cancelApiForLuckyNumber(PCPOSApi.ticketno, PCPOSApi.sessionId);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, BonusLottoSqlQuery.apiticketcanceldetails, PCPOSApi.ticketno);
		while (rs.next()) {
			dbcanceldata.put("ticketnumber", rs.getString(1) + "0");
			dbcanceldata.put("canceltime", rs.getString(2));
			dbcanceldata.put("refundamount", rs.getString(3));
		}
		System.out.println("API Data : " + apiCancelData);
		System.out.println("DB Data : " + dbcanceldata);
		Iterator iterator = apiCancelData.keySet().iterator();
		boolean flag = false;
		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			// System.out.println(key);
			if (key.equalsIgnoreCase("cancelTime")) {
				/*
				 * String s[]=dbcanceldata.get(key).split(".");
				 * System.out.println("DB Date : " + s[0]);
				 */
				if (dbcanceldata.get(key).contains(apiCancelData.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("ticketNumber")) {

				if (apiCancelData.get(key).equalsIgnoreCase(dbcanceldata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("refundAmount")) {

				if (Float.parseFloat(apiCancelData.get(key)) == Float.parseFloat(dbcanceldata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
		return flag;
	}


	


	public boolean isVarifyCancleDataSuperKeno(String atg1) throws SQLException {
		HashMap<String, String> apiCancelData = new HashMap<String, String>();
		HashMap<String, String> dbcanceldata = new HashMap<String, String>();
		apiCancelData = pcposapi.cancelApiForSuperKeno(PCPOSApi.ticketno, PCPOSApi.sessionId);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, SuperKenoSqlQuery.apiticketcanceldetails, PCPOSApi.ticketno);
		while (rs.next()) {
			dbcanceldata.put("ticketnumber", rs.getString(1)+"0");
			dbcanceldata.put("canceltime", rs.getString(2));
			dbcanceldata.put("refundamount", rs.getString(3));
		}
		System.out.println("API Data : " + apiCancelData);
		System.out.println("DB Data : " + dbcanceldata);
		Iterator iterator = apiCancelData.keySet().iterator();
		boolean flag = false;
		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			// System.out.println(key);
			if (key.equalsIgnoreCase("cancelTime")) {
				/*String s[]=dbcanceldata.get(key).split(".");
				System.out.println("DB Date : " + s[0]);*/
				if (dbcanceldata.get(key).contains(apiCancelData.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("ticketNumber")) {

				if (apiCancelData.get(key).equalsIgnoreCase(dbcanceldata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}
			if (key.equalsIgnoreCase("refundAmount")) {

				if (Float.parseFloat(apiCancelData.get(key)) == Float.parseFloat(dbcanceldata.get(key))) {
					flag = true;
				} else {
					flag = false;
				}
			}

		}
		return flag;
	}
	
	
	
	
	
public boolean isVarifyReprintDataBonusLotto(String arg1) throws SQLException {
		
		HashMap<String, String> apiReprintData = new HashMap<String, String>();
		HashMap<String, String> dbReprintdata = new HashMap<String, String>();
		apiReprintData = pcposapi.reprintApiForLuckyNumber(PCPOSApi.ticketno);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, BonusLottoSqlQuery.apiticketreprintdetails, PCPOSApi.ticketno);
		while (rs.next()) {
			dbReprintdata.put("ticketnumber", rs.getString(1).concat("1"));
			dbReprintdata.put("reprintcount", rs.getString(2));
			dbReprintdata.put("purchaseamt", rs.getString(3));
		}
		System.out.println("API Data : " + apiReprintData);
		System.out.println("DB Data : " + dbReprintdata);
		Iterator iterator = apiReprintData.keySet().iterator();
		boolean flag = false;
		while (iterator.hasNext()) {
			String key = (String) iterator.next();

			// System.out.println(key);
			if (key.equalsIgnoreCase("reprintcount")) {
				/*
				 * String s[]=dbcanceldata.get(key).split(".");
				 * System.out.println("DB Date : " + s[0]);
				 */
				if (dbReprintdata.get(key).contains(apiReprintData.get(key))) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (key.equalsIgnoreCase("ticketNumber")) {

				if (apiReprintData.get(key).equalsIgnoreCase(dbReprintdata.get(key))) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			if (key.equalsIgnoreCase("purchaseamt")) {

				if (Float.parseFloat(apiReprintData.get(key)) == Float.parseFloat(dbReprintdata.get(key))) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}

		}
		return flag;
	}

public boolean isVerifySaleResponseWithDBforMiniRoulette(String arg1) throws SQLException {
	HashMap<String, String> apidata = new HashMap<String, String>();
	HashMap<String, String> dbdata = new HashMap<String, String>();	
	System.out.println("**********************************");
	boolean flag = false;
	apidata = pcposapi.performMiniRouleteSale(arg1);
	con = dbconnection.getDBConnectionDge();
	ResultSet rs = dbconnection.ExecuteQuery(con,MiniRouletteSqlQuery.apiMinirouletteTicket, PCPOSApi.ticketno);
	while (rs.next()) {

		dbdata.put("gamename", rs.getString(1));
		dbdata.put("ticketNumber", rs.getString(2));
		dbdata.put("purchaseAmt", rs.getString(3));
		dbdata.put("purchaseTime", rs.getString(4));
		pickednum=rs.getString(5);
		
		
		
	}
	System.out.println("API Data : " + apidata);
	System.out.println("DB Data : " + dbdata);

	Iterator iterator = apidata.keySet().iterator();

	while (iterator.hasNext()) {
		String key = (String) iterator.next();

		// System.out.println(key);
		if (key.equalsIgnoreCase("gameName")) {
			if (apidata.get(key).equals(dbdata.get(key))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		if (key.equalsIgnoreCase("ticketNumber")) {

			if (apidata.get(key).equals(dbdata.get(key)) ) {
				flag = true;
			} else {
				flag = false;
			}
		}
		if (key.equalsIgnoreCase("purchaseAmt")) {

			if (Float.parseFloat(apidata.get(key)) == Float.parseFloat((String) dbdata.get(key))) {
				flag = true;
			} else {
				flag = false;
			}
		}

		if (key.equalsIgnoreCase("purchaseTime")) {
			if (apidata.get(key).equals(dbdata.get(key))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		

	}
	return flag;

	/*
	 * if(flag){ return true; } return false;
	 */
}
public boolean verifyPickedNumMiniroulette()
{  
	ArrayList<String> listitm=new ArrayList<String>();
	ArrayList<String> posSelectedNum=pcposapi.matchedPickedNumber();
	boolean flag = false;
	
	String[] str=pickednum.split(",");
	for(int i=0;i<str.length;i++)
	{
		if(str[i].contains("One"))
		{
			listitm.add("01");
		}
		if(str[i].contains("Two"))
		{
			listitm.add("02");
		}
		if(str[i].contains("Three"))
		{
			listitm.add("03");
		}
		if(str[i].contains("Four"))
		{
			listitm.add("04");
		}
		if(str[i].contains("Five"))
		{
			listitm.add("05");
		}
		if(str[i].contains("Six"))
		{
			listitm.add("06");
		}
		if(str[i].contains("Seven"))
		{
			listitm.add("07");
		}
		if(str[i].contains("Eight"))
		{
			listitm.add("08");
		}
		if(str[i].contains("Nine"))
		{
			listitm.add("09");
		}
		if(str[i].contains("Ten"))
		{
			listitm.add("10");
		}
		if(str[i].contains("Eleven"))
		{
			listitm.add("11");
		}
		if(str[i].contains("Twelve"))
		{
			listitm.add("12");
		}
	}
	for(int j=0;j<str.length;j++)
	{
		if(posSelectedNum.get(j).trim().equals(listitm.get(j).trim()))
		{
			flag=true;
			
		}
		else
		{
			flag=false;
		}
	}
	return flag;
    
	
}
  


public boolean isVerifySaleResponceWithDBforSuperKeno(String arg1) throws SQLException {
	HashMap<String, String> apidata = new HashMap<String, String>();
	HashMap<String, String> dbdata = new HashMap<String, String>();
	System.out.println("**********************************");
	boolean flag = false;
	apidata = pcposapi.performSuperKenoSale(arg1);
	con = dbconnection.getDBConnectionDge();
	ResultSet rs = dbconnection.ExecuteQuery(con,SuperKenoSqlQuery.apiticketdetails, PCPOSApi.ticketno);
	while (rs.next()) {

		dbdata.put("gamename", rs.getString(1));
		dbdata.put("ticketNumber", rs.getString(2));
		dbdata.put("purchaseAmt", rs.getString(3));
		dbdata.put("purchaseTime", rs.getString(4));
		dbdata.put("pickedNumbers", "[" + rs.getString(5) + "]");
	}
	System.out.println("API Data : " + apidata);
	System.out.println("DB Data : " + dbdata);

	Iterator iterator = apidata.keySet().iterator();

	while (iterator.hasNext()) {
		String key = (String) iterator.next();

		// System.out.println(key);
		if (key.equalsIgnoreCase("gameName")) {
			if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		if (key.equalsIgnoreCase("ticketNumber")) {

			if (apidata.get(key).equalsIgnoreCase(dbdata.get(key)) ) {
				flag = true;
			} else {
				flag = false;
			}
		}
		if (key.equalsIgnoreCase("purchaseAmt")) {

			if (Float.parseFloat(apidata.get(key)) == Float.parseFloat(dbdata.get(key))) {
				flag = true;
			} else {
				flag = false;
			}
		}

		if (key.equalsIgnoreCase("purchaseTime")) {
			if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
				flag = true;
			} else {
				flag = false;
			}
		}
		if (key.equalsIgnoreCase("pickedNumbers")) {
			if (apidata.get(key).equalsIgnoreCase(dbdata.get(key))) {
				flag = true;
			} else {
				flag = false;
			}
		}

	}
	return flag;

	/*
	 * if(flag){ return true; } return false;
	 */
}

public boolean isVarifyReprintDataSuperKeno(String arg1) throws SQLException {
	
	
	HashMap<String, String> apiReprintData = new HashMap<String, String>();
	HashMap<String, String> dbReprintdata = new HashMap<String, String>();
	apiReprintData = pcposapi.reprintApiForLuckyNumber(PCPOSApi.ticketno);
	con = dbconnection.getDBConnectionDge();
	ResultSet rs = dbconnection.ExecuteQuery(con,SuperKenoSqlQuery.apiticketreprintdetails, PCPOSApi.ticketno);
	while (rs.next()) {
		dbReprintdata.put("ticketnumber", rs.getString(1).concat("1"));
		dbReprintdata.put("reprintcount", rs.getString(2));
		dbReprintdata.put("purchaseamt", rs.getString(3));
	}
	System.out.println("API Data : " + apiReprintData);
	System.out.println("DB Data : " + dbReprintdata);
	Iterator iterator = apiReprintData.keySet().iterator();
	boolean flag = false;
	while (iterator.hasNext()) {
		String key = (String) iterator.next();

		// System.out.println(key);
		if (key.equalsIgnoreCase("reprintcount")) {
			/*String s[]=dbcanceldata.get(key).split(".");
			System.out.println("DB Date : " + s[0]);*/
			if (dbReprintdata.get(key).contains(apiReprintData.get(key))) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (key.equalsIgnoreCase("ticketNumber")) {

			if (apiReprintData.get(key).equalsIgnoreCase(dbReprintdata.get(key))) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}
		if (key.equalsIgnoreCase("purchaseamt")) {

			if (Float.parseFloat(apiReprintData.get(key)) == Float.parseFloat(dbReprintdata.get(key))) {
				flag = true;
			} else {
				flag = false;
				break;
			}
		}

	}
	return flag;
}
	
	public boolean isVerifyDrawFreezeDataForLuckyNumber() throws SQLException {		
			HashMap<String, String> apiFreezeData = new HashMap<String, String>();
			HashMap<String, String> dbFreezedata = new HashMap<String, String>();
			apiFreezeData = pcposapi.performDrawFreezeForPcPosGame("http://192.168.124.73:8082/DGE_Scheduler/services/drawMgmt/freezeDraw",PCPOSApi.drawid,PCPOSApi.gameid);
			
			con = dbconnection.getDBConnectionDge();
			ResultSet rs = dbconnection.ExecuteQuery(con,LuckyNumberSqlQuery.drawfreezetimeforluckynumber, apiFreezeData.get("drawid"));
			while (rs.next()) {
				dbFreezedata .put("updatedfreezetime", rs.getString(1));		
			}
			System.out.println("API Data : " + apiFreezeData);
			System.out.println("DB Data : " + dbFreezedata);	
			if(dbFreezedata.get("updatedfreezetime").contains(apiFreezeData.get("updatedfreezetime"))){
				return true;	
			}else{
				return false;
			}
			
		
		
	}

	public boolean isVerifyResultSubmissionDataForLuckyNumber() throws SQLException {
		HashMap<String, String> apiResultSubmissionData = new HashMap<String, String>();		
		apiResultSubmissionData = pcposapi.performResultSubmissionForPcPosGame("http://192.168.124.73:8082/DGE_Scheduler/services/drawResultMgmt/performManualWinningEntry",PCPOSApi.drawid,PCPOSApi.gameid);		
		System.out.println("API Data : " + apiResultSubmissionData);
			
		if(apiResultSubmissionData.get("responsemsg").equalsIgnoreCase("Perform Manual Winning Entry done successfully:FIRST TIME INSERT")){
			return true;	
		}else{
			return false;
		}
	}
}
