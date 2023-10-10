package com.amor.ticketing.service;

import java.util.List;
import java.util.Map;

import com.amor.playingMovie.model.PlayingMovieDTO;
import com.amor.ticketing.model.JoinTicketingHistoryDTO;
import com.amor.ticketing.model.TicketingDTO;
import com.amor.ticketing.model.TicketingListDTO;
import com.amor.ticketing.model.TicketingPayingJoinDTO;
import com.amor.ticketing.model.TicketingSelectMovieDTO;

public interface TicketingService {

	public List<JoinTicketingHistoryDTO> ticketingHistoryList(int useridx,int cp, int listSize);
	public boolean cancellationTicket(String seateNum,int playingMovieIdx,int ticketidx,int movieidx);
	public boolean checkDate(int ticketidx);
	public List<JoinTicketingHistoryDTO> ticketingcancellList(int useridx,int cp, int listSize);
	public int getticketingHistoryTotalCnt(int useridx);
	public int getTicketingCancellListTotalCnt(int useridx);
	
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieList();
	public List<TicketingSelectMovieDTO> ticketingPlayingMovieTimeList(String movie_name, java.sql.Date sumdate);
	public List<TicketingSelectMovieDTO> timetoMovieLists(java.sql.Date sumdate_s);
	
	public List<TicketingListDTO> ticketingList(int cp, int listSize);
	public List<TicketingListDTO> ticketingListSearch(int cp, int listSize, String search);
	public int getTotalCnt();
	public int getTotalSearchCnt(String search);
	public int ticketingstateChange(TicketingListDTO dto);
	
	
	
	
	public String allMovie(String startd, String endd);
	public List<TicketingDTO> dayMovie(String startd, String endd);
	public String dayMovieTotal(String startd, String endd);
	public List<TicketingDTO> monthMovie(String startd, String endd);
	public String monthMovieTotal(String startd, String endd);
	
	public TicketingPayingJoinDTO ticketingPaying(int movie_idx, int theater_idx, int playing_movie_idx);
	public int ticketingAdd(TicketingDTO dto);
	public int totalAudience(int playing_movie_idx);
	public int playingMovieSeat(int ticketing_personnel, int playing_movie_idx);
	public int movieAudience(int totalMovieAudience, int playing_movie_idx);
	public String playingMovieTotalSeat(int playing_movie_idx);
	public int playingMovieUpdateSeat(String playingUpdateSeat, int playing_movie_idx);
}
