package com.amor.inventory.model;

import java.util.*;
public interface InventoryDAO {

	public List<InventoryDTO> inventoryList(Map map);
	public int inventoryTotalCnt();
	public int inventoryAdd(InventoryDTO dto);
	public InventoryDTO inentoryUpdateForm(int idx);
	public int inventoryUpdate(InventoryDTO dto);
	public int inventoryDelete(int idx);
}
