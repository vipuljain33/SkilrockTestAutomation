package apis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import DataBaseQuery.DBConnection;
import DataBaseQuery.LuckyNumberSqlQuery;
import DataBaseQuery.SoccerThirteenSqlQuery;


public class ApiCommonValidationPage {
	private static Logger LOGGER = LoggerFactory.getLogger(ApiCommonValidationPage.class);
	PCPOSApi pcposapi = new PCPOSApi();
	DBConnection dbconnection = new DBConnection();
	Connection con;
   

	public boolean isVarifyCancleData(String atg1) throws SQLException {
		HashMap<String, String> apiCancelData = new HashMap<String, String>();
		HashMap<String, String> dbcanceldata = new HashMap<String, String>();
		apiCancelData = pcposapi.cancelApiForLuckyNumber(PCPOSApi.ticketno, PCPOSApi.sessionId);
		con = dbconnection.getDBConnectionDge();
		ResultSet rs = dbconnection.ExecuteQuery(con, LuckyNumberSqlQuery.apiticketcanceldetails, PCPOSApi.ticketno);
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

			
			if (key.equalsIgnoreCase("cancelTime")) {
				
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

			
			if (key.equalsIgnoreCase("reprintcount")) {
				
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
	public boolean verifySoccerThirteenSale() throws SQLException {
		con = dbconnection.getDBConnectionSle();
		ResultSet rs = dbconnection.ExecuteQuery(con, SoccerThirteenSqlQuery.soccerThirteenTicketDetails2, PCPOSApi.ticketno);
		HashMap<String, String> dbdata = new HashMap<String, String>();
		while (rs.next()) {

			
			dbdata.put("ticketNumber", rs.getString(1));
			dbdata.put("purchaseAmt", rs.getString(2));
			
		}
		
		if(PCPOSApi.soccerThirteenData.get("Ticket Number").equals(dbdata.get("ticketNumber")) && PCPOSApi.soccerThirteenData.get("Ticket Price").equals(dbdata.get("purchaseAmt"))) {
			 return true;
		}
		else {
			return false;
		}
	}
	 
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

			
		}
   
}
