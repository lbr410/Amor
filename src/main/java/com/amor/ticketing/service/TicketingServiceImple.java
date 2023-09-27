package com.amor.ticketing.service;

import java.util.List;

import com.amor.ticketing.model.JoinTicketingHistoryDTO;
import com.amor.ticketing.model.TicketingDAO;

public class TicketingServiceImple implements TicketingService {

	private TicketingDAO ticketingHisotoryDao;
		
	public TicketingServiceImple(TicketingDAO ticketingHisotoryDao) {
		super();
		this.ticketingHisotoryDao = ticketingHisotoryDao;
	}

	@Override
	public List<JoinTicketingHistoryDTO> getReserveList(int useridx) {
		List<JoinTicketingHistoryDTO> lists = ticketingHisotoryDao.ticketingList(useridx);
		return lists;
	}
	
}
