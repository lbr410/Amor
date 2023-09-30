package com.amor.ticketing.service;

import java.util.List;
import java.util.Map;

import com.amor.ticketing.model.JoinTicketingHistoryDTO;
import com.amor.ticketing.model.TicketingDTO;
import com.amor.ticketing.model.TicketingSelectMovieDTO;

public interface TicketingService {

	public List<JoinTicketingHistoryDTO> getReserveList(int useridx);
	//public List<Map<String, Object>> getReserveList(int useridx);
	public int cancellationTicket(String ticketnum);
	
	public List<JoinTicketingHistoryDTO> getcancellList(int useridx);
	
	
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieList();
	
	
	
	public String allMovie(String startd, String endd);
	public List<TicketingDTO> dayMovie(String startd, String endd);
	public String dayMovieTotal(String startd, String endd);
	public List<TicketingDTO> monthMovie(String startd, String endd);
	public String monthMovieTotal(String startd, String endd);
}
