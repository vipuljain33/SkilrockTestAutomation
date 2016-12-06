package DataBaseQuery;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.ConfigManager;

public class DBConnection {

	private static Connection con = null;
	private static Connection conDge = null;

	public static Connection getDBConnection() {
		try {
			if (con == null) {

				String url = ConfigManager.getProperty("DBConURL");
				String user = ConfigManager.getProperty("DBConnUser");
				String password = ConfigManager.getProperty("DBConnPwd");
				String driver = ConfigManager.getProperty("DBConnDriver");
				Class.forName(driver);
				con = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getDBConnectionDge() {
		try {
			if (conDge == null) {
				String url = ConfigManager.getProperty("DBConDgeURL");
				String user = ConfigManager.getProperty("DBConnDgeUser");
				String password = ConfigManager.getProperty("DBConnDgePwd");
				String driver = ConfigManager.getProperty("DBConnDgeDriver");
				Class.forName(driver);
				conDge = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conDge;
	}
	public static Connection getDBConnectionSle() {
		try {
			if (conDge == null) {
				String url = ConfigManager.getProperty("DBConSleURL");
				String user = ConfigManager.getProperty("DBConnSleUser");
				String password = ConfigManager.getProperty("DBConnSlePwd");
				String driver = ConfigManager.getProperty("DBConnSleDriver");
				Class.forName(driver);
				conDge = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conDge;
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection CreateConnectionForLMS() {
		Connection connection = getDBConnection();
		return connection;
	}

	public Connection CreateConnectionForDGE() {
		Connection connection = getDBConnectionDge();
		return connection;
	}

	public ResultSet ExecuteQuery(Connection connection, String Query, String param1) throws SQLException {

		PreparedStatement ps = connection.prepareStatement(Query);
		ps.setString(1, param1);
		ResultSet rs = ps.executeQuery();

		return rs;
	}

	
	public ResultSet ExecuteQuery(Connection connection, String Query, String param1, String param2)
			throws SQLException {
		
		PreparedStatement ps = connection.prepareStatement(Query);
		ps.setString(1, param1);
		ps.setString(2, param2);
		ResultSet rs = ps.executeQuery();
		return rs;
	}

	public ResultSet ExecuteQuery(Connection connection, String Query, String param1, String param2, String param3)
			throws SQLException {

		PreparedStatement ps = connection.prepareStatement(Query);
		ps.setString(1, param1);
		ps.setString(2, param2);
		ps.setString(3, param3);
		ResultSet rs = ps.executeQuery();

		
		return rs;
	}
	
	public int executeUpdate(Connection connection, String Query, String param1, String param2) throws SQLException
	{
		String temp= getFinalQuery(Query);		
		PreparedStatement preparedStatement = connection.prepareStatement(temp);
		preparedStatement.setString(1, param1);
		preparedStatement.setString(2,param2);
		// execute insert SQL stetement
		return preparedStatement .executeUpdate();		
	}
	
	
	

	public ResultSet ExecuteQuery(Connection connection, String Query, int param1, String param2) throws SQLException {

		// select * from employee where ename = ? and location = ?`

		// Statement stmt = (Statement) con.createStatement();
		PreparedStatement ps = connection.prepareStatement(Query);
		ps.setInt(1, param1);
		ps.setString(2, param2);
		ResultSet rs = ps.executeQuery();

		// while (rs.next()) {}
		return rs;
	}


	public ResultSet ExecuteQuery(Connection connection, String Query, int param1) throws SQLException {

		// select * from employee where ename = ? and location = ?`

		// Statement stmt = (Statement) con.createStatement();
		PreparedStatement ps = connection.prepareStatement(Query);
		ps.setInt(1, param1);		
		ResultSet rs = ps.executeQuery();

		// while (rs.next()) {}
		return rs;
	}

	
	public String getFinalQuery(String value) {

		String tempQuery = value;

		tempQuery = tempQuery.contains("DBLMS") ? tempQuery.replace("DBLMS", ConfigManager.getProperty("DBLMS"))
				: tempQuery;

		
		 tempQuery = tempQuery.contains("dbDGE") ? tempQuery.replace("dbDGE",
				 ConfigManager.getProperty("dbDGE")) : tempQuery;
		  
		  /*//changed performed by Amit tempQuery2 = tempQuery1.contains("dbSLE")
		 * ? tempQuery1.replace( "dbSLE", QueryFromProperty("dbSLE")) :
		 * tempQuery1; // tempQuery3 = tempQuery2.contains("dbPMS")
		 * ?tempQuery2.replace( "dbPMS", QueryFromProperty("dbPMS")) :
		 * tempQuery2; // finalQuery = tempQuery3.contains("dbIPE") ?
		 * tempQuery3.replace( "dbIPE", QueryFromProperty("dbIPE")) :
		 * tempQuery3;
		 * 
		 * System.out.println("Final Query :- " + finalQuery);
		 * SeleniumDriver.log.info("Final Query :- " + finalQuery); return
		 * finalQuery;
		 */
		return tempQuery;

	}

}
