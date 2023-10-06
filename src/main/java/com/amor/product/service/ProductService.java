package com.amor.product.service;

import java.util.*;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amor.product.model.ProductDTO;
import com.amor.storePayment.model.StorePaymentDTO;

public interface ProductService {
	public List<ProductDTO> productList(int cp, int listSize);
	public int totalCnt();
	public int soldOutChange(ProductDTO dto);
	public String prodContent(int product_idx);
	public List<ProductDTO> prodSearchList(int cp, int listSize, String search);
	public int prodSearchTotalCnt(String search);
	public int productAdd(ProductDTO dto);
	public ProductDTO productSelectIdx(int product_idx);
	public int productUpdate(ProductDTO dto);
	public int productDel(int product_idx);
	public List<ProductDTO> storeTicketList();
	public List<ProductDTO> storeDrinkList();
	public List<ProductDTO> storeSnackList();
	public ProductDTO storeContent(int idx);
	public ProductDTO storePayForm(int idx, int num);
	public ProductDTO storeKakao(int idx , int num);
}