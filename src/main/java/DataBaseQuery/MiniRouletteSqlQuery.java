package DataBaseQuery;


public class MiniRouletteSqlQuery 
{
 public static String ticketNumber="select num_of_lines,player_picked_data,if(is_quick_pick='Y','QP','Manual') as pickdata from ge_tickets_20 where ticket_number=?";
 public static String advanceDraw="select draw_datetime from ge_draw_master_20 where draw_status=?";
 public static String  miniRouletteActiveBetType="select bet_type from ge_price_master where game_no=? and bet_status=?";
 public static String apiMinirouletteTicket="select (select game_name from game_master where game_id=20)GameName,ticket_number,total_amount,time(purchase_time),player_picked_data  from  ge_tickets_20 where ticket_number= ?";
}

