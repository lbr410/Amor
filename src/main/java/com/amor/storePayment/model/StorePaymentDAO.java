package com.amor.storePayment.model;

import java.util.*;

public interface StorePaymentDAO {
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
}