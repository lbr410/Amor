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
	public List<MyPageStorePaymentDTO> mypageStorePaymentList(Map<String, Object> parameter) {
		List<MyPageStorePaymentDTO> lists = sqlmap.selectList("myPageStorePaymentList", parameter);
		return lists;
	}
	
	@Override
	public int mypageStoreCancel(int paymentidx) {
		int result = sqlmap.update("mypageStoreCancel", paymentidx);
		return result;
	}
	
	@Override
	public List<MyPageStorePaymentDTO> mypageStoreCancelList(Map<String, Object> parameter) {
		List<MyPageStorePaymentDTO> lists = sqlmap.selectList("myPageStoreCancelList", parameter);
		return lists;
	}
	
	@Override
	public int userStoreListTotalCntY(int userIdx) {
		int result = sqlmap.selectOne("userStoreListTotalCntY", userIdx);
		return result;
	}
	
	@Override
	public int userStoreListTotalCntN(int userIdx) {
		int result = sqlmap.selectOne("userStoreListTotalCntN", userIdx);
		return result;
	}
	
	@Override
	public int storeListTotalCnt() {
		int result=sqlmap.selectOne("storeListTotalCnt");
		return result;
	}
	
	@Override
	public List<StorePaymentDTO> storeList(Map map) {
		List<StorePaymentDTO> lists=sqlmap.selectList("storeList", map);
		return lists;
	}
	
	@Override
	public int storeListSubmit(Map map) {
		int result=sqlmap.update("storeListSubmit", map);
		return result;
	}
	
	@Override
	public int storePayInert(Map map) {
		int result=sqlmap.insert("storePayInsert", map);
		return result;
	}
	
	
}