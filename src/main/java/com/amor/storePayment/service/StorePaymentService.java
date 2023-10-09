package com.amor.storePayment.service;

import com.amor.storePayment.model.MyPageStorePaymentDTO;
import com.amor.storePayment.model.StorePaymentDTO;
import java.util.*;

public interface StorePaymentService {
	public String allAll(String startd, String endd);
	public String allStore(String startd, String endd);
	public List<StorePaymentDTO> dayAll(String startd, String endd);
	public String dayAllTotal(String startd, String endd);
	public List<StorePaymentDTO> dayStore(String startd, String endd);
	public String dayStoreTotal(String startd, String endd);
	public List<StorePaymentDTO> monthAll(String startd, String endd);
	public String monthAllTotal(String startd, String endd);
	public List<StorePaymentDTO> monthStore(String startd, String endd);
	public String monthStoreTotal(String startd, String endd);
	
	public List<MyPageStorePaymentDTO> mypageStorePaymentList(int useridx,int listSize,int cp);
	public int mypageStoreCancell(int paymentidx);
	public List<MyPageStorePaymentDTO> mypageStoreCancellList(int useridx,int listSize,int cp);
	public int userStoreListTotalCntY(int userIdx);
	public int userStoreListTotalCntN(int userIdx);
	
	public int storeListTotalCnt();
	public List<StorePaymentDTO> storeList(int cp, int listSize);
	public int storeListSubmit(String status, int idx);
	public int storePayInert(int product_idx, int sidx, int num, int totalPrice);

}