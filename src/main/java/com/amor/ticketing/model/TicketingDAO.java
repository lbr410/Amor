package com.amor.ticketing.model;

import java.util.List;
import java.util.Map;

import com.amor.movie.model.MovieDTO;
import com.amor.playingMovie.model.PlayingMovieDTO;

import java.sql.*;

public interface TicketingDAO {
	
	public List<JoinTicketingHistoryDTO> ticketingHistoryList(Map<String, Object> parameter);
	public java.util.Date checkDate(int ticketidx);
	public int cancellationTicket(int ticketidx);
	public List<JoinTicketingHistoryDTO> ticketingCancellList(Map<String, Object> parameter);
	public PlayingMovieDTO getPlayingMovie(int playingMovieidx);
	public int PlayingMovieSeateUpdate(Map<String, Object> parameter);
	public int getticketingHistoryTotalCnt(int useridx);
	public int getTicketingCancellListTotalCnt(int useridx);
	
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieList();
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieTimeList(Map map);
	public List<TicketingSelectMovieDTO> timetoMovieLists(Date sumdate_s);
	
	public List<TicketingListDTO> ticketingList(Map map);
	public List<TicketingListDTO> ticketingListSearch(Map map);
	public int getTotalCnt();
	public int getTotalSearchCnt(String search);
	public int ticketingstateChange(TicketingListDTO dto);
	
	public int allMovie(Map map);
	public List<TicketingDTO> dayMovie(Map map);
	public int dayMovieTotal(Map map);
	public List<TicketingDTO> monthMovie(Map map);
	public int monthMovieTotal(Map map);
	
	public TicketingPayingJoinDTO ticketingPaying(Map map);
}
