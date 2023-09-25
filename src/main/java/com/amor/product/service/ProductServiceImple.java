package com.amor.product.service;

import java.util.*;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amor.product.model.ProductDAO;
import com.amor.product.model.ProductDTO;

public class ProductServiceImple implements ProductService {
	
	private ProductDAO productDao;
	
	public ProductServiceImple(ProductDAO productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public List<ProductDTO> productList(int cp, int listSize) {
		int start = (cp-1) * listSize + 1;
		int end = cp * listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<ProductDTO> lists = productDao.productList(map);
		return lists;
	}
	
	@Override
	public int totalCnt() {
		int count = productDao.totalCnt();
		return count;
	}
	
	@Override
	public int soldOutChange(ProductDTO dto) {
		int count = productDao.soldOutChange(dto);
		return count;
	}
	
	@Override
	public String prodContent(int product_idx) {
		String content = productDao.prodContent(product_idx);
		return content;
	}
	
	@Override
	public List<ProductDTO> prodSearchList(int cp, int listSize, String search) {
		int start = (cp-1) * listSize + 1;
		int end = cp * listSize;
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("search", search);
		
		List<ProductDTO> lists = productDao.prodSearchList(map);
		return lists;
	}
	
	@Override
	public int prodSearchTotalCnt(String search) {
		int count = productDao.prodSearchTotalCnt(search);
		return count;
	}
	
	@Override
	public int productAdd(ProductDTO dto) {
		int count = productDao.productAdd(dto);
		return count;
	}
}
