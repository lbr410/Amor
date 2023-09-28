package com.amor.storePayment.model;

import java.util.*;

public interface StorePaymentDAO {
	public StorePaymentDTO aMonthAgo(Map map);
	public StorePaymentDTO twoMonthsAgo(Map map);
	public StorePaymentDTO threeMonthsAgo(Map map);
	public StorePaymentDTO fourMonthsAgo(Map map);
	public StorePaymentDTO fiveMonthsAgo(Map map);
	public StorePaymentDTO sixMonthsAgo(Map map);
}