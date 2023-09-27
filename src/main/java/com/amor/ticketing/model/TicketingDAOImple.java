package com.amor.ticketing.model;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;


public class TicketingDAOImple implements TicketingDAO {

	private SqlSessionTemplate sqlmap;
			
	public TicketingDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public List<JoinTicketingHistoryDTO> ticketingList(int useridx) {
		List<JoinTicketingHistoryDTO> lists = sqlmap.selectList("ticketingHistoryList", useridx);
		System.out.println(lists.size());
		return lists;
	}

	
}
