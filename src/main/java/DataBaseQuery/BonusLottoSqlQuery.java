package DataBaseQuery;

public class BonusLottoSqlQuery {
	public static String  BonusLottoActiveBetType="select bet_type from ge_price_master where game_no=? and bet_status=?";
	public static String advanceDraw="select draw_datetime from ge_draw_master_5 where draw_status=?";
	public static String ticketNumber="select num_of_lines,player_picked_data,if(is_quick_pick='Y','QP','Manual') as pickdata from ge_tickets_5 where ticket_number=?";
		
}
