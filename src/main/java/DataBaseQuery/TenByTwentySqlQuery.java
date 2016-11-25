package DataBaseQuery;

public class TenByTwentySqlQuery {
	public static String advanceDraw = "select draw_datetime from ge_draw_master_16 where draw_status=?";
	public static String ticketNumber = "select num_of_lines,player_picked_data,if(is_quick_pick='Y','QP','Manual') as pickdata from DGE.ge_tickets_16 where ticket_number=?";

}
