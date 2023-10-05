package com.amor.ticketing.model;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.amor.storePayment.model.StorePaymentDTO;


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

	
	
	
	
	
	
	
	
	@Override
	public int allMovie(Map map) {
		int result = sqlmap.selectOne("allMovie", map);
		return result;
	}
	
	@Override
	public List<TicketingDTO> dayMovie(Map map) {
		List<TicketingDTO> lists = sqlmap.selectList("dayMovie", map);
		return lists;
	}
	
	@Override
	public int dayMovieTotal(Map map) {
		int result = sqlmap.selectOne("dayMovieTotal", map);
		return result;
	}
	
	@Override
	public List<TicketingDTO> monthMovie(Map map) {
		List<TicketingDTO> lists = sqlmap.selectList("monthMovie", map);
		return lists;
	}
	
	@Override
	public int monthMovieTotal(Map map) {
		int result = sqlmap.selectOne("monthMovieTotal", map);
		return result;
	}
	
	@Override
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieList() {
		List<TicketingSelectMovieDTO> lists = sqlmap.selectList("ticketingPlayingMovieList");
		return lists;
	}
	
	@Override
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieTimeList(Map map) {
		List<TicketingSelectMovieDTO> lists = sqlmap.selectList("ticketingPlayingMovieTimeList", map);
		return lists;
	}
	
@Override
	public List<TicketingSelectMovieDTO> timetoMovieLists(Date sumdate_s) {
		List<TicketingSelectMovieDTO> lists = sqlmap.selectList("timetoMovieLists",sumdate_s);
		return lists;
	}


	@Override
	public TicketingPayingJoinDTO ticketingPaying(Map map) {
		TicketingPayingJoinDTO dto = sqlmap.selectOne("ticketingPaying", map);
		return dto;
	}
}
