package DataBaseQuery;

public class TwelveByTwentyFourSqlQuery {
	 public static String  TwelveByTwentyFourActiveBetType="select bet_type from ge_price_master where game_no=? and bet_status='ACTIVE'";
	 public static String advanceDraw="select draw_datetime from ge_draw_master_15 where draw_status=?";	 
	 public static String ticketNumber="select num_of_lines,player_picked_data,if(is_quick_pick='Y','QP','Manual') as pickdata from ge_tickets_15 where ticket_number=?";
}