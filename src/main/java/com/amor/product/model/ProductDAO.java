package com.amor.product.model;

import java.util.*;

public interface ProductDAO {
	public List<ProductDTO> productList(Map map);
	public int totalCnt();
	public int soldOutChange(ProductDTO dto);
	public String prodContent(int product_idx);
	public List<ProductDTO> prodSearchList(Map map);
	public int prodSearchTotalCnt(String search);
	public int productAdd(ProductDTO req);
	public ProductDTO productSelectIdx(int product_idx);
	public int productUpdate(ProductDTO dto);
	public int productDel(int product_idx);
	public List<ProductDTO> storeTicketList();
	public List<ProductDTO> storeDrinkList();
	public List<ProductDTO> storeSnackList();
	public ProductDTO storeContent(int idx);
	public ProductDTO storePayForm(int idx);
	public ProductDTO storeKakao(int idx);
	public List<ProductDTO> indexSnack(Map map);
	public List<ProductDTO> indexDrink(Map map);
	public List<ProductDTO> indexTicket(Map map);

}