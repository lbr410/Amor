package com.amor.ticketing.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
		if(lists != null && lists.size() > 0) {
			DecimalFormat df = new DecimalFormat("#,##0원");
			JoinTicketingHistoryDTO dto = null;
			for(int i = 0 ; i < lists.size(); i++) {
				java.util.Date utilDate = lists.get(i).getScreeningdate();
				LocalDate localDate = utilDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
				System.out.println(localDate);
				dto = lists.get(i);
				dto.setChangePrice(df.format(lists.get(i).getPrice()));
				lists.set(i, dto);
				
			}
			return lists;
		}else {
			return null;
		}
	}
	
	@Override
	public int cancellationTicket(String ticketnum) {
		int result = ticketingHisotoryDao.cancellationTicket(ticketnum);
		return result;
	}
	
	@Override
	public List<JoinTicketingHistoryDTO> getcancellList(int useridx) {
		List<JoinTicketingHistoryDTO> lists = ticketingHisotoryDao.getcancellList(useridx);
		if(lists != null && lists.size() > 0) {
			DecimalFormat df = new DecimalFormat("#,##0원");
			JoinTicketingHistoryDTO dto = null;
			for(int i = 0 ; i < lists.size(); i++) {
				dto = lists.get(i);
				dto.setChangePrice(df.format(lists.get(i).getPrice()));
				lists.set(i, dto);
				
			}
			return lists;
		}else {
			return null;	
		}
		
	}
	
//	@Override
//	public List<Map<String, Object>> getReserveList(int useridx) {
//		List<Map<String, Object>> lists = ticketingHisotoryDao.ticketingList(useridx);
//		System.out.println("test1="+lists.size());
//		if(lists != null && lists.size() > 0) {
//			System.out.println("test2");
//			DecimalFormat df = new DecimalFormat("#,##0원");
//			System.out.println("test3");
//			for(int i = 0 ; i < lists.size(); i++) {
//				System.out.println("test4="+((lists.get(i).get("PRICE"))).getClass());
//				BigDecimal changeValue =(BigDecimal)(lists.get(i).get("PRICE"));
//				System.out.println("test5="+changeValue);
//				Object resultValue = df.format(changeValue); 
//				System.out.p rintln(resultValue);
//				lists.get(i).put("price", resultValue); 
//			}
//		}
//		return lists;
//	}
	
}
