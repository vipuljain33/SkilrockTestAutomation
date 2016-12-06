package DataBaseQuery;

public class SuperKenoSqlQuery {









	public static String  apiticketdetails="select (select game_name from game_master where game_id=18)GameName,ticket_number,total_amount,time(purchase_time),player_picked_data  from  ge_tickets_18 where ticket_number= ?";

	public static String  apiticketcanceldetails="SELECT ticket_number,cancel_time,mrp_amt FROM ge_draw_ticket_cancel_18 INNER JOIN LMS.st_dg_ret_sale_refund_18 ON ticket_number=ticket_nbr WHERE ticket_number=?";
	public static String  apiticketreprintdetails="select  ticket_number,rpc_total,total_amount from ge_tickets_18 where party_type='retailer'and purchase_channel='LMS_Web' and ticket_number= ?";	





}
