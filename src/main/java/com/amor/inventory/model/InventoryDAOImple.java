package com.amor.inventory.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

public class InventoryDAOImple implements InventoryDAO {

	private SqlSessionTemplate sqlmap;
	
	public InventoryDAOImple(SqlSessionTemplate sqlmap) {
		super();
		this.sqlmap = sqlmap;
	}

	@Override
	public List<InventoryDTO> inventoryList(Map map) {
		List<InventoryDTO> lists=sqlmap.selectList("inventoryList", map);
		return lists;
	}
	
	@Override
	public int inventoryTotalCnt() {
		int result=sqlmap.selectOne("inventoryTotalCnt");
		return result;
	}
	
	@Override
	public int inventoryAdd(InventoryDTO dto) {
		int result=sqlmap.insert("inventoryAdd", dto);
		return result;
	}
	
	@Override
	public InventoryDTO inentoryUpdateForm(int idx) {
		InventoryDTO dto=sqlmap.selectOne("inventoryUpdateForm", idx);
		return dto;
	}
}
