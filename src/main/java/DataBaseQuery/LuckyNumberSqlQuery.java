package DataBaseQuery;

public class LuckyNumberSqlQuery 
{
 public static String ticketNumber="select num_of_lines,player_picked_data,if(is_quick_pick='Y','QP','Manual') as pickdata from ge_tickets_1 where ticket_number=?";
 public static String advanceDraw="select draw_datetime from ge_draw_master_1 where draw_status=?";
}