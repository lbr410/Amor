package com.amor.storePayment.service;

import com.amor.storePayment.model.MyPageStorePaymentDTO;
import com.amor.storePayment.model.StorePaymentDTO;
import java.util.*;

public interface StorePaymentService {
	public StorePaymentDTO aMonthAgo();
	public StorePaymentDTO twoMonthsAgo();
	public StorePaymentDTO threeMonthsAgo();
	public StorePaymentDTO fourMonthsAgo();
	public StorePaymentDTO fiveMonthsAgo();
	public StorePaymentDTO sixMonthsAgo();
	public StorePaymentDTO aDayAgo();
	public StorePaymentDTO twoDaysAgo();
	public StorePaymentDTO threeDaysAgo();
	public StorePaymentDTO fourDaysAgo();
	public StorePaymentDTO fiveDaysAgo();
	public StorePaymentDTO sixDaysAgo();
	public StorePaymentDTO sevenDaysAgo();
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
	//수민
	public List<MyPageStorePaymentDTO> mypageStorePaymentList(int useridx);
	public int mypageStoreCancell(int paymentidx);
	public List<MyPageStorePaymentDTO> mypageStoreCancellList(int useridx);

	public int storeListTotalCnt();
	public List<StorePaymentDTO> storeList(int cp, int listSize);
	public int storeListSubmit(String status, int idx);
	public int storePayInert(StorePaymentDTO dto);

}