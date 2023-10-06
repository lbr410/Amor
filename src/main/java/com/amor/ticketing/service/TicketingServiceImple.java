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
   public List<JoinTicketingHistoryDTO> getReserveList(int useridx) {
      List<JoinTicketingHistoryDTO> lists = ticketingDao.ticketingList(useridx);
      if(lists != null && lists.size() > 0) {
         DecimalFormat df = new DecimalFormat("#,##0원");
         SimpleDateFormat dateDf = new SimpleDateFormat("yyyy.MM.dd (E) | HH:mm");
         JoinTicketingHistoryDTO dto = null;

         for(int i = 0 ; i < lists.size(); i++) {
        	 java.util.Date sqlDate = lists.get(i).getScreeningdate();
        	 long sqlTimeMillis = sqlDate.getTime();
        	 long sqlMinutes = 30 * 60 * 1000;
        	 
        	 long newTime = sqlTimeMillis - sqlMinutes;
        	 java.util.Date getDate = new java.util.Date(newTime);
        	 java.util.Date nowDate = new java.util.Date();
            
        	 dto = lists.get(i);            
        	 if(nowDate.before(getDate)) {
        		 dto.setTimelimit("y");
        	 }else if(nowDate.equals(getDate) || nowDate.after(getDate)) {
        		 dto.setTimelimit("n");
        	 }
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
   public int cancellationTicket(int ticketnum) {
      int result = ticketingDao.cancellationTicket(ticketnum);
      return result;
   }
   
   @Override
   public List<JoinTicketingHistoryDTO> getcancellList(int useridx) {
      List<JoinTicketingHistoryDTO> lists = ticketingDao.getcancellList(useridx);
      if(lists != null && lists.size() > 0) {
         DecimalFormat df = new DecimalFormat("#,##0원");
         SimpleDateFormat dateDf = new SimpleDateFormat("yyyy.MM.dd (E) | HH:mm");
         JoinTicketingHistoryDTO dto = null;
         
         for(int i = 0 ; i < lists.size(); i++) {
            dto = lists.get(i);            
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
   
//   @Override
//   public List<Map<String, Object>> getReserveList(int useridx) {
//      List<Map<String, Object>> lists = ticketingDao.ticketingList(useridx);
//      System.out.println("test1="+lists.size());
//      if(lists != null && lists.size() > 0) {
//         System.out.println("test2");
//         DecimalFormat df = new DecimalFormat("#,##0원");
//         System.out.println("test3");
//         for(int i = 0 ; i < lists.size(); i++) {
//            System.out.println("test4="+((lists.get(i).get("PRICE"))).getClass());
//            BigDecimal changeValue =(BigDecimal)(lists.get(i).get("PRICE"));
//            System.out.println("test5="+changeValue);
//            Object resultValue = df.format(changeValue); 
//            System.out.p rintln(resultValue);
//            lists.get(i).put("price", resultValue); 
//         }
//      }
//      return lists;
//   }
   
   
   
   
   
   
   
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
      List<TicketingListDTO> lists = ticketingDao.ticketingList(map);
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
}