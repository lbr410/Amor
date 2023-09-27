package com.amor.ticketing.model;

import java.util.List;

public interface TicketingDAO {

	public List<JoinTicketingHistoryDTO> ticketingList(int useridx);
}
