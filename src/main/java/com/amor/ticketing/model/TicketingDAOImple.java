package com.amor.ticketing.model;


import java.util.List;
import java.util.Map;

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
		return lists;
	}
	
	@Override
	public int cancellationTicket(String ticketnum) {
		int result = sqlmap.update("cancellationTicket",ticketnum);
		System.out.println("updateResult="+result);
		return result;
	}
	
	@Override
	public List<JoinTicketingHistoryDTO> getcancellList(int useridx) {
		List<JoinTicketingHistoryDTO> lists = sqlmap.selectList("ticketingcancellList", useridx);
		return lists;
	}
	
//	@Override
//	public List<Map<String, Object>> ticketingList(int useridx) {
//		List<Map<String, Object>> lists = sqlmap.selectList("ticketingHistoryList", useridx);
//		System.out.println(lists.size());
//		return lists;
//	}

	
}
