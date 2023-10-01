package com.amor.storePayment.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;

import com.amor.product.model.ProductDTO;

public class StorePaymentDAOImple implements StorePaymentDAO {
	
	private SqlSessionTemplate sqlmap;
	
	public StorePaymentDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public StorePaymentDTO aMonthAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("aMonthAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO twoMonthsAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("twoMonthsAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO threeMonthsAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("threeMonthsAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO fourMonthsAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("fourMonthsAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO fiveMonthsAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("fiveMonthsAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO sixMonthsAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("sixMonthsAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO aDayAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("aDayAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO twoDaysAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("twoDaysAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO threeDaysAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("threeDaysAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO fourDaysAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("fourDaysAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO fiveDaysAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("fiveDaysAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO sixDaysAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("sixDaysAgo");
		return dto;
	}
	
	@Override
	public StorePaymentDTO sevenDaysAgo() {
		StorePaymentDTO dto = sqlmap.selectOne("sevenDaysAgo");
		return dto;
	}
	
	@Override
	public int allAll(Map map) {
		int result = sqlmap.selectOne("allAll", map);
		return result;
	}
	
	@Override
	public int allStore(Map map) {
		int result = sqlmap.selectOne("allStore", map);
		return result;
	}
	
	@Override
	public List<StorePaymentDTO> dayAll(Map map) {
		List<StorePaymentDTO> lists = sqlmap.selectList("dayAll", map);
		return lists;
	}
	
	@Override
	public int dayAllTotal(Map map) {
		int result = sqlmap.selectOne("dayAllTotal", map);
		return result;
	}
	
	@Override
	public List<StorePaymentDTO> dayStore(Map map) {
		List<StorePaymentDTO> lists = sqlmap.selectList("dayStore", map);
		return lists;
	}
	
	@Override
	public int dayStoreTotal(Map map) {
		int result = sqlmap.selectOne("dayStoreTotal", map);
		return result;
	}
	
	@Override
	public List<StorePaymentDTO> monthAll(Map map) {
		List<StorePaymentDTO> lists = sqlmap.selectList("monthAll", map);
		return lists;
	}
	
	@Override
	public int monthAllTotal(Map map) {
		int result = sqlmap.selectOne("monthAllTotal", map);
		return result;
	}
	
	@Override
	public List<StorePaymentDTO> monthStore(Map map) {
		List<StorePaymentDTO> lists = sqlmap.selectList("monthStore", map);
		return lists;
	}
	
	@Override
	public int monthStoreTotal(Map map) {
		int result = sqlmap.selectOne("monthStoreTotal", map);
		return result;
	}
	
	@Override
	public List<MyPageStorePaymentDTO> mypageStorePaymentList(int useridx) {
		List<MyPageStorePaymentDTO> lists = sqlmap.selectList("mypageStorePaymentList", useridx);
		return lists;
	}
	
	@Override
	public int mypageStoreCancell(int paymentidx) {
		int result = sqlmap.update("mypageStoreCancell", paymentidx);
		return result;
	}
	
	@Override
	public List<MyPageStorePaymentDTO> mypageStoreCancellList(int useridx) {
		List<MyPageStorePaymentDTO> lists = sqlmap.selectList("mypageStoreCancellList", useridx);
		return lists;
	}
}