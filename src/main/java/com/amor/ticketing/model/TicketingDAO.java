package com.amor.ticketing.model;

import java.util.List;
import java.util.Map;
import java.sql.*;

public interface TicketingDAO {
	
	public List<JoinTicketingHistoryDTO> ticketingList(int useridx);
	//public List<Map<String, Object>> ticketingList(int useridx);
	public int cancellationTicket(String ticketnum);
	public List<JoinTicketingHistoryDTO> getcancellList(int useridx);
	
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieList();
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieTimeList(Map map);
	public List<TicketingSelectMovieDTO> timetoMovieLists(Date sumdate_s);
	
	public List<TicketingListDTO> ticketingList(Map map);
	public List<TicketingListDTO> ticketingListSearch(Map map);
	public int getTotalCnt();
	public int getTotalSearchCnt(String search);
	public int ticketingstateChange(TicketingListDTO dto);
	
	public int allMovie(Map map);
	public List<TicketingDTO> dayMovie(Map map);
	public int dayMovieTotal(Map map);
	public List<TicketingDTO> monthMovie(Map map);
	public int monthMovieTotal(Map map);
}
