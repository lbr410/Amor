package com.amor.ticketing.service;

import com.amor.ticketing.model.TicketingDAO;

public class TicketingServiceImple implements TicketingService {

	private TicketingDAO ticketingHisotoryDao;
		
	public TicketingServiceImple(TicketingDAO ticketingHisotoryDao) {
		super();
		this.ticketingHisotoryDao = ticketingHisotoryDao;
	}

	
}
