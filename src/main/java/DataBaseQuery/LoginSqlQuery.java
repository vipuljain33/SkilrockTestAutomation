package DataBaseQuery;

public class LoginSqlQuery {
	
	public static String activeuser="select user_name from DBLMS.st_lms_user_master where status= ? and organization_type= ? limit 1;";
}

