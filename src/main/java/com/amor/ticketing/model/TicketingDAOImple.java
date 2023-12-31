package com.amor.ticketing.model;


import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.amor.playingMovie.model.PlayingMovieDTO;
import com.amor.storePayment.model.StorePaymentDTO;


public class TicketingDAOImple implements TicketingDAO {

	private SqlSessionTemplate sqlmap;
			
	public TicketingDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}
	
	@Override
	public List<JoinTicketingHistoryDTO> ticketingHistoryList(Map<String, Object> parameter) {
		List<JoinTicketingHistoryDTO> lists = sqlmap.selectList("ticketingHistoryList", parameter);
		return lists;
	}
	
	@Override
	public int cancellationTicket(int ticketidx) {
		int result = sqlmap.update("cancellationTicket",ticketidx);
		return result;
	}
	
	@Override
	public List<JoinTicketingHistoryDTO> ticketingCancelList(Map<String, Object> parameter) {
		List<JoinTicketingHistoryDTO> lists = sqlmap.selectList("ticketingCancelList", parameter);
		return lists;
	}
	
	@Override
	public java.util.Date checkDate(int ticketidx) {
		java.util.Date result = sqlmap.selectOne("checkDate", ticketidx);
		return result;
	}
	
	@Override
	public int getticketingHistoryTotalCnt(int useridx) {
		int result = sqlmap.selectOne("getticketingHistoryTotalCnt", useridx);
		return result;
	}
	
	@Override
	public int getTicketingCancelListTotalCnt(int useridx) {
		int result = sqlmap.selectOne("getTicketingCancelListTotalCnt", useridx);
		return result;
	}
	
	@Override
	public PlayingMovieDTO getPlayingMovie(int playingMovieidx) {
		PlayingMovieDTO result = sqlmap.selectOne("getPlayingMovie", playingMovieidx);
		return result;
	}
	
	@Override
	public int PlayingMovieSeateUpdate(Map<String, Object> parameter) {
		int result = sqlmap.update("playingMovieSeateUpdate", parameter);
		return result;
	}
	
	@Override
	public int getMovieAudience(int movieIdx) {
		int audience = sqlmap.selectOne("getMovieAudience", movieIdx);
		return audience;
	}
	
	@Override
	public int upDateMovieAudience(Map<String, Object> parameter) {
		int result = sqlmap.update("upDateMovieAudience", parameter);
		return result;
	}
		
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
	public List<TicketingListDTO> ticketingList(Map map) {
		List<TicketingListDTO> lists = sqlmap.selectList("ticketingList", map);
		return lists;
	}
	
	@Override
	public List<TicketingListDTO> ticketingListSearch(Map map) {
		List<TicketingListDTO> lists = sqlmap.selectList("ticketingListSearch", map);
		return lists;
	}
	
	
	@Override
	public int getTotalCnt() {
		int result = sqlmap.selectOne("ticketingListtotalCnt");
		return result;
	}
	
	@Override
	public int getTotalSearchCnt(String search) {
		int result = sqlmap.selectOne("ticketingListSearchtotalCnt", search);
		return result;
	}
	
	@Override
	public int ticketingstateChange(TicketingListDTO dto) {
		int result = sqlmap.update("ticketingstateChange",dto);
		return result;
	}
	

	@Override
	public TicketingPayingJoinDTO ticketingPaying(Map map) {
		TicketingPayingJoinDTO dto = sqlmap.selectOne("ticketingPaying", map);
		return dto;
	}
	
	@Override
	public int ticketingAdd(TicketingDTO dto) {
		int result = sqlmap.insert("ticketingAdd", dto);
		return result;
	}
	
	@Override
	public int totalAudience(int playing_movie_idx) {
		int totalAudience = sqlmap.selectOne("totalAudience", playing_movie_idx);
		return totalAudience;
	}
	
	@Override
	public int playingMovieSeat(Map map) {
		int result = sqlmap.update("playingMovieSeat", map);
		return result;
	}
	
	@Override
	public int movieAudience(Map map) {
		int result = sqlmap.update("movieAudience", map);
		return result;
	}
	
	@Override
	public String playingMovieTotalSeat(int playing_movie_idx) {
		String playing_movie_seat = sqlmap.selectOne("playingMovieTotalSeat", playing_movie_idx);
		return playing_movie_seat;
	}
	
	@Override
	public int playingMovieUpdateSeat(Map map) {
		int result = sqlmap.update("playingMovieUpdateSeat", map);
		return result;
	}
	
	
	
}
