package com.amor.ticketing.model;

import java.util.List;
import java.util.Map;

public interface TicketingDAO {
	
	public List<JoinTicketingHistoryDTO> ticketingList(int useridx);
	//public List<Map<String, Object>> ticketingList(int useridx);
	public int cancellationTicket(String ticketnum);
	public List<JoinTicketingHistoryDTO> getcancellList(int useridx);
}
