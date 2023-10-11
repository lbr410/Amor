package com.amor.ticketing.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.amor.playingMovie.model.PlayingMovieDTO;
import com.amor.storePayment.model.StorePaymentDTO;
import com.amor.ticketing.model.JoinTicketingHistoryDTO;
import com.amor.ticketing.model.TicketingDAO;
import com.amor.ticketing.model.TicketingDTO;
import com.amor.ticketing.model.TicketingListDTO;
import com.amor.ticketing.model.TicketingPayingJoinDTO;
import com.amor.ticketing.model.TicketingSelectMovieDTO;

public class TicketingServiceImple implements TicketingService {

   private TicketingDAO ticketingDao;
   DecimalFormat df = new DecimalFormat("#,###");
      
   public TicketingServiceImple(TicketingDAO ticketingDao) {
      super();
      this.ticketingDao = ticketingDao;
   }

   @Override
   public List<JoinTicketingHistoryDTO> ticketingHistoryList(int useridx,int cp, int listSize) {
	  
	  Map<String, Object> parameter = new HashMap<String, Object>();
	  int start=(cp-1)*listSize+1;
	  int end=cp*listSize;
	  
	  parameter.put("useridx", useridx);
	  parameter.put("start", start);
	  parameter.put("end", end);
	  
      List<JoinTicketingHistoryDTO> lists = ticketingDao.ticketingHistoryList(parameter);
      if(lists != null && lists.size() > 0) {
         DecimalFormat df = new DecimalFormat("#,##0원");
         SimpleDateFormat dateDf = new SimpleDateFormat("yyyy.MM.dd (E) | HH:mm");
         SimpleDateFormat endDateDf = new SimpleDateFormat("HH:mm");
         JoinTicketingHistoryDTO dto = null;
         for(int i = 0 ; i < lists.size(); i++) {
        	 java.util.Date ticketDate = lists.get(i).getScreeningdate();
        	 java.util.Date movieEndDate = lists.get(i).getEndDate();
        	 long getMS = ticketDate.getTime();
        	 long minutes = 30 * 60 * 1000;
        	 
        	 long resultTime = getMS - minutes;
        	 java.util.Date getDate = new java.util.Date(resultTime);
        	 java.util.Date nowDate = new java.util.Date();
            
        	 dto = lists.get(i);            
        	 if(nowDate.before(getDate)) {
        		 dto.setTimelimit("y");
        	 }else if(nowDate.equals(getDate) || nowDate.after(getDate)) {
        		 dto.setTimelimit("n");
        	 }
            dto.setChangePrice(df.format(lists.get(i).getPrice()));
            dto.setChangeEndDate(endDateDf.format(movieEndDate));
            dto.setChangeScreeningDate(dateDf.format(lists.get(i).getScreeningdate()));
            dto.setChangeReserveTime(dateDf.format(lists.get(i).getReservetime()));
            lists.set(i, dto);               
         }
         return lists;
      }else {
         return null;
      }
   }
   
   @Override
   public boolean cancellationTicket(String seateNum,int playingMovieIdx,int ticketIdx,int movieIdx) {
	   	int userTicketCancellation = ticketingDao.cancellationTicket(ticketIdx);
	   	boolean upDateResult = false;
	   	if(userTicketCancellation > 0) {
	   		
	   		PlayingMovieDTO getPlayingMovie = ticketingDao.getPlayingMovie(playingMovieIdx);
	   		
	   		String movieSeate = getPlayingMovie.getPlaying_movie_seat();
	   		
	   		String[] ticketSeate = seateNum.split(",");
	   		
	   		StringBuffer temp = new StringBuffer(movieSeate);
	   		for(int i = 0 ; i < ticketSeate.length ; i++) {
	   			int index = temp.indexOf(ticketSeate[i]);
	   			temp.delete(index, index+ticketSeate[i].length());
	   		}

	   		String[] splitData_s = temp.toString().split(",");
	   		StringBuffer splitData = new StringBuffer();
	   		for(int i = 0 ; i < splitData_s.length ; i++) {
	   			if(!splitData_s[i].equals("")) {
	   				if(i != splitData_s.length-1) {							
	   					splitData.append(splitData_s[i]).append(",");
	   				}else {
	   					splitData.append(splitData_s[i]);							
	   				}
	   			}
	   		}	
	   		
	   		//상영영화 남은 좌석수
	   		int totalSeatesNum = getPlayingMovie.getPlaying_movie_remain_seats()+ticketSeate.length;
	   		//상영영화 예약된 좌석
	   		String realignmentSeateData = !splitData.toString().equals("") ? splitData.toString():"[]";								
	   		Map<String, Object> parameter = new HashMap<String, Object>();
	   		parameter.put("playingMovieTotalSeateNum", totalSeatesNum);
	   		parameter.put("playingMovieSeates", realignmentSeateData);
	   		parameter.put("playingMovieIdx", playingMovieIdx);
	   		int playingMovieUpDateResult = ticketingDao.PlayingMovieSeateUpdate(parameter);
	   
	   		if(playingMovieUpDateResult > 0) {
	   			int movieAudience = ticketingDao.getMovieAudience(movieIdx)-ticketSeate.length;
	   			parameter.clear();
	   			parameter.put("audience", movieAudience);
	   			parameter.put("movieIdx", movieIdx);
	   			upDateResult = ticketingDao.upDateMovieAudience(parameter) > 0 ? true:false;
	   			
	   		}else {
	   			upDateResult = false;
	   		}
	   	}else {
	   		upDateResult = false;
	   	}
	   	return upDateResult;
   }
   
   @Override
	public boolean checkDate(int ticketidx) {
	
	 java.util.Date movieDate = ticketingDao.checkDate(ticketidx);
	 
		
	 long getMS = movieDate.getTime();
	 long minutes = 30 * 60 * 1000;
	 
	 long resultTime = getMS - minutes;
	 java.util.Date getDate = new java.util.Date(resultTime);
	 java.util.Date nowDate = new java.util.Date();
	 
	 boolean result = getDate.equals(nowDate) || getDate.after(nowDate);
	 
	return result;
	}
   
   @Override
	public int getticketingHistoryTotalCnt(int useridx) {
		int result = ticketingDao.getticketingHistoryTotalCnt(useridx);
		return result;
	}
   
   @Override
	public int getTicketingCancelListTotalCnt(int useridx) {
	   int result = ticketingDao.getTicketingCancelListTotalCnt(useridx);
		return result;
	}
   
   @Override
   public List<JoinTicketingHistoryDTO> ticketingcancelList(int useridx,int cp, int listSize) {
      
	   Map<String, Object> parameter = new HashMap<String, Object>();
		  int start=(cp-1)*listSize+1;
		  int end=cp*listSize;
		  
		  parameter.put("useridx", useridx);
		  parameter.put("start", start);
		  parameter.put("end", end);
	   
	  List<JoinTicketingHistoryDTO> lists = ticketingDao.ticketingCancelList(parameter);
      if(lists != null && lists.size() > 0) {
         DecimalFormat df = new DecimalFormat("#,##0원");
         SimpleDateFormat dateDf = new SimpleDateFormat("yyyy.MM.dd (E) | HH:mm");
         SimpleDateFormat endDateDf = new SimpleDateFormat("HH:mm");
         JoinTicketingHistoryDTO dto = null;
         
         for(int i = 0 ; i < lists.size(); i++) {
            dto = lists.get(i);
            dto.setChangeEndDate(endDateDf.format(lists.get(i).getEndDate()));
            dto.setChangePrice(df.format(lists.get(i).getPrice()));
            dto.setChangeScreeningDate(dateDf.format(lists.get(i).getScreeningdate()));
            dto.setChangeReserveTime(dateDf.format(lists.get(i).getReservetime()));
            lists.set(i, dto);               
         }
         return lists;
      }else {
         return null;
      }
      
   }
     
   @Override
   public String allMovie(String startd, String endd) {
      Map map = new HashMap();
      map.put("startd", startd);
      map.put("endd", endd);
      
      int result = ticketingDao.allMovie(map);
      String result_s = df.format(result);
      return result_s;
   }
   
   @Override
   public List<TicketingDTO> dayMovie(String startd, String endd) {
      Map map = new HashMap();
      map.put("startd", startd);
      map.put("endd", endd);
      
      List<TicketingDTO> lists = ticketingDao.dayMovie(map);
      for(int i=0; i<lists.size(); i++) {
         int totalPrice = lists.get(i).getA();
         String totalPrice_s = df.format(totalPrice);
         lists.get(i).setC(totalPrice_s);
      }
      return lists;
   }
   
   @Override
   public String dayMovieTotal(String startd, String endd) {
      Map map = new HashMap();
      map.put("startd", startd);
      map.put("endd", endd);
      
      int result = ticketingDao.dayMovieTotal(map);
      String result_s = df.format(result);
      return result_s;
   }
   
   @Override
   public List<TicketingDTO> monthMovie(String startd, String endd) {
      Map map = new HashMap();
      map.put("startd", startd);
      map.put("endd", endd);
      
      List<TicketingDTO> lists = ticketingDao.monthMovie(map);
      for(int i=0; i<lists.size(); i++) {
         int totalPrice = lists.get(i).getA();
         String totalPrice_s = df.format(totalPrice);
         lists.get(i).setC(totalPrice_s);
      }
      return lists;
   }
   
   @Override
   public String monthMovieTotal(String startd, String endd) {
      Map map = new HashMap();
      map.put("startd", startd);
      map.put("endd", endd);
      
      int result = ticketingDao.monthMovieTotal(map);
      String result_s = df.format(result);
      return result_s;
   }
   
   @Override
   public List<TicketingSelectMovieDTO> ticketingPlayingMovieList() {
      
      List<TicketingSelectMovieDTO> lists = ticketingDao.ticketingPlayingMovieList();
      
      return lists;
   }
   
   @Override
   public List<TicketingSelectMovieDTO> ticketingPlayingMovieTimeList(String movie_name, java.sql.Date sumdate) {
      
      Map map = new HashMap();
      map.put("movie_name", movie_name);
      map.put("sumdate", sumdate);
      List<TicketingSelectMovieDTO> lists = ticketingDao.ticketingPlayingMovieTimeList(map);
      
      return lists;
   }
   
   
   @Override
   public List<TicketingSelectMovieDTO> timetoMovieLists(Date sumdate_s) {
      
      List<TicketingSelectMovieDTO> lists = ticketingDao.timetoMovieLists(sumdate_s);
      
      return lists;
   }
   
   @Override
   public List<TicketingListDTO> ticketingList(int cp, int listSize) {
      int start=(cp-1)*listSize+1;
      int end=cp*listSize;
      Map map = new HashMap();
      map.put("start", start);
      map.put("end", end);
      List<TicketingListDTO> lists = ticketingDao.ticketingList(map);
      TicketingListDTO dto = null;
      java.util.Date nowDate = new java.util.Date();
      SimpleDateFormat dateDf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      //현재시간 list시간 비교
      for(int i = 0 ; i < lists.size(); i++) {
    	  dto = lists.get(i);
    	  dto.setTicketing_reservetime_s(dateDf.format(lists.get(i).getTicketing_reservetime()));
    	  if(nowDate.compareTo(lists.get(i).getPlaying_movie_start()) < 0) {
    		  dto.setBtn_cancel("canAble");
          }else{
        	  dto.setBtn_cancel("canDisAble");
          }
    	  lists.set(i, dto);
      }

      return lists;
   }
   
   @Override
   public List<TicketingListDTO> ticketingListSearch(int cp, int listSize, String search) {
      int start=(cp-1)*listSize+1;
      int end=cp*listSize;
      Map map = new HashMap();
      map.put("start", start);
      map.put("end", end);
      map.put("search",search);
      List<TicketingListDTO> lists = ticketingDao.ticketingListSearch(map);
      TicketingListDTO dto = null;
      java.util.Date nowDate = new java.util.Date();
      SimpleDateFormat dateDf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      //현재시간 list시간 비교
      for(int i = 0 ; i < lists.size(); i++) {
    	  dto = lists.get(i);
    	  dto.setTicketing_reservetime_s(dateDf.format(lists.get(i).getTicketing_reservetime()));
    	  if(nowDate.compareTo(lists.get(i).getPlaying_movie_start()) < 0) {
    		  dto.setBtn_cancel("canAble");
          }else{
        	  dto.setBtn_cancel("canDisAble");
          }
    	  lists.set(i, dto);
      }
      return lists;
   }
   
   
   
   @Override
   public int getTotalCnt() {
      int result = ticketingDao.getTotalCnt();
      return result;
   }
   
   @Override
   public int getTotalSearchCnt(String search) {
      int result = ticketingDao.getTotalSearchCnt(search);
      return result;
   }
   
   @Override
   public int ticketingstateChange(TicketingListDTO dto) {
      int result = ticketingDao.ticketingstateChange(dto);
      return result;
   }
   
  @Override
   public TicketingPayingJoinDTO ticketingPaying(int movie_idx, int theater_idx, int playing_movie_idx) {
      
      Map map = new HashMap();
      map.put("movie_idx", movie_idx);
      map.put("theater_idx", theater_idx);
      map.put("playing_movie_idx", playing_movie_idx);
      TicketingPayingJoinDTO dto = ticketingDao.ticketingPaying(map);
      return dto;
   }
  
  @Override
	public int ticketingAdd(TicketingDTO dto) {
	  	int result = ticketingDao.ticketingAdd(dto);
		return result;
	}
  
  @Override
	public int totalAudience(int playing_movie_idx) {
		int totalAudience = ticketingDao.totalAudience(playing_movie_idx);
		return totalAudience;
	}
  
  @Override
	public int playingMovieSeat(int ticketing_personnel, int playing_movie_idx) {
		Map map = new HashedMap();
		map.put("ticketing_personnel", ticketing_personnel);
		map.put("playing_movie_idx", playing_movie_idx);
		int result = ticketingDao.playingMovieSeat(map);
		return result;
	}
  
  @Override
	public int movieAudience(int totalMovieAudience, int playing_movie_idx) {
	  	Map map = new HashedMap();
	  	map.put("totalMovieAudience", totalMovieAudience);
		map.put("playing_movie_idx", playing_movie_idx);
		int result = ticketingDao.movieAudience(map);
		return result;
	}
  
  @Override
	public String playingMovieTotalSeat(int playing_movie_idx) {
		String playing_movie_seat = ticketingDao.playingMovieTotalSeat(playing_movie_idx);
		return playing_movie_seat;
	}
  
  @Override
	public int playingMovieUpdateSeat(String playingUpdateSeat, int playing_movie_idx) {
	  	Map map = new HashedMap();
	  	map.put("playingUpdateSeat", playingUpdateSeat);
	  	map.put("playing_movie_idx", playing_movie_idx);
		int result = ticketingDao.playingMovieUpdateSeat(map);
		return result;
	}
  
 
}