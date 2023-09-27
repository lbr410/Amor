package com.amor.ticketing.service;

import java.util.List;
import java.util.Map;

import com.amor.ticketing.model.JoinTicketingHistoryDTO;

public interface TicketingService {

	public List<JoinTicketingHistoryDTO> getReserveList(int useridx);
}
