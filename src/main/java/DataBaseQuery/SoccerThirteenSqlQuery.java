package DataBaseQuery;

public class SoccerThirteenSqlQuery {
	public static String soccerThirteenTicketDetails1="select LAST(ticket_number,total_amount) from st_sl_game_tickets_1_1";
	public static String soccerThirteenTicketDetails2="select ticket_number,total_amount from st_sl_game_tickets_1_1 ORDER BY trans_id DESC LIMIT 1 ";

}
