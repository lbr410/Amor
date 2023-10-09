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
	public List<MyPageStorePaymentDTO> mypageStorePaymentList(int useridx,int listSize,int cp) {
		 Map<String, Object> parameter = new HashMap<String, Object>();
		  int start=(cp-1)*listSize+1;
		  int end=cp*listSize;
		  
		  parameter.put("userIdx", useridx);
		  parameter.put("start", start);
		  parameter.put("end", end);
		List<MyPageStorePaymentDTO> lists = storePaymentDao.mypageStorePaymentList(parameter);
		if(lists != null && lists.size() > 0) {
			DecimalFormat df = new DecimalFormat("#,##0원");
			SimpleDateFormat dateDf = new SimpleDateFormat("yyyy.MM.dd (E) | HH:mm");
			MyPageStorePaymentDTO dto = null;
			for(int i = 0 ; i < lists.size(); i++) {
				dto = lists.get(i);
				dto.setChangePaymentDate(dateDf.format(lists.get(i).getPaymentdate()));
				dto.setChangePrice(df.format(dto.getPrice()));
				lists.set(i, dto);				
			}
			return lists;
		}else {
			return null;
		}
	}
	
	@Override
	public int userStoreListTotalCntY(int userIdx) {
		int result = storePaymentDao.userStoreListTotalCntY(userIdx);
		return result;
	}
	
	@Override
	public int userStoreListTotalCntN(int userIdx) {
		int result = storePaymentDao.userStoreListTotalCntN(userIdx);
		return result;
	}
	
	@Override
	public int mypageStoreCancell(int paymentidx) {
		int result = storePaymentDao.mypageStoreCancell(paymentidx);
		if(result > 0) {
			return result;
		}else {
			return -1;
		}
	}
	
	@Override
	public List<MyPageStorePaymentDTO> mypageStoreCancellList(int useridx,int listSize,int cp) {
		 
		Map<String, Object> parameter = new HashMap<String, Object>();
		  
		int start=(cp-1)*listSize+1;
		  
		int end=cp*listSize;
		  
		  parameter.put("userIdx", useridx);
		  parameter.put("start", start);
		  parameter.put("end", end);
		  
		List<MyPageStorePaymentDTO> lists = storePaymentDao.mypageStoreCancellList(parameter);
		
		if(lists != null && lists.size() > 0) {
			DecimalFormat df = new DecimalFormat("#,##0원");
			SimpleDateFormat dateDf = new SimpleDateFormat("yyyy.MM.dd (E) | HH:mm");
			MyPageStorePaymentDTO dto = null;
			for(int i = 0 ; i < lists.size(); i++) {
				dto = lists.get(i);
				dto.setChangePaymentDate(dateDf.format(lists.get(i).getPaymentdate()));
				dto.setChangePrice(df.format(dto.getPrice()));
				lists.set(i, dto);				
			}
			return lists;
		}else {
			return null;
		}
	}
	
	@Override
	public int storeListTotalCnt() {
		int result=storePaymentDao.storeListTotalCnt();
		return result;
	}
	
	@Override
	public List<StorePaymentDTO> storeList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		List<StorePaymentDTO> lists=storePaymentDao.storeList(map);
		DecimalFormat df=new DecimalFormat("#,##0원");
		
		for(int i=0;i<lists.size();i++) {
			double dbstore_price=lists.get(i).getStore_payment_price();
			String store_price=df.format(dbstore_price);
			lists.get(i).setC(store_price);
		}		
		return lists;
	}
	
	@Override
	public int storeListSubmit(String status, int idx) {
		Map map=new HashMap();
		map.put("status", status);
		map.put("idx", idx);
		int result=storePaymentDao.storeListSubmit(map);
		return result;
	}
	
	@Override
	public int storePayInert(int product_idx, int sidx, int num, int totalPrice) {
		Map map=new HashMap();
		map.put("product_idx", product_idx);
		map.put("sidx", sidx);
		map.put("num", num);
		map.put("totalPrice", totalPrice);
		int result=storePaymentDao.storePayInert(map);
		return result;
	}

	
}