package DataBaseQuery;

public class FortuneGameSqlQuery {
	public static String fortuneticketNumber="SELECT num_of_lines,player_picked_data,IF(is_quick_pick='Y','QP','Manual') AS pickdata FROM ge_tickets_19 WHERE ticket_number=?";
	 public static String fortuneadvanceDraw="select draw_datetime from ge_draw_master_19 where draw_status=?";
}
