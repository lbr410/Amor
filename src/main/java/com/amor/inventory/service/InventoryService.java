package com.amor.inventory.service;

import java.util.*;
import com.amor.inventory.model.InventoryDTO;

public interface InventoryService {

	public List<InventoryDTO> inventoryList(int cp, int listSize);
	public int inventoryTotalCnt();
	public int inventoryAdd(InventoryDTO dto);
	public InventoryDTO inventoryUpdateForm(int idx);
	public int inventoryUpdate(InventoryDTO dto);
}
