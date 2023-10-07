package com.amor.inventory.service;

import java.util.*;

import org.apache.commons.collections.map.HashedMap;

import com.amor.inquiry.model.InquiryJoinDTO;
import com.amor.inventory.model.InventoryDAO;
import com.amor.inventory.model.InventoryDTO;

public class InventoryServiceImple implements InventoryService {

	private InventoryDAO inventoryDao;

	public InventoryServiceImple(InventoryDAO inventoryDao) {
		super();
		this.inventoryDao = inventoryDao;
	}

	@Override
	public List<InventoryDTO> inventoryList(int cp, int listSize) {
		int start=(cp-1) * listSize + 1;
		int end=cp * listSize;
		Map map=new HashedMap();
		map.put("start", start);
		map.put("end", end);
		List<InventoryDTO>lists=inventoryDao.inventoryList(map);
		return lists;
	}
	
	@Override
	public int inventoryTotalCnt() {
		int result=inventoryDao.inventoryTotalCnt();
		return result;
	}
	
	@Override
	public int inventoryAdd(InventoryDTO dto) {
		int result=inventoryDao.inventoryAdd(dto);
		return result;
	}
	
	@Override
	public InventoryDTO inventoryUpdateForm(int idx) {
		InventoryDTO dto=inventoryDao.inentoryUpdateForm(idx);
		return dto;
	}
	
	@Override
	public int inventoryUpdate(InventoryDTO dto) {
		int result=inventoryDao.inventoryUpdate(dto);
		return result;
	}
}
