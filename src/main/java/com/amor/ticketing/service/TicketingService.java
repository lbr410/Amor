package com.amor.ticketing.service;

import java.util.List;
import java.util.Map;

import com.amor.ticketing.model.JoinTicketingHistoryDTO;

public interface TicketingService {

	public List<JoinTicketingHistoryDTO> getReserveList(int useridx);
	//public List<Map<String, Object>> getReserveList(int useridx);
	public int cancellationTicket(String ticketnum);
	
	public List<JoinTicketingHistoryDTO> getcancellList(int useridx);
}
