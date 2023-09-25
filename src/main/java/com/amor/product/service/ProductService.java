package com.amor.product.service;

import java.util.*;

import com.amor.product.model.ProductDTO;

public interface ProductService {
	public List<ProductDTO> productList(int cp, int listSize);
	public int totalCnt();
	public int soldOutChange(ProductDTO dto);
	public String prodContent(int product_idx);
	public List<ProductDTO> prodSearchList(int cp, int listSize, String search);
	public int prodSearchTotalCnt(String search);
	public int productAdd(ProductDTO dto);
}