package DataBaseQuery;

public class BonusLottoSqlQuery {
	public static String  BonusLottoActiveBetType="select bet_type from ge_price_master where game_no=? and bet_status=?";
	public static String advanceDraw="select draw_datetime from ge_draw_master_5 where draw_status=?";
	public static String ticketNumber="select num_of_lines,player_picked_data,if(is_quick_pick='Y','QP','Manual') as pickdata from ge_tickets_5 where ticket_number=?";
	
	
	
	
	public static String  apiticketdetails="select (select game_name from game_master where game_id=5)GameName,ticket_number,total_amount,time(purchase_time),player_picked_data  from  ge_tickets_5 where ticket_number= ?";

	public static String  apiticketcanceldetails="SELECT ticket_number,cancel_time,mrp_amt FROM ge_draw_ticket_cancel_5 INNER JOIN LMS.st_dg_ret_sale_refund_5 ON ticket_number=ticket_nbr WHERE ticket_number=?";
	public static String  apiticketreprintdetails="select  ticket_number,rpc_total,total_amount from ge_tickets_5 where party_type='retailer'and purchase_channel='LMS_Web' and ticket_number= ?";	



}
