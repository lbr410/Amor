package com.amor.storePayment.service;

import java.text.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amor.storePayment.model.MyPageStorePaymentDTO;
import com.amor.storePayment.model.StorePaymentDAO;
import com.amor.storePayment.model.StorePaymentDTO;
import com.amor.ticketing.model.JoinTicketingHistoryDTO;

public class StorePaymentServiceImple implements StorePaymentService {
	
	private StorePaymentDAO storePaymentDao;
	DecimalFormat df = new DecimalFormat("#,###");
	
	public StorePaymentServiceImple(StorePaymentDAO storePaymentDao) {
		super();
		this.storePaymentDao = storePaymentDao;
	}
	
	@Override
	public StorePaymentDTO aMonthAgo() {
		StorePaymentDTO dto = storePaymentDao.aMonthAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO twoMonthsAgo() {
		StorePaymentDTO dto = storePaymentDao.twoMonthsAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO threeMonthsAgo() {
		StorePaymentDTO dto = storePaymentDao.threeMonthsAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO fourMonthsAgo() {
		StorePaymentDTO dto = storePaymentDao.fourMonthsAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO fiveMonthsAgo() {
		StorePaymentDTO dto = storePaymentDao.fiveMonthsAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO sixMonthsAgo() {
		StorePaymentDTO dto = storePaymentDao.sixMonthsAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO aDayAgo() {
		StorePaymentDTO dto = storePaymentDao.aDayAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO twoDaysAgo() {
		StorePaymentDTO dto = storePaymentDao.twoDaysAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO threeDaysAgo() {
		StorePaymentDTO dto = storePaymentDao.threeDaysAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO fourDaysAgo() {
		StorePaymentDTO dto = storePaymentDao.fourDaysAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO fiveDaysAgo() {
		StorePaymentDTO dto = storePaymentDao.fiveDaysAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO sixDaysAgo() {
		StorePaymentDTO dto = storePaymentDao.sixDaysAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public StorePaymentDTO sevenDaysAgo() {
		StorePaymentDTO dto = storePaymentDao.sevenDaysAgo();
		int totalPrice = dto.getA();
		String totalPrice_s = df.format(totalPrice);
		dto.setC(totalPrice_s);
		return dto;
	}
	
	@Override
	public String allAll(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		int result = storePaymentDao.allAll(map);
		String result_s = df.format(result);
		return result_s;
	}
	
	@Override
	public String allStore(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		int result = storePaymentDao.allStore(map);
		String result_s = df.format(result);
		return result_s;
	}
	
	@Override
	public List<StorePaymentDTO> dayAll(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		List<StorePaymentDTO> lists = storePaymentDao.dayAll(map);
		for(int i=0; i<lists.size(); i++) {
			int totalPrice = lists.get(i).getA();
			String totalPrice_s = df.format(totalPrice);
			lists.get(i).setC(totalPrice_s);
		}
		return lists;
	}
	
	@Override
	public String dayAllTotal(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		int result = storePaymentDao.dayAllTotal(map);
		String result_s = df.format(result);
		return result_s;
	}
	
	@Override
	public List<StorePaymentDTO> dayStore(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		List<StorePaymentDTO> lists = storePaymentDao.dayStore(map);
		for(int i=0; i<lists.size(); i++) {
			int totalPrice = lists.get(i).getA();
			String totalPrice_s = df.format(totalPrice);
			lists.get(i).setC(totalPrice_s);
		}
		return lists;
	}
	
	@Override
	public String dayStoreTotal(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		int result = storePaymentDao.dayStoreTotal(map);
		String result_s = df.format(result);
		return result_s;
	}
	
	@Override
	public List<StorePaymentDTO> monthAll(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		List<StorePaymentDTO> lists = storePaymentDao.monthAll(map);
		for(int i=0; i<lists.size(); i++) {
			int totalPrice = lists.get(i).getA();
			String totalPrice_s = df.format(totalPrice);
			lists.get(i).setC(totalPrice_s);
		}
		return lists;
	}
	
	@Override
	public String monthAllTotal(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		int result = storePaymentDao.monthAllTotal(map);
		String result_s = df.format(result);
		return result_s;
	}
	
	@Override
	public List<StorePaymentDTO> monthStore(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		List<StorePaymentDTO> lists = storePaymentDao.monthStore(map);
		for(int i=0; i<lists.size(); i++) {
			int totalPrice = lists.get(i).getA();
			String totalPrice_s = df.format(totalPrice);
			lists.get(i).setC(totalPrice_s);
		}
		return lists;
	}
	
	@Override
	public String monthStoreTotal(String startd, String endd) {
		Map map = new HashMap();
		map.put("startd", startd);
		map.put("endd", endd);
		
		int result = storePaymentDao.monthStoreTotal(map);
		String result_s = df.format(result);
		return result_s;
	}
	
	@Override
	public List<MyPageStorePaymentDTO> MypageStorePaymentList(int useridx) {
		List<MyPageStorePaymentDTO> lists = storePaymentDao.MypageStorePaymentList(useridx);
		if(lists != null && lists.size() == 0) {
			DecimalFormat df = new DecimalFormat("#,##0원");
			MyPageStorePaymentDTO dto = null;
			for(int i = 0 ; i < lists.size(); i++) {
				dto = lists.get(i);				
				dto.setChangePrice(df.format(dto.getPrice()));
				lists.set(i, dto);				
			}
			return lists;
		}else {
			return null;
		}
	}
}