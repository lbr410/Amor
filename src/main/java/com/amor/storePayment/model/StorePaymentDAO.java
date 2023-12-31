package com.amor.storePayment.model;

import java.util.*;

public interface StorePaymentDAO {
	public int allAll(Map map);
	public int allStore(Map map);
	public List<StorePaymentDTO> dayAll(Map map);
	public int dayAllTotal(Map map);
	public List<StorePaymentDTO> dayStore(Map map);
	public int dayStoreTotal(Map map);
	public List<StorePaymentDTO> monthAll(Map map);
	public int monthAllTotal(Map map);
	public List<StorePaymentDTO> monthStore(Map map);
	public int monthStoreTotal(Map map);
	
	
	public List<MyPageStorePaymentDTO> mypageStorePaymentList(Map<String, Object> parameter);
	public int mypageStoreCancel(int paymentidx);
	public List<MyPageStorePaymentDTO> mypageStoreCancelList(Map<String, Object> parameter);
	public int userStoreListTotalCntY(int userIdx);
	public int userStoreListTotalCntN(int userIdx);
	
	public int storeListTotalCnt();
	public List<StorePaymentDTO> storeList(Map map);
	public int storeListSubmit(Map map);
	public int storePayInert(Map map);

}